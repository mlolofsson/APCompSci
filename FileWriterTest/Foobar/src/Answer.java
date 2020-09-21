import java.util.Arrays;

public class Answer {  
    public static void main(String[] args){
        int n=0; 
        //System.out.print("sdfgh");
        String yes = answer(n); 
        System.out.print(yes);
    }
    public static String answer(int n) { 
        // Your code goes here.
       int[] primes = new int[10006]; 
        int i=0; // i = primes index 
        int num=2; 
       // System.out.println("asdfghj");
        
        do{
            if(checkPrime(num)==true){
                primes[i] = num; 
                i++; 
            }
            num++; 
        }while(i<10006); 
        
        // turn into string 
        String p="";
        for(int k=0; k<primes.length; k++) {
        	int temp = primes[k];
        	String t = Integer.toString(temp);  
        	p = p + t; 
        }
        
        System.out.print(p.length() + " ");
        
        //int start = primes2.indexOf(n); 
        
        String answer = p.substring(n, n+6); 
        
        
        return answer; 
        
    }
    public static boolean checkPrime(int num){
        for(int i=2; i<num; i++){ // loops through for factors above 1 and less than num 
            if(num%i==0){ 
                return false; 
            }
        } 
        return true; 
    }
}
/*public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}*/
