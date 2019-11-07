package taedeEngine;

import java.util.HashMap;

public class EffectList extends HashMap<Long, Effect> {
	
	/**
	 * Adds an effect to the list.
	 * @param effect effect to be added.
	 */
	public void addEffect(Effect effect) {
		if(this.containsKey(effect.getID())) {
			this.put(effect.getID(), effect);
		}
	}
	
	/**
	 * gets an specific effect.
	 * @param effectID the ID of the desired effect
	 * @return the desired effect
	 */
	public Effect getEffect(Long effectID) {
		return this.get(effectID);
	}
}
