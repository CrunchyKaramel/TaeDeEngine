package taedeEngine;

public class Timeline {
	private static EventList head;
	private static int currentDay;
	
	public static void increment() {
		Timeline.currentDay++;
		if (Timeline.head.getDist() == 1) {
			Event current = Timeline.head.popEvent();
			while (current != null) {
				if (current.getLocation().getOverride() != null) {
					current.delay();
				} else {
					current.getLocation().setOverride(current);
				}
				current = Timeline.head.popEvent();
			}
		}
	}
}

class EventList {
	private EventListElement head;
	private EventList next; //TODO implement some things to control the next element
	private int distToPrev;
	
	EventList() {
		this.head = new EventListElement();
	}
	
	void decrement() {
		this.distToPrev--;
	}
	
	EventList getNext() {
		return this.next;
	}
	
	void addNext(EventList newList, int distance) {
		if (this.next.distToPrev < distance) {
			this.next.addNext(newList, distance - this.next.distToPrev);
		} else if (this.distToPrev == distance) {
			Event current = newList.popEvent();
			while (current != null) {
				this.next.addEvent(current);
				current = newList.popEvent();
			}
		} else {
			newList.setNext(this.next,this.distToPrev - distance);
			this.setNext(newList, distance);
		}
	}
	
	void setNext(EventList newList, int distance) {
		this.next = newList;
		newList.setDist(distance);
	}
	
	void setDist(int distance) {
		this.distToPrev = distance;
	}
	
	int getDist() {
		return this.distToPrev;
	}
	
	void addEvent(Event event) {
		EventListElement newHead = new EventListElement();
		newHead.set(event);
		newHead.setNext(this.head);
		this.head = newHead;
	}
	
	Event getEvent() {
		return this.head.get();
	}
	
	Event popEvent() {
		EventListElement out = this.head;
		this.head = this.head.getNext();
		return out.get();
	}
}

class EventListElement{
	private EventListElement next;
	private Event event;
	
	EventListElement() {
		this.next = null;
		this.event = null;
	}
	
	void set(Event event) {
		this.event = event;
	}
	
	void setNext(EventListElement next) {
		this.next = next;
	}
	
	Event get() {
		return this.event;
	}
	
	EventListElement getNext() {
		return this.next;
	}
}