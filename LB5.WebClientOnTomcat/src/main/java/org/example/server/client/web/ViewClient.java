package org.example.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.dao.ClientsDAO;
import org.example.dao.soap.entities.Client;
import org.example.dao.soap.services.DAOException_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ViewClient extends HttpServlet {
    private final transient Logger log = LoggerFactory.getLogger(ViewClient.class);
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
        HttpSession session = request.getSession();
        String errMsg = null;

        try {
            if (postId != null) {
                Client post = service.findById(Integer.parseInt(postId));

                if (post != null) {
                    // Set the post object as an attribute in the request
                    request.setAttribute("client", post);
                    // Forward the request to the view (JSP)
                    request.getRequestDispatcher("/view.jsp").forward(request, response);
                    return;
                }
            } else {
                errMsg = "postId have to be specified";
            }
        } catch (DAOException_Exception e) {
            errMsg = "Error: couldn't find post with id";
        } catch (Exception e) {
            errMsg = "Error: Something went wrong: " + e.getMessage();
        }
        if (errMsg != null) {
            session.setAttribute("errorMsg", errMsg);
        }
        System.out.println("errorMsg" + errMsg);
        response.sendRedirect("view.jsp");
    }
}
