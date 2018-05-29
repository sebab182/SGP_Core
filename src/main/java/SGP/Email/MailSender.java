package SGP.Email;

import javax.mail.MessagingException;

public interface MailSender {
	
	public void enviarMail(Account datosCuenta, String mailDestinatario, String asunto, String mensaje) throws MessagingException;

}
