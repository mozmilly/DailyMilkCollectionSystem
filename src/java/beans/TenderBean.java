/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author enrico
 */
public class TenderBean implements Serializable{
    private int id;
    private String title;
    private byte[] document;
    private String start_date;
    private String end_date;

    public TenderBean() {
        this.id = 0;
        this.title = "Title";
        this.document = new byte[0];
        this.start_date = "start_date";
        this.end_date = "end_date";
    }

    public TenderBean(int id, String title, byte[] document, String start_date, String end_date) {
        this.id = id;
        this.title = title;
        this.document = document;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "TenderBean{" + "id=" + id + ", title=" + title + ", start_date=" + start_date + ", end_date=" + end_date + '}';
    }
    
}
