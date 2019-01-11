/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import models.User;
import models.enums.Role;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.mindrot.jbcrypt.BCrypt;
import servlets.Login;

/**
 * Web application lifecycle listener.
 *
 * @author enrico
 */
@WebListener()
public class ApplicationListener implements ServletContextListener {

    private SessionFactory factory;
    private ServiceRegistry registry;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Configuration configuration = new Configuration().configure();
            registry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(registry);
            sce.getServletContext().setAttribute("factory", factory);
            sce.getServletContext().setAttribute("registry", registry);
            Login.factory = factory;
            
            Session session = factory.openSession();
            Transaction tx = null;
            User admin = new User("admin", "admin", "", "admin@example.com",
                    721504494, "323, Nakuru", Role.ADMIN.toString(), BCrypt.hashpw("12345", BCrypt.gensalt()));
            try {
                tx = session.beginTransaction();
                session.saveOrUpdate(admin);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                System.err.println("Hibernate error occurred: " + e);
            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            System.err.println("Failed to create sessionFactory object: " + e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        factory = (SessionFactory) sce.getServletContext().getAttribute("factory");
        registry = (ServiceRegistry) sce.getServletContext().getAttribute("registry");
        try {
            factory.close();
            StandardServiceRegistryBuilder.destroy(registry);
        } catch (HibernateException e) {
            System.err.println("Failed to close factory: " + e);
        }
    }
}
