package org.example.dao;

import org.example.dao.soap.services.RESTDao;

public class DAOFactory {
    public static ClientsDAO getInstance(String selectedDao) {
        ClientsDAO instance = null;
        if (selectedDao.equals(SelectedDao.SOAP)) {
            instance = SOAPDao.getInstance();
        } else if (selectedDao.equals(SelectedDao.REST)) {
            instance = RESTDao.getInstance();
        }
        return instance;
    }
}
