package com.apartment.examen_final.service;

import com.apartment.examen_final.model.Reservation;
import com.apartment.examen_final.repository.dao.ReservationDao;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class reservationService {
    private  ReservationDao dao;
    public reservationService(ReservationDao repository){

        this.dao=repository;

    }
    public List<Reservation> findAllReservation() throws SQLException {

        return dao.findAllReservation();

    }
    public void insertReservation (Reservation toInsert){

        dao.insertReservation(toInsert);

    }
    public  List<Reservation> findByIdReservation(int idReservation) throws  SQLException{

        return  dao.findByIdReservation(idReservation);

    }
    public void  deleteReservation(int idReservation) throws SQLException{

        dao.deleteByIdReservation(idReservation);

    }
    public void updateReservation(Reservation reservation,int idReservation) throws SQLException{

        dao.updateByIdReservation(reservation,idReservation);

    }

}
