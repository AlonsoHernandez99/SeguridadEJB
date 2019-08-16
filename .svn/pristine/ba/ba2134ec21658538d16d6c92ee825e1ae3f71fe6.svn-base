package com.seguridad.dao;

import com.seguridad.modelo.SecParParametros;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class SecParParametrosDAO extends DAOBase {

    public SecParParametrosDAO() {
    }

    public SecParParametros findByCodigo(String codigo) throws RuntimeException{
        SecParParametros parametro;
        String queryString = "SELECT par FROM SecParParametros par where par.parCodigo = :codigo";
        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("codigo", codigo);
        parametro = (SecParParametros) queryObject.getSingleResult();
        return parametro;
    }
    
    public List<SecParParametros> findAll() throws RuntimeException{
        String queryString = "SELECT par FROM SecParParametros par ORDER BY par.parCodigo";
        Query queryObject = getEntityManager().createQuery(queryString);
        return queryObject.getResultList();
    }    

}
