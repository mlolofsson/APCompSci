
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		System.out.println(args[0]);
		
		String[] names={"Nikki","Michelle","Liam","Danny","Natalie"};
		
		/*for(int i=0; i<names.length; i++) {
			System.out.print(names[i]);
			System.out.print(" ");
		}*/
		
		for(String n:names){
			System.out.print(n+" ");
		}	
	}
}
