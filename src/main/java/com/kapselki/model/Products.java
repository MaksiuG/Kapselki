package com.kapselki.model;

import jakarta.persistence.*;

@Table
@Entity(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product", nullable = false)
    private Long id_product;

    @Column(name = "text")
    private String napis;
    @Column(name = "is_done")
    private boolean czy_zrobione;
    @Column(name = "id_client")
    private Long id_klienta;

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public String getNapis() {
        return napis;
    }

    public void setNapis(String napis) {
        this.napis = napis;
    }

    public boolean isCzy_zrobione() {
        return czy_zrobione;
    }

    public void setCzy_zrobione(boolean czy_zrobione) {
        this.czy_zrobione = czy_zrobione;
    }

    public Long getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(Long id_klienta) {
        this.id_klienta = id_klienta;
    }
}
