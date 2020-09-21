package iDtechPractice;

public class CheckInventory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] inventory = new String[5];
		inventory[0] = "HP Potion";
		inventory[1] = "Magic Sword";
		inventory[2] = "Wooden Shield";
		inventory[3] = "Magic Key";
		printInventory(inventory);
		if(checkInventory(inventory,"Magic Key")){
			System.out.println("Using your magic key, you open the locked door.");	
		}

	}
	
	public static boolean checkInventory(String[] inventory, String toCheck){
		for(int i=0; i<inventory.length; i++){
			String item = inventory[i];
			if(item!= null && item.equals(toCheck)){
				return true;
			}
		}
		return false;
	}
	
	public static void printInventory(String[] inventory){
		for (int n=0; n<inventory.length; n++){
		System.out.println(inventory[n]);
		}
	}
}
