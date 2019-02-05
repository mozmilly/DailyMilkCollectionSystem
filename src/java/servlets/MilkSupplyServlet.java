/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
import models.MilkSupply;
import org.hibernate.SessionFactory;
import beans.MilkSupplyBean;


/**
 *
 * @author Mentor
 */
public class MilkSupplyServlet extends HttpServlet {
   public static SessionFactory factory;
   
    //
    MilkSupplyBean milkSupplyDao = new MilkSupplyBean();
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Retrieve all applications from the database
        List<MilkSupply> supplyHistory = new ArrayList<>();
        supplyHistory = milkSupplyDao.findAllSupply();
        
        request.setAttribute("milkSupply", supplyHistory);    
        
         RequestDispatcher rd = request.getRequestDispatcher("milkSupply/supplied_milk.jsp");
         rd.forward(request, response);
       
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
    }

    
}
