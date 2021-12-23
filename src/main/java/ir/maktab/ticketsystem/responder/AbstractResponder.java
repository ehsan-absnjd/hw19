package ir.maktab.ticketsystem.responder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public abstract class AbstractResponder implements Responder{
    HttpServletRequest request;
    HttpServletResponse response;

    public AbstractResponder(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void addAttributes(Map<String, Object> parameters){
        parameters.entrySet().stream().forEach(param -> request.setAttribute(param.getKey() , param.getValue()));
    }

    @Override
    public abstract void render(Map<String, Object> parameters);
}
