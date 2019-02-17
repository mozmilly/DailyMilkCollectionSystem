/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.InputStream;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author moses
 */
@Entity
@Table(name = "tender")
public class Tender implements java.io.Serializable {

    private int id;

    private String title;

    private byte[] document;

    private String start_date;
    
    private String end_date;

    public Tender() {
    }
    
    public Tender(int id, String title, byte[] document, String start_date, String end_date) {
        this.id = id;
        this.title = title;
        this.document = document;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    
    public Tender(String title, byte[] document, String start_date, String end_date) {
        this.title = title;
        this.document = document;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "start_date", nullable = false)
    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @Column(name = "end_date", nullable = false)
    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    
    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Lob
    @Column(name = "document", nullable = false)
    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

}
