//$Id: StaleObjectStateException.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate;

import java.io.Serializable;

import org.hibernate.pretty.MessageHelper;

/**
 * A <tt>StaleStateException</tt> that carries information 
 * about a particular entity instance that was the source
 * of the failure.
 *
 * @author Gavin King
 */
public class StaleObjectStateException extends StaleStateException {
	private final String entityName;
	private final Serializable identifier;

	public StaleObjectStateException(String persistentClass, Serializable identifier) {
		super("Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect)");
		this.entityName = persistentClass;
		this.identifier = identifier;
	}

	public String getEntityName() {
		return entityName;
	}

	public Serializable getIdentifier() {
		return identifier;
	}

	public String getMessage() {
		return super.getMessage() + ": " +
			MessageHelper.infoString(entityName, identifier);
	}

}







