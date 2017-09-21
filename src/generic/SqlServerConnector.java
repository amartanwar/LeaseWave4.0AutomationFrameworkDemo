package generic;	
import  java.sql.Connection;			
import  java.sql.DriverManager;
import java.sql.ResultSet;
import  java.sql.SQLException;
import java.sql.Statement;	

public class  SqlServerConnector {				
    	public static void  main(String[] args) throws  ClassNotFoundException, SQLException {													
				//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
                String dbUrl ="jdbc:sqlserver://otbsqlserver;database=MAG_TotalViewQA;user=development;password=jk";
            	Connection con = DriverManager.getConnection(dbUrl);
                if (con != null) {
                    System.out.println("Connected");
                }

//				//Query to Execute		
				String query = "select top 1 *  from customer_profile;";	
              

      		//Create Statement Object		
        	   Statement stmt = con.createStatement();					
     			
        	// Execute the SQL Query. Store results in ResultSet		
         		ResultSet rs= stmt.executeQuery(query);							
         		
         	// While Loop to iterate through all data and print results		
				while (rs.next()){
			        		String AccountNumber = rs.getString(2);								        
                            String CompanyName = rs.getString(8);	
                            String CustomerId = rs.getString(1);	
                            System. out.println("CustomerId "+CustomerId);		
                            System. out.println("AccountNumber "+AccountNumber);	
                            System. out.println("CompanyName "+CompanyName);	
                    }		
//      	closing DB Connection		
      			con.close();			
		}
}