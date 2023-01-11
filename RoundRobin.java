import java.sql.*;
import java.util.*;
class RoundRobin{
	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter table name :");
		String tname = sc.nextLine();
		System.out.println("Enter n :");
		int n = sc.nextInt();
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-8KR21VC:1521:sqlplus","scott","finalbtech8");  	
		Statement stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from "+tname);
		
		System.out.println("\nRecordes at Disk 1:\n");
		//System.out.println("prod_id\tprod_name\tcost\tcat_id\tbrand\trating");
		for(int i=1;i<=12;i++)
		{
			
			while(rs.next() && i%n == 1) 
			{
				
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getInt(7)+" "+rs.getInt(8));

				break;
				
			}
			
		}
		
		ResultSet rs4 = stmt.executeQuery("select * from "+tname);
		System.out.println("\nRecordes at Disk 2:\n");
		//System.out.println("prod_id\tprod_name\tcost\tcat_id\tbrand\trating");
		for(int i=1;i<=12;i++)
		{   
			
			while(rs4.next() && i%n == 2) 
			{
				
				System.out.println(rs4.getInt(1)+" "+rs4.getString(2)+" "+rs4.getInt(3)+" "+rs4.getString(4)+" "+rs4.getString(5)+" "+rs4.getString(6)+" "+rs4.getInt(7)+" "+rs4.getInt(8));
				break;
			}
			
		}
		
		ResultSet rs2 = stmt.executeQuery("select * from "+tname);
		System.out.println("\nRecordes at Disk 3:\n");
		//System.out.println("prod_id\tprod_name\tcost\tcat_id\tbrand\trating");
		for(int i=1;i<=12;i++)
		{
			
			while(rs2.next() && i%n == 0) 
			{
				
				System.out.println(rs2.getInt(1)+" "+rs2.getString(2)+" "+rs2.getInt(3)+" "+rs2.getString(4)+" "+rs2.getString(5)+" "+rs2.getString(6)+" "+rs2.getInt(7)+" "+rs2.getInt(8));

				break;
			}
			
		}
		
		}
		catch(Exception e){ System.out.println(e);}
	}
	
}