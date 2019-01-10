package com.cg.insurance.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	 static Connection connection;
		 
		  public static Connection getConnection()
		    throws SQLException, IOException
		  {
		    try
		    {
		    	FileInputStream fis=new FileInputStream("Resources/db.properties");
				   Properties p=new Properties();
				   p.load(fis);
				   String driver1=p.getProperty("driver");
				   String url=p.getProperty("url");
				   String username=p.getProperty("username");
				   String password=p.getProperty("password");
		      Class.forName(driver1);
		      connection = DriverManager.getConnection(url, username, password);
		    } catch (ClassNotFoundException e) {
		      e.printStackTrace();
		    } catch (SQLException s) { s.printStackTrace();
		    }
		    return connection;
		  }
		  
	
		  public static void closeConnection()
		  {
		      if (connection != null)
		          try {
		              connection.close();
		      } catch (SQLException ex) {
		          ex.printStackTrace();
		      }
		  }
	
	

}
