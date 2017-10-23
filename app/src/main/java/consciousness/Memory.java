package consciousness;

public class Memory extends Thought {
	/**
	 * When the thought happened
	 */
	private ApproximateDate approximateTime;

	/**
	 * Constructs this memory with a specified description and approximate time.
	 * 
	 * @param description
	 *            The specified description of the memory.
	 * @param approximateTime
	 *            The specified approximate time the memory occurred.
	 * 
	 */
	public Memory(String description, ApproximateDate approximateTime) {
		super(description);

		this.approximateTime = approximateTime;
	}

	/**
	 * Sets the approximate time.
	 * 
	 * @param approximateTime
	 */
	public void setApproximateTime(ApproximateDate approximateTime) {
		this.approximateTime = approximateTime;
	}

	/**
	 * Reports the approximate time.
	 * 
	 * @return the time.
	 */
	public ApproximateDate getApproximateTime() {
		return approximateTime;
	}
}
