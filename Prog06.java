import java.util.Arrays;
import java.util.Scanner;

public class File {

    private static int BinarySearchIndex(int[] soma ,int key, int high) //double preciso?
    {

	int low = 0;
	int mid=0;

	if (high < 0)
	    throw new IllegalArgumentException("The array cannot be empty");

	while (low < high) {
	    mid = low + (high-low) / 2;
	    if (key == soma[mid])
		return mid;
	    else if (key < soma[mid])
		high=mid;
	    else
		low=mid+1;
	}
	mid=low;	    
	if(mid > 0){
	    if(key - soma[mid-1] < soma[mid] - key)
		return mid-1;
	    if(key - soma[mid-1] == soma[mid] - key){
		System.out.print(soma[mid-1] + " " );
		return mid;
	    }
	    if(soma[mid]-key < key - soma[mid-1])
		return mid;
	}
	return mid;    	  
	    }
		
    public static void main(String[] args) {

	Scanner in = new Scanner (System.in);
	int n = in.nextInt();
	int v[] = new int[n];

	int ctr=0;                            //
	for (int a=0;a<n;a++) {         
	    v[a]=in.nextInt();
	    ctr +=a;                          //
	}
	int aux=0;	
	int p =in.nextInt();
	int v2[] = new int[p];

	for (int b=0;b<p;b++)
	    v2[b]=in.nextInt();
		
	int ncombos = (n*(n-1))/2;
	int[] somas = new int[ctr];

	
	int temp = 0;

	for (int i = 0; i < n; i++) { 
	    for (int j = 0; j < i; j++) { 
		somas[temp] = v[i] + v[j];
		temp++;
	    }

	}


	Arrays.sort(somas);	 

	int abc;

	for (int i=0;i<p;i++)
	    {
		int key=v2[i];
		abc = (BinarySearchIndex(somas,key,ctr-1));
		if(abc != -1){
		    System.out.println(somas[abc]);
		} else {
		    System.out.println(abc);
		}
		
	    }	
	in.close();
    }
}

