package com.apartment.examen_final.repository.interfacee;

import com.apartment.examen_final.model.Apartment;
import java.sql.SQLException;
import java.util.List;

public interface ApartmentInterface {
    void insertApartment(Apartment apartment);
    List<Apartment> findAllApartment() throws SQLException;
    List<Apartment> findByIdApartment (int idApartment) throws SQLException;
    void deleteByIdApartment (int idApartment) throws SQLException;
    void updateByIdApartment (Apartment apartment,int idApartment);
}
