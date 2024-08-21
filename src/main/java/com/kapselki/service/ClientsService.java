package com.kapselki.service;

import com.kapselki.Configuration.Mapp;
import com.kapselki.menage.ClientsMng;
import com.kapselki.model.Clients;
import com.kapselki.model.DTO.ClientsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {
    private ClientsMng clientsMng;
    private Mapp mapp;
@Autowired
    public ClientsService(ClientsMng clientsMng, Mapp mapp) {
        this.clientsMng = clientsMng;
        this.mapp = mapp;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void add(){
    String imie = "XD";
    String nazwisko = "XD";
    String email = "XD";

        ClientsDTO clientsDTO = new ClientsDTO(imie,nazwisko,email);
        Clients clients = mapp.modelMapper().map(clientsDTO,Clients.class);

        clientsMng.add(clients);
    }
}
