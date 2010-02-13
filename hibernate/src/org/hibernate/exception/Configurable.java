// $Id: Configurable.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.exception;

import org.hibernate.HibernateException;

import java.util.Properties;

/**
 * The Configurable interface defines the contract for SQLExceptionConverter impls that
 * want to be configured prior to usage given the currently defined Hibernate properties.
 *
 * @author Steve Ebersole
 */
public interface Configurable {
	// todo: this might really even be moved into the cfg package and used as the basis for all things which are configurable.

	/**
	 * Configure the component, using the given settings and properties.
	 *
	 * @param properties All defined startup properties.
	 * @throws HibernateException Indicates a configuration exception.
	 */
	public void configure(Properties properties) throws HibernateException;
}
