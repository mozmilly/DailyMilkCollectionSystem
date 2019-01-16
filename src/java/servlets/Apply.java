/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import static servlets.Login.factory;

/**
 *
 * @author moses
 */
@WebServlet("/apply")
public class Apply extends HttpServlet {
 
    public static SessionFactory factory;
    
    String error;
    String success;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/apply.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = factory.openSession();
        try{
            String firstname = req.getParameter("firstname");
            String lastname = req.getParameter("lastname");
            String email = req.getParameter("email");
            int nationalId = Integer.parseInt(req.getParameter("id"));
            int phone = Integer.parseInt(req.getParameter("phonenumber"));
        }catch(Exception e){
            error = e.getLocalizedMessage();
            req.setAttribute("error", error);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
