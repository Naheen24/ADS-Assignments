import java.sql.*;  
import java.util.*;
class IndependentParal{  
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
ResultSet r1=stmt.executeQuery("drop table temp1");
ResultSet r = stmt.executeQuery("create table temp1 as select u.id,u.name,u.age,u.gender,u.email,u.password,u.height,u.weight,d.docid,d.docname,d.city,d.docmail,d.mnumber from userRegis u,doc d where u.id = d.userid");
ResultSet res = stmt.executeQuery("select * from temp1");
System.out.println("\n\t\t\t\t\t\t\t***temp1:Userregis|><|Doc***");
System.out.println("\nUserId  UserName  UserAge  UserGender  Email  Password  Height  Weight  DocID  DocName  DocCity   DocMail  DocNumber\n");
while(res.next()){
System.out.println(res.getInt("id")+"      "+res.getString("NAME")+"     "+res.getInt("Age")+"    "+res.getString("gender")+"    "+res.getString("Email")+"    "+res.getString("Password")+"    "+res.getInt("Height")+"    "+res.getInt("Weight")+"    "+res.getInt("docid")+"    "+res.getString("docname")+"    "+res.getString("City")+"    "+res.getString("Docmail")+"    "+res.getString("MNumber"));  
}
ResultSet r2=stmt.executeQuery("drop table temp2");
ResultSet rr = stmt.executeQuery("create table temp2 as select b.userid,b.systolic,b.diastolic,v.hr,v.rr,v.spo2 from bp b,rvitals v where b.userid = v.userid");
ResultSet res1 = stmt.executeQuery("select * from temp2");
System.out.println("\n\n\t\t\t\t\t\t\t***temp2:BP|><|RVitals***");
System.out.println("\nUserId  Systolic   Diastolic   HR   RR   spo2\n");
while(res1.next()){
System.out.println(res1.getInt("userid")+"\t  "+res1.getInt("systolic")+"\t      "+res1.getInt("diastolic")+"       "+res1.getInt("hr")+"   "+res1.getInt("rr")+"    "+res1.getInt("spo2"));  
}

ResultSet r3=stmt.executeQuery("drop table out");
ResultSet rrr = stmt.executeQuery("create table out as select t1.id,t1.name,t1.age,t1.gender,t1.email,t1.password,t1.height,t1.weight,t1.docid,t1.docname,t1.city,t1.docmail,t1.mnumber,t2.systolic,t2.diastolic,t2.hr,t2.rr,t2.spo2 from temp1 t1,temp2 t2 where t1.id = t2.userid");
ResultSet res11 = stmt.executeQuery("select * from out");
System.out.println("\n\n\t\t\t\t\t\t\t***Final Output:temp1|><|temp2***");
System.out.println("\nUserId  UserName  UserAge  UserGender    Email    Password  Height  Weight  DocID  DocName  DocCity   DocMail     DocNumber   Systolic   Diastolic   HR   RR   spo2\n");
while(res11.next()){
System.out.println(res11.getInt("id")+"      "+res11.getString("NAME")+"     "+res11.getInt("Age")+"        "+res11.getString("gender")+" "+res11.getString("Email")+" "+res11.getString("Password")+" "+res11.getInt("Height")+"  "+res11.getInt("Weight")+"    "+res11.getInt("docid")+"    "+res11.getString("docname")+"    "+res11.getString("City")+"    "+res11.getString("Docmail")+"    "+res11.getString("MNumber")+"     "+res11.getInt("systolic")+"        "+res11.getInt("diastolic")+"\t      "+res11.getInt("hr")+"   "+res11.getInt("rr")+"  "+res11.getInt("spo2"));  
}
}
catch(Exception e){ System.out.println(e);}  
}
}