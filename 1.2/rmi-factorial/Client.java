import java.rmi.*;

public class Client 
{
	public static void main(String args[])
	{
		try 
		{
			String ServerURL = "rmi://" + args[0] + "/Server";
			ServerIntf ServerIntf =
			(ServerIntf)Naming.lookup(ServerURL);
			
			System.out.println("\n\tThe number is: " + args[1]);
			double n = Double.valueOf(args[1]).doubleValue();
			
			if(args[2].equals("Factorial"))
				System.out.println("\n\tThe Factorial of " + args[1] + " is: " + ServerIntf.factorial(n));
			else 
				System.out.println("Enter the command as :\n\t java AddClient 127.0.0.1 5 Factorial");
		}
		catch(Exception e) 
		{
			System.out.println("Exception: " + e);
		}
	}
}
