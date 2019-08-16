package com.seguridad.dto;

import java.io.Serializable;
import java.util.Objects;

public class Parametro implements Serializable {

    private static final long serialVersionUID = 1L;
    private String parCodigo;
    private String parDescripcion;
    private String parValor;

    public Parametro() {
    }

    public Parametro(String parCodigo) {
        this.parCodigo = parCodigo;
    }

    public String getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(String parCodigo) {
        this.parCodigo = parCodigo;
    }

    public String getParDescripcion() {
        return parDescripcion;
    }

    public void setParDescripcion(String parDescripcion) {
        this.parDescripcion = parDescripcion;
    }

    public String getParValor() {
        return parValor;
    }

    public void setParValor(String parValor) {
        this.parValor = parValor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.parCodigo);
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
        final Parametro other = (Parametro) obj;
        return Objects.equals(this.parCodigo, other.parCodigo);
    }
    
}
