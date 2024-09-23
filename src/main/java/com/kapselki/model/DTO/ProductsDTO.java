package com.kapselki.model.DTO;

import com.kapselki.model.Clients;
import jakarta.persistence.Column;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductsDTO {
    private Long product_id;
    private String text;
    private boolean is_done;
    private Clients client;


    public ProductsDTO(Long product_id, String text, boolean is_done, Clients client) {
        this.product_id = product_id;
        this.text = text;
        this.is_done = is_done;
        this.client = client;
    }

    public Clients getClient() {
        return client;
    }

    public void setClients(Clients clients) {
        this.client = clients;
    }

    public ProductsDTO() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isIs_done() {
        return is_done;
    }

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
