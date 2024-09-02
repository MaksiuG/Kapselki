package com.kapselki.menage;

import com.kapselki.model.Clients;
import com.kapselki.model.Products;
import com.kapselki.model.repo.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsMng {
    private ProductsRepo productsRepo;

    @Autowired
    public ProductsMng(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }
    public List<Products> productsToList(){
        return productsRepo.findAll();
    }
    public Iterable<Products> findAll(){
        return productsRepo.findAll();
    }

    public Optional<Products> findProductByID(@RequestParam Long id){
        return productsRepo.findById(id);
    }

    public Products add(Products products){
        return productsRepo.saveAndFlush(products);
    }

    public Products addPatch(Products products){
        return productsRepo.save(products);
    }

    public void delete(Long id){
        productsRepo.deleteById(id);
    }

    public Page<Products> getAllProductsPage(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return productsRepo.findAll(pageable);
    }
}
