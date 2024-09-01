package com.kapselki.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Table
@Entity(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product", nullable = false)
    private Long id_product;

    @Column(name = "text")
    private String text;
    @Column(name = "is_done")
    private boolean is_done;

    @ManyToOne
    @JsonBackReference
    private Clients client;

    public Products() {
    }

    public Products(Long id_product, String text, boolean is_done, Clients client) {
        this.id_product = id_product;
        this.text = text;
        this.is_done = is_done;
        this.client = client;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public boolean isIs_done() {
        return is_done;
    }

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

}
