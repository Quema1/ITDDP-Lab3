package org.example.server.client.web;

import java.io.IOException;

import org.example.dao.ClientsDAO;
import org.example.dao.soap.services.DAOException_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class DeletePost
 */
public class DeleteClient extends HttpServlet {
	private static final String DEBUG_ERROR_MSG = "Set errorMsg to the session";
	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(DeleteClient.class);

	private transient ClientsDAO service;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (ClientsDAO) ctx.getAttribute("dao");
		log.trace("Get attribute PostsService : {}",service);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String errMsg = null;
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			log.debug("Get id from request : {}",id);
			service.deleteClient(id);
		} catch (DAOException_Exception e) {
			// Internal exception in web-service
			errMsg = "Error: Can not delete post from database";
			log.debug(DEBUG_ERROR_MSG, e.getMessage());
		} catch (NumberFormatException e) {
			// Can not parse price or count
			errMsg = "Error: incorrect id";
			log.debug(DEBUG_ERROR_MSG, e.getMessage());
		} catch (Exception e) {
			// Any other exceptions
			errMsg = "Error: Can not communicate with post service";
			log.debug(DEBUG_ERROR_MSG, e.getMessage());
		}
		if (errMsg != null) {
			session.setAttribute("errorMsg", errMsg);
		}

		// PRG pattern
		response.sendRedirect("list");
	}

}
