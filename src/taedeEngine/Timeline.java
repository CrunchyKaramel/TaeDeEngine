package taedeEngine;

public class Timeline {
	private static EventList head;
	
}

class EventList {
	private EventListElement head;
	private EventList next; //TODO implement some things to control the next element
	
	EventList() {
		this.head = new EventListElement();
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