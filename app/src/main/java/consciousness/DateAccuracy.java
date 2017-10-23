package consciousness;

/**
 * Describes the accuracy of a date. Larger value are more accurate so that
 * SECOND is more accurate than MONTH.
 * 
 * @Note 8-6-17: If a date is accurate to the i-th value in the enum, we assume
 *       it's accurate to all values k < i. As in, if a date is accurate to the
 *       day, it is also accurate to the month and year.
 */
public enum DateAccuracy {
	YEAR, MONTH, DAY, HOUR, SECOND
}