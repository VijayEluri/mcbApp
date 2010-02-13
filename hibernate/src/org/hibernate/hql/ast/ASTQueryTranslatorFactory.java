//$Id: ASTQueryTranslatorFactory.java,v 1.1 2008/01/14 09:32:46 b18146 Exp $
package org.hibernate.hql.ast;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.FilterTranslator;
import org.hibernate.hql.QueryTranslator;
import org.hibernate.hql.QueryTranslatorFactory;

import java.util.Map;

/**
 * Generates translators which uses the Antlr-based parser to perform
 * the translation.
 *
 * @author Gavin King
 */
public class ASTQueryTranslatorFactory implements QueryTranslatorFactory {

	private static final Log log = LogFactory.getLog( ASTQueryTranslatorFactory.class );

	public ASTQueryTranslatorFactory() {
		log.info( "Using ASTQueryTranslatorFactory" );
	}

	/**
	 * @see QueryTranslatorFactory#createQueryTranslator
	 */
	public QueryTranslator createQueryTranslator(
			String queryIdentifier,
	        String queryString,
	        Map filters,
	        SessionFactoryImplementor factory) {
		return new QueryTranslatorImpl( queryIdentifier, queryString, filters, factory );
	}

	/**
	 * @see QueryTranslatorFactory#createFilterTranslator
	 */
	public FilterTranslator createFilterTranslator(
			String queryIdentifier,
	        String queryString,
	        Map filters,
	        SessionFactoryImplementor factory) {
		return new QueryTranslatorImpl( queryIdentifier, queryString, filters, factory );
	}

}
