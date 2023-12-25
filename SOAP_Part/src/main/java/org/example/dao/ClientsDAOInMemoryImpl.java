package org.example.dao;

import org.example.dbtable.DBTable;
import org.example.dbtable.DBTableFactory;
import org.example.entities.Client;
import org.example.entities.Clients;
import org.example.entities.Coach;
import org.example.entities.Subscription;


import java.sql.SQLException;
import java.util.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class ClientsDAOInMemoryImpl implements ClientsDAO {

	DBTable<Client> Clients = DBTableFactory.instance();
	
	private static ClientsDAOInMemoryImpl instance;

	private ClientsDAOInMemoryImpl() {
		initPosts();
	}
	
	public static synchronized ClientsDAOInMemoryImpl instance() {
		if (instance == null) {
			instance = new ClientsDAOInMemoryImpl();
		}
		return instance;
	}
	
	@Override
	public synchronized int addClient(Client item) {

		int id = Clients.insert(item);
		item.setId(id);
		try {
			Clients.update(id, item);
		} catch (SQLException e) {
			try {
			Clients.delete(id);
			} catch (SQLException e1) {
				// Do nothing
			}
		}
		return id;
	}

	@Override
	public synchronized Client deleteClient(int id) throws DAOException {
		try {
			return Clients.delete(id);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public org.example.entities.Clients ClientsList() {
		var posts = new ArrayList<>(Clients.selectAll());

		Clients result = new Clients();
		result.getClient().addAll(posts);
		return result;
	}

	@Override
	public Client findById(Integer id) throws DAOException {
		try {
			return Clients.get(id);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int editClient(int id, Client client) throws DAOException {
		try {
			var oldPost = findById(id);
			Clients.update(id, client);
			return client.getId();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	private Client newClient(String name, String surname, Date dateOfBirth, String photo, Subscription subscription, Coach coach) throws DatatypeConfigurationException {
		Client client = new Client();
		client.setName(name);
		client.setSurname(surname);

		client.setPhoto(photo);
		subscription.setCoach(coach);
		client.setCurrentSubscription(subscription);
		var date = new GregorianCalendar();
		XMLGregorianCalendar xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
		client.setDateOfBirth(xmlGregCal);
		return client;
	}

	private void initPosts() {
		Clients[] clients = new Clients[] {
//				newPost("Божественная комедия",
//						Arrays.asList(new String[] {"Данте Алигьери"}),
//						"ISBN-01234-0123", 125.0, Category.LOVE_NOVEL, 3),
//				newPost("Сказки",
//						Arrays.asList(new String[] {"Ханс Кристиан Андерсен"}),
//						"ISBN-01234-0124", 300.0, Category.ACTION, 12),
//				newPost("И пришло разрушение",
//						Arrays.asList(new String[] {"Чинуа Ачебе"}),
//						"ISBN-01234-0125", 245.5, Category.ACTION, 4),
//				newPost("Отец Горио",
//						Arrays.asList(new String[] {"Оноре де Бальзак"}),
//						"ISBN-01234-0126", 245.5, Category.LOVE_NOVEL, 5),
//				newPost("Вымыслы",
//						Arrays.asList(new String[] {"Хорхе Луис Борхес"}),
//						"ISBN-01234-0127", 118.3, Category.FANTASY, 8),
//				newPost("Декамерон",
//						Arrays.asList(new String[] {"Джованни Боккаччо"}),
//						"ISBN-01234-0128", 148.7, Category.LOVE_NOVEL, 7),
				};
		/*for (int i = 0; i < clients.length; i++) {
			addClient(clients[i]);
		}*/
	}
}
