package com.seguridad.dao;

import com.seguridad.modelo.SecSisSistemas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class SecSisSistemasDAO extends DAOBase {

    public SecSisSistemasDAO() {
    }

    public List<SecSisSistemas> findAll() throws RuntimeException {

        String queryString = "SELECT sis FROM SecSisSistemas sis ORDER BY sis.sisNombre";
        Query queryObject = getEntityManager().createQuery(queryString);
        return queryObject.getResultList();

    }
    
    public SecSisSistemas findById(int sistemaId) throws RuntimeException{
        
        String queryString = "SELECT sistema FROM SecSisSistemas sistema WHERE sistema.sisId = :sistemaId";
        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("sistemaId", sistemaId);

        return (SecSisSistemas) queryObject.getSingleResult();
    }

}
