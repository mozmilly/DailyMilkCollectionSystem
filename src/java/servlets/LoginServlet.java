/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.AccountInfoBean;
import factory.GetFactory;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static SessionFactory factory = GetFactory.getFactory();
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
                    String role = user.getRole();
                    //set username and nationalId in the bean
                    accountInfo.setUsername(username);
                    accountInfo.setIdNo(user.getNationalId());
                    accountInfo.setRole(role);
                    
                    HttpSession sessionScope = req.getSession();
                    sessionScope.setAttribute("loggedIn", true);
                    sessionScope.setAttribute("accountInfo", accountInfo);

                    req.setAttribute("success", success);
                    if(role.equals("ADMIN")){
                        query = session.createSQLQuery("select end_date from Tender order by id desc limit 1");
                        
                        String end_date = query.toString();
                        Date date = new Date();
                        String DATE_FORMAT = "yyyy-mm-dd";
                        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                        String current_date = sdf.format(date);
                        if (current_date.compareTo(end_date)<0){
                            resp.sendRedirect("/DailyMilkCollectionSystem/tender-details");
                        } else if(current_date.compareTo(end_date)==0){
                            resp.sendRedirect("/DailyMilkCollectionSystem/tender-details");
                        } else {
                            resp.sendRedirect("/DailyMilkCollectionSystem/create-tender");
                        }
                    }else if(role.equals("COLLECTOR")){
                        req.getRequestDispatcher("/recordSupply.jsp").forward(req, resp);
                    }else{
                        error = "Unrecognized user!";
                        req.setAttribute("error", error);
                        req.getRequestDispatcher("/login.jsp").forward(req, resp);
                    }
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
