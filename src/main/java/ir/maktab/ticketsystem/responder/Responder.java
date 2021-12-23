package ir.maktab.ticketsystem.responder;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public interface Responder {
    void render(Map<String, Object> parameters);
}
