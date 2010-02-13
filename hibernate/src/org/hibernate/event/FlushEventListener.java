//$Id: FlushEventListener.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.event;

import org.hibernate.HibernateException;

import java.io.Serializable;

/**
 * Defines the contract for handling of session flush events.
 *
 * @author Steve Ebersole
 */
public interface FlushEventListener extends Serializable {

    /** Handle the given flush event.
     *
     * @param event The flush event to be handled.
     * @throws HibernateException
     */
	public void onFlush(FlushEvent event) throws HibernateException;
}
