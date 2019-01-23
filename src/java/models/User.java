package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements java.io.Serializable {
    @Id
    @Column(name = "username", length = 40)
    private String username;
    
    @Column(name = "nationalId", length = 8, nullable = false)
    private int nationalId;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "role", length = 8, nullable = false)
    private String role;

    public User() {
    }

    public User(String username, int nationalId, String password, String role) {
        this.username = username;
        this.nationalId = nationalId;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", nationalId=" + nationalId + ", password=" + password + ", role=" + role + '}';
    }

}
