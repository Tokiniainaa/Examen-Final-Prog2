package com.apartment.examen_final.repository.dao;

import com.apartment.examen_final.model.Client;
import com.apartment.examen_final.repository.interfacee.ClientInterface;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientDao implements ClientInterface {
    private  Connection connection;

    public ClientDao(Connection connection){

        this.connection = connection;
    }
    @Override
    public void insertClient(Client client) {

    String sql ="INSERT INTO client (first_name,last_name,phone_number,nationality)values(?,?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getPhoneNumber());
            statement.setString(4,client.getNationality());

            statement.executeUpdate();

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Client> findAllClient() throws SQLException {

      List<Client> allClient = new ArrayList<>();

      String sql = "SELECT * FROM client";

      try (PreparedStatement preparedStatement =connection.prepareStatement(sql)) {

          ResultSet result = preparedStatement.executeQuery();

          while(result.next()){
              convertToList(allClient, result);
          }
      }
      return allClient;
    }


    @Override
    public List<Client> findByIdClient(int idClient) throws SQLException {

        List<Client> Client = new ArrayList<>();

        String sql = "SELECT * FROM client where id_client =?";

        try (PreparedStatement preparedStatement =connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,idClient);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){

                convertToList(Client, result);
            }
        }
        return Client;
    }

    @Override
    public void deleteByIdClient(int idCLient) throws SQLException {

        String sql ="DELETE  FROM client where id_client=?";

try (PreparedStatement preparedStatement=connection.prepareStatement(sql)) {

    preparedStatement.setInt(1,idCLient);

    preparedStatement.executeUpdate();
}
    }

    @Override
    public void updateByIdClient(Client client,int idClient) {

        String sql ="UPDATE client set first_name=?,last_name=?,phone_number=?,nationality=? WHERE ID_CLIENT=?;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getPhoneNumber());
            statement.setString(4,client.getNationality());
            statement.setInt(5,idClient);

            statement.executeUpdate();
        } catch (SQLException ex) {

            throw new RuntimeException(ex);

        }
    }
    private void convertToList(List<Client> allClient, ResultSet result) throws SQLException {
        allClient.add(new Client(
                result.getInt("id_client"),
                result.getString("first_name"),
                result.getString("last_name"),
                result.getString("phone_number"),
                result.getString("nationality")

        ));
    }
}
