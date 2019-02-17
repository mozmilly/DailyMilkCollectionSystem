/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factory.GetFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Supplier;
import models.SupplyDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author moses
 */
public class SupplyServlets extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public static SessionFactory factory = GetFactory.getFactory();
    String error;
    String success;
    

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
        req.getRequestDispatcher("/recordSupply.jsp").forward(req, resp);
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
                int idNo = Integer.parseInt(req.getParameter("id"));
                int amount = Integer.parseInt(req.getParameter("amount"));
                String quality = req.getParameter("quality");
                String date = new Date().toString();
                
                String hql = "select from Supplier as s where s.nationalId=:id";
                Query query = session.createQuery(hql);
                query.setInteger("id", idNo);
                List list = query.list();
                if (list.size() == 1) {
                    Supplier supplier = (Supplier) list.remove(0);
                    SupplyDetails sd = new SupplyDetails(amount, quality, date, supplier);
                    session.saveOrUpdate(sd);
                    transaction.commit();
                    success = "Recorded Successfully";
                    req.setAttribute("success", success);
                }else{
                    error = "Supplier doesn't exist";
                    req.setAttribute("error", error);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                session.close();
                req.getRequestDispatcher("/recordSupply.jsp").forward(req, resp);
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
