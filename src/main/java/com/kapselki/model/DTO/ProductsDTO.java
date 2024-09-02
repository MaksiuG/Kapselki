package com.kapselki.model.DTO;

import com.kapselki.model.Clients;
import jakarta.persistence.Column;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductsDTO {
    private String text;
    private boolean is_done;
    private Clients client;


    public ProductsDTO(String text, boolean is_done, Clients client) {
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
}
