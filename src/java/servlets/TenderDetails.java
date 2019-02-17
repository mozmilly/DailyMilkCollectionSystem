/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author enrico
 */
import beans.TenderBean;
import factory.GetFactory;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Tender;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class TenderDetails extends HttpServlet{

    public static SessionFactory factory = GetFactory.getFactory();
    String error;
    String success;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = factory.openSession();
        try {
            String hql = "SELECT FROM Tender ORDER BY id DESC LIMIT 1";
            
            Query query = session.createQuery(hql);
            List list = query.list();
            if (list.size() == 1) {
                Tender tender = (Tender) list.remove(0);
                TenderBean tenderBean = new TenderBean(tender.getId(), tender.getTitle(), 
                        tender.getDocument(), tender.getStart_date(), tender.getEnd_date());
                req.getSession().setAttribute("tenderBean", tenderBean);
                
                req.getRequestDispatcher("/tender-details.jsp").forward(req, resp);
            } else if (list.size() > 1) {
                error = "More than one tender with this id were found!";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("/DailyMilkCollectionSystem/create-tender");
            }
        } catch (Exception e) {
            error = e.getLocalizedMessage();
            req.setAttribute("error", error);
            log("ERROR: ", e);
            req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
        }finally{
            session.close();
        }
    }
}
