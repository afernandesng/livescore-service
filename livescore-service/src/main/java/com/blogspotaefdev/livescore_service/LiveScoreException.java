package com.blogspotaefdev.livescore_service;
/**
 * 
 * @author Abílio E Fernandes
 *
 */
public class LiveScoreException extends RuntimeException {
	private static final long serialVersionUID = -4247189339939036827L;

	public LiveScoreException(String message) {
		super(message);
	}
	
	public LiveScoreException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public LiveScoreException(Throwable cause) {
		super(cause);
	}
}
