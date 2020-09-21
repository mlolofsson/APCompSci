package iDtechPractice;

import java.util.ArrayList;
public class ListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // TODO Create an ArrayList of Strings
        ArrayList<String> list = new ArrayList<String>();
		 
        // TODO Add three strings to the list
         list.add("This is a String.");
         list.add("Oh hey, another one.");
         list.add("So many strings");
         
        System.out.println("The List:");
        // TODO Create a for each loop to print each element of the list
        for(String element : list){
        	System.out.println(element);
        }
        System.out.println("The second element of the list:");
        // TODO use the get(index) method to get and print the second element of the list
        System.out.println(list.get(1)); //prints out second value 
	}

}
