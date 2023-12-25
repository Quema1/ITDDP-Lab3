package org.example.service;

import org.example.dao.DAOException;
import org.example.entities.Client;
import org.example.entities.Clients;
import com.sun.istack.NotNull;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebParam.Mode;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.ws.Holder;

@WebService(targetNamespace = Const.SERVICE_NS)
public interface ClientService {

    @WebMethod()
    @WebResult(targetNamespace = "https://it.nure.ua/sport")
    public Client getClient(
            @WebParam(name = "id")
            @NotNull
            int id,
            @WebParam(name = "clientToken", header = true)
            String clientToken,
            @WebParam(name = "serverToken", header = true, mode = Mode.OUT)
            Holder<String> serverToken) throws DAOException;

    @WebMethod()
    public int addClient(
            @WebParam(name = "Client", targetNamespace = "https://it.nure.ua/sport")
            @NotNull
            Client Client, @WebParam(name = "clientToken", header = true)
            String clientToken,
            @WebParam(name = "serverToken", header = true, mode = Mode.OUT)
            Holder<String> serverToken) throws DAOException;

    @WebMethod()
    @WebResult(targetNamespace = "https://it.nure.ua/sport")
    public Client deleteClient(
            @WebParam(name = "id")
            @NotNull
            int id,
            @WebParam(name = "clientToken", header = true)
            String clientToken,
            @WebParam(name = "serverToken", header = true, mode = Mode.OUT)
            Holder<String> serverToken
    ) throws DAOException;


    @WebMethod()
    @WebResult(targetNamespace = "https://it.nure.ua/sport")
    public Clients ClientsList(@WebParam(name = "clientToken", header = true)
                                             String clientToken,
                              @WebParam(name = "serverToken", header = true, mode = Mode.OUT)
                                             Holder<String> serverToken);

    @WebMethod()
    @WebResult(targetNamespace = "https://it.nure.ua/sport")
    int editClient(
            @WebParam(name = "id")
            @NotNull
            int id,
            @WebParam(name = "Client", targetNamespace = "https://it.nure.ua/sport")
            @NotNull
            Client client,
            @WebParam(name = "clientToken", header = true)
            String clientToken,
            @WebParam(name = "serverToken", header = true, mode = Mode.OUT)
            Holder<String> serverToken) throws DAOException;
}