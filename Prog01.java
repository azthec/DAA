
import java.util.*;

public class Prog01 {

	
/*
 * 
 */

	static int n;         // Quantidade de numeros
	static int p[];       // Guardar a permutacao em si    
	static int d;
	static boolean used[]; // Indica se um numero ja foi usado
	static int x[];
	static int y[];
	static int min = Integer.MAX_VALUE;
	static int distance;


	// Funcao recursiva para colocar numero na posicao 'pos'
	static void go(int pos) {
		int i;

		// Chegamos ao fim da permutacao, vamos imprimi-la
		if (pos == n+1) {
				distance = Math.abs(1 - x[p[1]]) + Math.abs(1 - y[p[1]]);
				for(i=2; i<=n; i++) {
					distance += Math.abs(x[p[i]] - x[p[i-1]]) + Math.abs(y[p[i]] - y[p[i-1]]);
				}
				distance+=Math.abs(x[p[i-1]]-1)+Math.abs(y[p[i-1]]-1);
				if(distance < min) min = distance;
		}

		// Vamos a meio da permutacao
		// Gerar numero nao usado para colocar nesta posicao
		else {
			for (i=1; i<=n; i++)
				if (!used[i]) {
					p[pos] = i;
					used[i] = true;
					go(pos+1);
					used[i] = false;
				}
		}
	}    

	public static void main(String args[]) {

		// Ler a quantidade de numeros
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);
		d = stdin.nextInt();	
		n = stdin.nextInt();

		x = new int[n+1];
		y = new int[n+1];

		for(int i = 1; i<=n; i++) {
			x[i] = stdin.nextInt();
			y[i] = stdin.nextInt();
		}
		// Alocar memoria para criar permutacoes
		// (n+1 porque vou guardar a partir da posicao 1)
		p    = new int[n+1];
		used = new boolean[n+1];

		// Iniciar a permutacao na posicao 1
		go(1);    
		System.out.println(min);
	}


}
