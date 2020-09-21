import java.util.*;

public class HashExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> age = new HashMap<>();
		age.put("Nikki", 15);
		age.put("Liam", 5);
		System.out.println(age.get("Liam"));
		age.forEach((name, myage)->System.out.println(name + " " + myage));
	}

}
