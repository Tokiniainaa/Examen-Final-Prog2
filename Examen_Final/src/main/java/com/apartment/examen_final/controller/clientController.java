package com.apartment.examen_final.controller;

import com.apartment.examen_final.model.Client;
import com.apartment.examen_final.service.clientService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController

public class clientController {
    private clientService service;

    public clientController(clientService service){

        System.out.println("calling the constructor of the controller");
        this.service=service;

    }
    @PostMapping("/insertClient")
    public void insertClient(@RequestBody Client toInsert){

        service.insertClient(toInsert);

    }

    @GetMapping("/allClients")
    public List<Client> findAllClient() throws SQLException{

        return  service.findAllClient();

    }

    @GetMapping("/findOneClient/{idClient}")
    public List<Client> findClient(@PathVariable int idClient) throws SQLException{

        return service.findByIdClient(idClient);

    }
    @PutMapping("/updateClient/{idClient}")
    public void updateClient(@RequestBody Client toUpdate,@PathVariable int idClient) throws SQLException {

        service.updateClient(toUpdate,idClient);

    }

    @DeleteMapping("/deleteClient/{idClient}")
    public void deleteClient(@PathVariable int idClient) throws SQLException{

        service.deleteClient(idClient);

    }



}
