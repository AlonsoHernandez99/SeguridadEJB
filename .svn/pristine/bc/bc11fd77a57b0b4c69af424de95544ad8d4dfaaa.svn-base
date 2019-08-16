package com.seguridad.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Modulo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer mdsId;
    private String mdsNombre;
    private int mdsOrden;
    private Set<OpcionMenu> secOpmOpcionesMenus;
    private Sistema secSisSistemas;

    public Modulo() {
        mdsId = 0;
        secSisSistemas = new Sistema();
    }

    public Modulo(Integer mdsId) {
        this.mdsId = mdsId;
    }

    public Modulo(Integer mdsId, int mdsOrden) {
        this.mdsId = mdsId;
        this.mdsOrden = mdsOrden;
    }

    public Integer getMdsId() {
        return mdsId;
    }

    public void setMdsId(Integer mdsId) {
        this.mdsId = mdsId;
    }

    public String getMdsNombre() {
        return mdsNombre;
    }

    public void setMdsNombre(String mdsNombre) {
        this.mdsNombre = mdsNombre;
    }

    public int getMdsOrden() {
        return mdsOrden;
    }

    public void setMdsOrden(int mdsOrden) {
        this.mdsOrden = mdsOrden;
    }

    public Set<OpcionMenu> getSecOpmOpcionesMenus() {
        return secOpmOpcionesMenus;
    }

    public void setSecOpmOpcionesMenus(Set<OpcionMenu> secOpmOpcionesMenus) {
        this.secOpmOpcionesMenus = secOpmOpcionesMenus;
    }

    public Sistema getSecSisSistemas() {
        return secSisSistemas;
    }

    public void setSecSisSistemas(Sistema secSisSistemas) {
        this.secSisSistemas = secSisSistemas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.mdsId);
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
        final Modulo other = (Modulo) obj;
        return Objects.equals(this.mdsId, other.mdsId);
    }

    @Override
    public String toString() {
        return "com.seguridad.modelo.Modulo[ mdsId=" + mdsId + " ]";
    }
    
}
