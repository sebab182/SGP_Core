package SGP;

import SGP.Email.Account;
import SGP.Email.MailSender;

public class MailMock implements MailSender {
	private int mailEnviados;
	private int mailNoEnviados;
	
	public MailMock() {
		this.mailEnviados=0;
		this.mailNoEnviados=0;
	}

	@Override
	public void enviarMail(Account datosCuenta, String mailDestinatario, String asunto, String mensaje) {
		if(verificarAccount(datosCuenta) || mailDestinatario.isEmpty() || !mailDestinatario.contains("@")) {
			mailNoEnviados++;
		}
		else {
			mailEnviados++;
		}
	}

	private boolean verificarAccount(Account datosCuenta) {
		if(datosCuenta==null) {
			return true;
		}
		if(datosCuenta.getUsuario().isEmpty() || datosCuenta.getContrasena().isEmpty() || datosCuenta.getHost().isEmpty() || datosCuenta.getDireccionMail().isEmpty() || datosCuenta.getHost().isEmpty()) {
			return true;
		}
		return false;
	}

	public int getMailEnviados() {
		return mailEnviados;
	}

	public int getMailNoEnviados() {
		return mailNoEnviados;
	}
}
