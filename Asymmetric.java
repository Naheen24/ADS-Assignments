import java.sql.*;
import java.util.*;
class Asymmetric
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int j;
		System.out.println("Enter table name :");
		String tname = sc.nextLine();
		
		System.out.println("Enter Age range:");
		int c1 =sc.nextInt();
		int c2 =sc.nextInt();
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-8KR21VC:1521:sqlplus","scott","finalbtech8");  	
		Statement stmt=con.createStatement();
		ResultSet r = stmt.executeQuery("drop table asym1");
		ResultSet rs = stmt.executeQuery("create table asym1 as select * from "+tname+" where Age <"+c1);
		ResultSet res = stmt.executeQuery("select * from asym1");

		System.out.println("\n*** STEP1 Result - Patitioning of relation r ***\n");
		System.out.println("Records at r0:\n");
		while(res.next()) 
		{
			System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3)+" "+res.getString(4)+" "+res.getString(5)+" "+res.getString(6)+" "+res.getInt(7)+" "+res.getInt(8));	
		}
		con.commit();
		
		
		ResultSet r1=stmt.executeQuery("drop table asym2");
		ResultSet rs1=stmt.executeQuery("create table asym2 as select * from "+tname+" where Age >= "+c1+" and Age < "+c2);
		ResultSet res1=stmt.executeQuery("select * from asym2");
		System.out.println("\nRecords at r1:\n");
		while(res1.next()) 
		{
			System.out.println(res1.getInt(1)+" "+res1.getString(2)+" "+res1.getInt(3)+" "+res1.getString(4)+" "+res1.getString(5)+" "+res1.getString(6)+" "+res1.getInt(7)+" "+res1.getInt(8));	
		}
		con.commit();
		
		
		ResultSet r2=stmt.executeQuery("drop table asym3");
		ResultSet rs2=stmt.executeQuery("create table asym3 as select * from "+tname+" where Age >="+c2);
		ResultSet res2=stmt.executeQuery("select * from asym3");
		System.out.println("\nRecords at r2:\n");
		while(res2.next()) 
		{
			System.out.println(res2.getInt(1)+" "+res2.getString(2)+" "+res2.getInt(3)+" "+res2.getString(4)+" "+res2.getString(5)+" "+res2.getString(6)+" "+res2.getInt(7)+" "+res2.getInt(8));	
		}
		con.commit();
		
		ResultSet r3=stmt.executeQuery("drop table js1");
		System.out.println("\n*** STEP2 Result - Join with relation doc ***\n");
		ResultSet jr =stmt.executeQuery("create table js1 as select a.id,a.name,a.age,a.gender,a.email,a.password,a.height,a.weight,d.docid,d.docname,d.city,d.docmail,d.mnumber from asym1 a,Doc d where a.id = d.userid");
		ResultSet rj =stmt.executeQuery("select * from js1");
		System.out.println("\nRecords at r0:\n");
		while(rj.next()) 
		{
			System.out.println(rj.getInt("id")+" "+rj.getString("name")+" "+rj.getInt("age")+" "+rj.getString("gender")+" "+rj.getString("email")+" "+rj.getString("password")+" "+rj.getInt("Height")+" "+rj.getInt("weight")+" "+rj.getInt("Docid")+" "+rj.getString("docname")+" "+rj.getString("City")+" "+rj.getString("docmail")+" "+rj.getString("mnumber"));	
		}
		con.commit();
		
		ResultSet r4=stmt.executeQuery("drop table js2");
		ResultSet jr1 =stmt.executeQuery("create table js2 as select a.id,a.name,a.age,a.gender,a.email,a.password,a.height,a.weight,d.docid,d.docname,d.city,d.docmail,d.mnumber from asym2 a,Doc d where a.id = d.userid");
		ResultSet rj1 =stmt.executeQuery("select * from js2");
		System.out.println("\nRecords at r1:\n");
		while(rj1.next()) 
		{
			System.out.println(rj1.getInt("id")+" "+rj1.getString("name")+" "+rj1.getInt("age")+" "+rj1.getString("gender")+" "+rj1.getString("email")+" "+rj1.getString("password")+" "+rj1.getInt("Height")+" "+rj1.getInt("weight")+" "+rj1.getInt("Docid")+" "+rj1.getString("docname")+" "+rj1.getString("City")+" "+rj1.getString("docmail")+" "+rj1.getString("mnumber"));	
		}
		con.commit();
		
		ResultSet r5=stmt.executeQuery("drop table js3");
		ResultSet jr2 =stmt.executeQuery("create table js3 as select a.id,a.name,a.age,a.gender,a.email,a.password,a.height,a.weight,d.docid,d.docname,d.city,d.docmail,d.mnumber from asym3 a,Doc d where a.id = d.userid");
		ResultSet rj2 =stmt.executeQuery("select * from js3");
		System.out.println("\nRecords at r2:\n");
		while(rj2.next()) 
		{
			System.out.println(rj2.getInt("id")+" "+rj2.getString("name")+" "+rj2.getInt("age")+" "+rj2.getString("gender")+" "+rj2.getString("email")+" "+rj2.getString("password")+" "+rj2.getInt("Height")+" "+rj2.getInt("weight")+" "+rj2.getInt("Docid")+" "+rj2.getString("docname")+" "+rj2.getString("City")+" "+rj2.getString("docmail")+" "+rj2.getString("mnumber"));	
		}
		con.commit();

		System.out.println("\n*** Final Result - Merge both the relations ***\n");
		ResultSet r6=stmt.executeQuery("drop table atemp1");
		ResultSet jr3 =stmt.executeQuery("create table atemp1 as select * from js1 union all select * from js2 union all select * from js3");
		ResultSet rj3 =stmt.executeQuery("select * from atemp1");
		while(rj3.next()) 
		{
			System.out.println(rj3.getInt("id")+" "+rj3.getString("name")+" "+rj3.getInt("age")+" "+rj3.getString("gender")+" "+rj3.getString("email")+" "+rj3.getString("password")+" "+rj3.getInt("Height")+" "+rj3.getInt("weight")+" "+rj3.getInt("Docid")+" "+rj3.getString("docname")+" "+rj3.getString("City")+" "+rj3.getString("docmail")+" "+rj3.getString("mnumber"));	
		}
		con.commit();
		}
		catch(Exception e){ System.out.println(e);}
	}
}