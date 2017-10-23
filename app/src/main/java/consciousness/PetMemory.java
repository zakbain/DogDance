package consciousness;

/**
 * An memory unique to pets.
 * 
 * 8/5/17 - Ultimately, this class might be useless. I'd like thought to be a
 * very simple class with the complexity lying in how the brain and heart deal
 * with the thought.
 * 
 * @author Zak_b
 *
 */
public class PetMemory extends Memory {
	public PetMemoryType type;

	/**
	 * Construct PetMemory by specifying the description, approximate time, and
	 * the type of the pet thought.
	 * 
	 * @param description
	 *            Description of the memory
	 * @param approximateTime
	 *            Approximate time of memory
	 * @param type
	 *            Type of memory
	 */
	public PetMemory(String description, ApproximateDate approximateTime, PetMemoryType type) {
		super(description, approximateTime);

		this.type = type;
	}

}
