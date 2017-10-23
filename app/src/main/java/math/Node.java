package math;

import java.util.HashMap;
import java.util.Map;

/**
 * A node inside a tree.
 * 
 * @author Zak_b
 *
 * @param <T>
 *            The type of the value stored in the node.
 */
public class Node<T> {
	/**
	 * The value stored inside the node.
	 */
	private T value;

	/**
	 * The weighted edges between this node and other nodes. The Key is the node
	 * that this node connects to and the value is the weight.
	 * 
	 */
	Map<Node<T>, Integer> edges;

	/**
	 * Default constructor.
	 */
	public Node() {
		edges = new HashMap<Node<T>, Integer>();

	}

	/**
	 * Sets the edge from this node to the specified node to have the specified
	 * weight. If the edge already exists, the old edge weight is replaced.
	 * 
	 * @param node
	 * @param weight
	 */
	public void setEdge(Node<T> node, int weight) {
		edges.put(node, weight);
	}

	/**
	 * Gives a reference to this node's edges.
	 * 
	 * @return
	 */
	public Map<Node<T>, Integer> getEdges() {
		return this.edges;
	}

	/**
	 * Sets the value stored in this node.
	 * 
	 * @param value
	 *            The new value
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Reports the value stored in this node.
	 * 
	 * @return The value
	 */
	public T getValue() {
		return this.value;
	}
}
