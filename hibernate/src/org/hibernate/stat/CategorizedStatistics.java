//$Id: CategorizedStatistics.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.stat;

import java.io.Serializable;

/**
 * Statistics for a particular "category" (a named entity,
 * collection role, second level cache region or query).
 * 
 * @author Gavin King
 */
public class CategorizedStatistics implements Serializable {
	
	private final String categoryName;

	CategorizedStatistics(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
}
