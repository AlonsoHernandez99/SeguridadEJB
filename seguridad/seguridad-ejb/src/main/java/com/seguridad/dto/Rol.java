package com.seguridad.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer rolId;
    private String rolNombre;
    private String rolEstado;
    private Set<RolUsuario> secRouRolesUsuarioses;
    private Set<OpcionRol> secOprOpcionesRoleses;
    private Sistema secSisSistemas;

    public Rol() {
        secSisSistemas = new Sistema();
    }

    public Rol(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(String rolEstado) {
        this.rolEstado = rolEstado;
    }

    public Set<RolUsuario> getSecRouRolesUsuarioses() {
        return secRouRolesUsuarioses;
    }

    public void setSecRouRolesUsuarioses(Set<RolUsuario> secRouRolesUsuarioses) {
        this.secRouRolesUsuarioses = secRouRolesUsuarioses;
    }

    public Set<OpcionRol> getSecOprOpcionesRoleses() {
        return secOprOpcionesRoleses;
    }

    public void setSecOprOpcionesRoleses(Set<OpcionRol> secOprOpcionesRoleses) {
        this.secOprOpcionesRoleses = secOprOpcionesRoleses;
    }

    public Sistema getSecSisSistemas() {
        return secSisSistemas;
    }

    public void setSecSisSistemas(Sistema secSisSistemas) {
        this.secSisSistemas = secSisSistemas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.rolId);
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
        final Rol other = (Rol) obj;
        return Objects.equals(this.rolId, other.rolId);
    }

    @Override
    public String toString() {
        return "Rol{" + "rolId=" + rolId + ", rolNombre=" + rolNombre + ", rolEstado=" + rolEstado + '}';
    }
}
