package SGP.Email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailConcrete implements MailInterface {

	@Override
	public void enviarMail(DataAcount datosCuenta, String mailDestinatario, String asunto, String mensaje) throws MessagingException {
		  //Primero ordenamos los datos del cuenta de mail del Emisor
		  String emailEmisor = datosCuenta.getDireccionMail();
	      final String usuario = datosCuenta.getUsuario();
	      final String contrasena = datosCuenta.getContrasena();
	      String host = datosCuenta.getHost();
	      
	      //Seteo las propiedades
	      Properties props = new Properties();
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", datosCuenta.getPuerto());
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.required", "true");

	      //Autenticación de la cuenta: creamos una sesión con los datos del email Emisor
	      Session session = Session.getInstance(props, new javax.mail.Authenticator(){
	            protected PasswordAuthentication getPasswordAuthentication() 
	            {
	               return new PasswordAuthentication(usuario, contrasena);
	            }
	            });
	      try { 
	      //Armamos el mensaje y lo mandamos
	         MimeMessage message= new MimeMessage(session);
	         message.setFrom(new InternetAddress(emailEmisor));
	         message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailDestinatario));
	         message.setSubject(asunto);
	         message.setText(mensaje);
	         Transport.send(message);
	      } catch (MessagingException e) {
		         System.out.println("Se produjo el siguiente error: "+e.getMessage());
		         throw e;
		      }
		}
	}
