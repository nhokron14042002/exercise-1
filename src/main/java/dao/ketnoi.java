package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class ketnoi {
public Connection cn;
	public void ketnoi()
	{
		try {
			Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			
			String st="jdbc:sqlserver://VANHIEU:1433;databaseName=QUANLIAOQUAN;user=sa;password=0387002171";
			cn = DriverManager.getConnection(st);
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ketnoi kn = new ketnoi();
		kn.ketnoi();
	}

}
