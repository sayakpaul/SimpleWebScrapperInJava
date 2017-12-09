package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DBIndexing {

	Connection con;
	PreparedStatement ps1;
	PreparedStatement ps2;
	int i;
	public void makeIndex(List<String> words) {
		try {
			// DB Connection
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sayak", "root", "");
			System.out.println("Connection was successful.");
			if(words!=null){
			for(String word:words){
				ps1 = con.prepareStatement("insert into words_scrapper(words) values (?)"); // Inserting the words to the DB
				ps1.setString(1, word);
				ps1.executeUpdate();
			}}
			ps2 = con.prepareStatement("create index words_index on words_scrapper(words)"); // Creating index on the words
			ps2.executeUpdate();
			System.out.println("Indexing successful.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
