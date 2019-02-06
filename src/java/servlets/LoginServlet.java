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
import javax.servlet.http.HttpSession;
import models.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author enrico
 */
public class LoginServlet extends HttpServlet {

    public static SessionFactory factory;
    String error;
    String success;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = factory.openSession();
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            String hql = "select from User as u where u.username=:username";
            Query query = session.createQuery(hql);
            query.setString("username", username);
            List list = query.list();
            if (list.size() == 1) {
                User user = (User) list.remove(0);
                if (BCrypt.checkpw(password, user.getPassword())) {
                    success = "Welcome!";

                    //create an empty account info bean
                    AccountInfoBean accountInfo = new AccountInfoBean();
                    //set username and nationalId in the bean
                    accountInfo.setUsername(username);
                    accountInfo.setIdNo(user.getNationalId());
                    accountInfo.setRole(user.getRole());
                    
                    HttpSession sessionScope = req.getSession();
                    sessionScope.setAttribute("loggedIn", true);
                    sessionScope.setAttribute("accountInfo", accountInfo);

                    req.setAttribute("success", success);
                    req.getRequestDispatcher("/tender.jsp").forward(req, resp);
                } else {
                    error = "Wrong credentials!";
                    req.setAttribute("error", error);
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
            } else if (list.size() > 1) {
                error = "More than one users with this username were found!";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                error = "No such user!";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            error = e.getLocalizedMessage();
            req.setAttribute("error", error);
            log("ERROR: ", e);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }finally{
            session.close();
        }
    }

}
