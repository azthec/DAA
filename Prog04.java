//package DAA;
import java.util.*;
import java.io.*;

class Equipa implements Comparable<Equipa>
{
	String nome;
	int vitorias, empates, derrotas, golosmarcados, golossofridos, pontos, mediagolos;

	Equipa(String n, int v, int e, int d, int golosmarcados, int golossofridos)
	{
		nome=n;
		vitorias=v;
		empates=e;
		derrotas=d;
		this.golosmarcados=golosmarcados;
		this.golossofridos=golossofridos;
		pontos = 3*vitorias + 1*empates;
		mediagolos = golosmarcados-golossofridos;			
	}

	public int compareTo(Equipa e) 
	{
		if (pontos > e.pontos) {
			return -1;
		} else if (pontos < e.pontos) {
			return +1;
		} else {
			if (mediagolos > e.mediagolos) {
				return -1;
			} else if (mediagolos < e.mediagolos) {
				return 1;
			} else {
				return nome.compareTo(e.nome);
			}
		}
	}				
}

public class Problema04 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Equipa e[] = new Equipa[n];
		for (int i=0;i<n;i++)
		{
			e[i] = new Equipa(in.next(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());					
		}

		Arrays.sort(e);

		for (int j=0;j<n;j++)
			System.out.println(e[j].nome + " " + e[j].pontos + " " + e[j].mediagolos);
	}
}
