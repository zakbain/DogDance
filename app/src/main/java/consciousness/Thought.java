package consciousness;

/**
 * Anything an agent can thought. This is deliberately left open ended as the
 * goal of the AI is to be able to thought as much as possible.
 * 
 * @author Zak_b
 *
 */
public class Thought {
	/**
	 * Description of thought
	 */
	private String description;

	/**
	 * Constructs a thought.
	 * 
	 * @param description
	 *            A description of the thought.
	 */
	public Thought(String description) {
		this.description = description;
	}

	/**
	 * Report the description.
	 * 
	 * @return the description of this thought.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description to specified value.
	 * 
	 * @param description
	 *            The new description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
