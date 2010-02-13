//$Id: SecondPass.java,v 1.1 2008/01/14 09:32:46 b18146 Exp $
package org.hibernate.cfg;

import java.io.Serializable;

import org.hibernate.MappingException;

/**
 * Second pass operation
 *
 * @author Emmanuel Bernard
 */
public interface SecondPass extends Serializable {

	void doSecondPass(java.util.Map persistentClasses)
				throws MappingException;

}
