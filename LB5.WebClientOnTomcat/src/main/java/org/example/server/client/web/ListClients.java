package org.example.server.client.web;

import java.io.IOException;

import org.example.dao.ClientsDAO;
import org.example.dao.soap.entities.Clients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListPosts
 */
public class ListClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(ListClients.class);

	private ClientsDAO service;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (ClientsDAO) ctx.getAttribute("dao");
		log.trace("Get attribute PostService : {}",service);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("List triggered");
		System.out.println("DAO is " + service);
		try {
			Clients clients = service.ClientsList();
			log.debug("Get clients from PostService : {}",clients);
			request.setAttribute("clients", clients);
			log.trace("Set clients to the session : {}",clients);
			request.getRequestDispatcher("list.jsp").forward(request, response);
			log.trace("Redirect to list.jsp");
		} catch (Exception e) {
			System.out.println("Got exception" + e);
			throw new RuntimeException(e);
		}

	}

}
