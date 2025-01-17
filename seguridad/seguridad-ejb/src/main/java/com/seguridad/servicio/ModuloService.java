package com.seguridad.servicio;

import com.seguridad.dao.SecMdsModulosSistemasDAO;
import com.seguridad.dao.SecSisSistemasDAO;
import com.seguridad.modelo.SecMdsModulosSistemas;
import com.seguridad.modelo.SecSisSistemas;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ModuloService {

    @Inject
    private SecSisSistemasDAO sisDAO;
    @Inject
    private SecMdsModulosSistemasDAO mdsDAO;

    public List<SecSisSistemas> listarSistemas() {
        return sisDAO.findAll();
    }

    public List<SecMdsModulosSistemas> listarModulos(int sistemaId) {
        return mdsDAO.findBySistema(sistemaId);
    }

    public void guardar(SecMdsModulosSistemas modulo) throws RuntimeException{
        mdsDAO.save(modulo);

    }

    public void actualizar(SecMdsModulosSistemas modulo) throws RuntimeException{
        mdsDAO.merge(modulo);
    }

    public void borrar(SecMdsModulosSistemas modulo) throws RuntimeException{
        mdsDAO.remove(modulo);
    }

}
