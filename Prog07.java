import java.util.Scanner;

public class Prog07 {

	//precisao final que queremos nos calculos

	static final double precisao = 1e-7; //4 nao chegava? pk?

	//declarar variaveis globais para ser usado na funcaoo F(x)
	static int p,q,r,s,t,u;

	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		//um ciclo por caso
		for(int i = 0; i<n; i++) {

			p = in.nextInt();
			q = in.nextInt();
			r = in.nextInt();
			s = in.nextInt();
			t = in.nextInt();
			u = in.nextInt();
			in.nextLine();
			
			if(f(0) * f(1) > 0) System.out.println("Impossivel");
			else System.out.println(String.format("%.4f", newton()));
			
			
			//bisseccao
//			double low = 0.0 , result = 0.0, high = 0.0;
//			double a = f(low);
//			double b = f(high);
//
//
//
//			if(a * b > precisao) System.out.println("Impossivel");
//			else if (precisao>Math.abs(a)) System.out.println("0.0000");
//			else if (precisao>Math.abs(b)) System.out.println("1.0000");
//			else { 	//biseccao || binary search +-
//				while (Math.abs(high-low) > precisao) {
//					double mid = (low + high) / 2;
//
//					if(f(mid) * f(high) > precisao)
//						high = mid;
//					else
//						low = mid;
//					result = mid;
//				}
//				System.out.println(String.format("%.4f", result));
//			}
		}
	}

	static double f(double x) {
		//p*e-x + q*sin(x) + r*cos(x) + s*tan(x) + t*x^2 + u = 0
		return (double)p * Math.exp(-x) + q * Math.sin(x) + r * Math.cos(x) +
				s * Math.tan(x) + t * Math.pow(x, 2) + u;
	}
	
	static double derivadaf(double x) {
		return -p*Math.exp(-x) + q*Math.cos(x) - r*Math.sin(x) + s/(Math.cos(x) * Math.cos(x)) + 2*t*x;
	}
	
	static double newton(){
		  if (f(0)==0) return 0;
		  double x=0.5; //suposicao inicial
		  while(true){
		    double x1 = x - f(x)/derivadaf(x);      // proxima suposicao
		    if (Math.abs(x1-x) < precisao) return x;  // aproximado que chegue
		    x = x1;
		  }
		}


}
