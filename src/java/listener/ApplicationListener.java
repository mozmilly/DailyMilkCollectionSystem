/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import factory.GetFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import models.Operator;
import models.Supplier;
import models.SupplyDetails;
import models.User;
import models.Tender;
import models.enums.Role;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.mindrot.jbcrypt.BCrypt;
import servlets.AccountDetailsServlet;
import servlets.ChangeDetailsServlet;
import servlets.LoginServlet;
import servlets.SupplierServlet;
import servlets.SupplyServlets;
import servlets.TenderServlet;

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
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Operator.class);
            configuration.addAnnotatedClass(Tender.class);
            configuration.addAnnotatedClass(SupplyDetails.class);
            configuration.addAnnotatedClass(Supplier.class);
            
            registry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(registry);
            sce.getServletContext().setAttribute("factory", factory);
            sce.getServletContext().setAttribute("registry", registry);
//            LoginServlet.factory = factory;
//            TenderServlet.factory = factory;
//            AccountDetailsServlet.factory = factory;
//            ChangeDetailsServlet.factory = factory;
//            SupplyServlets.factory = factory;
//            SupplierServlet.factory = factory;
            GetFactory.setFactory(factory);

            Session session = factory.openSession();
            Transaction tx = null;
            User admin = new User("admin", 87654321, BCrypt.hashpw("12345", BCrypt.gensalt()), Role.ADMIN.toString());
            User collector = new User("collector", 12345678, BCrypt.hashpw("54321", BCrypt.gensalt()), Role.COLLECTOR.toString());
            Operator operator1 = new Operator(87654321, "admin@example.com", admin, "admin");
            Operator operator2 = new Operator(12345678, "collector@example.com", collector, "collector");
            try {
                tx = session.beginTransaction();
                session.saveOrUpdate(admin);
                session.saveOrUpdate(collector);
                session.saveOrUpdate(operator1);
                session.saveOrUpdate(operator2);
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
            if ((factory != null) && (registry != null)) {
                factory.close();
                StandardServiceRegistryBuilder.destroy(registry);
            }
        } catch (HibernateException e) {
            System.err.println("Failed to close factory: " + e);
        }
    }
}
