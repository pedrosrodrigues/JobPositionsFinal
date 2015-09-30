package backingbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import util.GwMessage;

@SessionScoped
@Named
public class EmailBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public void sendEmail() {

		GwMessage email = new GwMessage();
		// email.sendEmail("pedrorodrigues.idl@gmail.com",
		// "jobsatcritical@gmail.com", "Teste email!",
		// "Este é um email de teste!");
	}

}
