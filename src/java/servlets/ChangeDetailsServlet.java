/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.AccountInfoBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author enrico
 */
public class ChangeDetailsServlet extends HttpServlet {

    public static SessionFactory factory;
    String error;
    String success;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = factory.openSession();
        try {
            AccountInfoBean accountInfo = (AccountInfoBean)req.getSession().getAttribute("accountInfo");
            String username = accountInfo.getUsername();
            String oldPassword = req.getParameter("oldPassword");
            String newPassword = req.getParameter("newPassword2");

            String hql = "select from User as u where u.username=:username";
            Query query = session.createQuery(hql);
            query.setString("username", username);
            List list = query.list();
            if (list.size() == 1) {
                User user = (User) list.remove(0);
                if (BCrypt.checkpw(oldPassword, user.getPassword())) {
                    user.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
                    
                    Transaction tx = null;
                    try {
                        tx = session.beginTransaction();
                        session.saveOrUpdate(user);
                        tx.commit();
                    } catch (HibernateException e) {
                        if (tx != null) {
                            tx.rollback();
                        }
                        System.err.println("Hibernate error occurred: " + e);
                    } finally {
                        session.close();
                    }

                    success = "password changed successfully";
                    
                    req.setAttribute("success", success);
                    req.getRequestDispatcher("/account-details.jsp").forward(req, resp);
                } else {
                    error = "Wrong password!";
                    req.setAttribute("error", error);
                    req.getRequestDispatcher("/account-details.jsp").forward(req, resp);
                }
            } else if (list.size() > 1) {
                error = "More than one users with this username were found!";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/account-details.jsp").forward(req, resp);
            } else {
                error = "No such user!";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/account-details.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            error = e.getLocalizedMessage();
            req.setAttribute("error", error);
            log("ERROR: ", e);
            req.getRequestDispatcher("/account-details.jsp").forward(req, resp);
        } finally {
            session.close();
        }
    }
    
}
