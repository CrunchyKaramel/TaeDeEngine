package taedeEngine;

public abstract class Encounter {
	private int time;
	private List<Character> characters;
	private Step head;
	private int id;
	
	public Encounter(int id, int time, List<Character> characters, Step head) {
		this.id = id;
		this.time = time;
		this.characters = characters;
		this.head = head;
	}
	
	public int time() {
		return this.time;
	}
}
