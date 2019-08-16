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
import javax.validation.constraints.Size;

@Entity
@Table(name = "sec_usis_usuarios_sistema")
public class SecUsuariosSistema implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="SEQ_USIS_PK", sequenceName="SEQ_USIS_PK", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USIS_PK") 
    @Column(name = "usis_id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "usis_usuario_cod", referencedColumnName = "usr_codigo")
    private SecUsrUsuarios usuario;
    
    @ManyToOne
    @JoinColumn(name = "usis_sistema_id", referencedColumnName = "sis_id")
    private SecSisSistemas sistema;
    
    @Size(max = 3)
    @Column(name = "usis_estado")
    private String estado;

    public SecUsuariosSistema() {
    }

    public SecUsuariosSistema(SecUsrUsuarios usuario, SecSisSistemas sistema) {
        this.usuario = usuario;
        this.sistema = sistema;
    }
    
   
    
    public SecUsuariosSistema(SecUsrUsuarios usuario, SecSisSistemas sistema, String estado) {
        this.usuario = usuario;
        this.sistema = sistema;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SecUsrUsuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(SecUsrUsuarios usuario) {
        this.usuario = usuario;
    }

    public SecSisSistemas getSistema() {
        return sistema;
    }

    public void setSistema(SecSisSistemas sistema) {
        this.sistema = sistema;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "SecUsuariosSistema{" + "id=" + id + ", usuario=" + usuario.toString() + ", sistema=" + sistema.toString() + ", estado=" + estado + '}';
    }
  
}