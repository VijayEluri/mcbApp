//$Id: BESTransactionManagerLookup.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.transaction;

/**
 * A <tt>TransactionManager</tt> lookup strategy for Borland ES.
 * @author Etienne Hardy
 */
public final class BESTransactionManagerLookup extends JNDITransactionManagerLookup {

	protected String getName() {
		return "java:pm/TransactionManager";
	}

	public String getUserTransactionName() {
		return "java:comp/UserTransaction";
	}

}