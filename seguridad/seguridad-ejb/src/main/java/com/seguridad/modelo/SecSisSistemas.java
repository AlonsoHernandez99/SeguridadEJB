package com.seguridad.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sec_sis_sistemas")
public class SecSisSistemas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @SequenceGenerator(name="SEQ_SISID_PK", sequenceName="SEQ_SISID_PK", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SISID_PK")      
    
    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    */    
    
    @Column(name = "sis_id")
    private Integer sisId;
    @Size(max = 50)
    @Column(name = "sis_nombre")
    private String sisNombre;
    @Size(max = 30)
    @Column(name = "sis_codigo")
    private String sisCodigo;
    @OneToMany(mappedBy = "secSisSistemas")
    private Set<SecRolRoles> secRolRoleses;
    @OneToMany(mappedBy = "secSisSistemas")
    private Set<SecMdsModulosSistemas> secMdsModulosSistemases;

    public SecSisSistemas() {
        this.sisId = 0;
    }

    public SecSisSistemas(Integer sisId) {
        this.sisId = sisId;
    }

    public Integer getSisId() {
        return sisId;
    }

    public void setSisId(Integer sisId) {
        this.sisId = sisId;
    }

    public String getSisNombre() {
        return sisNombre;
    }

    public void setSisNombre(String sisNombre) {
        this.sisNombre = sisNombre;
    }

    public String getSisCodigo() {
        return sisCodigo;
    }

    public void setSisCodigo(String sisCodigo) {
        this.sisCodigo = sisCodigo;
    }

    public Set<SecRolRoles> getSecRolRoleses() {
        return secRolRoleses;
    }

    public void setSecRolRoleses(Set<SecRolRoles> secRolRoleses) {
        this.secRolRoleses = secRolRoleses;
    }

    public Set<SecMdsModulosSistemas> getSecMdsModulosSistemases() {
        return secMdsModulosSistemases;
    }

    public void setSecMdsModulosSistemases(Set<SecMdsModulosSistemas> secMdsModulosSistemases) {
        this.secMdsModulosSistemases = secMdsModulosSistemases;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.sisId);
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
        final SecSisSistemas other = (SecSisSistemas) obj;
        return Objects.equals(this.sisId, other.sisId);
    }

    @Override
    public String toString() {
        return "com.seguridad.modelo.SecSisSistemas[ sisId=" + sisId + " ]";
    }
    
}
