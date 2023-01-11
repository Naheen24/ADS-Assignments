import java.sql.*;
import java.util.*;
class RangePartition{
	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter table name :");
		String tname=sc.nextLine();
		System.out.println("Enter Age range:");
		int c1 =sc.nextInt();
		int c2 =sc.nextInt();
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-8KR21VC:1521:sqlplus","scott","finalbtech8");  	
		Statement stmt=con.createStatement();
		ResultSet r = stmt.executeQuery("drop table rp1");
		ResultSet rs = stmt.executeQuery("create table rp1 as select * from "+tname+" where Age <"+c1);
		ResultSet res = stmt.executeQuery("select * from rp1");

		System.out.println("\n*** STEP1 Result ***\n");
		System.out.println("\nRecordes at Disk 1:\n");
		while(res.next()) 
		{
			System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3)+" "+res.getString(4)+" "+res.getString(5)+" "+res.getString(6)+" "+res.getInt(7)+" "+res.getInt(8));
		}
		con.commit();
		
		System.out.println("\nRecords at Disk 2:\n");
		ResultSet r1=stmt.executeQuery("drop table rp2");
		ResultSet rs1=stmt.executeQuery("create table rp2 as select * from "+tname+" where Age >= "+c1+" and Age < "+c2);
		ResultSet res1=stmt.executeQuery("select * from rp2");

		while(res1.next()) 
		{
			System.out.println(res1.getInt(1)+" "+res1.getString(2)+" "+res1.getInt(3)+" "+res1.getString(4)+" "+res1.getString(5)+" "+res1.getString(6)+" "+res1.getInt(7)+" "+res1.getInt(8));
		}
		con.commit();
		
		System.out.println("\nRecords at Disk 3:\n");
		ResultSet r2=stmt.executeQuery("drop table rp3");
		ResultSet rs2=stmt.executeQuery("create table rp3 as select * from "+tname+" where Age>="+c2);
		ResultSet res2=stmt.executeQuery("select * from rp3");

		while(res2.next()) 
		{
			System.out.println(res2.getInt(1)+" "+res2.getString(2)+" "+res2.getInt(3)+" "+res2.getString(4)+" "+res2.getString(5)+" "+res2.getString(6)+" "+res2.getInt(7)+" "+res2.getInt(8));
		}
		con.commit();
		
		System.out.println("\n*** STEP2 Result ***\n");
		ResultSet r3=stmt.executeQuery("drop table rps1");
		ResultSet s1 = stmt.executeQuery("create table rps1 as select * from rp1 order by Age");
		ResultSet sort1 = stmt.executeQuery("select * from rps1");
		
		System.out.println("\nRecords at Disk 1 after Sorting : \n");
		while(sort1.next()) 
		{
			System.out.println(sort1.getInt(1)+" "+sort1.getString(2)+" "+sort1.getInt(3)+" "+sort1.getString(4)+" "+sort1.getString(5)+" "+sort1.getString(6)+" "+sort1.getInt(7)+" "+sort1.getInt(8));	
		}
		con.commit();
		ResultSet r4=stmt.executeQuery("drop table rps2");
		ResultSet s2 = stmt.executeQuery("create table rps2 as select * from rp2 order by Age");
		ResultSet sort2 = stmt.executeQuery("select * from rps2");
		System.out.println("\nRecords at Disk 2 after Sorting : \n");
		while(sort2.next()) 
		{
			System.out.println(sort2.getInt(1)+" "+sort2.getString(2)+" "+sort2.getInt(3)+" "+sort2.getString(4)+" "+sort2.getString(5)+" "+sort2.getString(6)+" "+sort2.getInt(7)+" "+sort2.getInt(8));
		}
		con.commit();
		
		ResultSet r5=stmt.executeQuery("drop table rps3");
		
		ResultSet s3 = stmt.executeQuery("create table rps3 as select * from rp3 order by Age");
		ResultSet sort3 = stmt.executeQuery("select * from rps3");
		System.out.println("\nRecords at Disk 3 after Sorting :\n");
		while(sort3.next()) 
		{
			System.out.println(sort3.getInt(1)+" "+sort3.getString(2)+" "+sort3.getInt(3)+" "+sort3.getString(4)+" "+sort3.getString(5)+" "+sort3.getString(6)+" "+sort3.getInt(7)+" "+sort3.getInt(8));	
		}
		con.commit();
		ResultSet r6=stmt.executeQuery("drop table rangepart");
		ResultSet out = stmt.executeQuery("create table rangepart as select * from rps1 union all select * from rps2 union all select * from rps3");
		ResultSet out1 = stmt.executeQuery("select * from rangepart");
	System.out.println("\n***Final Result after RangePartition sort :***\n");
		
		while(out1.next()) 
		{
			System.out.println(out1.getInt(1)+" "+out1.getString(2)+" "+out1.getInt(3)+" "+out1.getString(4)+" "+out1.getString(5)+" "+out1.getString(6)+" "+out1.getInt(7)+" "+out1.getInt(8));	
		}
		con.commit();
		}
		catch(Exception e){ System.out.println(e);} 
	}
}