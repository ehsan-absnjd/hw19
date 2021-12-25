package ir.maktab.ticketsystem.servlet;

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

@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UseCaseFactory useCaseFactory = Context.getUseCaseFactory();
        UseCase findUserUseCase = useCaseFactory.create("AddUserUseCase");
        UseCaseRequestFactory useCaseRequestFactory = Context.getUseCaseRequestFactory();
        UseCaseRequest useCaseRequest = useCaseRequestFactory.create("AddUserRequest");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username" , request.getParameter("username"));
        parameters.put("password" , request.getParameter("password"));
        parameters.put("isadmin" , false);
        Responder responder = createResponder(request , response);

        useCaseRequest.setParameters(parameters);
        findUserUseCase.setResponder(responder);
        findUserUseCase.process(useCaseRequest);
    }

    private Responder createResponder(HttpServletRequest request, HttpServletResponse response) {
        return new AbstractResponder(request , response){
            @Override
            public void render(Map<String, Object> parameters) {
                addAttributes(parameters);
                try {
                    if (parameters.get("error") == null) {
                        request.getSession().setAttribute("user", parameters.get("user"));
                        request.getRequestDispatcher("/home").forward(request, response);
                    }else {
                        request.setAttribute("error" , parameters.get("error"));
                        request.getRequestDispatcher("Login.jsp").forward(request , response);
                    }
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
