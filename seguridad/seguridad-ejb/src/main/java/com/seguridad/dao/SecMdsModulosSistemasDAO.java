package com.seguridad.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.seguridad.modelo.SecMdsModulosSistemas;

@Stateless
public class SecMdsModulosSistemasDAO extends DAOBase {

	public SecMdsModulosSistemasDAO() {
	}

	public SecMdsModulosSistemas findById(String usrId) throws RuntimeException {

		String queryString = "SELECT model FROM SecMdsModulosSistemas model where model.usrCodigo=:id";
		Query queryObject = getEntityManager().createQuery(queryString);
		queryObject.setParameter("id", usrId);
		return (SecMdsModulosSistemas) queryObject.getSingleResult();

	}
        
	public List<SecMdsModulosSistemas> findBySistema(int id) throws RuntimeException {

		String queryString = "SELECT model FROM SecMdsModulosSistemas model where model.secSisSistemas.sisId=:id";
		Query queryObject = getEntityManager().createQuery(queryString);
		queryObject.setParameter("id", id);
		return queryObject.getResultList();

	}

	public List<SecMdsModulosSistemas> findAll() throws RuntimeException {
		String queryString = "SELECT mds FROM SecMdsModulosSistemas mds ORDER BY mds.secSisSistemas.sisNombre, mds.mdsOrden";
		Query queryObject;
		queryObject = getEntityManager().createQuery(queryString);
		return queryObject.getResultList();

	}

	public List<SecMdsModulosSistemas> finbByUserAndSystem(String codigo, String sistema) throws RuntimeException {
		String query = ""
				+ "	SELECT distinct mds "
				+ "	FROM SecUsrUsuarios usr "
				+ "		 INNER JOIN usr.secRouRolesUsuarioses rou "
				+ "		 INNER JOIN rou.secRolRoles rol "
				+ "		 INNER JOIN rol.secOprOpcionesRoleses opr "
				+ "		 INNER JOIN opr.secOpmOpcionesMenu opm "
				+ "      INNER JOIN opm.secMdsModulosSistemas mds "
				+ "      INNER JOIN mds.secSisSistemas sis "
				+ "	WHERE usr.usrCodigo = :codigo and sis.sisCodigo = :sistema "
				+ "       and lower(opm.opmEstado) = lower('ACT') "
				//+ " ORDER BY opm.opmOrden"
				;

		Query hql = getEntityManager().createQuery(query);
		hql.setParameter("codigo", codigo);
		hql.setParameter("sistema", sistema);

		return hql.getResultList();
	}

}
