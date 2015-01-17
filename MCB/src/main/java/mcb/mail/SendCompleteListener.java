package mcb.mail;

import mcb.persistenz.PersistenceStore;

public interface SendCompleteListener {

  PersistenceStore getPersistenceStore();

  void messagesNotSent();

  void messagesSent();

}
