import java.util.Scanner;

public class Prog02 {
	static int n;
	static int seq[];


	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();

		seq = new int[n];

		for(int i=0;i<n;i++) {
			seq[i] = in.nextInt();
		}
		
		//Kadane modificado para funcionar com arrays de nums so negativos
		int max_so_far = seq[0];
		int max_ending_here = seq[0];
		for(int i =1; i<n; i++) {
			max_ending_here = Math.max(seq[i], max_ending_here + seq[i]);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		System.out.println(max_so_far);
	}

}
