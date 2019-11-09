package taedeEngine;

/**
 * represents a character, both playable and non-playable.
 * @author Twentyone
 *
 */
public abstract class Character {
	
	private long id;
	private ItemList inventory;
	private EffectList effects;
	private Location currentLocation;
	
	/**
	 * returns the character's unique ID
	 * @return the character's ID as long
	 */
	public long getID() {
		return this.id;
	}

	public Location getLocation() {
		return this.currentLocation;
	}
	
	public void act(int choice) {
		this.currentLocation.getEvent().act(choice);
	}
}
