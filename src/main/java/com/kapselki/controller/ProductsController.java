package com.kapselki.controller;
import com.kapselki.Configuration.Mapp;
import com.kapselki.Exceptions.ClientNotFoundException;
import com.kapselki.Exceptions.CreatingClientException;
import com.kapselki.Exceptions.ProductNotFoundException;
import com.kapselki.menage.ClientsMng;
import com.kapselki.menage.ProductsMng;
import com.kapselki.model.Clients;
import com.kapselki.model.DTO.ProductsDTO;
import com.kapselki.model.Products;
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
@RequestMapping("api/products")
public class ProductsController {
    private ProductsMng productsMng;
    private Mapp mapp;
    private ClientsMng clientsMng;
    private Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Autowired
    public ProductsController(ProductsMng productsMng, Mapp mapp, ClientsMng clientsMng) {
        this.productsMng = productsMng;
        this.mapp = mapp;
        this.clientsMng = clientsMng;
    }
    @GetMapping("/findAllProducts")
    public List<ProductsDTO> findAll(){
        List<Products> list = productsMng.productsToList();
        return list
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @PostMapping("/addProduct")
    public ResponseEntity<Products> addProduct(@Validated @RequestBody ProductsDTO productsDTO){
        logger.info("Creating Product with Client's ID " + productsDTO.getClient().getClient_id());
        try {

            Clients clients = clientsMng.findClientByID(productsDTO.getClient().getClient_id())
                    .orElseThrow(() -> new ProductNotFoundException(productsDTO.getProduct_id()));

            productsDTO.setClients(clients);
            Products products = convertToEntity(productsDTO);
            productsMng.add(products);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch(CreatingClientException e){
            e.getMessage();
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/findProductByID/{id}")
    public Products findProductByID(@PathVariable Long id){
        logger.info("Searching product by ID "+ id);

        Optional<Products> products = productsMng.findProductByID(id);

        return products.orElseThrow(
                () -> new ProductNotFoundException(id)
        );
    }
    private ProductsDTO convertToDTO(Products products){
        return mapp.modelMapper()
                .map(products,ProductsDTO.class
                );
    }
    private Products convertToEntity(ProductsDTO productsDTO){
        return mapp.modelMapper()
                .map(productsDTO,Products.class
                );
    }
}