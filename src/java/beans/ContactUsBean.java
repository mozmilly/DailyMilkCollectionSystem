/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import models.ContactUS;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Mentor
 */
public class ContactUsBean {
    
    
    
    //Save message
    public void saveMessage(Session session,ContactUS contactus){
        
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(contactus);
        transaction.commit();
        session.close();
        
    }
    
}
