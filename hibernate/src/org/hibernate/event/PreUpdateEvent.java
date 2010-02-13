//$Id: PreUpdateEvent.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.event;

import java.io.Serializable;

import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.engine.SessionImplementor;

/**
 * Occurs before updating the datastore
 * 
 * @author Gavin King
 */
public class PreUpdateEvent {
	private Object entity;
	private EntityPersister persister;
	private Object[] state;
	private Object[] oldState;
	private Serializable id;
	private SessionImplementor source;

	public PreUpdateEvent(
			Object entity,
			Serializable id,
			Object[] state,
			Object[] oldState,
			EntityPersister persister,
			SessionImplementor source
	) {
		this.source = source;
		this.entity = entity;
		this.id = id;
		this.state = state;
		this.oldState = oldState;
		this.persister = persister;
	}

	public Object getEntity() {
		return entity;
	}
	public Serializable getId() {
		return id;
	}
	public Object[] getOldState() {
		return oldState;
	}
	public EntityPersister getPersister() {
		return persister;
	}
	public Object[] getState() {
		return state;
	}
	public SessionImplementor getSource() {
		return source;
	}
}
