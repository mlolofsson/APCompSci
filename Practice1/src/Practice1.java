import java.util.*;
public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"Michelle", "Nikki", "Liam", "Danny", "Natalie"};
		List<String> myList = new ArrayList<>();
		for(String name:names) {
			myList.add(name);
		}
		myList.add(3,"blabla");
		System.out.print(myList);
		Collections.sort(myList);
		System.out.println(myList);
	}

}
