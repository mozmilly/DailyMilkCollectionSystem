/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.ContactUsBean;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import models.ContactUS;

/**
 *
 * @author Mentor
 */
public class ContactUSServlet extends HttpServlet {
      public static SessionFactory factory;
      ContactUsBean contactusDao = new ContactUsBean();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          request.getRequestDispatcher("/Contactus.jsp").forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Create hibernate session
        Session session = factory.openSession();
        
        //Get parameters
        String fullName = request.getParameter("fullname");
        Integer phoneNumber = Integer.parseInt(request.getParameter("phonenumber"));
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = "dfghjkl";//request.getParameter("asdfghjk");
       
        ContactUS contactus = new ContactUS(fullName,email,message,phoneNumber,subject);
        contactusDao.saveMessage(session, contactus);
        
        request.getRequestDispatcher("/login").forward(request, response);
        
    }

   

}
