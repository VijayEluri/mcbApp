package mcb.mail;

import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.SwingUtilities;

import mcb.model.Adresse;
import mcb.model.Treffen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MailSender implements Runnable {

  static final Logger LOGGER = LogManager.getLogger();
  private Session session;
  protected Date jetzt = new Date();
  private SendCompleteListener listener;

  public MailSender(SendCompleteListener theListener) {
    super();
    this.listener = theListener;
  }

  private Treffen getNeuestesTreffen() {
    return this.listener.getPersistenceStore().getTreffens().getNeuestesTreffen();
  }

  protected Session getSession() {
    if (this.session == null) {
      this.session = MailSessionFactory.createSession();
    }
    return this.session;
  }

  @Override
  public void run() {
    boolean problemHappened = false;
    for (Adresse adresse : this.listener.getPersistenceStore().getAdressen().getEmailAdressen()) {
      try {
        this.send(adresse);
      } catch (Exception e) {
        MailSender.LOGGER.fatal("Problem mit Adresse \"" + adresse.getEmail() + "\"");
        MailSender.LOGGER.fatal(e.getMessage(), e);
        problemHappened = true;
      }
    }
    Runnable communicateNotAllSent = new Runnable() {

      @Override
      public void run() {
        MailSender.this.listener.messagesNotSent();
      }
    };
    Runnable communicateAllSent = new Runnable() {

      @Override
      public void run() {
        MailSender.this.listener.messagesSent();
      }
    };
    SwingUtilities.invokeLater(problemHappened ? communicateNotAllSent : communicateAllSent);
  }

  private void send(Adresse adresse) throws Exception {
    MimeMessage message = new MimeMessage(this.getSession());
    message.addRecipient(RecipientType.TO, new InternetAddress(adresse.getEmail()));
    message.addRecipient(RecipientType.BCC, new InternetAddress(MailSessionFactory.replyto));
    message.addFrom(new InternetAddress[] { new InternetAddress(MailSessionFactory.from) });
    message.setReplyTo(new InternetAddress[] { new InternetAddress(MailSessionFactory.replyto) });
    message.setSubject(this.getNeuestesTreffen().getBeschreibung());
    message.setSentDate(this.jetzt);

    Multipart multipart = new MimeMultipart();

    MimeBodyPart htmlBodyPart = new MimeBodyPart();
    htmlBodyPart.setContent(this.getNeuestesTreffen().getEmailPreviewText(adresse.getVorname()), "text/html");
    multipart.addBodyPart(htmlBodyPart);

    MimeBodyPart messageBodyPart = new MimeBodyPart();
    String file = MailSessionFactory.attachmentName;
    String fileName = "einladung.pdf";
    DataSource source = new FileDataSource(file);
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(fileName);
    multipart.addBodyPart(messageBodyPart);

    message.setContent(multipart);

    Transport.send(message);
  }
}
