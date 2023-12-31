package org.example.dao;

import org.example.entities.Client;
import org.example.entities.Clients;

public interface ClientsDAO {
	public int addClient(Client item) throws DAOException;
	public Client deleteClient(int id) throws DAOException;
	public Clients ClientsList();
	public Client findById(Integer id) throws DAOException;
	int editClient(int id, Client client) throws DAOException;
}
