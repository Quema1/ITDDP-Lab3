package org.example.dao;


import org.example.dao.soap.entities.Client;
import org.example.dao.soap.entities.Clients;

public interface ClientsDAO {
	public int addClient(Client item) throws Exception;
	public Client deleteClient(int id) throws Exception;
	public Clients ClientsList() throws Exception;
	public Client findById(Integer id) throws Exception;
	int editClient(int id, Client client) throws Exception;
}
