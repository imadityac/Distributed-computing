/*
	Name:		Aditya Choudhari
	Roll No.:	45009
	Assignment:	4
	
	To develop any distributed algorithm for leader election.(Ring Algorithm) 
*/
import static java.lang.System.exit;
import java.util.Scanner;

class Ring
{
    static int n,front=0,rear=0,choice,maxi=0,cord;
    static int[][] cq;
    public static void main(String[] args) 
    {
        System.out.print("\n\t\t**Ring Election Algorithm**\n");
        
        Scanner scanner=new Scanner(System.in);
        System.out.print("\nEnter the no. of processes : ");
        cord=n=scanner.nextInt();
        cq=new int[n+1][n+1];
        for(int i=1;i<=n;i++)
        {
          if (rear==0 && front==0)
              front=rear=1;
          else if(rear==n && front!=1)
              rear=1;
          else
                rear=rear+1;
          System.out.print("\nEnter the  process no : ");
          cq[rear][0]=scanner.nextInt();
          System.out.print("\nEnter the state of process : ");
          cq[rear][1]=scanner.nextInt();
        }
        display();
        
        do
        {
              System.out.print("\n\n\t1.Crash \n\t2.Activate\n\t3.Conduct Election\n\t0.Quit");
              System.out.print("\n\tEnter the choice : ");
              choice=scanner.nextInt();
              switch(choice)
              {
                    case 1 : 
                            System.out.print("Enter the process no you want to crash : ");
                            //int x=scanner.nextInt();
                            crash(scanner.nextInt());   
                            break;

                    case 2 :
                            System.out.print("Enter the process no you want to activate : ");
                            activate(scanner.nextInt());
                            if(cord<n)
                            {
                            	for(int i=cord;i<=n;i++)
                            	{
                            		if(cq[i][1]==1)
                            			cord=i;
                            	}
                            }
                            break;
                    case 3 :
                        	if(cq[cord][1]==1)
		                    {
		                    	System.out.print("\nCo-ordinator is : "+cord);
		                        System.out.print("\nNo need to start election.");
		                    }
                            else
                            {
                                System.out.print("\nCo-ordinator is Crashed.\nEnter the process no to initiate election : ");
                                int x2=scanner.nextInt();
                                while(cq[x2][1]==0)
                                {
                                    System.out.print("Process "+x2 +" is crashed and cannot start election");
                                    System.out.print("Enter another Process :");
                                    x2=scanner.nextInt();
                                }
                                elect_cord(x2);
                            }
                            break;
                    case 0: 
                            exit(0);
                            break;
              }
         }while(choice!=0);
    }
    
    public static void crash(int x)
    {
        for(int i=0;i<=n;i++)
        {
            if(cq[i][0]==x)
            {
                if(cq[i][1]==0)
                {
                    System.out.print("Already crashed");
                    break;
                }
                else
                {
                    cq[i][1]=0;
                    display();
                    break;
                }
            }
        }
    }
    
    public static void activate(int x)
    {
        for(int i=0;i<=n;i++)
        {
            if(cq[i][0]==x)
            {
                if(cq[i][1]==1)
                {
                    System.out.print("Already activated");
                    break;
                }
                else
                {
                    cq[i][1]=1;
                    display();
                    break;
                }
            }
        }
    }

    public static void display()
    {
           System.out.print("\n\nProcess    \t : ");
           for(int i=1;i<=n;i++)
           {
               System.out.print("\tP"+i);
           }
           System.out.print("\nStatus     \t : ");
           for(int i=1;i<=n;i++)
           {
               System.out.print("\t"+cq[i][1]);
           }
           System.out.print("\nIdentifier (PID) : ");
           for(int i=1;i<=n;i++)
           {
               System.out.print("\t"+cq[i][0]);
           }
    }
    
    public static void elect_cord(int x)
    {
        rear=x-1;
        front=x;
        maxi=0;
        for(int i=front;i<=n;i++)
        {
            if(cq[i][1]!=0)
            {
                System.out.print(cq[i][0]);
                if(i!=n-1)
                {
                    System.out.print("->");  
                }
                maxi=Math.max(maxi, cq[i][0]);
            }
        }
        if(rear!=0)
            System.out.print("->"); 
        for(int i=1;i<=rear;i++)
        {
            if(cq[i][1]!=0)
            {
                System.out.print(cq[i][0]);
                if(i!=rear)
                {
                    System.out.print("->");  
                }
                maxi=Math.max(maxi, cq[i][0]);
            }
        }
        cord=maxi;
        System.out.print("\nNew Co-ordinator is : "+cord);
    }
}
/*
			++  OUTPUT  ++

administrator@admin:~/Downloads$ javac Ring.java 

administrator@admin:~/Downloads$ java Ring 

		**Ring Election Algorithm**

Enter the no. of processes : 4

Enter the  process no : 1

Enter the state of process : 1

Enter the  process no : 2

Enter the state of process : 1

Enter the  process no : 3

Enter the state of process : 1

Enter the  process no : 4

Enter the state of process : 1


Process    	 : 	P1	P2	P3	P4
Status     	 : 	1	1	1	1
Identifier (PID) : 	1	2	3	4

	1.Crash 
	2.Activate
	3.Conduct Election
	0.Quit
	Enter the choice : 1
Enter the process no you want to crash : 4


Process    	 : 	P1	P2	P3	P4
Status     	 : 	1	1	1	0
Identifier (PID) : 	1	2	3	4

	1.Crash 
	2.Activate
	3.Conduct Election
	0.Quit
	Enter the choice : 3

Co-ordinator is Crashed.
Enter the process no to initiate election : 2
2->3->1
New Co-ordinator is : 3

	1.Crash 
	2.Activate
	3.Conduct Election
	0.Quit
	Enter the choice : 2
Enter the process no you want to activate : 4


Process    	 : 	P1	P2	P3	P4
Status     	 : 	1	1	1	1
Identifier (PID) : 	1	2	3	4

	1.Crash 
	2.Activate
	3.Conduct Election
	0.Quit
	Enter the choice : 1
Enter the process no you want to crash : 2


Process    	 : 	P1	P2	P3	P4
Status     	 : 	1	0	1	1
Identifier (PID) : 	1	2	3	4

	1.Crash 
	2.Activate
	3.Conduct Election
	0.Quit
	Enter the choice : 3

Co-ordinator is : 4
No need to start election.

	1.Crash 
	2.Activate
	3.Conduct Election
	0.Quit
	Enter the choice : 0

*/
