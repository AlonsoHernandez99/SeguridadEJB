package com.seguridad.servicio;

import com.seguridad.dao.SecParParametrosDAO;
import com.seguridad.dao.SecRolRolesDAO;
import com.seguridad.dao.SecRouRolesUsuariosDAO;
import com.seguridad.dao.SecUsrUsuariosDAO;
import com.seguridad.modelo.SecRolRoles;
import com.seguridad.modelo.SecRouRolesUsuarios;
import com.seguridad.modelo.SecSisSistemas;
import com.seguridad.modelo.SecUsrUsuarios;
import com.seguridad.modelo.SecUsuariosSistema;
import com.seguridad.utilidad.Email;
import com.seguridad.utilidad.Mailer;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.MessagingException;
import org.apache.commons.codec.digest.DigestUtils;

@Stateless
public class UsuarioServicio {

    @Inject
    SecUsrUsuariosDAO userDAO;

    @Inject
    private SecParParametrosDAO parDAO;

    @Inject
    private SecRolRolesDAO rolDAO;

    @Inject
    private SecRouRolesUsuariosDAO rolUsrDAO;
    
    @Inject
    private SecRouRolesUsuariosDAO rolesUsuariosDAO;

    public List<SecUsrUsuarios> listarUsuarios() {
        return userDAO.findAll();
    }
    
    public List<SecUsrUsuarios> findUsuariosBySistema(int sistemaId) {
        return userDAO.findUsuariosBySistema(sistemaId);
    }
    public List<SecUsrUsuarios> getUsuariosWhereNoHasRole(int sistemaId) {
        return userDAO.getUsuariosWhereNoHasRole(sistemaId);
    }
    
    
    public SecUsrUsuarios findUser(SecUsrUsuarios user) throws RuntimeException {
        return userDAO.findUser(user.getUsrCodigo(), user.getUsrClave());
    }
    
    public SecUsuariosSistema getSistemaOfUser(String usuarioCod, int sistemaId) throws RuntimeException{
        return userDAO.getSistemaOfUser(usuarioCod, sistemaId);
    }
    
     public String getEstadoSistemaOfUser(String usuarioCod, int sistemaId) throws RuntimeException {        
         return userDAO.getEstadoSistemaOfUser(usuarioCod, sistemaId);
     }
    
    public void removeUsuarioFromSistema(SecUsuariosSistema usis,SecSisSistemas sistema){
        rolesUsuariosDAO.deleteRolesOfUser(usis.getUsuario().getUsrCodigo(),sistema.getSisId());
        userDAO.remove(usis);
    }
    
    public void addSistemaToUser(SecUsuariosSistema usis){
        userDAO.save(usis);
    }

    public void guardar(SecUsrUsuarios user) throws RuntimeException, MessagingException {
        Mailer cartero = new Mailer();

        cartero.setSmtpHost(parDAO.findByCodigo("mail_host").getParValor());
        cartero.setSmtpPort(parDAO.findByCodigo("mail_host_port").getParValor());
        cartero.setCorreo(parDAO.findByCodigo("email").getParValor());
        cartero.setPass(parDAO.findByCodigo("password").getParValor());

        String clave = generarContrasena(10);

        user.setUsrFechaIngreso(new Date());
        user.setUsrClave(DigestUtils.sha512Hex(clave));
        userDAO.save(user);

        Email correo = new Email();
        correo.getDestinatarios().add(user.getUsrCorreo());
        correo.setMensaje("Su código de usuario es: " + user.getUsrCodigo() + " y su contraseña es: " + clave);

        cartero.enviarCorreo(correo);
    }

    public void enviarContrasenaNueva(SecUsrUsuarios user, boolean enviarEmail) throws RuntimeException, MessagingException {
      
         if (!enviarEmail) {

            Mailer cartero = new Mailer();

            cartero.setSmtpHost(parDAO.findByCodigo("mail_host").getParValor());
            cartero.setSmtpPort(parDAO.findByCodigo("mail_host_port").getParValor());
            cartero.setCorreo(parDAO.findByCodigo("email").getParValor());
            cartero.setPass(parDAO.findByCodigo("password").getParValor());

            Email correo = new Email();
            correo.getDestinatarios().add(user.getUsrCorreo());
            correo.setMensaje("Su código de usuario es: " + user.getUsrCodigo() + " y su contraseña es: " + user.getUsrClave());
            
            cartero.enviarCorreo(correo);
        }
         
        String clave = user.getUsrClave();
        user.setUsrClave(DigestUtils.sha512Hex(clave));
       

        actualizar(user);

    }

    public void actualizar(SecUsrUsuarios user) throws RuntimeException {
        userDAO.merge(user);
    }
    
    public void actualizarUsis(SecUsuariosSistema user) throws RuntimeException {
        userDAO.merge(user);
    }

    public void borrar(SecUsrUsuarios user) throws RuntimeException {
        userDAO.remove(user);
    }

    public List<SecRolRoles> listarRolesPorSistema(SecSisSistemas sistema) {
        List<SecRolRoles> listRoles = rolDAO.findBySistema(sistema);
        return listRoles;
    }

    public Set<SecRolRoles> obtenerRolesUsuario(SecUsrUsuarios user) {
        Set<SecRolRoles> rolesUsuario = new HashSet<>();

        SecUsrUsuarios usuario = userDAO.findById(user.getUsrCodigo());

        for (SecRouRolesUsuarios rou : usuario.getSecRouRolesUsuarioses()) {
            rolesUsuario.add(rou.getSecRolRoles());
        }

        return rolesUsuario;
    }

    public void agregarRolUsuario(SecUsrUsuarios user, SecSisSistemas sistema, Set<SecRolRoles> rolesUsuario) throws RuntimeException {

        SecRouRolesUsuarios rolUsr;
        Set<SecRouRolesUsuarios> setRolUsr = new HashSet<>();
        user = userDAO.findById(user.getUsrCodigo());
        user.getSecRouRolesUsuarioses().removeAll(rolUsrDAO.findByUsuarioAndSistema(user.getUsrCodigo(), sistema.getSisId()));

        for (SecRolRoles rols : rolesUsuario) {
            rolUsr = new SecRouRolesUsuarios();
            rolUsr.setSecRolRoles(rols);
            rolUsr.setSecUsrUsuarios(user);
            setRolUsr.add(rolUsr);
        }

        user.getSecRouRolesUsuarioses().addAll(setRolUsr);

        userDAO.merge(user);

    }

    private String generarContrasena(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }
}
