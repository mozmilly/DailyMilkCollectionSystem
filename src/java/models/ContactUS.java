/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Mentor
 */
@Entity
@Table(name="contactUS")
public class ContactUS implements Serializable {
    @Id
    private int id;
    
    @Column(name="fullName",length=100 ,nullable=false)
    private String fullName;
    
    @Column(name="email",length=50,nullable=false)
    private String email;
    
    @Column(name="message",length=255,nullable=false)
    private String message;
    
    @Column(name="PhoneNumber")
    private Integer phoneNumber;
    
    @Column(name="subject")
    private String subject;

    public ContactUS(String fullName, String email, String message, Integer phoneNumber, String subject) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.message = message;
        this.phoneNumber = phoneNumber;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
    
}
