/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.TenderBean;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Tender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author
 */
@MultipartConfig()
public class TenderServlet extends HttpServlet {

    public static SessionFactory factory;
    public String error;
    public TenderBean tenderDao = new TenderBean();
    
    Tender tenderview  = null;
    

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
        
        //All tenders as a List
        List<Tender> tenders = new ArrayList<>();
        tenders = tenderDao.findAllTenders();
       
//        HttpSession session = req.getSession(true);
//        
//         resp.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = resp.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//          
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet DisplayDocServlet</title>");            
//            out.println("</head>");            
//            out.println("<body>");
//             for(Tender tender: tenders){
//              out.println("<h1> Name" + tender.getTitle() + "</h1> <br />");              
//              tenderview = tender;
//              out.println("<a href=\"tenderDocServlet\" target=\"_blank\" >pdf</a><br />");
//              out.println("=============================================================");
//             }
//            out.println("</body>");
//            out.println("</html>");
//        }
      if(!tenders.isEmpty()){
           for(Tender tender:tenders){
                System.out.println(tender);
//                
//                // byte[] b = tender.getDocument();
//                //resp.setContentType("application/pdf");
//                //resp.setContentLength(b.length);
//                //resp.getOutputStream().write(b);
           }
           
        }else{
            System.out.println("tender list is empty");
        }
        //add tenders list object to session attributes
        req.setAttribute("tenders", tenders);
        
        
        
        
//         resp.setHeader("Content-Disposition", "inline; filename=\"report.pdf\"");
//            //response.setDateHeader("Expires", -1);
        

            ///resp.setContentType("application/pdf");
            //resp.setContentLength();

        // resp.getOutputStream().write();
        
        
       req.getRequestDispatcher("view_tenders.jsp").forward(req, resp);

    }
    
    
    public byte[] tender(){
        return tenderview.getDocument();
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
            //Reg params
            String title = req.getParameter("title");
            InputStream is = req.getPart("file_upload").getInputStream();
            String startDate = req.getParameter("start_date");
            String endDate = req.getParameter("end_date");
            byte[] document = new byte[100000];
            is.read(document);
            
            Tender tender = new Tender(title, document, startDate, endDate);
          
            //Save to db
            tenderDao.saveOrUpdateTender(tender, session);
            
            req.getRequestDispatcher("/login.jsp").forward(req, resp);

        } catch (Exception e) {
            error = e.getLocalizedMessage();
            req.setAttribute("error", error);
            System.out.println(error);

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
