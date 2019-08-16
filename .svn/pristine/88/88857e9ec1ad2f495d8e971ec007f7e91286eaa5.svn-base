package com.seguridad.dao;

import com.seguridad.modelo.SecRolRoles;
import com.seguridad.modelo.SecRouRolesUsuarios;
import com.seguridad.modelo.SecSisSistemas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class SecRolRolesDAO extends DAOBase {

    public SecRolRolesDAO() {
    }

    public List<SecRolRoles> findAll(int sistemaId) throws RuntimeException {

        String queryString = "SELECT rol FROM SecRolRoles rol WHERE rol.secSisSistemas.sisId = :sistemaId ORDER BY rol.secSisSistemas.sisNombre, rol.rolNombre ";
        Query queryObject = getEntityManager().createQuery(queryString).setParameter("sistemaId", sistemaId);
        return queryObject.getResultList();

    }

    public List<SecRolRoles> findBySistema(SecSisSistemas sistema) throws RuntimeException {

        String queryString = "SELECT rol FROM SecRolRoles as rol where rol.secSisSistemas.sisId = :sisId";
        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("sisId", sistema.getSisId());
        return queryObject.getResultList();

    }

    public SecRolRoles findById(Integer rolId) throws RuntimeException {

        String queryString = "SELECT model FROM SecRolRoles model where model.rolId=:id";
        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("id", rolId);
        return (SecRolRoles) queryObject.getSingleResult();

    }

    public List<SecRolRoles> getRolesHasNotAccessOption(int opcionId) {

        String queryString = "SELECT p FROM SecRolRoles r LEFT JOIN r.secOprOpcionesRoleses d LEFT JOIN d.secRolRoles p";
        //"SELECT A FROM A a LEFT JOIN a.B b WHERE b.id = null;"
        Query query = getEntityManager().createQuery(queryString);
        return query.getResultList();
    }

    public List<SecRolRoles> getRolesWithoutAccess(int sistemaId, String usuarioCod) {
        String queryString = "SELECT r FROM SecRolRoles r WHERE "
                + "r.secSisSistemas.sisId = :sistemaId AND :usuarioId NOT IN (SELECT ru.secUsrUsuarios.usrCodigo FROM r.secRouRolesUsuarioses ru)";
        Query queryObject;
        queryObject = getEntityManager().createQuery(queryString).setParameter("usuarioId", usuarioCod).setParameter("sistemaId", sistemaId);;
        return queryObject.getResultList();
    }
    
     public List<SecRolRoles> getAllRolesOfSistema(int sistemaId) {
        String queryString = "SELECT r FROM SecRolRoles r WHERE "
                + "r.secSisSistemas.sisId = :sistemaId";
        Query queryObject;
        queryObject = getEntityManager().createQuery(queryString).setParameter("sistemaId", sistemaId);;
        return queryObject.getResultList();
    }

    public List<SecRolRoles> getRolesWithAccess(int sistemaId, String usuarioCod) {
        String queryString = "SELECT ru.secRolRoles FROM SecRouRolesUsuarios ru WHERE "
                + "ru.secRolRoles.secSisSistemas.sisId = :sistemaId AND ru.secUsrUsuarios.usrCodigo = :usuarioId";
        Query queryObject;
        queryObject = getEntityManager().createQuery(queryString).setParameter("usuarioId", usuarioCod).setParameter("sistemaId", sistemaId);
        return queryObject.getResultList();
    }

    public List<SecRouRolesUsuarios> getRolesAccessOfUser(int sistemaId, String usuarioCod) {
        String queryString = "SELECT ru FROM SecRouRolesUsuarios ru WHERE "
                + "ru.secRolRoles.secSisSistemas.sisId = :sistemaId AND ru.secUsrUsuarios.usrCodigo = :usuarioId";
        Query queryObject;
        queryObject = getEntityManager().createQuery(queryString).setParameter("usuarioId", usuarioCod).setParameter("sistemaId", sistemaId);
        return queryObject.getResultList();
    }

    public SecRouRolesUsuarios validateRolUsuario(int rolId, String usuarioId) {
        String queryString = "SELECT ru FROM SecRouRolesUsuarios ru WHERE ru.secRolRoles.rolId = :rolId AND ru.secUsrUsuarios.usrCodigo = :usuarioId";
        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("rolId", rolId).setParameter("usuarioId",usuarioId);
        return (SecRouRolesUsuarios) queryObject.getSingleResult();
    }
}
