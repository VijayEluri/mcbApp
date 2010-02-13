//$Id: KeyValue.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.mapping;

import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.id.IdentifierGenerator;

/**
 * Represents an identifying key of a table: the value for primary key
 * of an entity, or a foreign key of a collection or join table or
 * joined subclass table.
 * @author Gavin King
 */
public interface KeyValue extends Value {
	
	public void createForeignKeyOfEntity(String entityName);
	
	public boolean isCascadeDeleteEnabled();
	
	public boolean isIdentityColumn(Dialect dialect);
	
	public String getNullValue();
	
	public boolean isUpdateable();

	public IdentifierGenerator createIdentifierGenerator(
			Dialect dialect, 
			String defaultCatalog, 
			String defaultSchema, 
			RootClass rootClass) throws MappingException;
}
