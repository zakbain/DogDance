package math;

/**
 * A point in an n dimensional plane.
 * 
 * @author Zak_b
 *
 */
public class Point {
	/**
	 * The number of dimensions
	 */
	private int dimensions;

	/**
	 * The coordinates specifying where the point is in the plane. The nth value
	 * in the array describes the position of the point along the nth axis.
	 * 
	 * coordinates.length must equal dimensions
	 */
	private int[] coordinates;

	/**
	 * Creates a point with the specified number of dimensions
	 * 
	 * @param dimensions
	 *            Number of dimensions
	 */
	public Point(int dimensions) {
		this.dimensions = dimensions;

		// Create an array with the correct number of dimensions
		this.coordinates = new int[dimensions];
	}

	/**
	 * Changes the point's position along the specified axis to the specified
	 * value.
	 * 
	 * @param axis
	 *            The axis which we are changing
	 * @param value
	 *            The new value along that axis
	 */
	public void setCoordinate(int axis, int value) {
		coordinates[axis] = value;
	}
}
