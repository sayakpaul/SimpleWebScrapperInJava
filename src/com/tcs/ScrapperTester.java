package com.tcs;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ScrapperTester {

	private static final Logger logger = LoggerFactory.getLogger(ScrapperTester.class);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your URL: ");
		String url = sc.next();
		URLValidator uv = new URLValidator();
		Scrapper scrapper = new Scrapper();
		/*
		URL validation
		 */
		if(url!=null){
			if(uv.urlValidator(url)){
				logger.info("Starting URL validation.");
				System.out.println("URL: " + url + " is correct. Checking for the contents.....");
				try {
					logger.info("Scraping started.");
					scrapper.scrapeIt(url);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}}
		else{
			System.out.println("The given URL " + url + "is not valid");
		}

	}

}
