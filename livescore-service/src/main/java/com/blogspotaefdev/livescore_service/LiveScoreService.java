package com.blogspotaefdev.livescore_service;

import com.blogspotaefdev.livescore_service.model.Events;
import com.blogspotaefdev.livescore_service.model.Region;
import com.blogspotaefdev.livescore_service.model.Regions;
import com.blogspotaefdev.livescore_service.model.Sport;
import com.blogspotaefdev.livescore_service.model.Sports;

public interface LiveScoreService {

	Sports getSports();
	
	Regions getRegions(Sport sport);
	
	Events getEvents(Sport sport);
	
	Events getEvents(Sport sport, Region region);
}
