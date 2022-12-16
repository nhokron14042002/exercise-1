
package bo;


import java.sql.Connection;
import java.sql.DriverManager;




public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     
    
    public Connection cn;
	public void getConnection()
	{
		try {
			Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Xong b1");
			
			String st="jdbc:sqlserver://VANHIEU:1433;databaseName=QUANLIAOQUAN;user=sa;password=0387002171";
			cn = DriverManager.getConnection(st);
			System.out.println("Xong b3");
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	

	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBContext kn = new DBContext();
		kn.getConnection();
	}
}
 