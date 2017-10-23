package com.blackprince.agents;

import consciousness.Thought;

/**
 * Agent that can navigate, process, and adapt to an environment while
 * interfacing with its emotions to make decisions.
 * 
 * @author Zak_b
 *
 */
public interface Agent {

	/**
	 * Process the thought in a personal way. Very open ended to allow for a
	 * wide range of reactions to thoughts. One requirement is that as the
	 * computer grows it learns new ways to process thoughts.
	 */
	public void process(Thought thought);

	public void startRandomThoughtProcess(int desiredThoughtCount);
}
