package com.kapselki.model.DTO;

import jakarta.persistence.Column;

public class ProductsDTO {
    private String napis;
    private boolean czy_zrobione;
    private Long id_klienta;

    public ProductsDTO(String napis, boolean czy_zrobione, Long id_klienta) {
        this.napis = napis;
        this.czy_zrobione = czy_zrobione;
        this.id_klienta = id_klienta;
    }

    public ProductsDTO() {
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
