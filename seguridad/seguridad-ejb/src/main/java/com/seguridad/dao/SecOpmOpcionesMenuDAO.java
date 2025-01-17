package com.seguridad.dao;

import com.seguridad.modelo.SecOpmOpcionesMenu;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class SecOpmOpcionesMenuDAO extends DAOBase {

    public SecOpmOpcionesMenuDAO() {
    }

    public SecOpmOpcionesMenu findById(int opmId) throws RuntimeException {

        String queryString = "SELECT model FROM SecOpmOpcionesMenu model where model.opmId=:id";
        Query queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("id", opmId);
        return (SecOpmOpcionesMenu) queryObject.getSingleResult();

    }

    public List<SecOpmOpcionesMenu> findAll() throws RuntimeException {

        String queryString = "SELECT model FROM SecOpmOpcionesMenu model ORDER by model.opmOrden";
        Query queryObject;
        queryObject = getEntityManager().createQuery(queryString);
        return queryObject.getResultList();

    }

    public List<SecOpmOpcionesMenu> findByModulo(int id, int execOpm) throws RuntimeException {

        String queryString = "SELECT model FROM SecOpmOpcionesMenu model "
                + "WHERE model.secMdsModulosSistemas.mdsId = :id and model.opmId <> :execOpm";
        Query queryObject;
        queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("id", id);
        queryObject.setParameter("execOpm", execOpm);
        return queryObject.getResultList();

    }

    public List<SecOpmOpcionesMenu> findByModulo(int id) throws RuntimeException {

        String queryString = "SELECT model FROM SecOpmOpcionesMenu model WHERE model.secMdsModulosSistemas.mdsId = :id";
        Query queryObject;
        queryObject = getEntityManager().createQuery(queryString);
        queryObject.setParameter("id", id);
        return queryObject.getResultList();

    }

    public List<SecOpmOpcionesMenu> findOpcionesPadre(int moduloId) throws RuntimeException {

        String queryString = "SELECT model FROM SecOpmOpcionesMenu model WHERE model.secOpmOpcionesMenu is null "
                + "AND model.secMdsModulosSistemas.mdsId = :moduloId ORDER by model.opmOrden DESC";
        Query queryObject;
        queryObject = getEntityManager().createQuery(queryString).setParameter("moduloId",moduloId);
        return queryObject.getResultList();

    }

    public List<SecOpmOpcionesMenu> finbByUserAndSystem(String codigo, String sistema) throws RuntimeException {
        String query = ""
                + "	SELECT distinct opm "
                + "	FROM SecUsrUsuarios usr "
                + "		 INNER JOIN usr.secRouRolesUsuarioses rou "
                + "		 INNER JOIN rou.secRolRoles rol "
                + "		 INNER JOIN rol.secOprOpcionesRoleses opr "
                + "		 INNER JOIN opr.secOpmOpcionesMenu opm "
                + "	WHERE usr.usrCodigo = :codigo "
                + "           and rol.secSisSistemas.sisCodigo = :sistema "
                + "     ORDER BY opm.opmOrden";

        Query hql = getEntityManager().createQuery(query);
        hql.setParameter("codigo", codigo);
        hql.setParameter("sistema", sistema);

        List<SecOpmOpcionesMenu> resultado = hql.getResultList();

        return resultado;
    }

    public List<SecOpmOpcionesMenu> finbByUserAndModule(String codigo, int modulo) throws RuntimeException {
        String query = ""
                + "	SELECT distinct opm "
                + "	FROM SecUsrUsuarios usr "
                + "		 INNER JOIN usr.secRouRolesUsuarioses rou "
                + "		 INNER JOIN rou.secRolRoles rol "
                + "		 INNER JOIN rol.secOprOpcionesRoleses opr "
                + "		 INNER JOIN opr.secOpmOpcionesMenu opm "
                + "              INNER JOIN opm.secMdsModulosSistemas mds "
                + "	WHERE usr.usrCodigo = :codigo and mds.mdsId = :modulo "
                + "           and lower(opm.opmEstado) = lower('ACT') "
                + "     ORDER BY opm.opmOrden";

        Query hql = getEntityManager().createQuery(query);
        hql.setParameter("codigo", codigo);
        hql.setParameter("modulo", modulo);

        List<SecOpmOpcionesMenu> resultado = hql.getResultList();

        return resultado;
    }

}
