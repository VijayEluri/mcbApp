//$Id: AliasToEntityMapResultTransformer.java,v 1.1 2008/01/14 09:32:46 b18146 Exp $
package org.hibernate.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gavin King
 */
public class AliasToEntityMapResultTransformer implements ResultTransformer {

	public Object transformTuple(Object[] tuple, String[] aliases) {
		Map result = new HashMap(tuple.length);
		for ( int i=0; i<tuple.length; i++ ) {
			String alias = aliases[i];
			if ( alias!=null ) {
				result.put( alias, tuple[i] );
			}
		}
		return result;
	}

	public List transformList(List collection) {
		return collection;
	}

}
