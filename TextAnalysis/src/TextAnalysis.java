import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map.Entry;
import java.util.*;

public class TextAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("What is the name of your file?");
		System.out.println("The top 20 most frequent words in your text file are: ");
		readFile();

	}

	public static void readFile() {
		String line;
		String[] words = new String[0];
		String[] temp;
		try (InputStream fis = new FileInputStream("C:\\Users\\Michelle\\Documents/trump.txt");
				InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(isr);) {
			while ((line = br.readLine()) != null) {
				temp = line.split(" "); // fix so that it works with multiple
				words = concatenate(temp, words); // adding the strings together to create one large string
				// (prevents the lines from being overided by the next lines)
			}
			analyze(words);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void analyze(String[] words) {
		/*
		 * for(int i=0; i<words.length; i++){ System.out.print(words[i] + " "); }
		 */
		Map<String, Integer> Counter = new HashMap<>();
		Map<String, Integer> rejects = new HashMap<>();
		rejects.put("the", 0);
		rejects.put("a", 0);
		rejects.put("to", 0);
		rejects.put("of", 0);
		rejects.put("you", 0);
		rejects.put("and", 0);
		rejects.put("in", 0);
		rejects.put("your", 0);
		rejects.put("be", 0);
		rejects.put("is", 0);
		rejects.put("it", 0);
		rejects.put("have", 0);
		rejects.put("for", 0);
		rejects.put("are", 0);
		rejects.put("that", 0);
		rejects.put("And", 0);
		rejects.put("they", 0);
		rejects.put("we", 0);
		rejects.put("this", 0);
		rejects.put("was", 0);
		rejects.put("as", 0);
		rejects.put("with", 0);
		rejects.put("his", 0);
		rejects.put("he", 0);
		rejects.put("on", 0);
		rejects.put("so", 0);
		rejects.put("at", 0);
		rejects.put("from", 0);
		rejects.put("our", 0);
		int value = 0;
		for (int n = 0; n < words.length; n++) {
			if (rejects.containsKey(words[n])) {
				//do nothing
			}				
			else {
				if (Counter.containsKey(words[n])) {
					Counter.put(words[n], Counter.get(words[n]) + 1); //for if the word already exists
					value = Counter.get(words[n]);
				}
				else {
					Counter.put(words[n], 1); // for the first time the word appears
					value = 1;
				}
				// System.out.println(words[n] + " " + value);
			}
		} // find out how to find repetition of words in array
			// Print out map
		Counter = sortByValue(Counter);
		int x = 1;
		for (Map.Entry<String, Integer> entry : Counter.entrySet()) {
			System.out.print(x + ". " + entry.getKey() + "(");
			System.out.println(entry.getValue() + ")");
			x++;
			if (x > 50) {
				break;
			}
		}
		// ends
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				// it should be o2 compareTo o1, since I need descending order
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	public static <T> T[] concatenate(T[] a, T[] b) {
		int aLen = a.length;
		int bLen = b.length;

		@SuppressWarnings("unchecked")
		T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);

		return c;
	}
}
