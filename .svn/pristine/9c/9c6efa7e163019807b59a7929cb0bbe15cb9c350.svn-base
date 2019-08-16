package com.seguridad.dto;

import com.seguridad.modelo.SecSisSistemas;
import com.seguridad.modelo.SecUsrUsuarios;
import java.io.Serializable;

public class UsuarioSistema implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private SecUsrUsuarios usuario;

    private SecSisSistemas sistema;

    private String estado;
    
    public UsuarioSistema(){
        
    }

    public UsuarioSistema(Integer id, SecUsrUsuarios usuario, SecSisSistemas sistema, String estado) {
        this.id = id;
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
        return "UsuarioSistema{" + "id=" + id + ", usuario=" + usuario.toString() + ", sistema=" + sistema.toString() + ", estado=" + estado + '}';
    }
   
}
