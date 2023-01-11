import java.sql.*;  
import java.util.*;
class Part{  
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
/*
int count = stmt.executeUpdate(
        "CREATE TABLE UserRegis"+"(ID int,"+" Name VARCHAR(20),"+ " Age int,"+"gender char(1),"+ "Email VARCHAR(30),"+ "Password VARCHAR(10),"+ "Height int,"+" Weight int)");
      System.out.println("Table created.");
      //stmt.close();
*/

int ch;
do{
System.out.print("\n1.Insert into the table\n2.Delete\n3.Update\n4.Display\n5.Exit:\nChoice:");
ch=sc.nextInt();
System.out.println();
switch(ch){
case 1:
Scanner sf=new Scanner(System.in);
System.out.print("Enter the User ID :");  
int x=sf.nextInt();  
sf.nextLine();
System.out.print("Enter the User Name : ");  
String y=sf.nextLine();  
System.out.print("Enter the User Age : ");  
int z=sf.nextInt();
sf.nextLine();  
System.out.print("Enter the User Gender(F/M) : ");  
String w=sf.next();  
System.out.print("Enter the User Mail : ");  
String p=sf.next();  
System.out.print("Enter the User Password: ");  
String q=sf.next();  
System.out.print("Enter the User Height : ");  
int r=sf.nextInt();  
System.out.print("Enter the User Weight : ");  
int s=sf.nextInt();  


//Statement stmt=con.createStatement();  
stmt.executeUpdate("insert into UserRegis values("+x+",'"+y+"',"+z+",'"+w+"','"+p+"','"+q+"',"+r+","+s+")");  
System.out.println("Record Successfully Inserted...");
break;

case 2:
Scanner sc1=new Scanner(System.in);
System.out.print("Enter UserID for delete:");  
int x2=sc1.nextInt();
String sql1 = "DELETE FROM UserRegis WHERE ID="+x2;
         stmt.executeUpdate(sql1);
		 
System.out.println("Record Successfully Deleted.");
break;

case 3:
Scanner sc2=new Scanner(System.in);
System.out.print("Enter the User's new name: ");  
 String y1 = sc2.next(); 
System.out.print("Enter UserID of user whose name you want to update:");  
int x1=sc2.nextInt(); 
  String sql2 = "update UserRegis set Name='" + y1+ "' where ID=" + x1;  
  int no = stmt.executeUpdate(sql2);  
  if (no > 0)  
   System.out.println(no + " Records Successfully Updated");  
  else  
   System.out.println("Invalid User record"); 
break;

case 4:
Scanner sc3=new Scanner(System.in);
System.out.print("1.Display All Records\n2:Display According to condition(Horizontal Partitioning)\n3:Display only perticular Column(Vertical Partitioning)\n4:Mixed Fragmentation\nChoice:");
int choice=sc3.nextInt();
switch(choice){
case 1:
String sql3 = "select * from UserRegis";
//System.out.println(sql1);
ResultSet rs=stmt.executeQuery(sql3);
while(rs.next()){
System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getInt(7)+" "+rs.getInt(8));
}
break;

case 2:
System.out.print("Enter Age of users according to which you want to do Horizontal fragmentation:");
int uage=sc3.nextInt();
System.out.println("\nFragment 1");
String sql4 = "select * from UserRegis Where Age>="+uage;
//System.out.println(sql1);
ResultSet rs1=stmt.executeQuery(sql4);
while(rs1.next()){
System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getInt(3)+" "+rs1.getString(4)+" "+rs1.getString(5)+" "+rs1.getString(6)+" "+rs1.getInt(7)+" "+rs1.getInt(8));
}
System.out.println("\nFragment2");
ResultSet rs22=stmt.executeQuery("select * from UserRegis where Age<"+uage);
while(rs22.next()){
System.out.println(rs22.getInt(1)+" "+rs22.getString(2)+" "+rs22.getInt(3)+" "+rs22.getString(4)+" "+rs22.getString(5)+" "+rs22.getString(6)+" "+rs22.getInt(7)+" "+rs22.getInt(8));
}
break;

case 3:
System.out.print("Enter First column name you want to display:");
String cname=sc3.next();
System.out.print("Enter second column name you want to display:");
String cname01=sc3.next();
String sql5 = "select ID,"+cname+","+cname01+" from UserRegis";
ResultSet rs2=stmt.executeQuery(sql5);
System.out.println("\nVertical Fragment :");
while(rs2.next()){
System.out.println(rs2.getInt(1)+"  "+rs2.getString(cname.toString())+"  "+rs2.getString(cname01.toString()));
}
break;

case 4:
System.out.print("Enter column name you want to display:");
String cname1=sc3.next();
System.out.print("Enter Age of user whose data you want to display:");
int uAge=sc3.nextInt();
String sql6 = "select ID,"+cname1+" from UserRegis Where Age>="+uAge;
ResultSet rs3=stmt.executeQuery(sql6);
System.out.println("\nFragment 1:");
while(rs3.next()){
System.out.println(rs3.getInt(1)+"  "+rs3.getString(cname1.toString()));
}
String sql61 = "select ID,"+cname1+" from UserRegis Where Age<"+uAge;
ResultSet rs31=stmt.executeQuery(sql61);
System.out.println("\nFragment 2:");
while(rs31.next()){
System.out.println(rs31.getInt(1)+"  "+rs31.getString(cname1.toString()));
}
break;
default:System.out.println("Wrong choice:");
}break;
case 5:
System.out.println("Program Ends!!!");
break;

default:System.out.println("Wrong Choice");
break;
}
}while(ch!=5);

con.close();  
}
catch(Exception e){ System.out.println(e);}  
}
}
