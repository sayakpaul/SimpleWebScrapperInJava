package com.tcs;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RankerTest {
	private static final Logger logger = LoggerFactory.getLogger(DBIndexingTester.class);
	public static void main(String[] args) {
		Ranker r = new Ranker();
		Scanner sc = new Scanner(System.in);
		String word;
		System.out.println("Enter your serach word: ");
		word = sc.next();
		if(word!=null){
			logger.info("Starting the ranking process.");
			r.rankIt(word);
		}
		else
			System.out.println("You entered nothing.");
	}

}
