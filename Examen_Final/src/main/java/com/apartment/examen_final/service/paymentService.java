package com.apartment.examen_final.service;

import com.apartment.examen_final.model.Payment;
import com.apartment.examen_final.repository.dao.PaymentDao;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class paymentService {
    private PaymentDao dao;

    public paymentService(PaymentDao dao){

        this.dao=dao;

    }
    public List<Payment> findAllPayment() throws SQLException {

        return dao.findAllPayment();

    }
    public void insertPayment (Payment toInsert){

        dao.insertPayment(toInsert);

    }
    public  List<Payment> findByIdPayment(int idPayment) throws  SQLException{

        return  dao.findByIdPayment(idPayment);

    }
    public void  deletePayment(int idPayment) throws SQLException{

        dao.deleteByIdPayment(idPayment);

    }
    public void updatePayment(Payment payment,int idPayment) throws SQLException{

        dao.updateByIdPayment(payment,idPayment);

    }

}
