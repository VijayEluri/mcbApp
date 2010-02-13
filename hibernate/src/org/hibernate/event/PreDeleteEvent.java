//$Id: PreDeleteEvent.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.event;

import java.io.Serializable;

import org.hibernate.persister.entity.EntityPersister;

/**
 * Occurs before deleting an item from the datastore
 * 
 * @author Gavin King
 */
public class PreDeleteEvent {
	private Object entity;
	private EntityPersister persister;
	private Serializable id;
	private Object[] deletedState;
	
	public Object getEntity() {
		return entity;
	}
	public Serializable getId() {
		return id;
	}
	public EntityPersister getPersister() {
		return persister;
	}
	public Object[] getDeletedState() {
		return deletedState;
	}
	
	public PreDeleteEvent(
			Object entity, 
			Serializable id,
			Object[] deletedState,
			EntityPersister persister
	) {
		this.entity = entity;
		this.persister = persister;
		this.id = id;
		this.deletedState = deletedState;
	}

}
