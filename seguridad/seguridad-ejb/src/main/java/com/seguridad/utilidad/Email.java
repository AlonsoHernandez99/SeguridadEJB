package com.seguridad.utilidad;

import java.util.ArrayList;
import java.util.List;

public class Email {

    private String remitente;
    private String asunto;
    private String mensaje;    
    private List<String> cc = new ArrayList<>();
    private List<String> cco = new ArrayList<>();
    private List<String> destinatarios = new ArrayList<>();
    private List<Adjunto> adjuntos = new ArrayList<>();

    public Email() {
        asunto = "";
        mensaje = "";
        remitente = "";
    }        

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public List<String> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<String> destinatarios) {
        this.destinatarios = destinatarios;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getCco() {
        return cco;
    }

    public void setCco(List<String> cco) {
        this.cco = cco;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Adjunto> getAdjuntos() {
        return adjuntos;
    }

    public void setAdjuntos(List<Adjunto> adjuntos) {
        this.adjuntos = adjuntos;
    }   

}
