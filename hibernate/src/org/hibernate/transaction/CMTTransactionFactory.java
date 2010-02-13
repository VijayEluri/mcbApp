//$Id: CMTTransactionFactory.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.transaction;

import java.util.Properties;

import org.hibernate.ConnectionReleaseMode;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.util.JTAHelper;
import org.hibernate.jdbc.JDBCContext;

import javax.transaction.SystemException;

/**
 * Factory for <tt>CMTTransaction</tt>.
 *
 * @see CMTTransaction
 * @author Gavin King
 */
public class CMTTransactionFactory implements TransactionFactory {

	public ConnectionReleaseMode getDefaultReleaseMode() {
		return ConnectionReleaseMode.AFTER_STATEMENT;
	}

	public void configure(Properties props) throws HibernateException {}

	public Transaction createTransaction(JDBCContext jdbcContext, Context transactionContext)
	throws HibernateException {
		return new CMTTransaction(jdbcContext, transactionContext);
	}

	public boolean isTransactionManagerRequired() {
		return true;
	}

	public boolean areCallbacksLocalToHibernateTransactions() {
		return false;
	}

	public boolean isTransactionInProgress(
			JDBCContext jdbcContext,
	        Context transactionContext,
	        Transaction transaction) {
		try {
			return JTAHelper.isTransactionInProgress(
					transactionContext.getFactory().getTransactionManager().getTransaction()
			);
		}
		catch( SystemException se ) {
			throw new TransactionException( "Unable to check transaction status", se );
		}

	}

}
