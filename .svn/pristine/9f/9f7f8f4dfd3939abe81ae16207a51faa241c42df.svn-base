package com.seguridad.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private String usrCodigo;
    private String usrClave;
    private String usrNombre; 
    private String usrCorreo;    
    private Date usrFechaIngreso;
    private String usrEstado;
    private Set<RolUsuario> secRouRolesUsuarioses;

    public Usuario() {
    }

    public Usuario(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Usuario(String usrCodigo, String usrClave) {
        this.usrCodigo = usrCodigo;
        this.usrClave = usrClave;
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

    public String getUsrCorreo() {
        return usrCorreo;
    }

    public void setUsrCorreo(String usrCorreo) {
        this.usrCorreo = usrCorreo;
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

    public Set<RolUsuario> getSecRouRolesUsuarioses() {
        return secRouRolesUsuarioses;
    }

    public void setSecRouRolesUsuarioses(Set<RolUsuario> secRouRolesUsuarioses) {
        this.secRouRolesUsuarioses = secRouRolesUsuarioses;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.usrCodigo);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.usrCodigo, other.usrCodigo);
    }

    @Override
    public String toString() {
        return "com.seguridad.modelo.Usuario[ usrCodigo=" + usrCodigo + " ]";
    }
    
}
