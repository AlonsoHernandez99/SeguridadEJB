package com.seguridad.servicio;

import com.seguridad.dao.SecParParametrosDAO;
import com.seguridad.modelo.SecParParametros;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ParameterService {

    @Inject
    private SecParParametrosDAO parDAO;

    public void guardar(SecParParametros parametro) throws RuntimeException {
        parDAO.save(parametro);
    }

    public void actualizar(SecParParametros parametro) throws RuntimeException {
        parDAO.merge(parametro);
    }

    public void borrar(SecParParametros parametro) throws RuntimeException {
        parDAO.remove(parametro);
    }

    public List<SecParParametros> listarParametros() {
        return parDAO.findAll();
    }
}
