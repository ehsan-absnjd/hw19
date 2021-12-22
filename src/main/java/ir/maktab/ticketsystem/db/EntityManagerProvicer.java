package ir.maktab.ticketsystem.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvicer {
    private static EntityManagerFactory ticketsystem
            = Persistence.createEntityManagerFactory("ticketsystem");
    public static EntityManager getEntityManager(){
        return ticketsystem.createEntityManager();
    }
}
