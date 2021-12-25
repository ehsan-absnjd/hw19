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

@WebServlet(name = "AddTrip", value = "/addtrip")
public class AddTrip extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UseCaseFactory useCaseFactory = Context.getUseCaseFactory();
        UseCase addTripUseCase = useCaseFactory.create("AddTripUseCase");
        UseCaseRequestFactory useCaseRequestFactory = Context.getUseCaseRequestFactory();
        UseCaseRequest addTripRequest = useCaseRequestFactory.create("AddTripRequest");

        Map<String, Object> parameters = prepareParameters(request);
        Responder responder = createResponder(request , response);

        addTripRequest.setParameters(parameters);
        addTripUseCase.setResponder(responder);
        addTripUseCase.process(addTripRequest);

    }

    private Map<String, Object> prepareParameters(HttpServletRequest request) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("origin" , request.getParameter("origin"));
        parameters.put("destination" , request.getParameter("destination"));
        parameters.put("date" , LocalDate.parse(request.getParameter("date")));
        parameters.put("time" , LocalTime.parse(request.getParameter("time")));
        parameters.put("username" , ((User) request.getSession().getAttribute("user")).getUserName());
        return parameters;
    }

    private Responder createResponder(HttpServletRequest request, HttpServletResponse response) {
        return new AbstractResponder(request , response){
            @Override
            public void render(Map<String, Object> parameters) {
                addAttributes(parameters);
                try {
                    if(parameters.get("error")!=null){
                        request.setAttribute("error" ,parameters.get("error") );
                    }
                    request.getRequestDispatcher("/home").forward(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
