/*
	Name:		Aditya Choudhari
	Roll No.:	45009
	Assignment:	3
	
	Distributed application with CORBA program using JAVA IDL.
*/

import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;

class ReverseClient
{
    
    public static void main(String args[])
    {
        Reverse ReverseImpl=null;
        
        try
        {
            // initialize the ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            String name = "Reverse";
            ReverseImpl = ReverseHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Enter String=");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str= br.readLine();

            String tempStr= ReverseImpl.reverse_string(str);
        
            System.out.println(tempStr);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
/*
			++  OUTPUT  ++

administrator@admin:~/Downloads/$ java ReverseClient -ORBInitialPosr -ORBInitialHost localhost
Enter String=
Hello CORBA! PES Modern.
Server Send .nredoM SEP !ABROC olleH

*/
