package taedeEngine;

import java.util.HashMap;

/**
 * the blueprint for an event, including the blueprint for the main method,
 * which picks a choice and acts accordingly.
 * @author Twentyone
 *
 */
public abstract class Event {
	private Event next;
	
	/**
	 * returns the resulting event chosen by the number,
	 * and possibly other factors.
	 * @param choice the identification number of the choice made
	 * @return the resulting event
	 */
	public abstract Event act(int choice);
}