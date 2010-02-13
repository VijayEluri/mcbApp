//$Id: PostLoadEvent.java,v 1.1 2008/01/14 09:32:44 b18146 Exp $
package org.hibernate.event;

import java.io.Serializable;

import org.hibernate.persister.entity.EntityPersister;

/**
 * Occurs after an an entity instance is fully loaded.
 *
 * @author <a href="mailto:kabir.khan@jboss.org">Kabir Khan</a>, Gavin King
 */
public class PostLoadEvent extends AbstractEvent {
	private Object entity;
	private Serializable id;
	private EntityPersister persister;

	public PostLoadEvent(EventSource session) {
		super(session);
	}

	public Object getEntity() {
		return entity;
	}
	
	public EntityPersister getPersister() {
		return persister;
	}
	
	public Serializable getId() {
		return id;
	}

	public PostLoadEvent setEntity(Object entity) {
		this.entity = entity;
		return this;
	}
	
	public PostLoadEvent setId(Serializable id) {
		this.id = id;
		return this;
	}

	public PostLoadEvent setPersister(EntityPersister persister) {
		this.persister = persister;
		return this;
	}
	
}
