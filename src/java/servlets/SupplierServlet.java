/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factory.GetFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author moses
 */
public class SupplierServlet extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();
    String error;
    String success;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/add-supplier.jsp").forward(req, resp);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Session session = factory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            int nationalId = Integer.parseInt(req.getParameter("nationalId"));
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            int phone = Integer.parseInt(req.getParameter("phone"));
            String email = req.getParameter("email");
            
            Supplier supplier = new Supplier(nationalId, firstName, lastName, phone, email);
            session.saveOrUpdate(supplier);
            transaction.commit();
            success = "Supplier Added Successfully";
            req.setAttribute("success", success);
        } catch (Exception e) {
            error = "Error when adding supplier";
            req.setAttribute("error", error);
            e.printStackTrace();
        }finally{
            session.close();
            req.getRequestDispatcher("/add-supplier.jsp").forward(req, resp);
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
