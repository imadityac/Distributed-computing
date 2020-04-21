/*
	Name:		Aditya Choudhari
	Roll No.:	45009
	Assignment:	4
	
	To develop any distributed algorithm for leader election.(Bully Algorithm)
*/
import java.util.Scanner;  // Import the Scanner class

class Bully {
	public static void main(String args[]){
        System.out.print("\n\t\t**Bully Election Algorithm**\n");
		
		Scanner input = new Scanner(System.in);  // Create a Scanner object
		System.out.println("\n\t\tEnter no. of processes:");
		int processno = input.nextInt();
		System.out.println("\n\t\tEnter Coordinator Process no.:");
		int coordinator = input.nextInt();
		
		int[] processes = new int[processno];
		for (int i=0;i<processno;i++) {
			processes[i]=1;
		}
		
		while(true)
		{
			System.out.println("\n\t\tMenu:");
			System.out.println("\n\t1:Coordinator\n\t2:Down the process\n\t3:Up the process\n\t0:Exit");
			int choice = input.nextInt();
			switch(choice) {
				case 1:
					System.out.println("\n\tThe Coordinator is "+coordinator);
					break;
				case 2:
					System.out.println("\n\tEnter process which is Down :");
					processes[input.nextInt()]=0;
					if(processes[coordinator]==0)
					{
						for(int i=0 ;i<processno; i++)
						{
							if(processes[i]==1)
								coordinator=i;
						}
					}
					break;
				case 3:
					System.out.println("\n\tEnter process which is Up :");
					int flag = input.nextInt();
					processes[flag]=1;
					if(coordinator<flag)
					{
						for(int i=0 ;i<processno; i++)
						{
							if(processes[i]==1)
								coordinator=i;
						}
					}
					break;
				case 0:
					input.close();
					System.exit(0);
			}
		}	
	}
}
/*
			++OUTPUT++

	administrator@admin:~/Downloads$ javac Bully.java 
	
	administrator@admin:~/Downloads$ java Bully 

			**Bully Election Algorithm**

		Enter no. of processes: 5

		Enter Coordinator Process no.: 3

			Menu:

		1:Coordinator
		2:Down the process
		3:Up the process
		0:Exit
				1

		The Coordinator is 3

			Menu:

		1:Coordinator
		2:Down the process
		3:Up the process
		0:Exit
				2

		Enter process which is Down : 3

			Menu:

		1:Coordinator
		2:Down the process
		3:Up the process
		0:Exit
				1

		The Coordinator is 4

			Menu:

		1:Coordinator
		2:Down the process
		3:Up the process
		0:Exit
				2

		Enter process which is Down : 4

			Menu:

		1:Coordinator
		2:Down the process
		3:Up the process
		0:Exit
				1

		The Coordinator is 2

			Menu:

		1:Coordinator
		2:Down the process
		3:Up the process
		0:Exit
				3

		Enter process which is Up : 3

			Menu:

		1:Coordinator
		2:Down the process
		3:Up the process
		0:Exit
				1

		The Coordinator is 3

			Menu:

		1:Coordinator
		2:Down the process
		3:Up the process
		0:Exit
				0

*/
