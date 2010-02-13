//$Id: SessionStatisticsImpl.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.stat;

import java.util.Collections;
import java.util.Set;

import org.hibernate.engine.SessionImplementor;

/**
 * @author Gavin King
 */
public class SessionStatisticsImpl implements SessionStatistics {

	private final SessionImplementor session;
	
	public SessionStatisticsImpl(SessionImplementor session) {
		this.session = session;
	}

	public int getEntityCount() {
		return session.getPersistenceContext().getEntityEntries().size();
	}
	
	public int getCollectionCount() {
		return session.getPersistenceContext().getCollectionEntries().size();
	}
	
	public Set getEntityKeys() {
		return Collections.unmodifiableSet( session.getPersistenceContext().getEntitiesByKey().keySet() );
	}
	
	public Set getCollectionKeys() {
		return Collections.unmodifiableSet( session.getPersistenceContext().getCollectionsByKey().keySet() );
	}
	
	public String toString() {
		return new StringBuffer()
			.append("SessionStatistics[")
			.append("entity count=").append( getEntityCount() )
			.append("collection count=").append( getCollectionCount() )
			.append(']')
			.toString();
	}

}
