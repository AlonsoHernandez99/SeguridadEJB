package com.seguridad.utilidad;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {
    private String fUser;
    private String fPassword;
    
    public SMTPAuthenticator(String user, String password) {
        fUser = user;
        fPassword = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(fUser, fPassword);
    }    
}
