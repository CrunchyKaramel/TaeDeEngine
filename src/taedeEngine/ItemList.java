package taedeEngine;

import java.util.HashMap;

/**
 * stores an amount of individual items, which can be called via their unique ID.
 * @author Twentyone
 *
 */
public class ItemList extends HashMap<Long, Item> {

	/**
	 * Defines the current version number.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Adds an item.
	 * @param item the item to be added
	 */
	public void addItem(Item item) {
		if (this.containsKey(item.getID())) {
			this.put(item.getID(), item);
		}
	}
	
	/**
	 * Searches for a general item, accepting any instance of it.
	 * @param generalItemID the ItemID with the Instance part being 0
	 * @return any item of the desired kind
	 */
	public Item getGeneralItem(Long generalItemID) {
		//TODO add structures to the Item IDs, should have one part for the general ID and one for the instance number
		//TODO implement structure
	}
	
	/**
	 * retrieves a specific item, if possible.
	 * @param ItemID the ItemID with both parts filled out.
	 * @return
	 */
	public Item getSpecificItem(Long ItemID) {
		return this.get(ItemID);
	}
}
