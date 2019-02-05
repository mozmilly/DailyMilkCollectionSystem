/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import servlets.TenderServlet;
import models.Tender;
import org.hibernate.Transaction;

/**
 *
 * @author Mentor
 */
public class TenderBean {
    
    //Find all milk supply history corresponding to the supplier
    public List<Tender> findAllTenders(){
        // Open a session
      Session session = TenderServlet.factory.openSession();
     
     //Criteria builder
      Criteria criteria = session.createCriteria(Tender.class);
      List<Tender> tenders = new ArrayList<>();
      tenders = criteria.list();      
     
      session.close();
    
      return tenders;        
    }
    
    
    //save tender
    public void saveOrUpdateTender(Tender tender,Session session){
         Transaction transaction = session.beginTransaction();
         
         session.saveOrUpdate(tender);
         
         transaction.commit();
         session.close();
        
    }
}
