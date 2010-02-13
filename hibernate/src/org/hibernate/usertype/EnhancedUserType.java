//$Id: EnhancedUserType.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.usertype;

/**
 * A custom type that may function as an identifier or
 * discriminator type, or may be marshalled to and from
 * an XML document
 * 
 * @author Gavin King
 */
public interface EnhancedUserType extends UserType {
	/**
	 * Return an SQL literal representation of the value
	 */
	public String objectToSQLString(Object value);
	
	/**
	 * Return a string representation of this value, as it
	 * should appear in an XML document
	 */
	public String toXMLString(Object value);
	/**
	 * Parse a string representation of this value, as it
	 * appears in an XML document
	 */
	public Object fromXMLString(String xmlValue);
}
