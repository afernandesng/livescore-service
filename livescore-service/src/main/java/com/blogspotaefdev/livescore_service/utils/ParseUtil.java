package com.blogspotaefdev.livescore_service.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.blogspotaefdev.livescore_service.model.Region;
import com.blogspotaefdev.livescore_service.model.Regions;

public class ParseUtil {

	public static Regions parseMenu(String menu) {
		Regions regions = new Regions();
		Pattern pattern = Pattern.compile("^[\\w\\d\\-]+=[\\w\\d\\-\\(\\)\\. ]+", Pattern.MULTILINE);		
		Matcher matcher = pattern.matcher(menu);

		String[] reg;
		while(matcher.find()) {
			reg = matcher.group().split("=");
			Region region = new Region(reg[0]);
			region.setName(reg[1]);
			regions.add(region);
		}
		return regions;
	}
}
