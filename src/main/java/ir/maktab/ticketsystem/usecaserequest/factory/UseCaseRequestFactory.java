package ir.maktab.ticketsystem.usecaserequest.factory;

import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UseCaseRequestFactory {
    private Map<String, Class> classMap = new HashMap<>();

    public UseCaseRequestFactory() {
    }

    public UseCaseRequestFactory(Set<Class> classes) {
        classes.forEach(this::register);
    }

    public void register(Class useCaseRequestClass){
        classMap.put(useCaseRequestClass.getSimpleName() , useCaseRequestClass);
    }

    public UseCaseRequest create(String useCaseRequestName){
        UseCaseRequest request = null;
        try {
            request = (UseCaseRequest) classMap.get(useCaseRequestName).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return request;
    }
}
