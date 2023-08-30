package com.apartment.examen_final.repository.dao;


import com.apartment.examen_final.model.Reservation;
import com.apartment.examen_final.repository.interfacee.ReservationInterface;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationDao implements ReservationInterface {
    private Connection connection;

    public ReservationDao (Connection connection){
        this.connection = connection;
    }
    @Override
    public void insertReservation(Reservation reservation) {

        String sql ="INSERT INTO reservation (id_apartment,id_client,reservation_date) values (?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, reservation.getIdApartment());
            statement.setInt(2, reservation.getIdClient());
            statement.setString(3,reservation.getReservationDate());

            statement.executeUpdate();

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Reservation> findAllReservation() throws SQLException {

        List<Reservation> allReservation = new ArrayList<>();

        String sql = "SELECT * FROM reservation";

        try (PreparedStatement preparedStatement =connection.prepareStatement(sql)) {

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){

                convertToList(allReservation, result);
            }
        }
        return allReservation;
    }

    @Override
    public List<Reservation> findByIdReservation(int idReservation) throws SQLException {

        List<Reservation> reservation = new ArrayList<>();

        String sql = "SELECT * FROM reservation where id_reservation =?";

        try (PreparedStatement preparedStatement =connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,idReservation);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){

                convertToList(reservation, result);
            }
        }
        return reservation;
    }

    @Override
    public void deleteByIdReservation(int idReservation) throws SQLException {

        String sql ="DELETE  FROM reservation where id_reservation=?";

        try (PreparedStatement preparedStatement=connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,idReservation);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateByIdReservation(Reservation reservation,int idReservation) {

        String sql ="UPDATE reservation set id_apartment=?,id_client=?,reservation_date=? WHERE id_reservation=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, reservation.getIdApartment());
            statement.setInt(2, reservation.getIdClient());
            statement.setString(3,reservation.getReservationDate());

            statement.setInt(4,reservation.getIdReservation());



            statement.executeUpdate();
        } catch (SQLException ex) {

            throw new RuntimeException(ex);

        }
    }
    private void convertToList(List<Reservation> allReservation, ResultSet result) throws SQLException {
        allReservation.add(new Reservation(

                result.getInt("id_reservation"),
                result.getInt("id_apartment"),
                result.getInt("id_client"),
                result.getString("reservation_date")


        ));
    }
}
