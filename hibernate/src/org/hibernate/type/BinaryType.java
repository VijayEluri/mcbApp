//$Id: BinaryType.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.type;

/**
 * <tt>binary</tt>: A type that maps an SQL VARBINARY to a Java byte[].
 * @author Gavin King
 */
public class BinaryType extends AbstractBynaryType {

	protected Object toExternalFormat(byte[] bytes) {
		return bytes;
	}

	protected byte[] toInternalFormat(Object bytes) {
		return (byte[]) bytes;
	}

	public Class getReturnedClass() {
		return byte[].class;
	}

	public String getName() { return "binary"; }

}
