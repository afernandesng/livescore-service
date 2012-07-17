package com.blogspotaefdev.livescore_service;

import com.blogspotaefdev.livescore_service.model.Sport;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LiveScoreService service = new LiveScoreServiceImpl();
        service.getEvents(Sport.SOCCER);
    }
}
