package com.tcs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class WordSeparator {
	public ArrayList<String> separateWords(String file) throws IOException {
		ArrayList<String> words = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(file)); // Reading the file
		String line;
		while( (line = br.readLine()) != null){
			String [] tokens = line.split("\\s+"); // Splits on the basis of Whitespace delimition
			for (String token : tokens) {
				token = removePunctuation(token);
				words.add(token);
			}
		}
		return words;
	}
	private static String removePunctuation(String token) {
		token = token.replaceAll("[^a-zA-Z]", "");
		return token;
	}

}

