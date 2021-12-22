package ir.maktab.ticketsystem.responder;

import java.util.Map;

public interface Responder {
    void render(Map<String, Object> parameters);
}
