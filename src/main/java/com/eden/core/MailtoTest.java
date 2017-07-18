package com.eden.core;

import java.awt.Desktop;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Arrays;

public class MailtoTest {

	public static void main(String[] args) throws IOException, URISyntaxException {
		  String uriStr = String.format("mailto:%s?subject=%s&body=%s",
		            join(",", Arrays.asList("john@example.com", "jane@example.com")), // use semicolon ";" for Outlook!
		            urlEncode("Hello!"),
		            urlEncode("This is\nan automatically sent email!\n "
		            		+ "Meteorologists generally define four seasons in many climatic areas: spring, summer, autumn (fall) and winter. These are demarcated by the values of their average temperatures on a monthly basis, with each season lasting three months. The three warmest months are by definition summer, the three coldest months are winter and the intervening gaps are spring and autumn. Spring, when defined in this manner, can start on different dates in different regions In some cultures in the Northern Hemisphere (e.g. Germany), the astronomical Vernal "
		            		+ "equinox (varying between 19 and 21 March) is taken to mark the first day of spring, and the Summer solstice (around 21 June) is taken as the first day of summer. In Persian culture the first day of spring is the first day of the first month (called Farvardin) "
		            		+ "which begins on 20 or 21 March. In other traditions, the equinox is taken as mid-spring The beginning of spring is not always determined by fixed calendar dates."
		            		+ " The phenological or ecological definition of spring relates to biological indicators, such as the blossoming of a range of plant species, the activities of animals, and the special smell of soil that has reached the temperature for micro flora to"
		            		+ " flourish. These indicators, along with the beginning of spring, vary according to the local climate and according to "
		            		+ "the specific weather of a particular year. Most ecologists divide the year into six seasons that have no fixed dates. In addition "
		            		+ "the specific weather of a particular year. Most ecologists divide the year into six seasons that have no fixed dates. In addition "
		            		+ "the specific weather of a particular year. Most ecologists divide the year into six seasons that have no fixed dates. In addition "
		            		+ "the specific weather of a particular year. Most ecologists divide the year into six seasons that have no fixed dates. In addition "
		            		+ "the specific weather of a particular year. Most ecologists divide the year into six seasons that have no fixed dates. In addition "
		            		+ "the specific weather of a particular year. Most ecologists divide the year into six seasons that have no fixed dates. In addition "
		            		+ "to spring, ecological reckoningss"));
		    Desktop.getDesktop().browse(new URI(uriStr));

	}

	public static final String join(String sep, Iterable<?> objs) {
	    StringBuilder sb = new StringBuilder();
	    for(Object obj : objs) {
	        if (sb.length() > 0) sb.append(sep);
	        sb.append(obj);
	    }
	    return sb.toString();
	}
	
	private static final String urlEncode(String str) {
	    try {
	        return URLEncoder.encode(str, "UTF-8").replace("+", "%20");
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException(e);
	    }
	}
}
