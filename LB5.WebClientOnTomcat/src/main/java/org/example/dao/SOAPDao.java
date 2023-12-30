package org.example.dao;

import org.example.dao.soap.entities.Client;
import org.example.dao.soap.entities.Clients;
import org.example.dao.soap.services.*;

public class SOAPDao implements ClientsDAO{
    private static final String CLIENT_TOKEN = "clientToken";
    private static final ClientService service = new org.example.dao.soap.services.Clients().getClientPort();

    private static SOAPDao instance;

    public static SOAPDao getInstance() {
        if (instance == null) {
            instance = new SOAPDao();
        }
        return instance;
    }
    public int addClient(Client item) throws Exception {
        var params = new AddClient();
        params.setClient(item);
        var request = service.addClient(params, CLIENT_TOKEN, null);
        var res = request.getReturn();
        return res;
    }

    @Override
    public Client deleteClient(int id) throws Exception {
        var params = new DeleteClient();
        params.setId(id);
        var request = service.deleteClient(params, CLIENT_TOKEN, null);
        var res = request.getReturn();
        return res;
    }

    @Override
    public Clients ClientsList() {
        var raw = service.ClientsList(new ClientsList(), CLIENT_TOKEN, null);
        return raw.getReturn();
    }

    @Override
    public Client findById(Integer id) throws Exception {
        var params = new GetClient();
        params.setId(id);
        var raw = service.getClient(params, CLIENT_TOKEN, null).getReturn();
        return raw;
    }

    @Override
    public int editClient(int id, Client post) throws Exception {
        var params = new EditClient();
        params.setClient(post);
        params.setId(id);
        var request = service.editClient(params, CLIENT_TOKEN, null);
        var ret = request.getReturn();
        return id;
    }
}
