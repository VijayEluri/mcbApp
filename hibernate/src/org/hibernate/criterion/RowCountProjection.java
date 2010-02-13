//$Id: RowCountProjection.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.criterion;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.type.Type;

/**
 * A row count
 * @author Gavin King
 */
public class RowCountProjection extends SimpleProjection {

	protected RowCountProjection() {}

	public String toString() {
		return "count(*)";
	}

	public Type[] getTypes(Criteria criteria, CriteriaQuery criteriaQuery) 
	throws HibernateException {
		return new Type[] { Hibernate.INTEGER };
	}

	public String toSqlString(Criteria criteria, int position, CriteriaQuery criteriaQuery) 
	throws HibernateException {
		return new StringBuffer()
			.append("count(*) as y")
			.append(position)
			.append('_')
			.toString();
	}

}
