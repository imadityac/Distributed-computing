/*
	Name:		Aditya Choudhari
	Roll No.:	45009
	Assignment:	3
	
	Distributed application with CORBA program using JAVA IDL.
*/

import ReverseModule.Reverse;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

class ReverseServer
{
    public static void main(String[] args)
    {
        try
        {
            // initialize the ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

            // initialize the BOA/POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            // creating the calculator object
            ReverseImpl rvr = new ReverseImpl();
            
            // get the object reference from the servant class
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(rvr);

            System.out.println("Step1");
            Reverse h_ref = ReverseModule.ReverseHelper.narrow(ref);
            System.out.println("Step2");

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            System.out.println("Step3");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            System.out.println("Step4");

            String name = "Reverse";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path,h_ref);

            System.out.println("Reverse Server reading and waiting....");
            orb.run();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
/*
			++  OUTPUT  ++
			
administrator@admin:~/Downloads$ idlj -fall ReverseModule.idl

administrator@admin:~/Downloads$ javac *.java ReverseModule/*.java
Note: ReverseModule/ReversePOA.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

administrator@admin:~/Downloads$ orbd -ORDBInitialPort 1050&
[1] 7045

administrator@admin:~/Downloads$ java ReverseServer -ORBInititalPort 1050& -ORBInitialHost localhost&
[2] 7062
[3] 7063

administrator@admin:~/Downloads$ Reverse Object Created
Step1
Step2
Step3
Step4
Reverse Server reaing and waiting....
-ORBInitialHost: command not found

*/
