import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class rizzuto_lab13 {
	private final ArrayList<Integer> intArray = new ArrayList<Integer>();
	
	public void readData (String filename) {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String inn;
			while( (inn = input.readLine()) != null ) {
				intArray.add(Integer.parseInt(inn.trim()));
			}
			input.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	public long getTotalCount() {
		return intArray.stream().count();
	}
	
	public long getOddCount() {
		return intArray.stream().filter(x -> x % 2 == 1).count();
	}
	
	public long getEvenCount() {
		return intArray.stream().filter(x -> x % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return intArray.stream().distinct().filter(x -> x > 5).count();	
	}
	
	public Integer[] getResult1() {
		return intArray.stream().filter(x -> (x > 5) && (x < 50) && (x % 2 == 0)).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2() {
		return intArray.stream().map(x -> x*x*3).limit(50).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3() {
		return intArray.stream().filter(x -> (x % 2 == 1)).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}

}