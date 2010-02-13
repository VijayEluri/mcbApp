//$Id: RefreshEventListener.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.event;

import org.hibernate.HibernateException;

import java.io.Serializable;
import java.util.Map;

/**
 * Defines the contract for handling of refresh events generated from a session.
 *
 * @author Steve Ebersole
 */
public interface RefreshEventListener extends Serializable {

    /** 
     * Handle the given refresh event.
     *
     * @param event The refresh event to be handled.
     * @throws HibernateException
     */
	public void onRefresh(RefreshEvent event) throws HibernateException;
	
	public void onRefresh(RefreshEvent event, Map refreshedAlready) throws HibernateException;

}
