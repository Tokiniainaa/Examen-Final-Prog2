package com.apartment.examen_final.repository.interfacee;


import com.apartment.examen_final.model.Reservation;
import java.sql.SQLException;
import java.util.List;

public interface ReservationInterface {
    void insertReservation(Reservation reservation);
    List<Reservation> findAllReservation() throws SQLException;
    List<Reservation> findByIdReservation (int idReservation) throws SQLException;
    void deleteByIdReservation (int idReservation) throws SQLException;
    void updateByIdReservation (Reservation reservation,int idReservation);
}
