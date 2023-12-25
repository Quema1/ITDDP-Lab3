package org.example.fitnessClub.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.example.fitnessClub.dao.ClientsDAO;
import org.example.fitnessClub.dao.ClientsDAOInMemoryImpl;

public class PostSearcher {

	private ClientsDAO store = ClientsDAOInMemoryImpl.instance();

	/*@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Posts search(@QueryParam("pattern") String pattern, @QueryParam("author") String author) {
		System.out.println("search for Title: " + pattern + " Author: " + author);
        return store.findByTitleAndAuthor(pattern, author);
	}*/

}
