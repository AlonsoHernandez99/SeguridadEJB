package com.seguridad.servicio;

import com.seguridad.dao.DAOBase;

public class BaseService {
    DAOBase dao;

    public BaseService() {
    }        

    public void save(Object transientInstance) throws RuntimeException {
        dao.save(transientInstance);
    }

    public Object merge(Object detachedInstance) throws RuntimeException {
        return dao.merge(detachedInstance);
    }

    public void remove(Object persistentInstance) throws RuntimeException {
        dao.remove(persistentInstance);
    }
}
