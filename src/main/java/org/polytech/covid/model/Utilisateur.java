package org.polytech.covid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userMail;

    private String role;

    private String firstName;

    private String lastName;

    private String passwordHash;

    @ManyToOne
    @JsonIgnoreProperties({"users"})
    private CentreVaccination centreVaccination;

    public Long getId() {
        return id;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getRole() {
        return role;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public CentreVaccination getCentreVaccination() {
        return centreVaccination;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setCentreVaccination(CentreVaccination centreVaccination) {
        this.centreVaccination = centreVaccination;
    }
}
