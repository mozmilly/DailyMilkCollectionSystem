package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier implements java.io.Serializable {
    @Id
    @Column(name = "nationalId", length = 8)
    private int nationalId;

    @Column(name = "firstName", length = 20, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 20, nullable = false)
    private String lastName;

    @Column(name = "phone", nullable = false)
    private int phone;

    @Column(name = "email", length = 40)
    private String email;
    
    public Supplier() {
    }

    public Supplier(int nationalId, String firstName, String lastName, int phone, String email) {
        this.nationalId = nationalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
    
    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Supplier{" + "nationalId=" + nationalId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email + '}';
    }

}
