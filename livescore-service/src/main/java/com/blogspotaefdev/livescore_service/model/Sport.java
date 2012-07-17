package com.blogspotaefdev.livescore_service.model;

/**
 * Sport model
 * 
 * @author Abílio E Fernandes
 * 
 */
public enum Sport {

	SOCCER("", "Soccer"),
	
	BASKETBALL("basket", "Basketball"),
	
	TENNIS("tennis", "tennis"),
	
	CRICKET("cricket", "Cricket"),
	
	HOCKEY("hockey", "Hockey");
	
	public static final Sports SPORTS = new Sports();
	
	static {
		for(Sport sport : values()) {
			SPORTS.add(sport);
		}
	}

	private final String id;
	private final String name;

	private Sport(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
