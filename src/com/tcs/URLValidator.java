package com.tcs;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLValidator {
	public boolean urlValidator(String url)
	{
		/*validating url*/
		try {
			new URL(url).toURI();
			return true;
		}
		catch (URISyntaxException exception) {
			return false;
		}

		catch (MalformedURLException exception) {
			return false;
		}
	}    
}
