//$Id: SimpleProjection.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.criterion;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.type.Type;


/**
 * A single-column projection that may be aliased
 * @author Gavin King
 */
public abstract class SimpleProjection implements Projection {

	public Projection as(String alias) {
		return Projections.alias(this, alias);
	}

	public String[] getColumnAliases(String alias, int loc) {
		return null;
	}
	
	public Type[] getTypes(String alias, Criteria criteria, CriteriaQuery criteriaQuery) 
	throws HibernateException {
		return null;
	}

	public String[] getColumnAliases(int loc) {
		return new String[] { "y" + loc + "_" };
	}
	
	public String[] getAliases() {
		return new String[1];
	}

	public String toGroupSqlString(Criteria criteria, CriteriaQuery criteriaQuery) 
	throws HibernateException {
		throw new UnsupportedOperationException("not a grouping projection");
	}

	public boolean isGrouped() {
		return false;
	}

}