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
@Table(name = "sec_rou_roles_usuarios")
public class SecRouRolesUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @SequenceGenerator(name="SEQ_ROUID_PK", sequenceName="SEQ_ROUID_PK", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ROUID_PK")      
    
    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    */    
    
    @Column(name = "rou_id")
    private Integer rouId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private SecRolRoles secRolRoles;
    @JoinColumn(name = "usr_codigo", referencedColumnName = "usr_codigo")
    @ManyToOne
    private SecUsrUsuarios secUsrUsuarios;

    public SecRouRolesUsuarios() {
    }

    public SecRouRolesUsuarios(SecRolRoles secRolRoles, SecUsrUsuarios secUsrUsuarios) {
        this.secRolRoles = secRolRoles;
        this.secUsrUsuarios = secUsrUsuarios;
    }
    

    public SecRouRolesUsuarios(Integer rouId) {
        this.rouId = rouId;
    }

    public Integer getRouId() {
        return rouId;
    }

    public void setRouId(Integer rouId) {
        this.rouId = rouId;
    }

    public SecRolRoles getSecRolRoles() {
        return secRolRoles;
    }

    public void setSecRolRoles(SecRolRoles secRolRoles) {
        this.secRolRoles = secRolRoles;
    }

    public SecUsrUsuarios getSecUsrUsuarios() {
        return secUsrUsuarios;
    }

    public void setSecUsrUsuarios(SecUsrUsuarios secUsrUsuarios) {
        this.secUsrUsuarios = secUsrUsuarios;
    }

    @Override
    public String toString() {
        return "com.seguridad.modelo.SecRouRolesUsuarios[ rouId=" + rouId + " ]";
    }
    
}
