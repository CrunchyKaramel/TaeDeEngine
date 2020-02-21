package taedeEngine;

/**
 * An Event changes the game world though the choices made to it.
 * @author Twentyone
 *
 */
public abstract class Event {
	private Event[] nextEvent; //the choices that can be made from this Event
	private Requirement[] requirement; //requirements for the choices that can be made in this event
	private String initMessage; //the initial message before the player can choose
	private String responseMessage; // the message this even returns after the useer has chosen a choice
	private boolean inHistory; //is false from the beginning, and only flips to true if this event has served its purpose
	
	/**
	 * returns the initial message of this event when it starts.
	 * @return the initial message of this event
	 */
	public String initMessage() {
		return this.initMessage;
	}
	
	/**
	 * lets the user choose a path and retuns the final version of this event's message.
	 * @param choice the choice made by the user
	 * @return the final responseMessage of this choice
	 */
	public String access(int choice) {
		if (!inHistory) {
			this.inHistory = true;
			return this.choice(choice);
		}
		return this.responseMessage;
	}
	
	/**
	 * this will influence all parts connected to this event in relation to the choice made.
	 * Should only be accessed by its own Event class.
	 * @param choice the choice taken by the user
	 * @return the final responseMessage
	 */
	abstract String choice(int choice);
}
