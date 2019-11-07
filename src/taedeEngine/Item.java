package taedeEngine;

/**
 * this class depicts an item, something that doesn't act on its own and can be held by one person, each unique item can only exist once,
 * but there can be multiple instances of one type of item.
 * @author Twentyone
 *
 */
public interface Item {
	
	/**
	 * gets the name of the item.
	 * @return name of the item as a String.
	 */
	public String getName();
	
	/**
	 * gets the current description of the item.
	 * @return description of the item as String
	 */
	public String getDescription();
	
	/**
	 * gets the Unique ID of the Item.
	 * @return the Unique ID as long
	 */
	public long getID();
}
