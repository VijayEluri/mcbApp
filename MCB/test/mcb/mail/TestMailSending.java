package mcb.mail;

import org.junit.Ignore;
import org.junit.Test;

public class TestMailSending {

	@Test
	@Ignore
	public void testSendingWithUmlauts() throws Exception {
		String to = "leider@me.com";
		String subject = "Test";
		String body = "Body mit �ml�uten ���";
		new MailSender(null).send(to, subject, body);
	}

}
