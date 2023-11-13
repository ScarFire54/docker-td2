package org.polytech.covid.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CentreVaccination {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    private String postalCode;

    private String city;

    private String phone;

    @OneToMany
    @JsonIgnoreProperties({"centreVaccination", "passwordHash"})
    private List<Utilisateur> users;

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public List<Utilisateur> getUsers() {
        return users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setUsers(List<Utilisateur> users) {
        this.users = users;
    }
    
    public void addUser(Utilisateur user){
        if(this.users != null) this.users.add(user);
        else {
            List<Utilisateur> listUsers = new ArrayList<>();
            listUsers.add(user);
            this.users = listUsers;
        }
    }
}
