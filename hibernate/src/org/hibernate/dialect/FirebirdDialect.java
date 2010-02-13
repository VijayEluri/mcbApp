//$Id: FirebirdDialect.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.dialect;

/**
 * An SQL dialect for Firebird.
 * @author Reha CENANI
 */
public class FirebirdDialect extends InterbaseDialect {

	public String getDropSequenceString(String sequenceName) {
		return "drop generator " + sequenceName;
	}

	public String getLimitString(String sql, boolean hasOffset) {
		return new StringBuffer( sql.length()+20 )
			.append(sql)
			.insert(6, hasOffset ? " first ? skip ?" : " first ?")
			.toString();
	}

	public boolean bindLimitParametersFirst() {
		return true;
	}

	public boolean bindLimitParametersInReverseOrder() {
		return true;
	}

}