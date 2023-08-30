package com.apartment.examen_final.controller;

import com.apartment.examen_final.model.Client;
import com.apartment.examen_final.model.Payment;
import com.apartment.examen_final.service.clientService;
import com.apartment.examen_final.service.paymentService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class paymentController {
    private paymentService service;

    public paymentController(paymentService service){

        this.service=service;

    }
    @PostMapping("/insertPayment")
    public void insertPayment(@RequestBody Payment toInsert){

        service.insertPayment(toInsert);

    }

    @GetMapping("/allPayments")
    public List<Payment> findAllPayment() throws SQLException {

        return  service.findAllPayment();

    }

    @GetMapping("/findOnePayment/{idPayment}")
    public List<Payment> findPayment(@PathVariable int idPayment) throws SQLException{

        return service.findByIdPayment(idPayment);

    }
    @PutMapping("/updatePayment/{idPayment}")
    public void updatePayment(@RequestBody Payment toUpdate,@PathVariable int idPayment) throws SQLException {

        service.updatePayment(toUpdate,idPayment);

    }

    @DeleteMapping("/deletePayment/{idPayment}")
    public void deletePayment(@PathVariable int idPayment) throws SQLException{

        service.deletePayment(idPayment);

    }


}
