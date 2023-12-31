package Banking_Management_System;

import java.sql.*;

public class Conn {
	Connection c;
	Statement s;

	public Conn() {
		try {
			//here root123 in the mysql password.
			c = DriverManager.getConnection("jdbc:mysql:///Bankmanagementsystem", "root", "root123");
			s = c.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
