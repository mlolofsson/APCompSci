import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathname = "LolPleaseWork2.txt"; 
		File file = new File(pathname);
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException ex) {
			System.out.println("Cannot create " + pathname);
			System.exit(1);
		}
		output.print("hellooo");
		output.close();
	}

}
