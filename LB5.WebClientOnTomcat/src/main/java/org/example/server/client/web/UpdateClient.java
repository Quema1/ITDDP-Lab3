package org.example.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.example.dao.ClientsDAO;
import org.example.dao.soap.entities.Client;
import org.example.dao.soap.entities.Coach;
import org.example.dao.soap.entities.Subscription;
import org.example.dao.soap.services.DAOException_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Servlet implementation class AddPost
 */
public class UpdateClient extends HttpServlet {
	private static final String DEBUG_ERROR_MSG = "Set errorMsg to the session";
	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(UpdateClient.class);

	private transient ClientsDAO service;
	
	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (ClientsDAO) ctx.getAttribute("dao");
		log.trace("Get attribute dao : {}",service);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postId = request.getParameter("id");
		log.debug("Looking for post with id = " + postId);
//        HttpSession session = request.getSession();
		String errMsg = null;

		try {
			if (postId != null) {
				// Assuming you have a service to retrieve the post details based on the ID
				// Replace PostService with your service class
				Client post = service.findById(Integer.parseInt(postId));

				if (post != null) {
					// Set the post object as an attribute in the request
					request.setAttribute("post", post);
					// Forward the request to the view (JSP)
					request.getRequestDispatcher("/update.jsp").forward(request, response);
					return;
				}
			} else {
				errMsg = "postId have to be specified";
			}
		} catch (DAOException_Exception e) {
			errMsg = "Error: couldn't find post with id";
		} catch (Exception e) {
			errMsg = "Error: Something went wrong";
		}
		if (errMsg != null) {
			request.setAttribute("errorMsg", errMsg);
		}
		response.sendRedirect("update.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postId = request.getParameter("id");
		HttpSession session = request.getSession();
		log.debug("Requst encoding : {}",request.getCharacterEncoding());
		String errMsg = null;
		int id = Integer.valueOf(postId);
		try {
			Client post = service.findById(Integer.parseInt(postId));
			post.setName(request.getParameter("name"));
			post.setSurname(request.getParameter("surname"));
			var dateOfBirth = request.getParameter("dateOfBirth");
			post.setDateOfBirth(convertToGregorianCalendar(dateOfBirth));
			post.setPhoto(request.getParameter("photo"));
			var author = new Subscription();
			var startDate = request.getParameter("startDate");
			author.setStartDate(convertToGregorianCalendar(startDate));
			var endDate = request.getParameter("endDate");
			author.setEndDate(convertToGregorianCalendar(endDate));
			var price = request.getParameter("price");
			author.setPrice(new BigDecimal(price));
			var coach = new Coach();
			coach.setName(request.getParameter("name"));
			coach.setSurname(request.getParameter("surname"));
			var experience = request.getParameter("experience");
			author.setPrice(new BigDecimal(price));
			coach.setExperience(new BigDecimal(experience));
			author.setCoach(coach);
			post.setCurrentSubscription(author);
			log.debug("Get clients from request : {}",post);

				// send request to web-service
				service.editClient(id, post);
				log.debug("Client added with id : {}",id);

		} catch (DAOException_Exception e) {
		// Internal exception in web-service
		errMsg = "Error: Can not add post into database";
		log.debug(DEBUG_ERROR_MSG, e);
		} catch (NumberFormatException e) {
			// Can not parse price or count
			errMsg = "Error: incorrect price or count";
			log.debug(DEBUG_ERROR_MSG, e);
		} catch (Exception e) {
			// Any other exceptions
			errMsg = "Error: Can not communicate with post service";
			log.debug(DEBUG_ERROR_MSG, e);
		}
		if (errMsg != null) {
			session.setAttribute("errorMsg", errMsg);
		}
		
		// PRG pattern
		response.sendRedirect("view?id=" + id);
		log.debug("Redirect to view.jsp");
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
