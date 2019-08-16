package com.seguridad.dao;

import com.seguridad.modelo.SecOprOpcionesRoles;
import com.seguridad.modelo.SecRolRoles;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class SecOprOpcionesRolesDAO extends DAOBase {

    public SecOprOpcionesRolesDAO() {
    }

    public List<SecOprOpcionesRoles> findByModuloAndRol(int mdsId, int rolId) throws RuntimeException {

        String queryString = "SELECT model FROM SecOprOpcionesRoles model "
                + "WHERE model.secOpmOpcionesMenu.secMdsModulosSistemas.mdsId = :mdsId "
                + "AND model.secRolRoles.rolId = :rolId";
        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("mdsId", mdsId);
        queryObject.setParameter("rolId", rolId);
        return queryObject.getResultList();

    }

    public SecOprOpcionesRoles findByRol(int rolId) throws RuntimeException {

        SecOprOpcionesRoles opr;

        String queryString = "SELECT model FROM SecOprOpcionesRoles model where model.secRolRoles.rolId = :rolId";
        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("rolId", rolId);
        opr = (SecOprOpcionesRoles) queryObject.getResultList();

        return opr;
    }

    public SecOprOpcionesRoles findByRolOpcion(int rolId, int opmId) throws RuntimeException {

        SecOprOpcionesRoles opr;

        String queryString = "SELECT model FROM SecOprOpcionesRoles model where model.secOpmOpcionesMenu.opmId = :opmId and model.secRolRoles.rolId = :rolId";
        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("opmId", opmId);
        queryObject.setParameter("rolId", rolId);
        opr = (SecOprOpcionesRoles) queryObject.getResultList();

        return opr;
    }
    
     public List<SecOprOpcionesRoles> findByOpcion(int opmId) throws RuntimeException {
         
        String queryString = "SELECT model FROM SecOprOpcionesRoles model where model.secOpmOpcionesMenu.opmId = :opmId";
        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("opmId", opmId);
        return queryObject.getResultList();
    }
    

}
