/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Mentor
 */
@Entity
@Table(name="MilkSupply")
public class MilkSupply implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "dateSupplied",nullable = false, columnDefinition = "Date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateSupplied;
    
    @Column(name = "milkAmountSupplied",length = 6,nullable=false)
    private int milkAmountSupplied;
    
    @Column(name = "remarks",unique = true,nullable = false,length = 200 )
    private String remarks;

    public MilkSupply(Date dateSupplied, int milkAmountSupplied, String remarks) {
        this.dateSupplied = dateSupplied;
        this.milkAmountSupplied = milkAmountSupplied;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(Date dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getMilkAmountSupplied() {
        return milkAmountSupplied;
    }

    public void setMilkAmountSupplied(int milkAmountSupplied) {
        this.milkAmountSupplied = milkAmountSupplied;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "MilkSupply{" + "dateSupplied=" + dateSupplied + '}';
    }
    
    
    
    
    
    
    
}
