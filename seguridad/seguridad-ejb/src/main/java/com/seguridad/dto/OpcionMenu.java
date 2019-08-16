package com.seguridad.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class OpcionMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer opmId;
    private String opmEtiqueta;
    private String opmComando;
    private String opmEstado;
    private int opmOrden;    
    private Set<OpcionRol> secOprOpcionesRoleses;    
    private Set<OpcionMenu> secOpmOpcionesMenus;
    private OpcionMenu secOpmOpcionesMenu;
    private Modulo secMdsModulosSistemas;

    public OpcionMenu() {
        this.opmId = 0;
        this.secMdsModulosSistemas = new Modulo();
    }

    public OpcionMenu(Integer opmId) {
        this.opmId = opmId;
    }

    public OpcionMenu(Integer opmId, int opmOrden) {
        this.opmId = opmId;
        this.opmOrden = opmOrden;
    }

    public Integer getOpmId() {
        return opmId;
    }

    public void setOpmId(Integer opmId) {
        this.opmId = opmId;
    }

    public String getOpmEtiqueta() {
        return opmEtiqueta;
    }

    public void setOpmEtiqueta(String opmEtiqueta) {
        this.opmEtiqueta = opmEtiqueta;
    }

    public String getOpmComando() {
        return opmComando;
    }

    public void setOpmComando(String opmComando) {
        this.opmComando = opmComando;
    }

    public String getOpmEstado() {
        return opmEstado;
    }

    public void setOpmEstado(String opmEstado) {
        this.opmEstado = opmEstado;
    }

    public int getOpmOrden() {
        return opmOrden;
    }

    public void setOpmOrden(int opmOrden) {
        this.opmOrden = opmOrden;
    }

    public Set<OpcionRol> getSecOprOpcionesRoleses() {
        return secOprOpcionesRoleses;
    }

    public void setSecOprOpcionesRoleses(Set<OpcionRol> secOprOpcionesRoleses) {
        this.secOprOpcionesRoleses = secOprOpcionesRoleses;
    }

    public Set<OpcionMenu> getSecOpmOpcionesMenus() {
        return secOpmOpcionesMenus;
    }

    public void setSecOpmOpcionesMenus(Set<OpcionMenu> secOpmOpcionesMenus) {
        this.secOpmOpcionesMenus = secOpmOpcionesMenus;
    }

    public OpcionMenu getSecOpmOpcionesMenu() {
        return secOpmOpcionesMenu;
    }

    public void setSecOpmOpcionesMenu(OpcionMenu secOpmOpcionesMenu) {
        this.secOpmOpcionesMenu = secOpmOpcionesMenu;
    }

    public Modulo getSecMdsModulosSistemas() {
        return secMdsModulosSistemas;
    }

    public void setSecMdsModulosSistemas(Modulo secMdsModulosSistemas) {
        this.secMdsModulosSistemas = secMdsModulosSistemas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.opmId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OpcionMenu other = (OpcionMenu) obj;
        return Objects.equals(this.opmId, other.opmId);
    }

    @Override
    public String toString() {
        return "com.seguridad.modelo.OpcionMenu[ opmId=" + opmId + " ]";
    }
    
}
