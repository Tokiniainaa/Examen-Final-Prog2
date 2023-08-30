package com.apartment.examen_final.repository.dao;

import com.apartment.examen_final.model.Apartment;
import com.apartment.examen_final.repository.interfacee.ApartmentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository

public class ApartmentDao implements ApartmentInterface {
    private  Connection connection;

    public ApartmentDao (Connection connection){
        this.connection = connection;
    }

    @Override
    public void insertApartment(Apartment apartment) {

        String sql ="INSERT INTO apartment (location,number_of_room,is_available) values (?,?,?)";

             try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, apartment.getLocation());
            statement.setInt(2, apartment.getNumberOfRoom());
            statement.setBoolean(3, apartment.isAvailable());

            statement.executeUpdate();
            }
             catch (SQLException ex) {

            throw new RuntimeException(ex);

        }
    }

    @Override
    public List<Apartment> findAllApartment() throws SQLException {

        List<Apartment> allApartement = new ArrayList<>();

        String sql = "SELECT * FROM apartment";

        try (PreparedStatement preparedStatement =connection.prepareStatement(sql)) {

            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){

                convertToList(allApartement, result);

            }
        }
        return allApartement;
    }

    @Override
    public List<Apartment> findByIdApartment(int idApartment) throws SQLException {

        List<Apartment> apartment = new ArrayList<>();

        String sql = "SELECT * FROM apartment where id_apartment =?";

        try (PreparedStatement preparedStatement =connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,idApartment);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){

                convertToList(apartment, result);
            }
        }
        return apartment;
    }

    @Override
    public void deleteByIdApartment(int idApartment) throws SQLException {

        String sql ="DELETE  FROM apartment where id_apartment=?";

        try (PreparedStatement preparedStatement=connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,idApartment);

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateByIdApartment(Apartment apartment,int idApartment) {

        String sql ="UPDATE apartment set location=?,number_of_room=?,is_available=? WHERE id_apartment=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, apartment.getLocation());
            statement.setInt(2, apartment.getNumberOfRoom());
            statement.setBoolean(3, apartment.isAvailable());
            statement.setInt(4,apartment.getIdApartment());


            statement.executeUpdate();

        } catch (SQLException ex) {

            throw new RuntimeException(ex);

        }
    }
    private void convertToList(List<Apartment> allApartment, ResultSet result) throws SQLException {
        allApartment.add(new Apartment(
                result.getInt("id_Apartment"),
                result.getString("location"),
                result.getInt("number_of_room"),
                result.getBoolean("is_available")


        ));
    }
}
