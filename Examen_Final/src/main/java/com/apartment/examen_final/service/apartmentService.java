package com.apartment.examen_final.service;

import com.apartment.examen_final.model.Apartment;
import com.apartment.examen_final.repository.dao.ApartmentDao;
import com.apartment.examen_final.repository.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;
@Service
public class apartmentService {

    private  ApartmentDao dao;


    public apartmentService(ApartmentDao dao) {

    this.dao = dao;

    }

    public void insertApartment (Apartment toInsert){

        dao.insertApartment(toInsert);
    }
    public List<Apartment> findAllApartment() throws SQLException {

        return dao.findAllApartment();
    }
    public  List<Apartment> findByIdApartment(int idApartment) throws  SQLException{

        return  dao.findByIdApartment(idApartment);

    }
    public void  deleteApartment(int idApartment) throws SQLException{

        dao.deleteByIdApartment(idApartment);

    }
    public void updateApartment(Apartment apartment,int idApartment) throws SQLException{

        dao.updateByIdApartment(apartment,idApartment);

    }
}
