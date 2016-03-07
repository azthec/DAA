// Exemplo de ordenacao customizada de nomes
// Primeiro pelo apelido e em caso de empate pelo primeiro nome
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 17/10/2015
// ----------------------------------

import java.io.*;
import java.util.*;

// Classe para guardar um nome
class Name implements Comparable<Name> {
    public String first;
    public String last;

    Name(String f, String l) {
	first = f;
	last  = l;
    }
    
    // Definir como comparar dois elementos da classe Name
    // compareTo e uma funcao que compara objecto com outro objecto "n"
    // Esta funcao deve devolver:
    //  - numero < 0 se objecto for menor que objecto "n"
    //  - numero > 0 se objecto for maior que objecto "n"
    //  - zero, se objecto for igual ao objecto "n"
    @Override
    public int compareTo(Name n) {
	if (last.equals(n.last))
	    return first.compareTo(n.first);
	else
	    return last.compareTo(n.last);
    }
}

public class CustomSort {
    public static void main(String args[]) {
	Scanner stdin = new Scanner(System.in);

	int n    = stdin.nextInt();	
	Name v[] = new Name[n]; 
	for (int i = 0; i<n; i++)
	    v[i] = new Name(stdin.next(), stdin.next());
       	
	// Chamada ao sort padrao da linguagem Java
	// Usa o comparador padrao do tipo do array
	Arrays.sort(v);
	
	for (int i = 0; i<n; i++)
	    System.out.println(v[i].first + " " + v[i].last);
    }
}