package taedeEngine;

public abstract class Location {
	private long id;
	private String name;
	private Event standard;
	private Event override;
	
	public long getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Event getStandard() {
		return this.standard;
	}
	
	public void setStandard(Event event) {
		this.standard = event;
	}
	
	public Event getOverride() {
		return this.override;
	}
	
	public void setOverride(Event event) {
		this.override = event;
	}
	
	public Event getEvent() {
		if (this.override == null) {
			return this.standard;
		}
		return this.override;
	}
	
	public Event removeOverride() {
		Event event = this.override;
		this.override = null;
		return event;
	}
}
