package anatomy;

public class Signal {
	private SignalType signalType;
	private String message;

	/**
	 * Constructor
	 * 
	 * @param type
	 *            Must have type so we know what to do with signal
	 * @param message
	 *            Might be an instruction to execute or a status message.
	 */
	public Signal(SignalType signalType, String message) {
		this.signalType = signalType;
		this.message = message;
	}

}
