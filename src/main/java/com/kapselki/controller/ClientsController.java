package com.kapselki.controller;

import com.kapselki.Configuration.Mapp;
import com.kapselki.Exceptions.ClientNotFoundException;
import com.kapselki.Exceptions.CreatingClientException;
import com.kapselki.menage.ClientsMng;
import com.kapselki.model.Clients;
import com.kapselki.model.DTO.ClientsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientsController {
    private Logger logger = LoggerFactory.getLogger(LoggerFactory.class);
    private ClientsMng clientsMng;
    private Mapp mapp;


    @Autowired
    public ClientsController(Mapp mapp,ClientsMng clientsMng) {
        this.mapp = mapp;
        this.clientsMng = clientsMng;
    }
    //Works fine, for now
    @GetMapping("/findAll")
    public List<ClientsDTO> findAll(){
        List<Clients> list = clientsMng.clientsToList();
        return list
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/addClient")
    public ResponseEntity<Clients> addClient(@Validated @RequestBody ClientsDTO clientsDTO){
            logger.info("Creating Client with ID " + clientsDTO.getName());
            try {
                Clients clients = convertToEntity(clientsDTO);
                clientsMng.add(clients);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            catch(CreatingClientException e){
                e.getMessage();
                return ResponseEntity.internalServerError().build();
            }


    }
    @GetMapping("/findClientByID/{id}")
    public Clients findClientByID(@PathVariable Long id){
        logger.info("Searching Client by ID "+ id);


            Optional<Clients> client = clientsMng.findClientByID(id);

            return client.orElseThrow(() -> new ClientNotFoundException(id));

    }
    private ClientsDTO convertToDTO(Clients clients){
        return mapp.modelMapper().map(clients,ClientsDTO.class);
    }
    private Clients convertToEntity(ClientsDTO clientsDTO){
        return mapp.modelMapper().map(clientsDTO,Clients.class);
    }
}
