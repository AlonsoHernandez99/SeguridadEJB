package com.seguridad.dto;

import java.io.Serializable;
import java.util.Objects;

public class Sistema implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer sisId;
    private String sisNombre;
    private String sisCodigo;

    public Sistema() {
        this.sisId = 0;
    }

    public Sistema(Integer sisId) {
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
        final Sistema other = (Sistema) obj;
        return Objects.equals(this.sisId, other.sisId);
    }

    @Override
    public String toString() {
        return "com.seguridad.modelo.Sistema[ sisId=" + sisId + " ]";
    }
    
}
