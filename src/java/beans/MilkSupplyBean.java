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
import org.hibernate.SessionFactory;

import models.MilkSupply;

/**
 *
 * @author Mentor
 */
public class MilkSupplyBean {
    private SessionFactory factory;
    
    
    
    //Find all milk supply history corresponding to the supplier
    public List<MilkSupply> findAllSupply(){
        // Open a session
     Session session = factory.openSession();
     
     //Criteria builder
      Criteria criteria = session.createCriteria(MilkSupply.class);
      List<MilkSupply> supply = new ArrayList<>();
      supply = criteria.list();      
     
      session.close();
    
      return supply;        
    }
    
}
