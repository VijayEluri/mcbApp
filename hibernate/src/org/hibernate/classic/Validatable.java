//$Id: Validatable.java,v 1.1 2008/01/14 09:32:46 b18146 Exp $
package org.hibernate.classic;


/**
 * Implemented by persistent classes with invariants that must
 * be checked before inserting into or updating the database.
 *
 * @author Gavin King
 */
public interface Validatable {
	/**
	 * Validate the state of the object before persisting it.
	 * If a violation occurs, throw a <tt>ValidationFailure</tt>.
	 * This method must not change the state of the object by
	 * side-effect.
	 * @throws ValidationFailure if an invariant is violated
	 */
	public void validate() throws ValidationFailure;
}






