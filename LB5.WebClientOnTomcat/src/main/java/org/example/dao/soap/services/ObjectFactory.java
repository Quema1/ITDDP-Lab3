
package org.example.dao.soap.services;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.it.social.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DAOException_QNAME = new QName("https://it.nure.ua/sport/service", "DAOException");
    private final static QName _AddClient_QNAME = new QName("https://it.nure.ua/sport/service", "addClient");
    private final static QName _AddClientResponse_QNAME = new QName("https://it.nure.ua/sport/service", "addClientResponse");
    private final static QName _ClientToken_QNAME = new QName("https://it.nure.ua/sport/service", "clientToken");
    private final static QName _DeleteClient_QNAME = new QName("https://it.nure.ua/sport/service", "deleteClient");
    private final static QName _DeleteClientResponse_QNAME = new QName("https://it.nure.ua/sport/service", "deleteClientResponse");
    private final static QName _EditClient_QNAME = new QName("https://it.nure.ua/sport/service", "editClient");
    private final static QName _EditClientResponse_QNAME = new QName("https://it.nure.ua/sport/service", "editClientResponse");
    private final static QName _FindById_QNAME = new QName("https://it.nure.ua/sport/service", "findById");
    private final static QName _FindByIdResponse_QNAME = new QName("https://it.nure.ua/sport/service", "findByTitleId");
    private final static QName _GetClient_QNAME = new QName("https://it.nure.ua/sport/service", "getClient");
    private final static QName _GetClientResponse_QNAME = new QName("https://it.nure.ua/sport/service", "getClientResponse");
    private final static QName _ClientsList_QNAME = new QName("https://it.nure.ua/sport/service", "ClientsList");
    private final static QName _ClientsListResponse_QNAME = new QName("https://it.nure.ua/sport/service", "ClientsListResponse");
    private final static QName _ServerToken_QNAME = new QName("https://it.nure.ua/sport/service", "serverToken");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.it.social.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DAOException }
     * 
     */
    public DAOException createDAOException() {
        return new DAOException();
    }

    /**
     * Create an instance of {@link AddClient }
     * 
     */
    public AddClient createAddClient() {
        return new AddClient();
    }

    /**
     * Create an instance of {@link AddClientResponse }
     * 
     */
    public AddClientResponse createAddClientResponse() {
        return new AddClientResponse();
    }

    /**
     * Create an instance of {@link DeleteClient }
     * 
     */
    public DeleteClient createDeleteClient() {
        return new DeleteClient();
    }

    /**
     * Create an instance of {@link DeleteClientResponse }
     * 
     */
    public DeleteClientResponse createDeleteClientResponse() {
        return new DeleteClientResponse();
    }


    /**
     *
     * Create an instance of {@link EditClient }
     * 
     */
    public EditClient createEditClient() {
        return new EditClient();
    }

    /**
     * Create an instance of {@link EditClientResponse }
     * 
     */
    public EditClientResponse createEditClientResponse() {
        return new EditClientResponse();
    }

    /**
     * Create an instance of {@link FindById }
     * 
     */
    public FindById createFindById() {
        return new FindById();
    }


    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link GetClient }
     * 
     */
    public GetClient createGetClient() {
        return new GetClient();
    }

    /**
     *
     * Create an instance of {@link GetClientResponse }
     * 
     */
    public GetClientResponse createGetClientResponse() {
        return new GetClientResponse();
    }

   /* /**
     * Create an instance of {@link NewPostsList }
     * 
     */
   /* public NewPostsList createNewPostsList() {
        return new NewPostsList();
    }

    /**
     * Create an instance of {@link NewPostsListResponse }
     * 
     */
   /* public NewPostsListResponse createNewPostsListResponse() {
        return new NewPostsListResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "DAOException")
    public JAXBElement<DAOException> createDAOException(DAOException value) {
        return new JAXBElement<DAOException>(_DAOException_QNAME, DAOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddClient }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddClient }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "addClient")
    public JAXBElement<AddClient> createAddClient(AddClient value) {
        return new JAXBElement<AddClient>(_AddClient_QNAME, AddClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddClientResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddClientResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "addClientResponse")
    public JAXBElement<AddClientResponse> createAddClientResponse(AddClientResponse value) {
        return new JAXBElement<AddClientResponse>(_AddClientResponse_QNAME, AddClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "clientToken")
    public JAXBElement<String> createClientToken(String value) {
        return new JAXBElement<String>(_ClientToken_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteClient }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteClient }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "deleteClient")
    public JAXBElement<DeleteClient> createDeleteClient(DeleteClient value) {
        return new JAXBElement<DeleteClient>(_DeleteClient_QNAME, DeleteClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteClientResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteClientResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "deleteClientResponse")
    public JAXBElement<DeleteClientResponse> createDeleteClientResponse(DeleteClientResponse value) {
        return new JAXBElement<DeleteClientResponse>(_DeleteClientResponse_QNAME, DeleteClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditClient }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EditClient }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "editClient")
    public JAXBElement<EditClient> createEditClient(EditClient value) {
        return new JAXBElement<EditClient>(_EditClient_QNAME, EditClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditClientResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EditClientResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "editClientResponse")
    public JAXBElement<EditClientResponse> createEditClientResponse(EditClientResponse value) {
        return new JAXBElement<EditClientResponse>(_EditClientResponse_QNAME, EditClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "findById")
    public JAXBElement<FindById> createFindById(FindById value) {
        return new JAXBElement<FindById>(_FindById_QNAME, FindById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClient }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetClient }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "getClient")
    public JAXBElement<GetClient> createGetPost(GetClient value) {
        return new JAXBElement<GetClient>(_GetClient_QNAME, GetClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetClientResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/Sport/service", name = "getClientResponse")
    public JAXBElement<GetClientResponse> createGetClientResponse(GetClientResponse value) {
        return new JAXBElement<GetClientResponse>(_GetClientResponse_QNAME, GetClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientsList }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientsList }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "ClientsList")
    public JAXBElement<ClientsList> createClientsList(ClientsList value) {
        return new JAXBElement<ClientsList>(_ClientsList_QNAME, ClientsList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientsListResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientsListResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "ClientsListResponse")
    public JAXBElement<ClientsListResponse> createClientsListResponse(ClientsListResponse value) {
        return new JAXBElement<ClientsListResponse>(_ClientsListResponse_QNAME, ClientsListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "https://it.nure.ua/sport/service", name = "serverToken")
    public JAXBElement<String> createServerToken(String value) {
        return new JAXBElement<String>(_ServerToken_QNAME, String.class, null, value);
    }

}
