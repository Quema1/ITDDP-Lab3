package org.example.fitnessClub.service.rest;//package shop.service.rest;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.example.fitnessClub.service.ServiceException;

@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

	@Override
	public Response toResponse(ServiceException exception) {
		// лог
		System.out.println("toResponse() exception " + exception.getMessage());
		exception.printStackTrace();

		// Вернуть объект класса Response
		return Response.status(exception.getStatusCode())
				.entity(exception.getMessage())
				.type(MediaType.TEXT_PLAIN_TYPE)
				.build();
	}

}