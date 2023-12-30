package org.example.dao.soap.services;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.example.dao.ClientsDAO;
import org.example.dao.Constants;
import org.example.dao.additions.ReturnsAtomic;
import org.example.rest.JSONMessageBodyReader;

import java.net.URI;

public class RESTDao implements ClientsDAO {
    private static final URI BASE_URI = getBaseURI(Constants.BASE_URI, Constants.PORT, Constants.APPLICATION_PATH,
                                                      Constants.CLIENTS_SERVICE_PATH);
    Client client = ClientBuilder.newBuilder().register(JSONMessageBodyReader.class).build();

    private static RESTDao instance;

    public static RESTDao getInstance() {
        if (instance == null) {
            instance = new RESTDao();
        }
        return instance;
    }

    @Override
    public int addClient(org.example.dao.soap.entities.Client item) throws Exception {
        WebTarget target = client.target(BASE_URI);
        Invocation.Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<org.example.dao.soap.entities.Client> payload = jakarta.ws.rs.client.Entity.json(item);
        Response resp = request.post(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body = (ReturnsAtomic<Integer>) resp.readEntity(ReturnsAtomic.class);
            return body.getItem();
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    @Override
    public org.example.dao.soap.entities.Client deleteClient(int id) throws Exception {
        WebTarget target = client.target(BASE_URI).path(String.valueOf(id));
        Invocation.Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response resp = request.delete();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body = resp.readEntity(org.example.dao.soap.entities.Client.class);
            return body;
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    @Override
    public org.example.dao.soap.entities.Clients ClientsList() throws Exception {
        WebTarget target = client.target(BASE_URI);
        Invocation.Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response resp = request.get();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body = resp.readEntity(org.example.dao.soap.entities.Clients.class);
            return body;
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    @Override
    public org.example.dao.soap.entities.Client findById(Integer id) throws Exception {
        WebTarget target = client.target(BASE_URI).path(id.toString());
        Invocation.Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response resp = request.get();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var client = resp.readEntity(org.example.dao.soap.entities.Client.class);
            return client;
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    @Override
    public int editClient(int id, org.example.dao.soap.entities.Client post) throws Exception {
        System.out.println("Enter id of post to edit: ");
        WebTarget target = client.target(BASE_URI).path(String.valueOf(id));
        Invocation.Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<org.example.dao.soap.entities.Client> payload = jakarta.ws.rs.client.Entity.json(post);
        Response resp = request.put(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body = (ReturnsAtomic<Integer>) resp.readEntity(ReturnsAtomic.class);
            return body.getItem();
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
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
