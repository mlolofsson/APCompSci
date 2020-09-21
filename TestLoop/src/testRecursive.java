
public class testRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 5; 
		//print(num); 
		double[] v = {-2, -1, 0, 1, 2};
		int n=3; 
		double output = mystery(v, n); 
		System.out.print(output); 
		
		int x=11;
		int solution = f(x);
		System.out.print("\n" + solution); 
	}
	
	public static void print(int num) {
		if(num==1)
			System.out.print(1);
		else {
			System.out.print(num);
			print(num-1);
			
		}
	}
	
	public static double mystery(double[] v, int n) {
		if(n==0)
			return 0; 
		return mystery(v, n-1) + sum(v, n-1) * v[n-1]; 
	}
	
	public static double sum(double[] v, int n) {
		double sum=0; 
		for(int i=0; i<n; i++) {
			sum = sum + v[i]; 
		}
		return sum; 
	}
	
	public static int f(int x) {
		if(x>5)
			return f( f(x-2) -1) + x;
		if(x>0 && x<=5)
			return f( f(x-1) -2) + 2;
		return x; 
	}

}
