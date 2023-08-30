package com.apartment.examen_final.repository.dao;

import com.apartment.examen_final.model.Payment;
import com.apartment.examen_final.repository.interfacee.PaymentInterface;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



@Repository
public class PaymentDao implements PaymentInterface {
    private Connection connection;

    public PaymentDao(Connection connection){
        this.connection = connection;
    }
    @Override
    public void insertPayment(Payment payment) {

        String sql ="INSERT INTO payment (id_reservation,payment_date) values (?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, payment.getIdReservation());
            statement.setString(2, payment.getPaymentDate());

            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Payment> findAllPayment() throws SQLException {

        List<Payment> allPayment = new ArrayList<>();

        String sql = "SELECT * FROM payment";

        try (PreparedStatement preparedStatement =connection.prepareStatement(sql)) {

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){

                convertToList(allPayment, result);

            }
        }
        return allPayment;
    }

    @Override
    public List<Payment> findByIdPayment(int idPayment) throws SQLException {

        List<Payment> payment = new ArrayList<>();

        String sql = "SELECT * FROM payment where id_payment =?";

        try (PreparedStatement preparedStatement =connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,idPayment);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){

                convertToList(payment, result);
            }
        }
        return payment;
    }

    @Override
    public void deleteByIdPayment(int idPayment) throws SQLException {

        String sql ="DELETE  FROM payment where id_payment=?";

        try (PreparedStatement preparedStatement=connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,idPayment);

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateByIdPayment(Payment payment,int idPayment) {

        String sql ="UPDATE payment set id_reservation=?,payment_date=? WHERE id_payment=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, payment.getIdReservation());
            statement.setString(2, payment.getPaymentDate());

            statement.setInt(3,payment.getIdPayment());

            statement.executeUpdate();

        } catch (SQLException ex) {

            throw new RuntimeException(ex);

        }
    }
    private void convertToList(List<Payment> allPayment, ResultSet result) throws SQLException {

        allPayment.add(new Payment(

                result.getInt("id_payment"),
                result.getInt("id_reservation"),
                result.getString("payment_date")


        ));
    }
}
