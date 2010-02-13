//$Id: EvictEventListener.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.event;

import org.hibernate.HibernateException;

import java.io.Serializable;

/**
 * Defines the contract for handling of evict events generated from a session.
 *
 * @author Steve Ebersole
 */
public interface EvictEventListener extends Serializable {

    /** 
     * Handle the given evict event.
     *
     * @param event The evict event to be handled.
     * @throws HibernateException
     */
	public void onEvict(EvictEvent event) throws HibernateException;
}