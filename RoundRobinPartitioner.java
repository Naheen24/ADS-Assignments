import java.sql.*;  
import java.util.*;
class RoundRobinPartitioner{  
public static void main(String args[]){  
try{  
//step1 load the driver class  

Scanner sc=new Scanner(System.in);

Class.forName("oracle.jdbc.driver.OracleDriver"); 
String url="jdbc:oracle:thin:@DESKTOP-8KR21VC:1521:sqlplus";  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(url,"scott","finalbtech8");  
//step3 create the statement object  
Statement stmt=con.createStatement();
System.out.println("Enter Table Name:");
String tname=sc.next();
System.out.println("Enter n:");
int n=sc.nextInt();
ResultSet rs1=stmt.executeQuery("drop table D1");
ResultSet rs2=stmt.executeQuery("create table D1 as select * from "+tname+" where MOD(sr,"+n+")=1");
//System.out.println("Table D1 created.");

ResultSet rs3=stmt.executeQuery("select * from D1");
System.out.println("\nRecords at disk 1:\n");
while(rs3.next()){
System.out.println(rs3.getInt(1)+" "+rs3.getString(2)+" "+rs3.getInt(3)+" "+rs3.getString(4)+" "+rs3.getString(5)+" "+rs3.getString(6)+" "+rs3.getInt(7)+" "+rs3.getInt(8));
}

ResultSet rs11=stmt.executeQuery("drop table D2");
ResultSet rs22=stmt.executeQuery("create table D2 as select * from "+tname+" where MOD(sr,"+n+")=2");
//System.out.println("Table D2 created.");

ResultSet rs33=stmt.executeQuery("select * from D2");
System.out.println("\nRecords at disk 2:\n");
while(rs33.next()){
System.out.println(rs33.getInt(1)+" "+rs33.getString(2)+" "+rs33.getInt(3)+" "+rs33.getString(4)+" "+rs33.getString(5)+" "+rs33.getString(6)+" "+rs33.getInt(7)+" "+rs33.getInt(8));
}

ResultSet rs111=stmt.executeQuery("drop table D3");
ResultSet rs222=stmt.executeQuery("create table D3 as select * from "+tname+" where MOD(sr,"+n+")=0");
//System.out.println("Table D3 created.");

ResultSet rs333=stmt.executeQuery("select * from D3");
System.out.println("\nRecords at disk 3:\n");
while(rs333.next()){
System.out.println(rs333.getInt(1)+" "+rs333.getString(2)+" "+rs333.getInt(3)+" "+rs333.getString(4)+" "+rs333.getString(5)+" "+rs333.getString(6)+" "+rs333.getInt(7)+" "+rs333.getInt(8));
}
con.close();
}catch(Exception e)
{
	System.out.println(e);
}
}
}
