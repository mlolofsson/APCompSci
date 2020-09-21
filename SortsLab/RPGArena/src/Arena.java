import java.util.Random;

public class Arena {
	
	public static Random generator = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Character player1 = new Character(10, 2, 100);
		Character player2 = new Rogue();
		
		player1.strength = 5; 
		player1.defense = 1; 
		player1.health = 100; 
		player2.strength = 4; 
		player2.defense = 2; 
		player2.health = 65;
		
		System.out.println(player1.name + " vs." + player2.name);
		System.out.println(player1.health + " vs. " + player2.health); 
		
		while(player1.isAlive() && player2.isAlive()){
			int damage; 
			System.out.println(player1.name + ": " + player1.health);
			System.out.println(player2.name + ": " + player2.health);
			
			player1.attack(player2);
			player2.attack(player1);
			
			damage = player1.attack(player2);
			System.out.println(player1.name + " hits " + player2.name + " for " + damage);
			damage = player2.attack(player1);
			System.out.println(player2.name + " hits " + player1.name + " for " + damage);
			
			if(player1.isAlive())
				System.out.println(player1.name + " wins.");
			
			else if(player2.isAlive())
				System.out.println(player2.name + " wins.");
			
			else 
				System.out.println("It's a draw!");
			
		}

	}
	

}
