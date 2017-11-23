package pack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {

    public static void main(String[] args) throws SQLException {

        String csvFile = "E:\\sample_data\\mallnow_Nov122017.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        Map<Date,String> finalMap = new HashMap<Date,String>();
         

        try {
        	Connection conn=ConnectionSingleton.getConnection();
        	Statement st=conn.createStatement();
        	
        	FileReader fr=new FileReader(csvFile);
        	//System.out.println("hey");
            br = new BufferedReader(fr);
            int i=1;
            
            while ((line = br.readLine())!=null) {
            	
            	if(i>4){
            		
	            	//System.out.println(line);	            	
	            	System.out.println("i value"+i);
	                //use comma as separator
            		
            		System.out.println(line);
            		if(line.length()<10){
            			break;
            		}
	                String[]  row = line.split(cvsSplitBy);
	                //System.out.println("Country [code= " + row[0] + " , name=" + row[1] + "]");
	                
	                String dateval=row[0];
	                String gasval=row[1];
	                
	                dateval=dateval.replaceAll(" CET", "");
	                dateval=dateval.replaceAll(" CEST", "");
	        		
	        		//System.out.println(dateval);
	        		
	        		try {
	        			/*Date date1=new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dateval);
	        			System.out.println(date1);
	        			String gasval=row[1];
	        			finalMap.put(date1,gasval);
	        			*/
	        			
	        			
	        			String sql="insert into Gasdata(station,Start_Date,Information) "
	        					+ "values('mallnow',to_date('"
	        					+dateval+"','DD-MM-YYYY HH24:MI'),"+gasval
	        					+ ")";
	        			
	        			System.out.println(sql);
	                   st.execute(sql);
	                   
	        			
	        			//Todo -- insert values into table
	        			//Connection conn=JdbcConnection.getConnection();
	        			//if conn is not null
	        			//conn.execute("insert ")
	        			
	        			
	        		} catch (Exception e) {
	        			e.printStackTrace();
	        		}
	                
	            	}

                i++;
                line=""; 
  
            }
            
            System.out.println("size of finalMap "+finalMap.size());
            
            
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}