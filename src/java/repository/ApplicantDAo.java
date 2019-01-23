/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import models.Applicant;
import java.util.List;

/**
 *
 * @author Mentor
 */
public interface ApplicantDAo {
   //Find all Employees
    public List<Applicant> findAllApplicants();
    
}
