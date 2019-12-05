package be.ehb.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String naam;
    private String email;
    private int telefoonNr;


    public Employee(int id, String naam, String email, int telefoonNr) {
        this.id = id;
        this.naam = naam;
        this.email = email;
        this.telefoonNr = telefoonNr;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefoonNr() {
        return telefoonNr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefoonNr(int telefoonNr) {
        this.telefoonNr = telefoonNr;
    }

    @Override
    public String toString() {
        return "Emloyee{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", email='" + email + '\'' +
                ", telefoonNr=" + telefoonNr +
                '}';
    }
}
