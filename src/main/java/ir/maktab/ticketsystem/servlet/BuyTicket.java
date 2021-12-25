package ir.maktab.ticketsystem.servlet;

import ir.maktab.ticketsystem.entity.User;
import ir.maktab.ticketsystem.responder.AbstractResponder;
import ir.maktab.ticketsystem.responder.Responder;
import ir.maktab.ticketsystem.usecase.abstraction.UseCase;
import ir.maktab.ticketsystem.usecase.factory.UseCaseFactory;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;
import ir.maktab.ticketsystem.usecaserequest.factory.UseCaseRequestFactory;
import ir.maktab.ticketsystem.util.Context;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "BuyTicket", value = "/buyticket")
public class BuyTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tripid = request.getParameter("tripid");
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("tripid" , tripid);
        request.getRequestDispatcher("BuyTicket.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        UseCaseFactory useCaseFactory = Context.getUseCaseFactory();
        UseCase addTripUseCase = useCaseFactory.create("AddTicketUseCase");
        UseCaseRequestFactory useCaseRequestFactory = Context.getUseCaseRequestFactory();
        UseCaseRequest addTripRequest = useCaseRequestFactory.create("AddTicketRequest");

        Map<String, Object> parameters = prepareParameters(request);
        parameters.put("userid", user.getId());

        Responder responder = createResponder(request , response);

        addTripRequest.setParameters(parameters);
        addTripUseCase.setResponder(responder);
        addTripUseCase.process(addTripRequest);

    }

    private Responder createResponder(HttpServletRequest request, HttpServletResponse response) {
        return new AbstractResponder(request , response){
            @Override
            public void render(Map<String, Object> parameters) {
                addAttributes(parameters);
                try {

                    request.setAttribute("message" ,parameters.get("message") );

                    request.getRequestDispatcher("Home.jsp").forward(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private Map<String, Object> prepareParameters(HttpServletRequest request) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("tripid" , Integer.parseInt(request.getParameter("tripid")));
        parameters.put("fullname" , request.getParameter("fullname"));
        parameters.put("gender" , request.getParameter("gender").equals("male"));
        return parameters;
    }
}
