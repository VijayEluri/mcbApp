//$Id: Selectable.java,v 1.1 2008/01/14 09:32:46 b18146 Exp $
package org.hibernate.mapping;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionRegistry;

public interface Selectable {
	public String getAlias(Dialect dialect);
	public String getAlias(Dialect dialect, Table table);
	public boolean isFormula();
	public String getTemplate(Dialect dialect, SQLFunctionRegistry functionRegistry);
	public String getText(Dialect dialect);
	public String getText();
}
