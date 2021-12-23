package ir.maktab.ticketsystem.usecase.factory;

import ir.maktab.ticketsystem.usecase.abstraction.UseCase;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UseCaseFactory {
    private Map<String, Class> classMap = new HashMap<>();

    public UseCaseFactory() {
    }

    public UseCaseFactory(Set<Class> classes) {
        classes.forEach(this::register);
    }

    public void register(Class useCaseClass){
        classMap.put(useCaseClass.getSimpleName() , useCaseClass);
    }

    public UseCase create(String useCaseName){
        UseCase useCase = null;
        try {
            useCase = (UseCase) classMap.get(useCaseName).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return useCase;
    }
}
