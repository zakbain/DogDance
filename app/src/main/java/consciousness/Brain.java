package consciousness;

import anatomy.BodyPart;
import emotions.Heart;
import math.Node;

/**
 * Responsible for controlling the memory and analysis of thoughts. The
 * combination of @allThoughts and @popularThoughts represents the memory.
 * 
 * @author Zak_b
 *
 */
public interface Brain extends BodyPart {
	/**
	 * Think about an thought. Interact with the heart to guide our thinking.
	 * Log thoughts into the specified log.
	 * 
	 * @param startThought
	 *            The thought to start the thought process.
	 * @param heart
	 *            The heart used to guide our thinking.
	 * @param desiredThoughtCount
	 *            The number of thoughts to think.
	 * @param logFileName
	 *            The log for recording the thoughts.
	 */
	public void startThoughtProcess(Node<Thought> startThought, Heart heart, int desiredThoughtCount);

	/**
	 * Save the thought in memory.
	 * 
	 * @param thought
	 *            The thought to save
	 */
	public void saveThought(Node<Thought> thought);

	/**
	 * Start a random thought process from one of the popular thoughts.
	 * 
	 * @NOTE 8-7: For testing purposes. Will most likely be deleted
	 */
	public void startRandomThoughtProcess(Heart heart, int desiredThoughtCount);
}
