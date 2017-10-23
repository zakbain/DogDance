package emotions;

import java.util.ArrayList;
import java.util.List;

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

	private List<Emotion> emotions;

	/**
	 * Default constructor for the pet heart.
	 */
	public PetHeart(String logFileName) {
		this.happiness = new Emotion("Happiness");
		this.certainty = new Emotion("Certainty");

		emotions = new ArrayList<Emotion>();
		emotions.add(this.happiness);
		emotions.add(this.certainty);
	}

	@Override
	public Signal stateDescription() {
		return new Signal(SignalType.STATUS, "Fucked");
	}

	@Override
	public void processThought(Thought thought) {
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
	}

	/**
	 * Access happiness
	 *
	 * @return Happiness
	 */
	public List<Emotion> getEmotions() {
		return emotions;
	}
}
