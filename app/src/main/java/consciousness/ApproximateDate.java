package consciousness;

import java.util.Date;

/**
 * Represents an approximation of a date. This exists so we can mimic how the
 * brain remembers an approximation of when something happened but not
 * necessarily the exact date and time.
 * 
 * Future Ideas: The precision of this variable might decay over time to save
 * space in the brain. Also, the brain might only remember how long its been
 * since an event happened.
 * 
 * 
 * @author Zak_b
 *
 */
public class ApproximateDate {
	private Date date;
	private DateAccuracy accuracy;

	/**
	 * Create an approximate date by specifying the exact date and then how
	 * close that date is to the actual date of the experience.
	 * 
	 * @param date
	 *            The exact date.
	 * @param accuracy
	 *            Describes accuracy of the exact date.
	 */
	public ApproximateDate(Date date, DateAccuracy accuracy) {
		this.setDate(date);
		this.setAccuracy(accuracy);
	}

	/**
	 * Report the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Set the date.
	 * 
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Report the accuracy.
	 * 
	 * @return the accuracy.
	 */
	public DateAccuracy getAccuracy() {
		return accuracy;
	}

	/**
	 * Set the accuracy.
	 * 
	 * @param accuracy
	 *            the accuracy to set
	 */
	public void setAccuracy(DateAccuracy accuracy) {
		this.accuracy = accuracy;
	}

}
