package br.com.projeto.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static{
        try {
            System.out.println("Tentando abrir session factory...");
            Configuration cfg = new Configuration().configure();
            ServiceRegistryBuilder serviceRegistry = (ServiceRegistryBuilder) new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
            sessionFactory = cfg.buildSessionFactory((ServiceRegistry) serviceRegistry);
            System.out.println("Session factory criada com sucesso.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao iniciar Session Factory. "+e.getLocalizedMessage());
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        HibernateUtil.sessionFactory = sessionFactory;
    }
    
}
