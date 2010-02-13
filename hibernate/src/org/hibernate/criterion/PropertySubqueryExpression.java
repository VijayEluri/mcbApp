//$Id: PropertySubqueryExpression.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.criterion;

import org.hibernate.Criteria;

/**
 * A comparison between a property value in the outer query and the
 * result of a subquery
 * @author Gavin King
 */
public class PropertySubqueryExpression extends SubqueryExpression {
	private String propertyName;

	protected PropertySubqueryExpression(String propertyName, String op, String quantifier, DetachedCriteria dc) {
		super(op, quantifier, dc);
		this.propertyName = propertyName;
	}

	protected String toLeftSqlString(Criteria criteria, CriteriaQuery criteriaQuery) {
		return criteriaQuery.getColumn(criteria, propertyName);
	}

}
