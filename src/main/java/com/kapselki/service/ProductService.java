package com.kapselki.service;

import com.kapselki.menage.ClientsMng;
import com.kapselki.menage.ProductsMng;
import com.kapselki.model.Clients;
import com.kapselki.model.DTO.ClientsDTO;
import com.kapselki.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductsMng productsMng;
    private ClientsMng clientsMng;

    @Autowired
    public ProductService(ProductsMng productsMng, ClientsMng clientsMng) {
        this.productsMng = productsMng;
        this.clientsMng = clientsMng;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void add(){
        String text = "XD";
        boolean isdone = true;
        Clients clients = new Clients(2L,"jeb","blyat","jebac");
        clientsMng.add(clients);

        productsMng.add(new Products(1L,text,isdone,clients));
    }


}
