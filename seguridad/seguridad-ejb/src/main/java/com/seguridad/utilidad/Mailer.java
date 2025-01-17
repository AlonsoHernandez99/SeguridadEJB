package com.seguridad.utilidad;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class Mailer {

    private String smtpHost;
    private String smtpPort;
    private String correo;
    private String pass;

    public Mailer() {
    }

    public void enviarCorreo(Email mail) throws AddressException, MessagingException {

        //Establemecemos los parametros de conexión para el servidor de correos.
        Properties properties = new Properties();
        properties.put("mail.smtp.host", this.smtpHost);
        properties.put("mail.smtp.port", this.smtpPort);
        properties.put("mail.smtp.starttls.enable", "true");//Parametro de seguridad.        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", this.smtpHost);

        //Creamos un objeto que permitirá iniciar sessión en el servidor de correos.
        SMTPAuthenticator auth = new SMTPAuthenticator(this.correo, this.pass);

        //Iniciamos sessión.
        Session session = Session.getInstance(properties, auth);

        InternetAddress remitente;                           

        String ccs = "";
        String ccos = "";
        String destinatarios = "";

        for (String cc : mail.getCc()) {
            ccs = ccs + cc + ",";
        }

        for (String cco : mail.getCco()) {
            ccos = ccos + cco + ",";
        }

        for (String dest : mail.getDestinatarios()) {
            destinatarios = destinatarios + dest + ",";
        }

        //remitente = new InternetAddress(mail.getRemitente());
        Address toList[] = InternetAddress.parse(destinatarios);
        Address ccList[] = InternetAddress.parse(ccs);
        Address ccoList[] = InternetAddress.parse(ccos);

        MimeBodyPart mensaje = new MimeBodyPart();
        //Setea el mensaje del correo
        mensaje.setText(mail.getMensaje());

        //Setea el archivo adjunto MIME
        DataSource dataSource;
        MimeBodyPart adjunto;
        String mime = "";

        MimeMultipart body = new MimeMultipart();    
        
        for (Adjunto adj : mail.getAdjuntos()) {
            adjunto = new MimeBodyPart();

            switch (adj.getExtension()) {
                case "pdf":
                    mime = "application/pdf";
                    break;
                case "docx":
                    mime = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                    break;
            }

            dataSource = new ByteArrayDataSource(adj.getDatos(), mime);
            adjunto.setDataHandler(new DataHandler(dataSource));
            adjunto.setFileName(adj.getNombre() + "." + adj.getExtension());
            body.addBodyPart(adjunto);
        }

        body.addBodyPart(mensaje);

        MimeMessage msj = new MimeMessage(session);
        //msj.setFrom(remitente);
        //msj.setSender(remitente);
        msj.setSubject(mail.getAsunto());
        msj.setRecipients(Message.RecipientType.TO, toList);
        msj.setRecipients(Message.RecipientType.BCC, ccoList);
        msj.setRecipients(Message.RecipientType.CC, ccList);
        msj.setContent(body);
        
        Transport.send(msj);
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
