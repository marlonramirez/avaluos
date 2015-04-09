package org.domain.avaluosapl.session;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import org.domain.avaluosapl.entity.Usuario;
import org.domain.avaluosapl.util.FacesUtils;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

@Name("authenticator")
public class Authenticator
{
    @Logger private Log log;

    @In Identity identity;
    @In Credentials credentials;
    
    @In(create = true)
    SessionApp sessionApp;

    public boolean authenticate()
    {
        log.info("authenticating {0}", credentials.getUsername());
        //write your authentication logic here,
        //return true if the authentication was
        //successful, false otherwise
		try {
			String password = getSecurePassword(credentials.getPassword(), getSalt());
			String usuario = credentials.getUsername();
			UsuarioList usuarioList = (UsuarioList) FacesUtils.getManagedBean("usuarioList");
			Usuario user = usuarioList.access(usuario, password);
			if (user != null) {
				sessionApp.setUsuario(user);
				if (sessionApp.hasPermiso("CU01")) {
					identity.addRole(user.getPerfil().getNombre()/*"admin"*/);
		            return true;
				}
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
        return false;
    }
    
    public static String getSecurePassword(String passwordToHash, String salt){
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
     
    //Add salt
    public static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        String str = salt.toString();
        return "[B@8f07a1";
    }

}
