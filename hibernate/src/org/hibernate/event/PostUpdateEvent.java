//$Id: PostUpdateEvent.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.event;

import java.io.Serializable;

import org.hibernate.persister.entity.EntityPersister;

/**
 * Occurs after the datastore is updated
 * 
 * @author Gavin King
 */
public class PostUpdateEvent extends AbstractEvent {
	private Object entity;
	private EntityPersister persister;
	private Object[] state;
	private Object[] oldState;
	private Serializable id;
	
	public PostUpdateEvent(
			Object entity, 
			Serializable id,
			Object[] state,
			Object[] oldState,
			EntityPersister persister,
			EventSource source
	) {
		super(source);
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
}
