/*
	Name:		Aditya Choudhari
	Roll No.:	45009
	Assignment:	2
	
	To develop any distributed application using Message Passing Interface(MPI). 
*/
import mpi.MPI;
import java.util.*;
import java.lang.*;

public class MPJUppercase {
	public static void main(String args[]) {
		// Initialize MPI execution environment
		MPI.Init(args);
		// Get the id of the process
		int rank = MPI.COMM_WORLD.Rank();
		// total number of processes is stored in size
		int size = MPI.COMM_WORLD.Size();
		int root = 0;
		// array which will be filled with data by root process
		String sendbuf[];

		sendbuf = new String[size];

		// creates data to be scattered
		if (rank == root) {
			sendbuf[0] = "pes";
			sendbuf[1] = "modern";
			sendbuf[2] = "coe";
			sendbuf[3] = "pune";

			// print current process number
			System.out.print("Processor " + rank + " has data: ");
			for (int i = 0; i < size; i++) {
				System.out.print(sendbuf[i] + " ");
			}
			System.out.println();
		}
		// collect data in recvbuf
		String recvbuf[] = new String[1];

		// following are the args of Scatter method
		// send, offset, chunk_count, chunk_data_type, recv, offset, chunk_count,
		// chunk_data_type, root_process_id
		MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.OBJECT, recvbuf, 0, 1, MPI.OBJECT, root);
		System.out.println("Processor " + rank + " has data: " + recvbuf[0]);
		System.out.println("Processor " + rank + " is converting data to uppercase");
		recvbuf[0] = recvbuf[0].toUpperCase();
		// following are the args of Gather method
		// Object sendbuf, int sendoffset, int sendcount, Datatype sendtype,
		// Object recvbuf, int recvoffset, int recvcount, Datatype recvtype,
		// int root)
		MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.OBJECT, sendbuf, 0, 1, MPI.OBJECT, root);
		// display the gathered result
		if (rank == root) {
			System.out.println("Process 0 has data: ");
			for (int i = 0; i < 4; i++) {
				System.out.print(sendbuf[i] + " ");
			}
		}
		// Terminate MPI execution environment
		MPI.Finalize();
	}
}
/*

				++ OUTPUT++				
				
	administrator@it-nl-pc14:~/Downloads/mpi$ export MPJ_HOME=/home/administrator/Downloads/mpi/mpj-v0_44
	administrator@it-nl-pc14:~/Downloads/mpi$ javac -cp $MPJ_HOME/lib/mpj.jar MPJUppercase.java
	administrator@it-nl-pc14:~/Downloads/mpi$ $MPJ_HOME/bin/mpjrun.sh -np 4 MPJUppercase
	MPJ Express (0.44) is started in the multicore configuration
	Processor 0 has data: pes modern coe pune 
	Processor 0 has data: pes
	Processor 0 is converting data to uppercase
	Processor 1 has data: modern
	Processor 1 is converting data to uppercase
	Processor 2 has data: coe
	Processor 2 is converting data to uppercase
	Processor 3 has data: pune
	Processor 3 is converting data to uppercase
	Process 0 has data: 
	PES MODERN COE PUNE 

*/
