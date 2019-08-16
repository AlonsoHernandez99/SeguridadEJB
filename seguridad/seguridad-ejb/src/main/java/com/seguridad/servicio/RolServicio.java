package com.seguridad.servicio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.seguridad.dao.SecMdsModulosSistemasDAO;
import com.seguridad.dao.SecOpmOpcionesMenuDAO;
import com.seguridad.dao.SecOprOpcionesRolesDAO;
import com.seguridad.dao.SecRolRolesDAO;
import com.seguridad.dao.SecRouRolesUsuariosDAO;
import com.seguridad.dao.SecSisSistemasDAO;
import com.seguridad.dto.Modulo;
import com.seguridad.dto.OpcionMenu;
import com.seguridad.dto.Rol;
import com.seguridad.dto.Sistema;
import com.seguridad.modelo.SecOpmOpcionesMenu;
import com.seguridad.modelo.SecOprOpcionesRoles;
import com.seguridad.modelo.SecRolRoles;
import com.seguridad.modelo.SecRouRolesUsuarios;
import com.seguridad.modelo.SecSisSistemas;

@Stateless
public class RolServicio {

    @Inject
    SecRolRolesDAO rolDAO;

    @Inject
    private SecSisSistemasDAO sistemasDAO;

    @Inject
    private SecMdsModulosSistemasDAO mdsDAO;

    @Inject
    private SecOpmOpcionesMenuDAO opmDAO;

    @Inject
    private SecOprOpcionesRolesDAO oprDAO;

    @Inject
    private SecRouRolesUsuariosDAO rolesUsuariosDAO;

    @Inject
    private DozerMapper dozMap;

    public List<Sistema> obtenerSistemas() {
        List<SecSisSistemas> listaSistemas = sistemasDAO.findAll();
        return dozMap.mapList(listaSistemas, Sistema.class);
    }

    public List<SecRolRoles> getRolesHasNotAccessOption(int opcionId) {
        return dozMap.mapList(rolDAO.getRolesHasNotAccessOption(opcionId), SecRolRoles.class);
    }

    public List<Rol> getRolesWithoutAccess(int sistemaId, String usuarioCod) {
        return dozMap.mapList(rolDAO.getRolesWithoutAccess(sistemaId, usuarioCod), Rol.class);
    }

    public List<SecRolRoles> getAllRolesOfSistema(int sistemaId) {
        return rolDAO.getAllRolesOfSistema(sistemaId);
    }

    public List<Rol> getRolesWithAccess(int sistemaId, String usuarioCod) {
        return dozMap.mapList(rolDAO.getRolesWithAccess(sistemaId, usuarioCod), Rol.class);
    }

    public SecRouRolesUsuarios validateRolUsuario(int rolId, String usuarioId) {
        return rolDAO.validateRolUsuario(rolId, usuarioId);
    }

    public List<SecRouRolesUsuarios> getRolesAccessOfUser(int sistemaId, String usuarioCod) {
        return rolDAO.getRolesAccessOfUser(sistemaId, usuarioCod);
    }

    public void deleteRolesOfUser(String usuarioCod, int sistemaId) throws RuntimeException {
        rolesUsuariosDAO.deleteRolesOfUser(usuarioCod, sistemaId);
    }

    public Rol convertToDto(SecRolRoles rol) {
        return dozMap.map(rol, Rol.class);
    }

    public List<Modulo> listarModulosPorSistemas(Rol rol) {
        return dozMap.mapList(mdsDAO.findBySistema(rol.getSecSisSistemas().getSisId()), Modulo.class);
    }

    public List<OpcionMenu> listarOpcionesPorModulo(Modulo modulo) {
        return dozMap.mapList(opmDAO.findByModulo(modulo.getMdsId()), OpcionMenu.class);
    }

    public List<Rol> findAll(int sistemaId) throws RuntimeException {
        return dozMap.mapList(rolDAO.findAll(sistemaId), Rol.class);
    }

    public List<SecOprOpcionesRoles> findByOpcion(int opmId) throws RuntimeException {
        return dozMap.mapList(oprDAO.findByOpcion(opmId), SecOprOpcionesRoles.class);
    }

    public List<SecRolRoles> findBySistema(SecSisSistemas sistema) throws RuntimeException {
        return rolDAO.findBySistema(sistema);

    }

    public SecRolRoles findById(Integer rolId) throws RuntimeException {
        return rolDAO.findById(rolId);
    }

    public void save(Object transientInstance) throws RuntimeException {
        rolDAO.save(dozMap.map(transientInstance, SecRolRoles.class));
    }

    public Object merge(Object detachedInstance) throws RuntimeException {
        return rolDAO.merge(dozMap.map(detachedInstance, SecRolRoles.class));
    }

    public void saveAllRolesUser(List<SecRouRolesUsuarios> roles) {
        try {
            for (SecRouRolesUsuarios rolu : roles) {
                rolDAO.merge(rolu);
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public void saveOneRolesUser(SecRouRolesUsuarios rol) {
        rolDAO.save(rol);
    }

    public void remove(Object persistentInstance) throws RuntimeException {
        rolDAO.remove(dozMap.map(persistentInstance, SecRolRoles.class));
    }

    public void deleteRolUsuario(SecRouRolesUsuarios rolu) {
        rolDAO.remove(rolu);
    }

    public Set<OpcionMenu> obtenerOpciones(Rol rol) {

        SecRolRoles rolAux = findById(rol.getRolId());

        Set<SecOpmOpcionesMenu> opciones = new HashSet<>();
        for (SecOprOpcionesRoles opr : rolAux.getSecOprOpcionesRoleses()) {
            opciones.add(opr.getSecOpmOpcionesMenu());
        }

        List<OpcionMenu> opcionesAux = dozMap.mapList(new ArrayList<>(opciones), OpcionMenu.class);

        return new HashSet<>(opcionesAux);
    }

    public void asignarOpciones(Rol rol, Modulo modulo, Set<OpcionMenu> opciones) {
        SecOprOpcionesRoles opr;
        Set<SecOprOpcionesRoles> oprs = new HashSet<>();

        SecRolRoles rolAux = dozMap.map(rol, SecRolRoles.class);
        List<SecOpmOpcionesMenu> opcionesAux = dozMap.mapList(new ArrayList<>(opciones), SecOpmOpcionesMenu.class);

        rolAux = findById(rolAux.getRolId());
        rolAux.getSecOprOpcionesRoleses().removeAll(oprDAO.findByModuloAndRol(modulo.getMdsId(), rol.getRolId()));

        for (SecOpmOpcionesMenu opm : opcionesAux) {
            opr = new SecOprOpcionesRoles();
            opr.setSecRolRoles(rolAux);
            opr.setSecOpmOpcionesMenu(opm);
            oprs.add(opr);
        }

        rolAux.getSecOprOpcionesRoleses().addAll(oprs);
        merge(rolAux);
    }

}
