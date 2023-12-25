package org.example.ClientSimpleStandalone;

import org.example.ClientSimpleStandalone.generated.Client;
import org.example.ClientSimpleStandalone.generated.Coach;
import org.example.ClientSimpleStandalone.generated.Subscription;
import org.example.ClientSimpleStandalone.services.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    private static final String CLIENT_TOKEN_VALID = "clientToken";
    private static String CLIENT_TOKEN = "clientToken";
    private static void printMenu() {
        System.out.println("1. Get client\n" +
                "2. Get client by id\n" +
                "3. Add client\n" +
                "4. Update client\n" +
                "5. Delete client\n" +
                "7. Exit\n" +
                "8. Send with invalid token\n" +
                "9. Send with valid token");
    }

    private static void getClients(ClientService service) {
        var raw = service.ClientsList(new ClientsList(), CLIENT_TOKEN, null).getReturn();
        System.out.println("Got response " + raw.toString());
        for (Client client : raw.getClient()) {
            System.out.println(client.toString());
        }
    }

    private static void getClientById(ClientService service, Scanner scanner) throws Exception {
        var params = new GetClient();
        System.out.println("Enter client id: ");
        int id = Integer.valueOf(scanner.nextLine());
        params.setId(id);
        var raw = service.getClient(params, CLIENT_TOKEN, null).getReturn();
        System.out.println("Got client " + raw.toString());
    }

    /*private static void findPostByHeader(ClientService service, Scanner scanner) throws Exception {
        var params = new FindByTitle();
        System.out.println("Enter posts header: ");
        String header = scanner.nextLine();
        params.setPattern(header);
        var raw = service.findByTitle(params, CLIENT_TOKEN, null).getReturn();
        System.out.println("Got response " + raw.toString());
        for (Post post : raw.getPost()) {
            System.out.println(post.toString());
        }
    }*/

    private static void addClient(ClientService service, Scanner scanner) throws DAOException_Exception, DatatypeConfigurationException, ParseException {
        var params = new AddClient();
        var client = new Client();
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


        client.setName(name);
        client.setSurname(surname);

        client.setDateOfBirth(convertToGregorianCalendar(dateOfBirth));
        client.setPhoto(photo);
        var subscription = new Subscription();
        subscription.setStartDate(convertToGregorianCalendar(startDate));
        subscription.setEndDate(convertToGregorianCalendar(endDate));
        subscription.setPrice(price);
        var coach = new Coach();
        coach.setName(coachName);
        coach.setSurname(coachSurname);
        coach.setExperience(coachExperience);
        subscription.setCoach(coach);
        client.setCurrentSubscription(subscription);
        params.setClient(client);

        var request = service.addClient(params, CLIENT_TOKEN, null);
        var res = request.getReturn();
        System.out.println("Created client with id " + res);
    }

    private static void updateClient(ClientService service, Scanner scanner) throws DAOException_Exception, DatatypeConfigurationException, ParseException {
        var params = new EditClient();
        System.out.println("Enter id of client to edit: ");
        int id = Integer.valueOf(scanner.nextLine());
        var client = new Client();
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
        client.setName(name);
        client.setSurname(surname);

        client.setDateOfBirth(convertToGregorianCalendar(dateOfBirth));
        client.setPhoto(photo);
        var subscription = new Subscription();
        subscription.setStartDate(convertToGregorianCalendar(startDate));
        subscription.setEndDate(convertToGregorianCalendar(endDate));
        subscription.setPrice(price);
        var coach = new Coach();
        coach.setName(coachName);
        coach.setSurname(coachSurname);
        coach.setExperience(coachExperience);
        subscription.setCoach(coach);
        client.setCurrentSubscription(subscription);

        params.setClient(client);
        params.setId(id);

        var request = service.editClient(params, CLIENT_TOKEN, null);
        var res = request.getReturn();
        System.out.println("Updated client with id " + res);
    }

    private static void deleteClient(ClientService service, Scanner scanner) throws DAOException_Exception {
        var params = new DeleteClient();
        System.out.println("Enter id of client to delete: ");
        int id = Integer.valueOf(scanner.nextLine());
        params.setId(id);
        var request = service.deleteClient(params, CLIENT_TOKEN, null);
        var res = request.getReturn();
        System.out.println("Deleted client " + res.toString());
    }
    public static void main(String[] args) throws Exception {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        ClientService client = new Clients().getClientPort();
        Scanner sc = new Scanner(System.in);
        printMenu();
        while (true) {
            int choise = Integer.valueOf(sc.nextLine());
            try {
                switch (choise) {
                    case 1 -> {
                        getClients(client);
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
                    case 6 -> {
                        return;
                    }
                    case 8 -> {
                        CLIENT_TOKEN = null;
                    }
                    case 9 -> {
                        CLIENT_TOKEN = CLIENT_TOKEN_VALID;
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
}
