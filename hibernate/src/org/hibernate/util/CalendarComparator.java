//$Id: CalendarComparator.java,v 1.1 2008/01/14 09:32:45 b18146 Exp $
package org.hibernate.util;

import java.util.Calendar;
import java.util.Comparator;

/**
 * @author Gavin King
 */
public class CalendarComparator implements Comparator {

	public int compare(Object x, Object y) {
		Calendar xcal = (Calendar) x;
		Calendar ycal = (Calendar) y;
		if ( xcal.before(ycal) ) return -1;
		if ( xcal.after(ycal) ) return 1;
		return 0;
	}
	
	public static final Comparator INSTANCE = new CalendarComparator();

}
