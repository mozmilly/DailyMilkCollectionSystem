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
public class AccountInfoBean implements Serializable{
    private String username;
    private int idNo;
    private String role;

    public AccountInfoBean() {
        this.username = "username";
        this.idNo = 0;
        this.role = "role";
    }

    public AccountInfoBean(String username, int idNo, String role) {
        this.username = username;
        this.idNo = idNo;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AccountInfoBean{" + "username=" + username + ", idNo=" + idNo + ", role=" + role + '}';
    }

}
