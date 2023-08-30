package com.apartment.examen_final.service;

import com.apartment.examen_final.model.Client;
import com.apartment.examen_final.repository.dao.ClientDao;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class clientService {
    private  ClientDao dao;
    public clientService(ClientDao repository){

        System.out.println("Calling the constructor of service ");

        this.dao=repository;

    }
    public List<Client> findAllClient() throws SQLException{

        return dao.findAllClient();

    }
    public void insertClient (Client toInsert){

        dao.insertClient(toInsert);
    }
    public  List<Client> findByIdClient(int idClient) throws  SQLException{

        return  dao.findByIdClient(idClient);

    }
    public void  deleteClient(int idClient) throws SQLException{

         dao.deleteByIdClient(idClient);

    }
public void updateClient(Client client,int idClient) throws SQLException{

        dao.updateByIdClient(client,idClient);

}


}
