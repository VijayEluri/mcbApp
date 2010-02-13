//$Id: AssociationKey.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.engine;

import java.io.Serializable;

/**
 * Identifies a named association belonging to a particular
 * entity instance. Used to record the fact that an association
 * is null during loading.
 * 
 * @author Gavin King
 */
final class AssociationKey implements Serializable {
	private EntityKey ownerKey;
	private String propertyName;
	
	public AssociationKey(EntityKey ownerKey, String propertyName) {
		this.ownerKey = ownerKey;
		this.propertyName = propertyName;
	}
	
	public boolean equals(Object that) {
		AssociationKey key = (AssociationKey) that;
		return key.propertyName.equals(propertyName) && 
			key.ownerKey.equals(ownerKey);
	}
	
	public int hashCode() {
		return ownerKey.hashCode() + propertyName.hashCode();
	}
}