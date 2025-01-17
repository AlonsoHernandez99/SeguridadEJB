package com.seguridad.utilidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class Usuario {

    private String usrCodigo;
    private String usrClave;
    private String usrNombre;
    private Date usrFechaIngreso;
    private String usrEstado;
    private OpcionMenu moduloActual;
    List<OpcionMenu> menu = new ArrayList<>();
    List<Rol> roles = new ArrayList<>();
    
    /*Cambio de contraseña*/
    private String usrContraActual;
    private String usrContraNueva;    

    public Usuario() {
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrClave() {
        return usrClave;
    }

    public void setUsrClave(String usrClave) {
        this.usrClave = usrClave;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public Date getUsrFechaIngreso() {
        return usrFechaIngreso;
    }

    public void setUsrFechaIngreso(Date usrFechaIngreso) {
        this.usrFechaIngreso = usrFechaIngreso;
    }

    public String getUsrEstado() {
        return usrEstado;
    }

    public void setUsrEstado(String usrEstado) {
        this.usrEstado = usrEstado;
    }

    public List<OpcionMenu> getMenu() {
        return menu;
    }

    public void setMenu(List<OpcionMenu> menu) {
        this.menu = menu;
    }   

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public OpcionMenu getModuloActual() {
        return moduloActual;
    }

    public void setModuloActual(OpcionMenu moduloActual) {
        this.moduloActual = moduloActual;
    }    

    public String getUsrContraActual() {
        return usrContraActual;
    }

    public void setUsrContraActual(String usrContraActual) {
        this.usrContraActual = usrContraActual;
    }

    public String getUsrContraNueva() {
        return usrContraNueva;
    }

    public void setUsrContraNueva(String usrContraNueva) {
        this.usrContraNueva = usrContraNueva;
    }    
        
}
