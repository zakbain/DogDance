package emotions;

import anatomy.BodyPart;
import anatomy.Signal;
import consciousness.Thought;

/**
 * Class to read and control emotions.
 * 
 * @author Zak_b
 *
 */
public interface Heart extends BodyPart {

	/**
	 * Reports how the heart is feeling in a way that may be understood by
	 * humans.
	 * 
	 * @return A human-readable version of the heart's current state
	 */
	public Signal stateDescription();

	/**
	 * Process the thought, potentially changing the heart's current state.
	 * 
	 * @param thought
	 *            The thought to process
	 */
	public void processThought(Thought thought);
}
