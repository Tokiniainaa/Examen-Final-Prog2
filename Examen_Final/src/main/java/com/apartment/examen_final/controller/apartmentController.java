package com.apartment.examen_final.controller;

import com.apartment.examen_final.model.Apartment;
import com.apartment.examen_final.service.apartmentService;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
public class apartmentController {
    private apartmentService service;

    public apartmentController(apartmentService service){

        System.out.println("calling the constructor of the controller");
        this.service=service;

    }

    @PostMapping("/insertApartment")
    public void insertApartment(@RequestBody Apartment toInsert){

        service.insertApartment(toInsert

        );
    }
    @GetMapping("/allApartments")
    public List<Apartment> findAllApartment() throws SQLException {

        return  service.findAllApartment();

    }
    @GetMapping("/findOneApartment/{idApartment}")
    public List<Apartment> findApartment(@PathVariable int idApartment) throws SQLException{

        return service.findByIdApartment(idApartment);

    }
    @PutMapping("/updateApartment/{idApartment}")
    public void updateApartment(@RequestBody Apartment toUpdate,@PathVariable int idApartment) throws SQLException {

        service.updateApartment(toUpdate,idApartment);

    }

    @DeleteMapping("/deleteApartment/{idApartment}")

    public void deleteApartment(@PathVariable int idApartment) throws SQLException{

        service.deleteApartment(idApartment);

    }
}
