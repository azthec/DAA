import java.util.Scanner;
	
public class Prog14 {
	//the subset sum problem
	//visto que é apenas um saco
	//podemos utilizar o knapsack com valor = weight
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		// 0/1knapsack problem  wikipediapseudocode adaptado (v=w)
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();	//number of distinct items
		int w = in.nextInt();	//knapsack capacity
		int[] val = new int[n+1];
		for(int i=0;i<n;i++) {
			val[i]=in.nextInt();
		}
		//alternativamente posso trocar no passo de programacao dinamica todas as ocorrencias de value por weight + value
		//http://stackoverflow.com/questions/27013060/knapsack-algorithm-optimized-for-weight-instead-of-values
		short[][] matrix = new short[n+1][w+1];
		//n e preciso inicializar a primeira linha e coluna 0, vantagems do java
		for(int i=1;i<=n;i++){
			for(int j=1;j<=w;j++){
				if(val[i-1]<=j) {
					matrix[i][j]=(short) Math.max(val[i-1]+matrix[i-1][j-val[i-1]], matrix[i-1][j]);
				} else {
					matrix[i][j]=matrix[i-1][j];
				}
			}
		}
		
		System.out.println(matrix[n][w]);
	}
}
