package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operator")
public class Operator implements java.io.Serializable {
    @Id
    @Column(name = "nationalId", length = 8)
    private int nationalId;

    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "name", length = 20)
    private String name;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;
    
    public Operator() {
    }

    public Operator(int nationalId, String email, User user, String name) {
        this.nationalId = nationalId;
        this.email = email;
        this.user = user;
        this.name = name;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Operator{" + "nationalId=" + nationalId + ", email=" + email + ", name=" + name + ", user=" + user + '}';
    }

}