package emotions;

import anatomy.Signal;
import anatomy.SignalType;
import consciousness.Thought;
import io.WritingHelper;

/**
 * The heart used by Pet Agent.
 * 
 * @author Zak_b
 *
 */
public class PetHeart implements Heart {
	private static double BASE_INCREMENT = 0.1;

	/**
	 * The degree of happiness
	 */
	private Emotion happiness;

	/**
	 * The degree of certainty
	 */
	private Emotion certainty;

	/**
	 * Helper to write logs.
	 * 
	 * @note 8-7: most likely will be removed to fix vulnerability of having
	 *       open log
	 */
	private WritingHelper logWriter;

	/**
	 * Default constructor for the pet heart.
	 */
	public PetHeart(String logFileName) {
		this.happiness = new Emotion("Happiness");
		this.certainty = new Emotion("Certainty");
		logWriter = new WritingHelper(logFileName);
	}

	@Override
	public Signal stateDescription() {
		return new Signal(SignalType.STATUS, "Fucked");
	}

	@Override
	public void processThought(Thought thought) {
		logWriter.startWriting();

		// Print heart status before thought
		logWriter.writeLine("Heart: " + thought.getDescription());
		logWriter.writeLine("\tBefore Happiness: " + this.happiness.getDegree());
		logWriter.writeLine("\tBefore Certainty: " + this.certainty.getDegree());

		// Quite hardcoded. For now part 1 is the command
		String[] descSplit = thought.getDescription().split(" ");
		String command = descSplit[0];

		if (command.equals("Pet")) {

			// Increase happiness and certainty, using BASE_INCREMENT for weighting
			double happDiff = 1.0 - this.happiness.getDegree();
			this.happiness.increaseDegree(happDiff * BASE_INCREMENT);

			double certDiff = 1.0 - this.certainty.getDegree();
			this.certainty.increaseDegree(certDiff * BASE_INCREMENT);
		} else if (command.equals("Scold")) {

			// Decrease happiness and certainty, using BASE_INCREMENT for weighting
			double happDeg = 1.0 - this.happiness.getDegree();
			this.happiness.increaseDegree(-1 * happDeg * BASE_INCREMENT);

			double certDeg = 1.0 - this.certainty.getDegree();
			this.certainty.increaseDegree(-1 * certDeg * BASE_INCREMENT);
		}

		// Print heart status after thought
		logWriter.writeLine("Heart: " + thought.getDescription());
		logWriter.writeLine("\tAfter Happiness: " + this.happiness.getDegree());
		logWriter.writeLine("\tAfter Certainty: " + this.certainty.getDegree());
		logWriter.stopWriting();
	}

	/**
	 * Access happiness
	 * @return
	 */
	private Emotion getHappiness() {
		return happiness;
	}

	/**
	 * Access certainty
	 * @return
	 */
	private Emotion getCertainty() {
		return certainty;
	}

}
