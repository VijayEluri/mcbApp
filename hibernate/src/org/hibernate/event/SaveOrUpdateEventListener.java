//$Id: SaveOrUpdateEventListener.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.event;

import java.io.Serializable;

import org.hibernate.HibernateException;

/**
 * Defines the contract for handling of update events generated from a session.
 *
 * @author Steve Ebersole
 */
public interface SaveOrUpdateEventListener extends Serializable {

    /** 
     * Handle the given update event.
     *
     * @param event The update event to be handled.
     * @throws HibernateException
     */
	public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException;

}
