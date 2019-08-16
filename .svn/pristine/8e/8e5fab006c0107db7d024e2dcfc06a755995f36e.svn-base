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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sec_opm_opciones_menu")
public class SecOpmOpcionesMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @SequenceGenerator(name="SEQ_OPMID_PK", sequenceName="SEQ_OPMID_PK", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_OPMID_PK")      
    
    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    */
    
    @Column(name = "opm_id")
    private Integer opmId;
    @Size(max = 100)
    @Column(name = "opm_etiqueta")
    private String opmEtiqueta;
    @Size(max = 500)
    @Column(name = "opm_comando")
    private String opmComando;
    @Size(max = 3)
    @Column(name = "opm_estado")
    private String opmEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "opm_orden")
    private int opmOrden;
    @OneToMany/*(mappedBy = "secOpmOpcionesMenu", fetch = FetchType.EAGER)*/(mappedBy = "secOpmOpcionesMenu", fetch = FetchType.LAZY)
    private Set<SecOprOpcionesRoles> secOprOpcionesRoleses;
    
    @OneToMany/*(mappedBy = "secOpmOpcionesMenu", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)*/(mappedBy = "secOpmOpcionesMenu", fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    @OrderBy("opmOrden")
    private Set<SecOpmOpcionesMenu> secOpmOpcionesMenus;
    
    @JoinColumn(name = "opm_padre", referencedColumnName = "opm_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private SecOpmOpcionesMenu secOpmOpcionesMenu;
    @JoinColumn(name = "mds_id", referencedColumnName = "mds_id")
    
    @ManyToOne(fetch = FetchType.EAGER)
    private SecMdsModulosSistemas secMdsModulosSistemas;

    public SecOpmOpcionesMenu() {
        this.opmId = 0;
        this.secMdsModulosSistemas = new SecMdsModulosSistemas();
    }

    public SecOpmOpcionesMenu(Integer opmId) {
        this.opmId = opmId;
    }

    public SecOpmOpcionesMenu(Integer opmId, int opmOrden) {
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

    public Set<SecOprOpcionesRoles> getSecOprOpcionesRoleses() {
        return secOprOpcionesRoleses;
    }

    public void setSecOprOpcionesRoleses(Set<SecOprOpcionesRoles> secOprOpcionesRoleses) {
        this.secOprOpcionesRoleses = secOprOpcionesRoleses;
    }

    public Set<SecOpmOpcionesMenu> getSecOpmOpcionesMenus() {
        return secOpmOpcionesMenus;
    }

    public void setSecOpmOpcionesMenus(Set<SecOpmOpcionesMenu> secOpmOpcionesMenus) {
        this.secOpmOpcionesMenus = secOpmOpcionesMenus;
    }

    public SecOpmOpcionesMenu getSecOpmOpcionesMenu() {
        return secOpmOpcionesMenu;
    }

    public void setSecOpmOpcionesMenu(SecOpmOpcionesMenu secOpmOpcionesMenu) {
        this.secOpmOpcionesMenu = secOpmOpcionesMenu;
    }

    public SecMdsModulosSistemas getSecMdsModulosSistemas() {
        return secMdsModulosSistemas;
    }

    public void setSecMdsModulosSistemas(SecMdsModulosSistemas secMdsModulosSistemas) {
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
        final SecOpmOpcionesMenu other = (SecOpmOpcionesMenu) obj;
        return Objects.equals(this.opmId, other.opmId);
    }

    @Override
    public String toString() {
        return "com.seguridad.modelo.SecOpmOpcionesMenu[ opmId=" + opmId + " ]";
    }
    
}
