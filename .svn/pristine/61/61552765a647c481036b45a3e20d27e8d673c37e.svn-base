package com.seguridad.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.apache.commons.codec.digest.DigestUtils;

import com.seguridad.modelo.SecUsrUsuarios;
import com.seguridad.modelo.SecUsuariosSistema;

@Stateless
public class SecUsrUsuariosDAO extends DAOBase {

    public SecUsrUsuariosDAO() {
    }

    public SecUsrUsuarios findUser(String usrId, String usrClave) throws RuntimeException {

        String queryString = "SELECT model FROM SecUsrUsuarios model where model.usrCodigo=:id AND model.usrClave = :clave AND model.usrEstado = 'ACT'";
        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("id", usrId);
        queryObject.setParameter("clave", DigestUtils.sha512Hex(usrClave));
        //queryObject.setParameter("clave", usrClave);

        return (SecUsrUsuarios) queryObject.getSingleResult();
    }

    public SecUsrUsuarios findById(String usrId) throws RuntimeException {
        String queryString = "SELECT model FROM SecUsrUsuarios model where model.usrCodigo=:id";
        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("id", usrId);
        return (SecUsrUsuarios) queryObject.getSingleResult();
    }

    public List<SecUsrUsuarios> findAll() throws RuntimeException {
        String queryString = "SELECT usr FROM SecUsrUsuarios usr"
                + " ORDER BY usr.usrNombre";
        Query queryObject;
        queryObject = getEntityManager().createQuery(queryString);
        return queryObject.getResultList();
    }

    public List<SecUsrUsuarios> findBySystem(String sistema) throws RuntimeException {
        String queryString = ""
                + "SELECT DISTINCT rou.secUsrUsuarios "
                + "FROM SecRouRolesUsuarios rou "
                + "WHERE rou.secRolRoles.secSisSistemas.sisCodigo = :sis";
        Query queryObject;
        queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("sis", sistema);
        return queryObject.getResultList();
    }

    public List<SecUsrUsuarios> findUsuariosBySistema(int sistemaId) throws RuntimeException {
        String queryString = "SELECT usis.usuario FROM SecUsuariosSistema usis WHERE usis.sistema.sisId = :sistemaId "
                + "ORDER BY usis.usuario.usrNombre";
        Query queryObject;
        queryObject = getEntityManager().createQuery(queryString).setParameter("sistemaId", sistemaId);
        return queryObject.getResultList();
    }

    public List<SecUsrUsuarios> getUsuariosWhereNoHasRole(int sistemaId) throws RuntimeException {
        String queryString = "SELECT u FROM SecUsrUsuarios u WHERE :sistemaId NOT IN (SELECT usis.sistema.sisId FROM u.secUsuariosSistemas usis)";
        Query queryObject;
        queryObject = getEntityManager().createQuery(queryString).setParameter("sistemaId", sistemaId);
        return queryObject.getResultList();
    }

    public SecUsuariosSistema getSistemaOfUser(String usuarioCod, int sistemaId) throws RuntimeException {        
        String queryString = "SELECT usis "
                + "FROM SecUsuariosSistema usis "
                + "WHERE usis.usuario.usrCodigo = :usrId AND usis.sistema.sisId = :sisId";

        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("usrId", usuarioCod);
        queryObject.setParameter("sisId", sistemaId);

        return (SecUsuariosSistema) queryObject.getSingleResult();
    }
    
     public String getEstadoSistemaOfUser(String usuarioCod, int sistemaId) throws RuntimeException {        
        String queryString = "SELECT usis.estado "
                + "FROM SecUsuariosSistema usis "
                + "WHERE usis.usuario.usrCodigo = :usrId AND usis.sistema.sisId = :sisId";

        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("usrId", usuarioCod);
        queryObject.setParameter("sisId", sistemaId);
       
        return queryObject.getSingleResult().toString();
    }
    
    

}
