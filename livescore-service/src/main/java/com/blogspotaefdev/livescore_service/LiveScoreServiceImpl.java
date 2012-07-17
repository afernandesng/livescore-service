package com.blogspotaefdev.livescore_service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.blogspotaefdev.livescore_service.model.Events;
import com.blogspotaefdev.livescore_service.model.Region;
import com.blogspotaefdev.livescore_service.model.Regions;
import com.blogspotaefdev.livescore_service.model.Sport;
import com.blogspotaefdev.livescore_service.model.Sports;
import com.blogspotaefdev.livescore_service.utils.DecodeUtil;
import com.blogspotaefdev.livescore_service.utils.ParseUtil;

public class LiveScoreServiceImpl implements LiveScoreService {
	private final Log log = LogFactory.getLog(LiveScoreServiceImpl.class);
	private static final String BASE_URL = "http://iphone.livescore.com/iphone";

	private final HttpClient httpClient;

	public LiveScoreServiceImpl() {
		httpClient = new DefaultHttpClient();
	}

	private String getURLContent(String url) {
		StringBuffer stringBuffer = new StringBuffer();

		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse response = httpClient.execute(httpGet);
			InputStream inputStream = response.getEntity().getContent();

			InputStreamReader reader = new InputStreamReader(inputStream,
					"UTF8");
			int ch;
			while ((ch = reader.read()) > -1) {
				stringBuffer.append((char) ch);
			}
			reader.close();
		} catch (ClientProtocolException e) {
			log.fatal(e);
		} catch (IOException e) {
			log.fatal(e);
		}
		return stringBuffer.toString();
	}

	public Sports getSports() {
		return Sport.SPORTS;
	}

	public Regions getRegions(Sport sport) {
		String url = BASE_URL.concat(sport.getId() + ".dll/menu");

		Regions regions = ParseUtil.parseMenu(getURLContent(url));

		return regions;
	}

	public Events getEvents(Sport sport) {
		return getEvents(sport, null);
	}

	public Events getEvents(Sport sport, Region region) {
		String url = BASE_URL.concat(sport.getId() + ".dll?gmt=0.0");
		if (region != null) {
			url = url.concat("&page="+region.getId());
		}
		
		System.out.println(DecodeUtil.decode(getURLContent(url)));
		return null;
	}

}
