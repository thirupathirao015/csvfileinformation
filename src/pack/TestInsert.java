package pack;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn=ConnectionSingleton.getConnection();
    	Statement st=conn.createStatement();
    	
    	String sql="insert into Gasdata(station,Start_Date,Information) values('mallnow',to_date('20/10/2017 04:00','DD/MM/YYYY HH24:MI'), 35892505)";
		System.out.println(sql);
       st.execute(sql);
       
       String dateval="20/10/2017 20:00";
       String gasval="5";
       
       String sql1="insert into Gasdata(station,Start_Date,Information) "
				+ "values('mallnow',to_date('"
				+dateval+"','DD-MM-YYYY HH24:MI'),"+gasval
				+ ")";
		System.out.println(sql1);
       
       st.execute(sql1);

	}

}
