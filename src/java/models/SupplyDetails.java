/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import models.Supplier;

/**
 *
 * @author moses
 */
@Entity
@Table( name = "supply_details")
public class SupplyDetails implements java.io.Serializable{
    
    private int idNo;
    private double amount;
    private String quality;
    private String date;
    private Supplier supplier;



    public SupplyDetails(int idNo, double amount, String quality, String date) {
        this.idNo = idNo;
        this.amount = amount;
        this.quality = quality;
        this.date = date;
    }

    @Id
    @Column(name = "id_number")
    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "quality")
    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
}
