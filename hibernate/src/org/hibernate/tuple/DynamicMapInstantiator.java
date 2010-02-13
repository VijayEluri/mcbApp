//$Id: DynamicMapInstantiator.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.tuple;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.hibernate.mapping.PersistentClass;


public class DynamicMapInstantiator implements Instantiator {
	public static final String KEY = "$type$";

	private String entityName;
	private Set isInstanceEntityNames = new HashSet();

	public DynamicMapInstantiator() {
		this.entityName = null;
	}

	public DynamicMapInstantiator(PersistentClass mappingInfo) {
		this.entityName = mappingInfo.getEntityName();
		isInstanceEntityNames.add( entityName );
		if ( mappingInfo.hasSubclasses() ) {
			Iterator itr = mappingInfo.getSubclassClosureIterator();
			while ( itr.hasNext() ) {
				final PersistentClass subclassInfo = ( PersistentClass ) itr.next();
				isInstanceEntityNames.add( subclassInfo.getEntityName() );
			}
		}
	}

	public final Object instantiate(Serializable id) {
		return instantiate();
	}

	public final Object instantiate() {
		Map map = generateMap();
		if ( entityName!=null ) {
			map.put( KEY, entityName );
		}
		return map;
	}

	public final boolean isInstance(Object object) {
		if ( object instanceof Map ) {
			if ( entityName == null ) {
				return true;
			}
			String type = ( String ) ( ( Map ) object ).get( KEY );
			return type == null || isInstanceEntityNames.contains( type );
		}
		else {
			return false;
		}
	}

	protected Map generateMap() {
		return new HashMap();
	}
}