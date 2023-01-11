import java.util.*;
import java.sql.*;  

class SemiJoin
{  
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
try
{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-8KR21VC:1521:sqlplus","scott","finalbtech8");  
Statement stmt=con.createStatement();

ResultSet r0=stmt.executeQuery("drop table temp1");
ResultSet r = stmt.executeQuery("create table temp1 as select u.id from userRegis u,doc d where u.id = d.userid");  
ResultSet res = stmt.executeQuery("select * from temp1");
System.out.println("Step 1 Results :");
System.out.println("id"); 
while(res.next())  
System.out.println(res.getInt("id"));    

ResultSet r00=stmt.executeQuery("drop table temp2");
ResultSet r1 = stmt.executeQuery("create table temp2 as select t1.id,d.docname from temp1 t1,doc d where t1.id = d.userid");
ResultSet res1 = stmt.executeQuery("select * from temp2");
System.out.println("Step 2 Results :");
System.out.println("id\tDocName"); 
while(res1.next())  
System.out.println(res1.getInt(1)+"\t"+res1.getString(2));    

ResultSet r000=stmt.executeQuery("drop table temp3");
ResultSet r2 = stmt.executeQuery("create table temp3 as select t2.id,t2.docname,d.city,d.gender,d.docid,d.docmail,d.mnumber from temp2 t2,doc d where t2.id = d.userid");
ResultSet res2 = stmt.executeQuery("select * from temp3");
System.out.println("Step 3 Results :");
System.out.println("id\tDocName\tCity\tGender\tDocID\tDocMail\t\t\tDocMNumber"); 
while(res2.next())  
System.out.println(res2.getInt(1)+"\t"+res2.getString(2)+"\t"+res2.getString(3)+"\t"+res2.getString(4)+"\t"+res2.getInt(5)+"\t"+res2.getString(6)+"\t\t"+res2.getString(7));    
}
catch(Exception e){ System.out.println(e);}  
 
}  
}  

