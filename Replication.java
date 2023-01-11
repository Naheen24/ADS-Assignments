import java.sql.*;
import java.util.*;
class Replication{
public static void main(String args[]){
Scanner sc= new Scanner(System.in);

try{
Class.forName("oracle.jdbc.OracleDriver");

String url="jdbc:oracle:thin:@DESKTOP-8KR21VC:1521:sqlplus";
Connection con=DriverManager.getConnection(url,"scott","finalbtech8");


 /*String url1="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};  
              Connection con=DriverManager.getConnection(url1, "finalbtech32", "finalbtech32");
*/

Statement  stmt=con.createStatement();
Statement  stmt1=con.createStatement();
Statement  stmt2=con.createStatement();
ResultSet rs=stmt.executeQuery("create table Replicat1 as select * FROM UserRegis");
ResultSet rs1=stmt1.executeQuery("select * from  Replicat1");
ResultSet rs0=stmt2.executeQuery("select * from UserRegis");
System.out.println("UserRegis Table:");
while(rs0.next())
{
System.out.println(rs0.getInt(1)+" "+rs0.getString(2)+" "+rs0.getInt(3)+" "+rs0.getString(4)+" "+rs0.getString(5)+" "+rs0.getString(6)+" "+rs0.getInt(7)+" "+rs0.getInt(8));
}
System.out.println("\n\nReplication UserRegis Table:");
while(rs1.next())
{
System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getInt(3)+" "+rs1.getString(4)+" "+rs1.getString(5)+" "+rs1.getString(6)+" "+rs1.getInt(7)+" "+rs1.getInt(8));
}
con.close();
}catch(Exception e){System.out.println(e);
}
}
}
