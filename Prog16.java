import java.io.*;
import java.util.Scanner;

/*
 * como queremos separar as salas, queremos usar flood fill com 4 direcoes (se usarmos 8 ele vai entrar nas salas
 * qnd nao devia e o resultado esta errado)
 * http://cstheory.stackexchange.com/questions/18490/flood-fill-vs-depth-first-search
 * The Flood Fill algorithm is a particular case of the Depth First Seach algorithm, on regular mesh graphs
 * In any case, the complexity is clearly within O(n) where n is the number of nodes being colored (for both problems).
 * 
 * A complexidade continua a ser O(n) porque nao estamos a usar nenhuma estrutura adicional para guardar data temporariamente
 */

public class Prog16 {
	
	static int[][] map;
	static boolean[][] visited;
	static int counter;
	
/*
* metodo criado para evitar outofbounds, retorna -1 se tentares acessar posicao invalida
*/
	private static int getValue(int x, int y, int[][] map) {
		if (x <= 0 || y <= 0 || x >= map.length || y >= map[x].length) {
			return -1;
		} else {
			return map[x][y];
		}
	}

	private static void flood(int row, int col){
		//se ja foi visitado termina
		if (visited[row][col]) return;
		
		//faz coisas diferentes consoante o valor no map[x][y]
		if(map[row][col]==0) {
			visited[row][col]=true;
			floodIt(row,col);
		}
		if(map[row][col]==-1) { //se for -1 entao ignoro, assim nao salto paredes / portas
			return;
		}
		if(map[row][col]==1) {
			visited[row][col]=true;
			counter++;				//TEST
			floodIt(row,col);
		}
		
		
	}
	
	private static void floodIt(int row, int col) {
		flood(row-1,col);
		flood(row+1,col);
		flood(row,col-1);
		flood(row,col+1);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//Reader reader = new InputStreamReader(System.in);
		int l = in.nextInt();
		int c = in.nextInt();
		in.nextLine();
		map = new int[l][c];
		visited = new boolean[l][c];
		//input do esquema, convertido para ints
		for(int linhas = 0; linhas<l; linhas++) {
			String str = in.nextLine();
			for(int colunas = 0; colunas<c; colunas++) {
				char caracter = str.charAt(colunas);
						//map[linhas][colunas] = 
				//optimizado por numero normal de caracteres num input normal
				//' '=0 | '#'=-1 | 'C'=1 | 'P'=-1
				//na pratica paredes e portas sao equivalentes
				if (caracter == ' ') {
					map[linhas][colunas] = 0;
				} else if (caracter == '#'){
					map[linhas][colunas] = -1;
				} else if (caracter == 'C') {
					map[linhas][colunas] = 1;
				} else {
					map[linhas][colunas] = -1;
				}
			}
		}
		int max = 0;
		//correr flood
		for(int linhas = 0; linhas<l; linhas++) {
			for(int colunas = 0; colunas<c; colunas++) {
				counter = 0; //TEST
				flood(linhas,colunas);
				if (counter!=0 && max < counter) max = counter;
			}
		}
		System.out.println(max);
		
	}
}