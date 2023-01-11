import java.io.*;
import java.net.*;
public class Client2 implements Runnable
{
static Socket clientSocket = null;
static PrintStream os = null;
static DataInputStream is = null;
static BufferedReader inputLine = null;
static boolean closed = false;
public static void main(String[] args)
{
int port_number=1521;
String host="DESKTOP-8KR21VC";
try
{
clientSocket = new Socket(host, port_number);
inputLine = new BufferedReader(new InputStreamReader(System.in));


os = new PrintStream(clientSocket.getOutputStream());
is = new DataInputStream(clientSocket.getInputStream());
}
catch (Exception e)
{
System.out.println("Exception occurred : "+e.getMessage());
}
if (clientSocket != null && os != null && is != null)
{
try
{
new Thread(new Client2()).start();
while (!closed)
{
os.println(inputLine.readLine());
}
os.close();
is.close();
clientSocket.close();
}
catch (IOException e)
{
System.err.println("IOException: " + e);
}
}
} public void run()
{
String responseLine;
try
{
while ((responseLine = is.readLine()) != null)
{
System.out.println("\n"+responseLine);
if (responseLine.equalsIgnoreCase("GLOBAL_COMMIT")==true || responseLine.equalsIgnoreCase("GLOBAL_ABORT")==true )
{
break;
}
}
closed=true;
}
catch (IOException e)
{
System.err.println("IOException: " + e);
}}}