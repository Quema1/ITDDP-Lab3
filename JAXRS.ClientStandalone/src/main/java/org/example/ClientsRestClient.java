package org.example;

import java.math.BigDecimal;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.*;
import org.example.additions.ReturnsAtomic;
import org.example.entities.Clients;
import org.example.entities.Coach;
import org.example.entities.Subscription;
import org.example.service.Constants;
import org.example.service.rest.JSONMessageBodyReader;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


public class ClientsRestClient extends Application {

	//private static final URI BASE_URI = URI.create(Constants.SERVICE_BASE_URL);
	private static final URI BASE_URI = getBaseURI(Constants.BASE_URI, Constants.PORT, Constants.APPLICATION_PATH,
			Constants.Clients_SERVICE_PATH);
	private static void printMenu() {
		System.out.println("1. Get clients\n" +
				"2. Get client by id\n" +
				"3. Add client\n" +
				"4. Update client\n" +
				"5. Delete client\n" +
				"6. Exit\n");
	}

	private static void getClient(Client client) throws Exception {
		WebTarget target = client.target(BASE_URI);
		Builder request = target.request()
				.accept(MediaType.APPLICATION_JSON);
		Response resp = request.get();
		if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
			var body = resp.readEntity(Clients.class);
			for (var client1 : body.getClient()) {
				System.out.println(client1.toString());
			}
		} else {
			throw new Exception("Error with code " + resp.getStatus());
		}
	}

	private static void getClientById(Client client, Scanner scanner) throws Exception {
		System.out.println("Enter client id: ");
		String id = scanner.nextLine();
		WebTarget target = client.target(BASE_URI).path(id);
		Builder request = target.request()
				.accept(MediaType.APPLICATION_JSON);
		Response resp = request.get();
		if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
			var client1 = resp.readEntity(Client.class);
			System.out.println(client1.toString());
		} else {
			throw new Exception("Error with code " + resp.getStatus());
		}
	}

	private static void addClient(Client client, Scanner scanner) throws Exception {
		var client1 = new org.example.entities.Client();
		System.out.println("Enter client name: ");
		String name = scanner.nextLine();
		System.out.println("Enter client surname: ");
		String surname = scanner.nextLine();
		System.out.println("Enter dateOfBirth (Format: 2023-10-02): ");
		String dateOfBirth = scanner.nextLine();
		System.out.println("Enter photo link: ");
		String photo = scanner.nextLine();
		System.out.println("Enter subscription startDate (Format: 2023-10-02): ");
		String startDate = scanner.nextLine();
		System.out.println("Enter subscription endDate (Format: 2023-10-02): ");
		String endDate = scanner.nextLine();
		System.out.println("Enter subscription price: ");
		BigDecimal price = BigDecimal.valueOf(Long.parseLong(scanner.nextLine()));
		System.out.println("Enter coach name: ");
		String coachName = scanner.nextLine();
		System.out.println("Enter coach surname: ");
		String coachSurname = scanner.nextLine();
		System.out.println("Enter coach experience: ");
		BigDecimal coachExperience = BigDecimal.valueOf(Long.parseLong(scanner.nextLine()));


		client1.setName(name);
		client1.setSurname(surname);

		client1.setDateOfBirth(convertToGregorianCalendar(dateOfBirth));
		client1.setPhoto(photo);
		var subscription = new Subscription();
		subscription.setStartDate(convertToGregorianCalendar(startDate));
		subscription.setEndDate(convertToGregorianCalendar(endDate));
		subscription.setPrice(price);
		var coach = new Coach();
		coach.setName(coachName);
		coach.setSurname(coachSurname);
		coach.setExperience(coachExperience);
		subscription.setCoach(coach);
		client1.setCurrentSubscription(subscription);

		WebTarget target = client.target(BASE_URI);
		Builder request = target.request()
				.accept(MediaType.APPLICATION_JSON);
		jakarta.ws.rs.client.Entity<org.example.entities.Client> payload = jakarta.ws.rs.client.Entity.json(client1);
		Response resp = request.post(payload);
		if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
			var body = resp.readEntity(ReturnsAtomic.class);
			System.out.println("id = " + body.getItem());
		} else {
			throw new Exception("Error with code " + resp.getStatus());
		}
	}

	private static void updateClient(Client client, Scanner scanner) throws Exception {
		System.out.println("Enter id of client to edit: ");
		int id = Integer.valueOf(scanner.nextLine());
		var client1 = new org.example.entities.Client();
		System.out.println("Enter client name: ");
		String name = scanner.nextLine();
		System.out.println("Enter client surname: ");
		String surname = scanner.nextLine();
		System.out.println("Enter dateOfBirth (Format: 2023-10-02): ");
		String dateOfBirth = scanner.nextLine();
		System.out.println("Enter photo link: ");
		String photo = scanner.nextLine();
		System.out.println("Enter subscription startDate (Format: 2023-10-02): ");
		String startDate = scanner.nextLine();
		System.out.println("Enter subscription endDate (Format: 2023-10-02): ");
		String endDate = scanner.nextLine();
		System.out.println("Enter subscription price: ");
		BigDecimal price = BigDecimal.valueOf(Long.parseLong(scanner.nextLine()));
		System.out.println("Enter coach name: ");
		String coachName = scanner.nextLine();
		System.out.println("Enter coach surname: ");
		String coachSurname = scanner.nextLine();
		System.out.println("Enter coach experience: ");
		BigDecimal coachExperience = BigDecimal.valueOf(Long.parseLong(scanner.nextLine()));


		client1.setName(name);
		client1.setSurname(surname);

		client1.setDateOfBirth(convertToGregorianCalendar(dateOfBirth));
		client1.setPhoto(photo);
		var subscription = new Subscription();
		subscription.setStartDate(convertToGregorianCalendar(startDate));
		subscription.setEndDate(convertToGregorianCalendar(endDate));
		subscription.setPrice(price);
		var coach = new Coach();
		coach.setName(coachName);
		coach.setSurname(coachSurname);
		coach.setExperience(coachExperience);
		subscription.setCoach(coach);
		client1.setCurrentSubscription(subscription);
		client1.setId(id);

		WebTarget target = client.target(BASE_URI).path(String.valueOf(id));
		Builder request = target.request()
				.accept(MediaType.APPLICATION_JSON);
		jakarta.ws.rs.client.Entity<org.example.entities.Client> payload = jakarta.ws.rs.client.Entity.json(client1);
		Response resp = request.put(payload);
		if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
			var body = resp.readEntity(ReturnsAtomic.class);
			System.out.println("id = " + body.getItem());
		} else {
			throw new Exception("Error with code " + resp.getStatus());
		}
	}

	private static void deleteClient(Client client, Scanner scanner) throws Exception {
		System.out.println("Enter id of client to delete: ");
		String id = scanner.nextLine();
		WebTarget target = client.target(BASE_URI).path(String.valueOf(id));
		Builder request = target.request()
				.accept(MediaType.APPLICATION_JSON);
		Response resp = request.delete();
		if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
			var body = resp.readEntity(org.example.entities.Client.class);
			System.out.println("deleted " + body);
		} else {
			throw new Exception("Error with code " + resp.getStatus());
		}
	}

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		client
				.register(JSONMessageBodyReader.class);

		Scanner sc = new Scanner(System.in);
		printMenu();
		while (true) {
			int choise = Integer.valueOf(sc.nextLine());
			try {
				switch (choise) {
					case 1 -> {
						getClient(client);
						break;
					}
					case 2 -> {
						getClientById(client, sc);
						break;
					}
					case 3 -> {
						addClient(client, sc);
						break;
					}
					case 4 -> {
						updateClient(client, sc);
						break;
					}
					case 5 -> {
						deleteClient(client, sc);
						break;
					}
					case 7 -> {
						return;
					}
					default -> {
						System.out.println("Invalid option");
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("[Error] " + e.getMessage());
				e.printStackTrace();
			}
			printMenu();
		}


	}
	private static XMLGregorianCalendar convertToGregorianCalendar(String dateString) throws ParseException, DatatypeConfigurationException {
		SimpleDateFormat dateFormat;

		if (dateString.length() <= 10) { // If input contains only date (without time)
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		} else {
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		Date date = dateFormat.parse(dateString);

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);

		return convertToXMLGregorianCalendar(cal);
	}

	private static XMLGregorianCalendar convertToXMLGregorianCalendar(GregorianCalendar calendar) throws DatatypeConfigurationException {
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
	}

	public static URI getBaseURI(String basePath, int port, String... path) {
		UriBuilder builder = UriBuilder.fromUri(basePath).port(port);
		for (String part : path) {
			builder.path(part);
		}
		URI uri = builder.build();
		System.out.println("uri: " + uri);
		return uri;
	}
}
