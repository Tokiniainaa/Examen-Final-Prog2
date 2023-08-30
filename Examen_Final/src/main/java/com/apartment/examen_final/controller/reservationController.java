package com.apartment.examen_final.controller;

import com.apartment.examen_final.model.Apartment;
import com.apartment.examen_final.model.Reservation;
import com.apartment.examen_final.service.apartmentService;
import com.apartment.examen_final.service.reservationService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class reservationController {
    private reservationService service;
    public reservationController(reservationService service){

        this.service=service;

    }
    @PostMapping("/insertReservation")
    public void insertReservation(@RequestBody Reservation toInsert){

        service.insertReservation(toInsert);

    }
    @GetMapping("/allReservations")
    public List<Reservation> findAllReservation() throws SQLException {

        return  service.findAllReservation();

    }
    @GetMapping("/findOneReservation/{idReservation}")
    public List<Reservation> findReservation(@PathVariable int idReservation) throws SQLException{

        return service.findByIdReservation(idReservation);

    }
    @PutMapping("/updateReservation/{idReservation}")
    public void updateReservation(@RequestBody Reservation  toUpdate,@PathVariable int idReservation) throws SQLException {

        service.updateReservation(toUpdate,idReservation);

    }

    @DeleteMapping("/deleteReservation/{idReservation}")
    public void deleteReservation(@PathVariable int idReservation) throws SQLException{

        service.deleteReservation(idReservation);

    }
}
