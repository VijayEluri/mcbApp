//$Id: MapProxyFactory.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.proxy.map;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.proxy.map.MapLazyInitializer;
import org.hibernate.proxy.map.MapProxy;
import org.hibernate.proxy.ProxyFactory;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.type.AbstractComponentType;

/**
 * @author Gavin King
 */
public class MapProxyFactory implements ProxyFactory {

	private String entityName;

	public void postInstantiate(
		final String entityName, 
		final Class persistentClass,
		final Set interfaces, 
		final Method getIdentifierMethod,
		final Method setIdentifierMethod,
		AbstractComponentType componentIdType) 
	throws HibernateException {
		
		this.entityName = entityName;

	}

	public HibernateProxy getProxy(
		final Serializable id, 
		final SessionImplementor session)
	throws HibernateException {
		return new MapProxy( new MapLazyInitializer(entityName, id, session) );
	}

}
