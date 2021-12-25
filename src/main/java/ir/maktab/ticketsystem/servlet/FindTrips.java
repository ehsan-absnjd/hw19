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

@WebServlet(name = "FindTrips", value = "/findtrips")
public class FindTrips extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Trips.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UseCaseFactory useCaseFactory = Context.getUseCaseFactory();
        UseCase findTripUseCase = useCaseFactory.create("FindTripsUseCase");
        UseCaseRequestFactory useCaseRequestFactory = Context.getUseCaseRequestFactory();
        UseCaseRequest findTripRequest = useCaseRequestFactory.create("FindTripRequest");

        Map<String, Object> parameters = prepareParameters(request);
        Responder responder = createResponder(request , response);

        System.out.println("inside controller");
        findTripRequest.setParameters(parameters);
        findTripUseCase.setResponder(responder);
        findTripUseCase.process(findTripRequest);
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
                    if(parameters.get("trips")!=null){
                        request.setAttribute("trips" , parameters.get("trips"));
                    }
                    request.getRequestDispatcher("Trips.jsp").forward(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private Map<String, Object> prepareParameters(HttpServletRequest request) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("origin" , request.getParameter("origin"));
        parameters.put("destination" , request.getParameter("destination"));
        parameters.put("date" , LocalDate.parse(request.getParameter("date")));
        return parameters;
    }
}
