package com.kapselki.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Table
@Entity(name = "clients")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Clients {

    public Clients() {
    }

    public Clients(Long client_id, String name, String surname, String e_mail) {
        this.client_id = client_id;
        this.name = name;
        this.surname = surname;
        this.e_mail = e_mail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id", nullable = false)
    private Long client_id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "e_mail")
    private String e_mail;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Products> products;

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}
