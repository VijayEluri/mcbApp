//$Id: DB2390Dialect.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.dialect;

/**
 * An SQL dialect for DB2/390. This class provides support for
 * DB2 Universal Database for OS/390, also known as DB2/390.
 *
 * @author Kristoffer Dyrkorn
 */
public class DB2390Dialect extends DB2Dialect {

	public boolean supportsSequences() {
		return false;
	}

	public String getIdentitySelectString() {
		return "select identity_val_local() from sysibm.sysdummy1";
	}

	public boolean supportsLimit() {
		return true;
	}

	public boolean supportsLimitOffset() {
		return false;
	}

	public String getLimitString(String sql, int offset, int limit) {
		return new StringBuffer(sql.length() + 40)
			.append(sql)
			.append(" fetch first ")
			.append(limit)
			.append(" rows only ")
			.toString();
	}

	public boolean useMaxForLimit() {
		return true;
	}

	public boolean supportsVariableLimit() {
		return false;
	}

}