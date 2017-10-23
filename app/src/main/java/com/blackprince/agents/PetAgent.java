package com.blackprince.agents;

import java.util.Random;

import consciousness.Brain;
import consciousness.PetBrain;
import consciousness.Thought;
import emotions.Heart;
import emotions.PetHeart;
import math.Node;

// Must be given a heart and a brain. If either are missing, you have to go
// on a quest with Alice in Wonderland and it's kind of a drag.
public class PetAgent implements Agent {
	/**
	 * Controls the emotions of this pet.
	 * 
	 * @NOTE 8-7: Heart doesn't do anything ATM
	 */
	private Heart petHeart;
	/**
	 * Controls the thoughts and memory of this pet.
	 */
	private Brain petBrain;

	private Node<Thought> recentThought;

	/**
	 * Very temporary. The int is a terrible way of distinguishing what type of
	 * agent this should be.
	 * 
	 * @param i
	 */
	public PetAgent(int i, String heartLogFileName, String brainLogFileName) {
		petHeart = new PetHeart(heartLogFileName);
		petBrain = new PetBrain(brainLogFileName);
	}

	/**
	 * Process a thought that occurs to this agent.
	 * 
	 * @param thought
	 *            The thought to process
	 */
	public void process(Thought thought) {
		// Create a node with relevant connections
		Node<Thought> thoughtNode = createNode(thought);

		// Save the new thought in the brain
		petBrain.saveThought(thoughtNode);
		petHeart.processThought(thought);
	}

	/**
	 * Create a new node with the specified thought.
	 * 
	 * @param thought
	 *            The thought from which to create a node
	 * @return
	 */
	public Node<Thought> createNode(Thought thought) {
		Node<Thought> thoughtNode = new Node<Thought>();
		thoughtNode.setValue(thought);

		/**
		 * For now, pick a random weight and create an edge pointing from the
		 * recent thought to the new thought.
		 */
		Integer randomWeight = new Random().nextInt(1);

		if (recentThought != null) {
			recentThought.setEdge(thoughtNode, randomWeight);
		}

		recentThought = thoughtNode;

		return thoughtNode;
	}

	/**
	 * Agent thinks a random number of thoughts.
	 * 
	 * @param desiredThoughtCount
	 *            The desired number of thoughts
	 * 
	 */
	public void startRandomThoughtProcess(int desiredThoughtCount) {
		petBrain.startRandomThoughtProcess(this.petHeart, desiredThoughtCount);
	}
}
