// $Id: AliasGenerator.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.hql.ast.util;

import org.hibernate.util.StringHelper;

/**
 * Generates class/table/column aliases during semantic analysis and SQL rendering.
 * <p/>
 * Its essential purpose is to keep an internal counter to ensure that the
 * generated aliases are unique.
 */
public class AliasGenerator {
	private int next = 0;

	private int nextCount() {
		return next++;
	}

	public String createName(String name) {
		return StringHelper.generateAlias( name, nextCount() );
	}
}
