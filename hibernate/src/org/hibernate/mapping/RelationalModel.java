//$Id: RelationalModel.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.mapping;

import org.hibernate.engine.Mapping;
import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;

/**
 * A relational object which may be created using DDL
 * @author Gavin King
 */
public interface RelationalModel {
	public String sqlCreateString(Dialect dialect, Mapping p, String defaultCatalog, String defaultSchema) throws HibernateException;
	public String sqlDropString(Dialect dialect, String defaultCatalog, String defaultSchema);
}
