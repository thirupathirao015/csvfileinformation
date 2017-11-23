package pack;
import java.sql.*;
import java.util.*;

public class ConnectionSingleton {

		static Connection con = null;
		 
		 
		private ConnectionSingleton(){
			try{
			// Load & Register JDBC Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection(){
			if(con == null ){				
				  ConnectionSingleton  obj=new ConnectionSingleton();
				  System.out.println("first time connection object is created");
				  return con;
			}else{
				System.out.println("next time connection object is created");
				return con;
			}
			
			
			 
		}	

}
