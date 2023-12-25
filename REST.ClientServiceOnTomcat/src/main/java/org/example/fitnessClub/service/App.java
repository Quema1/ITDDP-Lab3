package org.example.fitnessClub.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.example.fitnessClub.service.rest.JSONMessageBodyWriter;
import org.example.fitnessClub.service.rest.ServiceExceptionMapper;
import org.example.fitnessClub.service.rest.TextPlainMessageBodyWriter;
import org.example.fitnessClub.service.rest.XMLItemMessageBodyWriter;

@ApplicationPath(Constants.APPLICATION_PATH)
public class App extends Application {

    @Override
    public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(ClientServiceRestImpl.class);
		classes.add(XMLItemMessageBodyWriter.class);
		classes.add(TextPlainMessageBodyWriter.class);
		classes.add(JSONMessageBodyWriter.class);
		classes.add(ServiceExceptionMapper.class);

		return Collections.unmodifiableSet(classes);
    }
}
