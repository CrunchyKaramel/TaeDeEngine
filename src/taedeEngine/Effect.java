package taedeEngine;

/**
 * effect that can affect a stat and/or reflects an effect that can influence a decision directly.
 * It also has an unique ID to identify it easily.
 * @author Twentyone
 *
 */
public abstract class Effect {
	private Stat stat;
	private long id;
	private int change;
	
	/**
	 * gets the stat that is being affected, if there is one, or returns the defined invalud value (NULL).
	 * @return the stat as an enum, if applicable.
	 */
	public Stat getStat() {
		return this.stat;
	}
	
	/**
	 * Returns the value of the changed stat, if applicable, or 0 if no stat is being affected.
	 * @return the value change of the affected stat, if applicable, or otherwise 0.
	 */
	public int getChange() {
		return this.change;
	}
	
	/**
	 * returns the unique ID of that effect.
	 * @return the unique ID of that effect as long.
	 */
	public long getID() {
		return this.id;
	}
}
