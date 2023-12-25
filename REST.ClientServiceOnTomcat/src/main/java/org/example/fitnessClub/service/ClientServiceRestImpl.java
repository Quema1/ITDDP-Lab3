package org.example.fitnessClub.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.example.fitnessClub.additions.ReturnsAtomic;
import org.example.fitnessClub.dao.ClientsDAO;
import org.example.fitnessClub.dao.ClientsDAOInMemoryImpl;
import org.example.fitnessClub.dao.DAOException;
import org.example.fitnessClub.entities.Client;

@Path(Constants.CLIENT_SERVICE_PATH)
public class ClientServiceRestImpl {

	private static final long LONG_WORK_WAIT_TIMEOUT = 1000;

	private static final int DEFAULT_THREAD_POOL_SIZE = 10;

	private ClientsDAO clients;

	ExecutorService executor = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE);

	private void log(String msg) {
		System.out.println(this.getClass().getSimpleName() + ": " + msg);
	}

	@PostConstruct
	public void init() {
		log("init");
		clients = ClientsDAOInMemoryImpl.instance();
	}

	@PreDestroy
	public void destroy() {
		log("destroy");
		clients = null;
		executor.shutdown();
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response all() {
		log("all");
		var posts = this.clients.ClientsList();
		System.out.println("Running all");
		return Response.ok(posts).build();
	}

	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response find(@PathParam("id") Integer id) throws NotFoundException {
		try {
			log("by id");
			var posts = clients.findById(id);
			return Response.ok(posts).build();
		} catch (DAOException e) {
			throw new NotFoundException(e);
		}
	}

	@Path("search")
	public PostSearcher find() {
		return new PostSearcher();
	}

	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ReturnsAtomic<Integer> add(Client client) throws DAOException {
		log("add");
		var id = clients.addClient(client);
		return new ReturnsAtomic<Integer>(id);
	}

	@PUT
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ReturnsAtomic<Integer> update(Client client, @PathParam("id") int id) throws DAOException {
		log("update");
		var resId = clients.editClient(id, client);
		return new ReturnsAtomic<Integer>(resId);
	}

	@DELETE
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Client remove(@PathParam("id") int id) throws DAOException {
		log("remove");
		var res = clients.deleteClient(id);
		return res;
	}
}
