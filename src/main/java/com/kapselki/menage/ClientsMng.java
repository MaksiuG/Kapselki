package com.kapselki.menage;

import com.kapselki.model.Clients;
import com.kapselki.model.repo.ClientsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ClientsMng {
    private ClientsRepo clientsRepo;

    @Autowired
    public ClientsMng(ClientsRepo clientsRepo) {
        this.clientsRepo = clientsRepo;
    }

    public List<Clients> clientsToList(){
        return clientsRepo.findAll();
    }
    public Iterable<Clients> findAll(){
        return clientsRepo.findAll();
    }

    public Optional<Clients> findClientByID(@RequestParam Long id){
        return clientsRepo.findById(id);
    }

    public Clients add(@RequestBody  Clients clients){
        return clientsRepo.saveAndFlush(clients);
    }

    public Clients addPatch(Clients clients){
        return clientsRepo.save(clients);
    }

    public void delete(Long id){
        clientsRepo.deleteById(id);
    }

    public Page<Clients> getAllClientsPage(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return clientsRepo.findAll(pageable);
    }


}
