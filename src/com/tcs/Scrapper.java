package com.tcs;

import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*; // Only needed if scraping a local File.
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
public class Scrapper {
	public void scrapeIt(String url) throws FileNotFoundException {

		PrintWriter out = new PrintWriter("C:\\Users\\1336828\\Desktop\\Sayak.txt"); // The path of the .txt file in which the contents are to be stored
		Document doc = null;
		/**
		 * As I am behind TCS proxy firewall that is why this.
		 */
		System.setProperty("http.proxyHost", "10.18.220.65"); // set TCS proxy server
		System.setProperty("http.proxyPort", "8080");  //set proxy port
		
		try {
			doc = Jsoup.connect(url).timeout(0).get(); // timeout(0) To handle the ReadTimeOutException
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println(doc.text());
		try {
			out.println(doc.text());
			System.out.println("File written successfully. Closing it...");
		} catch (Exception e) {
			System.out.println(e);
		}
		out.flush();
		out.close();
	}
}
