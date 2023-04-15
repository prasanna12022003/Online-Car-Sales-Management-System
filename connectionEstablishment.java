package project;
//import java.util.*;
import java.sql.*;
public class Connection_Establishment {
	static Connection con=null;
	static Statement st;
	void connect() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		st=con.createStatement();
	}
}