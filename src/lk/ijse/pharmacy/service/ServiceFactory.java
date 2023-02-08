package lk.ijse.pharmacy.service;

import lk.ijse.pharmacy.dao.DaoFactory;
import lk.ijse.pharmacy.dao.DaoTypes;
import lk.ijse.pharmacy.dao.SuperDAO;
import lk.ijse.pharmacy.dao.custom.impl.*;
import lk.ijse.pharmacy.service.custom.impl.AdminServiceImpl;

import java.sql.Connection;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance(){
        return serviceFactory==null?(serviceFactory=new ServiceFactory()):serviceFactory;
    }

    public <T extends SuperService> T getService(ServiceTypes serviceTypes){
        switch (serviceTypes){
            case ADMIN:
                return (T)new AdminServiceImpl();

            default:
                return null;
        }
    }
}
