import java.util.Scanner; 

public class FoodQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Do you like food? (yes/no)");
		String answer = input.next();
		
		if(answer.equals("yes")) {
			System.out.print("Okay! Here is a watermelon!");
			
		}
		else {
			System.out.print("Boo hoo boo hoo");
		} 
	}

}
