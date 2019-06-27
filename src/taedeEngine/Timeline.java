package taedeEngine;

/**
 * Acts as the timeline of the game. This timeline is flexible and can be extended during
 * runtime. Furthermore, it only sorts events through time. Furthermore, the individual cells save the
 * difference between when the last cell is happening vs the next cell is happening. Obsolete cells will be
 * automatically deleted, so all necessary events must be used before this happens, otherwise they might
 * get lost.
 * @author Twentyone
 *
 */
public class Timeline {
	private Cell head; //the to be examined next cell in the timeline
	
	/**
	 * creates a standard timeline.
	 */
	public Timeline() {
		this.head = null;
	}
	
	/**
	 * adds a single encounter. keep in mind that the time filter is applied automatically.
	 * @param encounter the to be added encounter
	 */
	public void add(Encounter encounter) {
		int time = encounter.time();
		if (this.head == null) {
			this.head = new Cell(time, null, null);
			this.head.add(encounter);
		} else if (this.head.getTime() > time) {
			Cell newCell = new Cell(time, null, this.head);
			this.head.setPrev(newCell);
			this.head.setTime(this.head.getTime() - time);
			this.head = newCell;
		} else {
			Cell current = this.head;
			while (current.getNext().getTime() <= time) {
				current = current.getNext();
			}
			if (current.getTime() == time) {
				current.add(encounter);
			} else {
				Cell newCell = new Cell(time - current.getTime(), current, current.getNext());
				current.setNext(newCell);
				newCell.getNext().setPrev(newCell);
				newCell.add(encounter);
				newCell.getNext().setTime(newCell.getNext().getTime() - newCell.getTime());
			}
		}
	}
	
	/**
	 * returns the next encounter and will delete it from the time line at the same time.
	 * @return the next event saved in the list
	 */
	public Encounter next() {
		if (this.head == null) {
			return null;
		}
		return this.head.next();
	}
	
	/**
	 * returns the next encounter without removing it from the list.
	 * @return the next saved encounter
	 */
	public Encounter getNext() {
		if (this.head == null) {
			return null;
		}
		return this.head.getContent().get();
	}
	
	/**
	 * ticks the time forward. An obsolete cell will be automatically discarded.
	 */
	public void tick() {
		this.head.tick();
		if (this.head.getTime() < 0) {
			this.head = this.head.getNext();
			this.head.tick();
		}
	}
}

class Cell {
	private int time;
	private Cell prev;
	private Cell next;
	private SubCell content;

	Cell(int time, Cell prev, Cell next) {
		this.time = time;
		this.prev = prev;
		this.next = next;
		this.content = null;
		this.prev.setNext(this);
		this.next.setPrev(this);
	}
	
	SubCell getContent() {
		return this.content;
	}
	
	Cell getPrev() {
		return this.prev;
	}
	
	Cell getNext() {
		return this.next;
	}
	
	int getTime() {
		return this.time;
	}
	
	void add(Encounter newEncounter) {
		SubCell current = this.content;
		while (current != null && current.next != null) {
			current = current.next;
		}
		if (current == null) {
			this.content = new SubCell(newEncounter);
		} else {
			current.next = new SubCell(newEncounter);
		}
	}
	
	Encounter next() {
		Encounter out = this.content.get();
		this.content = this.content.next;
		return out;
	}
	
	void tick() {
		if (this.time > 0) {
			this.time--;
		}
	}
	
	void setPrev(Cell prev) {
		this.prev = prev;
	}
	
	void setNext(Cell next) {
		this.next = next;
	}
	
	void setTime(int time) {
		this.time = time;
	}
}

class SubCell {
	SubCell next;
	private Encounter content;
	
	SubCell(Encounter content) {
		this.content = content;
	}
	Encounter get() {
		return this.content;
	}
}