package com.apartment.examen_final.repository.interfacee;

import com.apartment.examen_final.model.Payment;
import java.sql.SQLException;
import java.util.List;

public interface PaymentInterface {
    void insertPayment(Payment payment);
    List<Payment> findAllPayment() throws SQLException;
    List<Payment> findByIdPayment (int idPayment) throws SQLException;
    void deleteByIdPayment (int idPayment) throws SQLException;
    void updateByIdPayment (Payment payment,int idPayment);
}
