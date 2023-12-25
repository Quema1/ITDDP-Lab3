package org.example.service;

import org.example.dao.ClientsDAO;
import org.example.dao.ClientsDAOInMemoryImpl;
import org.example.dao.DAOException;
import org.example.entities.Client;
import org.example.entities.Clients;
import jakarta.jws.HandlerChain;
import jakarta.jws.WebService;
import jakarta.xml.ws.Holder;

@HandlerChain(file = "security_handler.xml")
@WebService(serviceName="Clients",
		portName="ClientPort",
		endpointInterface="org.example.service.ClientService",
		targetNamespace="https://it.nure.ua/sport/service")
public class ClientServiceImpl implements ClientService {
	private static final ClientsDAO clientDao = ClientsDAOInMemoryImpl.instance();

	@Override
	public Client getClient(int id, String clientToken, Holder<String> serverToken) throws DAOException {
		return clientDao.findById(id);
	}

	@Override
	public Clients ClientsList(String clientToken, Holder<String> serverToken) {
		return clientDao.ClientsList();
	}

	@Override
	public int addClient(Client client, String clientToken, Holder<String> serverToken) throws DAOException {
		return clientDao.addClient(client);
	}

	@Override
	public Client deleteClient(int id, String clientToken, Holder<String> serverToken) throws DAOException {
		return clientDao.deleteClient(id);
	}

	@Override
	public int editClient(int id, Client client, String clientToken, Holder<String> serverToken) throws DAOException {
		return clientDao.editClient(id, client);
	}
}

