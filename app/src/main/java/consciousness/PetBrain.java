package consciousness;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import emotions.Heart;
import io.WritingHelper;
import math.Node;

public class PetBrain implements Brain {
	/**
	 * A queue with every single thought ever thoughtd by this brain.
	 */
	private Queue<Node<Thought>> allThoughts;

	/**
	 * A list of thoughts the brain frequents.
	 */
	private List<Node<Thought>> popularThoughts;

	/**
	 * Helper to write logs.
	 * 
	 * @note 8-7: most likely will be removed to fix vulnerability of having
	 *       open log
	 */
	private WritingHelper logWriter;

	public PetBrain(String logFileName) {
		// Initialize member variables
		allThoughts = new LinkedList<Node<Thought>>();
		popularThoughts = new ArrayList<Node<Thought>>();
		logWriter = new WritingHelper(logFileName);
	}

	@Override
	public void startThoughtProcess(Node<Thought> startThought, Heart heart, int desiredThoughtCount) {
		logWriter.startWriting();

		// Log the thought we started thinking about
		logWriter.writeLine("NEW THOUGHT PROCESS: " + startThought.getValue().getDescription());

		// Remember current thought for traversing below
		Node<Thought> currentThought = startThought;

		// Number of thoughts we still have to think
		int remainingThoughtCount = desiredThoughtCount;
		while (remainingThoughtCount > 0) {
			// Find a related thought
			currentThought = findRandomConnectedThought(currentThought);

			if (currentThought == null) {
				// If we found no connected thoughts, end the thought process
				remainingThoughtCount = 0;
			} else {
				// If we found a connected thought, log it and continue
				logWriter.write("\t" + currentThought.getValue().getDescription());
				remainingThoughtCount--;
			}
		}

		logWriter.stopWriting();
	}

	/**
	 * 
	 * @param thought
	 */
	private Node<Thought> findStrongestConnectedThought(Node<Thought> thought) {
		return null;
	}

	/**
	 * Find a random thought that is connected to the given thought.
	 * 
	 * @param thought
	 *            The thought node from which to start finding connections.
	 * @return The connected thought that was discovered. NULL if no thought is
	 *         found.
	 */
	private Node<Thought> findRandomConnectedThought(Node<Thought> thought) {
		Node<Thought> randomConnectedThought = null;

		// Get all nodes connected to this thought
		Set<Node<Thought>> connectedNodes = thought.getEdges().keySet();

		// If there is at least one node, designate it is as our random thought
		Iterator<Node<Thought>> nodeIterator = connectedNodes.iterator();
		if (nodeIterator.hasNext()) {
			randomConnectedThought = nodeIterator.next();
		}

		return randomConnectedThought;
	}

	@Override
	public void saveThought(Node<Thought> thought) {
		logWriter.startWriting();

		// let em know we're in the brain
		logWriter.writeLine("Brain: " + thought.getValue().getDescription());

		// Add to all thoughts and report
		logWriter.writeLine("\t Added to all thoughts.");
		allThoughts.add(thought);

		// Always add to popular thoughts and report
		popularThoughts.add(thought);
		logWriter.writeLine("\t Added to popular thoughts.");
		logWriter.stopWriting();
	}

	@Override
	public void startRandomThoughtProcess(Heart heart, int desiredThoughtCount) {
		this.startThoughtProcess(popularThoughts.get(0), heart, desiredThoughtCount);
	}
}
