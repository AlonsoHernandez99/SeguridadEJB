package com.seguridad.servicio;

import com.seguridad.dao.SecMdsModulosSistemasDAO;
import com.seguridad.dao.SecOpmOpcionesMenuDAO;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class OpcionMenuService {

    @Inject
    private SecMdsModulosSistemasDAO mdsDAO;
    @Inject
    private SecOpmOpcionesMenuDAO opmDAO;


}
