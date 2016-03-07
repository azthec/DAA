//We greedily make sure that the last trip will take exactly n cars. 
//Therefore, if m%n!=0, we must take m%n first. After that, just 
//update the time by taking the max(currentTime,lastCarArrivalTime). 
//Remember that the last trip will only take us t, not 2t as usual.



import java.util.Scanner;

public class Prog11 {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt(), t = in.nextInt(), n = in.nextInt();
		
		int[] cars = new int[n];
		for (int i = 0; i <n; i++) {
			cars[i] = in.nextInt();
		}
		
		int time = 0;
		int trips = 0;
		int rest = n%c; // resto inteiro de carros / capacidade
		if (rest>0) {	// se resto > 0 ajustar os calculos para o que fica de fora
			time = cars[rest-1]+2*t;
			trips++;
		}
		for(int i=rest+c-1; i<n; i+=c) { //greed
			time = Math.max(time, cars[i]) + 2 * t;
			trips++;
		}
		time -= t;	//ajustar (ultima linha da ajuda topo)
		System.out.println(time + " " + trips);
	}
	
}


//http://www.dcc.fc.up.pt/~pribeiro/aulas/daa1516/avaliacao/aulas_31122015.pdf
