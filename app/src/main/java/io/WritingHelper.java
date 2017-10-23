package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * A helper class for printing.
 * 
 * @author Zak_b
 *
 */
public class WritingHelper {

	/**
	 * Whether this class has written the file yet. Helps with deciding override
	 * vs append.
	 */
	private boolean hasWritten;

	/**
	 * Our esteemed writer.
	 * 
	 * Please if you have strong feelings about War and Peace contact me at
	 * zakbain@gmail.com. This book got me through a very hard time in my life.
	 */
	private BufferedWriter tolstoy;

	/**
	 * The name of the file where things will be written. This is saved so that
	 * we can open and close the writer repeatedly.
	 */
	private String filename;

	/**
	 * Default constructor
	 * 
	 * @param filename
	 *            The name of the file where WritingHelper will write.
	 */
	public WritingHelper(String filename) {
		this.filename = filename;

	}

	/**
	 * Write the given string to our known destination file.
	 * 
	 * @param str
	 *            The string to write.
	 */
	public void write(String str) {
		try {
			// Write the specified string
			tolstoy.write(str);
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Write the given string to our known destination file.
	 * 
	 * @param str
	 *            The string to write.
	 */
	public void writeLine(String str) {
		try {
			// Write the specified string then add a newline
			tolstoy.write(str);
			tolstoy.newLine();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Prepare the writing helper to be ready to write.
	 */
	public void startWriting() {
		try {
			// Create an output stream for the given file.
			OutputStream fileOut = new FileOutputStream(this.filename, hasWritten);
			if (!hasWritten) {
				hasWritten = true;
			}

			// Boy can Tolstoy write. Let's give him the tools to do it
			this.tolstoy = new BufferedWriter(new OutputStreamWriter(fileOut));
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Allow the writing helper some rest from its tireless writing.
	 */
	public void stopWriting() {
		try {
			// Put the pen down. War and Peace is long enough
			this.tolstoy.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
