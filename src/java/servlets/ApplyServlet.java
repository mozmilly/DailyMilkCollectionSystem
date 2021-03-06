/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Applicant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repository.ApplicantDaoImpl;

/**
 *
 * @author moses
 */
@WebServlet("/apply")
@MultipartConfig(maxFileSize = 16177215) 
public class ApplyServlet extends HttpServlet {
 
    public static SessionFactory factory;
    
    public ApplicantDaoImpl applicantDao;
    
    String error;
    String success;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/apply.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     System.out.println("sdfghj");
         if(req.getParameter("showAllApplication")!=null){
            List<Applicant> allApplicant = new ArrayList<Applicant>();
            System.out.println(allApplicant.size());
            allApplicant = applicantDao.findAllApplicants();
            req.setAttribute("applicantList", allApplicant);
             RequestDispatcher rd = req.getRequestDispatcher("all-applicant.jsp");
            rd.forward(req, resp);
        }
        try{
            
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            String firstname = req.getParameter("firstname");
            String lastname = req.getParameter("lastname");
            String email = req.getParameter("email");
            int nationalId = Integer.parseInt(req.getParameter("id"));
            int phone = Integer.parseInt(req.getParameter("phonenumber"));
            
            InputStream is = req.getPart("document").getInputStream();
            byte[] document = new byte[100000];
            is.read(document);
            Applicant applicant = new Applicant(nationalId, firstname, lastname, phone, email, document, true);
            session.saveOrUpdate(applicant);
            transaction.commit();
            session.close();
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            
        }catch(Exception e){
            error = e.getLocalizedMessage();
            req.setAttribute("error", error);
            
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
