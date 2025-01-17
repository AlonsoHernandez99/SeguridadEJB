package com.seguridad.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sec_rol_roles")
public class SecRolRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @SequenceGenerator(name="SEQ_ROLID_PK", sequenceName="SEQ_ROLID_PK", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ROLID_PK")      
    
    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    */    
    
    @Column(name = "rol_id")
    private Integer rolId;
    @Size(max = 50)
    @Column(name = "rol_nombre")
    private String rolNombre;
    @Size(max = 3)
    @Column(name = "rol_estado")
    private String rolEstado;
    @OneToMany(mappedBy = "secRolRoles")
    private Set<SecRouRolesUsuarios> secRouRolesUsuarioses;
    
    @OneToMany(mappedBy = "secRolRoles", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SecOprOpcionesRoles> secOprOpcionesRoleses;
    
    @JoinColumn(name = "sis_id", referencedColumnName = "sis_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private SecSisSistemas secSisSistemas;

    public SecRolRoles() {
        secSisSistemas = new SecSisSistemas();
    }

    public SecRolRoles(Integer rolId) {
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

    public Set<SecRouRolesUsuarios> getSecRouRolesUsuarioses() {
        return secRouRolesUsuarioses;
    }

    public void setSecRouRolesUsuarioses(Set<SecRouRolesUsuarios> secRouRolesUsuarioses) {
        this.secRouRolesUsuarioses = secRouRolesUsuarioses;
    }

    public Set<SecOprOpcionesRoles> getSecOprOpcionesRoleses() {
        return secOprOpcionesRoleses;
    }

    public void setSecOprOpcionesRoleses(Set<SecOprOpcionesRoles> secOprOpcionesRoleses) {
        this.secOprOpcionesRoleses = secOprOpcionesRoleses;
    }

    public SecSisSistemas getSecSisSistemas() {
        return secSisSistemas;
    }

    public void setSecSisSistemas(SecSisSistemas secSisSistemas) {
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
        final SecRolRoles other = (SecRolRoles) obj;
        return Objects.equals(this.rolId, other.rolId);
    }

    @Override
    public String toString() {
        return "com.seguridad.modelo.SecRolRoles[ rolId=" + rolId + " ]";
    }
    
}
