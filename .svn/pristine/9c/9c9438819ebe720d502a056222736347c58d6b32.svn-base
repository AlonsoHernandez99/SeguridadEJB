package com.seguridad.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sec_opr_opciones_roles")
public class SecOprOpcionesRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @SequenceGenerator(name="SEQ_OPRID_PK", sequenceName="SEQ_OPRID_PK", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_OPRID_PK")      
    
    /*
     @GeneratedValue(strategy = GenerationType.IDENTITY)  
    */    
    
    @Column(name = "opr_id")
    private Integer oprId;
    @JoinColumn(name = "opm_id", referencedColumnName = "opm_id")
    @ManyToOne
    private SecOpmOpcionesMenu secOpmOpcionesMenu;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private SecRolRoles secRolRoles;

    public SecOprOpcionesRoles() {
    }

    public SecOprOpcionesRoles(SecOpmOpcionesMenu secOpmOpcionesMenu, SecRolRoles secRolRoles) {
        this.secOpmOpcionesMenu = secOpmOpcionesMenu;
        this.secRolRoles = secRolRoles;
    }
    
   
    public SecOprOpcionesRoles(Integer oprId) {
        this.oprId = oprId;
    }

    public Integer getOprId() {
        return oprId;
    }

    public void setOprId(Integer oprId) {
        this.oprId = oprId;
    }

    public SecOpmOpcionesMenu getSecOpmOpcionesMenu() {
        return secOpmOpcionesMenu;
    }

    public void setSecOpmOpcionesMenu(SecOpmOpcionesMenu secOpmOpcionesMenu) {
        this.secOpmOpcionesMenu = secOpmOpcionesMenu;
    }

    public SecRolRoles getSecRolRoles() {
        return secRolRoles;
    }

    public void setSecRolRoles(SecRolRoles secRolRoles) {
        this.secRolRoles = secRolRoles;
    }

    @Override
    public String toString() {
        return "com.seguridad.modelo.SecOprOpcionesRoles[ oprId=" + oprId + " ]";
    }
    
}
