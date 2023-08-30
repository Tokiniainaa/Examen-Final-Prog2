package com.apartment.examen_final.repository.interfacee;

import com.apartment.examen_final.model.Client;
import java.sql.SQLException;
import java.util.List;

public interface ClientInterface {
    void insertClient(Client client);
    List<Client> findAllClient() throws SQLException;
    List<Client> findByIdClient (int idClient) throws SQLException;
    void deleteByIdClient (int idClient) throws SQLException;
    void updateByIdClient (Client client,int idClient);
}
