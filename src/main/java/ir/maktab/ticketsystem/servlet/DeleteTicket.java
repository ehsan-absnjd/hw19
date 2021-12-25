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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DeleteTicket", value = "/deleteticket")
public class DeleteTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        UseCaseFactory useCaseFactory = Context.getUseCaseFactory();
        UseCase addTripUseCase = useCaseFactory.create("RemoveTicketUseCase");
        UseCaseRequestFactory useCaseRequestFactory = Context.getUseCaseRequestFactory();
        UseCaseRequest addTripRequest = useCaseRequestFactory.create("RemoveTicketRequest");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userid" , user.getId());
        parameters.put("ticketid" , Integer.parseInt(request.getParameter("ticketid")));

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
                    request.getRequestDispatcher("/seetickets").forward(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
