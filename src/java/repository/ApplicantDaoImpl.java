/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.Applicant;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author Mentor
 */
public class ApplicantDaoImpl implements ApplicantDAo{
    public static SessionFactory factory;

    //Return all applicants as a list
    @Override
    public List<Applicant> findAllApplicants() {
        
        List<Applicant> applicantList = new ArrayList<>();
        
        //open session
        Session session = factory.openSession(); 
        
        //create query
        Query query = session.createQuery("From Applicant");
        applicantList = query.list();
         return applicantList ;
        
    }
    
}
