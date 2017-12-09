package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ranker {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	double percentage;
	public void rankIt(String word){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sayak", "root", "");
			System.out.println("Connection was successful.");
			ps = con.prepareStatement("SELECT * FROM ( SELECT words, occurrences, @rownum := @rownum + 1 AS position FROM "
					+ "( SELECT words, COUNT(*) AS occurrences FROM words_scrapper GROUP BY words ORDER BY occurrences   ) a  JOIN "
					+ "(  SELECT @rownum := 0   ) r ) b WHERE words = ?");
			ps.setString(1, word);
			rs = ps.executeQuery();
			if(rs.next()){ // Word found
				System.out.println("Word: " + word + " Occurrences: " + rs.getInt(2) + " Position: " + rs.getDouble(3));
			}
			else{
				System.out.println("Word not found.");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
}
