
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * http://uvacode.blogspot.pt/2011/05/hints-for-uva-problem-set-200.html
 * DFS + Ord top
 * 
 * recebemos um indicide ordenado alfabeticamente (no alfabeto que queremos descobrir)
 * indices sao ordenados "verticalmente" IE: se tenho XT e YT posso pelo menos concluir que o Y vem depois do X
 * 
 */

public class Prog17 {
	static int n;						// Numero de nos do grafo
	static boolean adj[][];				// Matriz de adjacencias
	static boolean visited[];			// Que nos ja foram visitados?
	static String sort;
	static boolean vertices[];

	static void dfs(int s) {

		visited[s] = true;
		for (int i = 0; i < 26; i++)
			if (adj[s][i] && !visited[i])
				dfs(i);

		sort = (char)(s + 'A') + sort;	//porque usamos recursao, e printed na ordem inversa 
	}



	static void topsort() {	//string global em vez de lista, + facil de implementar
		visited = new boolean[26];

		for (int i = 0; i < 26; i++)	//"para todos nos do grafo"
			if (vertices[i] && !visited[i])
				dfs(i);
		System.out.println(sort);	//nao preciso de truncar espacos porque nao existem
	}

	//para nao estar a repetir sempre que quero fazer isto
	static int char2int (char c) {
		return c - 'A';
	}

	static int int2char (int i) {
		return i + 'A';
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		List<String> lista = new ArrayList<String>();		//apontamentos, para nao usar um array de Strings, isto nao aumenta complexidade
		int n = in.nextInt();								//e nao me preocupo com inversoes no final
		in.nextLine();
		sort = new String();
		adj = new boolean[26][26];
		vertices = new boolean[26];
		String str = new String();
		boolean anterioresIguais = true;
		for(int i=0; i<n;i++) {						//le n linhas de input e poe na string
			str = in.nextLine();
			lista.add(str);
		}

		for(int i = 0; i<10; i++) {					//1 caracter da string
			for(int j =0; j<lista.size(); j++) {	//1 string do input (recebida da list)
				String s = lista.get(j);			//ir buscar string da linha j do input
				if(i>=s.length()) continue;			//se nao tiver isto, vou tentar is buscar um caracter que ja nao existe na string
													//da erro indexoutofbounds no charAt(i)
				vertices[s.charAt(i) - 'A'] = true; //vertices inicializado a false, se tem true entao existe caracter (obvio)
				if(j>0) {							//vou comparar de baixo para o anterior, assim inicializo S para fazer o profimo prev
					String previous = lista.get(j-1);
					if(previous.length() > i) {		//outra vez para nao ter index out of bounds
						if(i==0 && s.charAt(i) != previous.charAt(i))	//estou na primeira coluna, portanto tenho a certeza que estas letras estao ordenadas
							adj[previous.charAt(i) - 'A'][s.charAt(i) - 'A'] = true;
						else if(s.charAt(i) != previous.charAt(i)) { //nao estou na primeira coluna de letras, e as letras q comparo sao diferentes
							anterioresIguais = true;			//sem esta linha falha na segunda vez que faz o check
							for(int w = 0; anterioresIguais && w < i; w++) {//comparo todas as colunas anteriores para ver se as letras eram iguais
								if(s.charAt(w) != previous.charAt(w)) anterioresIguais=false; //se as letras anteriores nao eram iguais nao faco nada
							} //se os anteriores eram iguais, entao posso confiar q o previous.charAt(i) vem antes do s.charAt(i)
							if(anterioresIguais) adj[previous.charAt(i)-'A'][s.charAt(i)-'A'] = true;
						}
					}
				}
			}
		}
		topsort();
	}
}