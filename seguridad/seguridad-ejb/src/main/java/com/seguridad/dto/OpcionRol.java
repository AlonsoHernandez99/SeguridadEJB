package com.seguridad.dto;

import java.io.Serializable;

public class OpcionRol implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer oprId;
    private OpcionMenu secOpmOpcionesMenu;
    private Rol secRolRoles;

    public OpcionRol() {
    }

    public OpcionRol(Integer oprId) {
        this.oprId = oprId;
    }

    public Integer getOprId() {
        return oprId;
    }

    public void setOprId(Integer oprId) {
        this.oprId = oprId;
    }

    public OpcionMenu getSecOpmOpcionesMenu() {
        return secOpmOpcionesMenu;
    }

    public void setSecOpmOpcionesMenu(OpcionMenu secOpmOpcionesMenu) {
        this.secOpmOpcionesMenu = secOpmOpcionesMenu;
    }

    public Rol getSecRolRoles() {
        return secRolRoles;
    }

    public void setSecRolRoles(Rol secRolRoles) {
        this.secRolRoles = secRolRoles;
    }

    @Override
    public String toString() {
        return "com.seguridad.modelo.OpcionRol[ oprId=" + oprId + " ]";
    }
    
}
