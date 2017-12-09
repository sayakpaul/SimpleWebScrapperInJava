package com.tcs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBIndexingTester {
	private static final Logger logger = LoggerFactory.getLogger(DBIndexingTester.class);
	public static void main(String[] args) {
		logger.info("Starting indexing.");
		WordSeparator ws = new WordSeparator();
		DBIndexing dbIndexing = new DBIndexing();
		ArrayList<String> words = new ArrayList<String>();
		String file = "C:\\Users\\1336828\\Desktop\\Sayak.txt"; // The file in which the parsed contents were stored
		try {
			logger.info("Starting the word separation.");
			words = ws.separateWords(file); // For separating the words from the contents
			dbIndexing.makeIndex(words); // For storing and creating DB Index
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}