package com.kapselki.model.DTO;

import org.antlr.v4.runtime.misc.NotNull;

public class ClientsDTO {
    private Long clientID;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String e_mail;

    public ClientsDTO(Long clientID, String name, String surname, String e_mail) {
        this.clientID = clientID;
        this.name = name;
        this.surname = surname;
        this.e_mail = e_mail;
    }

    public ClientsDTO() {

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

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }
}
