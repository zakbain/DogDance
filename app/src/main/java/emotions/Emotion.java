package emotions;

/**
 * Modeled after but not restricted to the human version of emotion as a complex
 * experience of consciousness, sensation and behavior that reflects the
 * personal significance of a thing, an event, or a state of affairs.
 * 
 * These emotions act as ranges where an agent's heart will feel anywhere from
 * none of that emotion to the maximum (where you can never hit the maximum)
 * 
 * @author Zak_b
 *
 */
public class Emotion {

	private String description;
	private double degree;

	/**
	 * Creates an emotion with a degree.
	 */
	public Emotion(String description) {
		this.description = description;
		degree = 0;
	}

	/**
	 * Change the degree
	 */
	public void increaseDegree(double increment) {
		this.degree += increment;
	}

	/**
	 * Report the degree
	 * 
	 * @return the degree.
	 */
	public double getDegree() {
		return this.degree;
	}
}
