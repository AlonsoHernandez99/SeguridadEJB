package com.seguridad.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sec_usr_usuarios")
public class SecUsrUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usr_clave")
    private String usrClave;
    @Size(max = 60)
    @Column(name = "usr_nombre")
    private String usrNombre;
    @Size(max = 100)
    @Column(name = "usr_correo")    
    private String usrCorreo;    
    @Column(name = "usr_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date usrFechaIngreso;
    @Size(max = 3)
    @Column(name = "usr_estado")
    private String usrEstado;
    @OneToMany(mappedBy = "secUsrUsuarios", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SecRouRolesUsuarios> secRouRolesUsuarioses;
    
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SecUsuariosSistema> secUsuariosSistemas;

    public SecUsrUsuarios() {
    }

    public SecUsrUsuarios(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public SecUsrUsuarios(String usrCodigo, String usrClave) {
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

    public Set<SecRouRolesUsuarios> getSecRouRolesUsuarioses() {
        return secRouRolesUsuarioses;
    }

    public void setSecRouRolesUsuarioses(Set<SecRouRolesUsuarios> secRouRolesUsuarioses) {
        this.secRouRolesUsuarioses = secRouRolesUsuarioses;
    }

    public Set<SecUsuariosSistema> getSecUsuariosSistemas() {
        return secUsuariosSistemas;
    }

    public void setSecUsuariosSistemas(Set<SecUsuariosSistema> secUsuariosSistemas) {
        this.secUsuariosSistemas = secUsuariosSistemas;
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
        final SecUsrUsuarios other = (SecUsrUsuarios) obj;
        return Objects.equals(this.usrCodigo, other.usrCodigo);
    }

    @Override
    public String toString() {
        return "Usuario{" + "usrCodigo=" + usrCodigo + ", usrClave=" + usrClave + ", usrNombre=" + usrNombre + ", usrCorreo=" + usrCorreo + ", usrFechaIngreso=" + usrFechaIngreso + ", usrEstado=" + usrEstado + '}';
    }
    
}
