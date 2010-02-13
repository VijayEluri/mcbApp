//$Id: StaleStateException.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate;

/**
 * Thrown when a version number or timestamp check failed, indicating that the
 * <tt>Session</tt> contained stale data (when using long transactions
 * with versioning). Also occurs if we try delete or update a row that does
 * not exist.<br>
 * <br>
 * Note that this exception often indicates that the user failed to specify the
 * correct <tt>unsaved-value</tt> strategy for a class!
 *
 * @see StaleObjectStateException
 * @author Gavin King
 */
public class StaleStateException extends HibernateException {

	public StaleStateException(String s) {
		super(s);
	}
}
