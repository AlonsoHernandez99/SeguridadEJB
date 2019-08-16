package com.seguridad.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sec_mds_modulos_sistemas")
public class SecMdsModulosSistemas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @SequenceGenerator(name="SEQ_MDSID_PK", sequenceName="SEQ_MDSID_PK", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MDSID_PK")   
    
    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    */

    @Column(name = "mds_id")  
    private Integer mdsId;
    @Size(max = 50)
    @Column(name = "mds_nombre")
    private String mdsNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mds_orden")
    private int mdsOrden;
    @OneToMany(mappedBy = "secMdsModulosSistemas")
    private Set<SecOpmOpcionesMenu> secOpmOpcionesMenus;
    @JoinColumn(name = "sis_id", referencedColumnName = "sis_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private SecSisSistemas secSisSistemas;

    public SecMdsModulosSistemas() {
        mdsId = 0;
        secSisSistemas = new SecSisSistemas();
    }

    public SecMdsModulosSistemas(Integer mdsId) {
        this.mdsId = mdsId;
    }

    public SecMdsModulosSistemas(Integer mdsId, int mdsOrden) {
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

    public Set<SecOpmOpcionesMenu> getSecOpmOpcionesMenus() {
        return secOpmOpcionesMenus;
    }

    public void setSecOpmOpcionesMenus(Set<SecOpmOpcionesMenu> secOpmOpcionesMenus) {
        this.secOpmOpcionesMenus = secOpmOpcionesMenus;
    }

    public SecSisSistemas getSecSisSistemas() {
        return secSisSistemas;
    }

    public void setSecSisSistemas(SecSisSistemas secSisSistemas) {
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
        final SecMdsModulosSistemas other = (SecMdsModulosSistemas) obj;
        return Objects.equals(this.mdsId, other.mdsId);
    }

    @Override
    public String toString() {
        return "com.seguridad.modelo.SecMdsModulosSistemas[ mdsId=" + mdsId + " ]";
    }
    
}
