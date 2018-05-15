package SGP.Email;

import javax.mail.MessagingException;

public interface MailInterface {
	
	public void enviarMail(DataAcount datosCuenta, String mailDestinatario, String asunto, String mensaje) throws MessagingException;

}
