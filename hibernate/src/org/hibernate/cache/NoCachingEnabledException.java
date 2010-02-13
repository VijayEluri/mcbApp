// $Id: NoCachingEnabledException.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.cache;

import org.hibernate.cfg.Environment;

/**
 * Implementation of NoCachingEnabledException.
 *
 * @author Steve Ebersole
 */
public class NoCachingEnabledException extends CacheException {
	private static final String MSG =
	        "Second-level cache is not enabled for usage [" +
	        Environment.USE_SECOND_LEVEL_CACHE +
	        " | " + Environment.USE_QUERY_CACHE + "]";

	public NoCachingEnabledException() {
		super( MSG );
	}
}
