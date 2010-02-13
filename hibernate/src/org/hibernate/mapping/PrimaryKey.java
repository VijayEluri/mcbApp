//$Id: PrimaryKey.java,v 1.1 2008/01/14 09:32:46 b18146 Exp $
package org.hibernate.mapping;

import java.util.Iterator;

import org.hibernate.dialect.Dialect;

/**
 * A primary key constraint
 * @author Gavin King
 */
public class PrimaryKey extends Constraint {

	public String sqlConstraintString(Dialect dialect) {
		StringBuffer buf = new StringBuffer("primary key (");
		Iterator iter = getColumnIterator();
		while ( iter.hasNext() ) {
			buf.append( ( (Column) iter.next() ).getQuotedName(dialect) );
			if ( iter.hasNext() ) buf.append(", ");
		}
		return buf.append(')').toString();
	}

	public String sqlConstraintString(Dialect dialect, String constraintName, String defaultCatalog, String defaultSchema) {
		StringBuffer buf = new StringBuffer(
			dialect.getAddPrimaryKeyConstraintString(constraintName)
		).append('(');
		Iterator iter = getColumnIterator();
		while ( iter.hasNext() ) {
			buf.append( ( (Column) iter.next() ).getQuotedName(dialect) );
			if ( iter.hasNext() ) buf.append(", ");
		}
		return buf.append(')').toString();
	}
}
