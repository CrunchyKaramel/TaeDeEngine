package taedeEngine;

/**
 * This class provides a centralized place for all stats of a character.
 * @author Twentyone
 *
 */
public abstract class StatSheet {
	
	/**
	 * gets the stat using the index number of that particular stat
	 * @param index the index number of the stat
	 * @return the value of the stat
	 */
	public abstract int getStat(int index);
	
	/**
	 * gets the stat using an Enum of the same name
	 * @param stat the enum named after the stat
	 * @return the value of the stat
	 */
	public abstract int getStat(Stat stat);
}
