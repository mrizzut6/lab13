import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class rizzuto_lab13test {
	rizzuto_lab13 lab;
	Integer[] expectedResult1;
	Integer[] expectedResult2;
	Integer[] expectedResult3;
	String inputFilename = "lab13_input_data.txt";
	String expectedResultsFilename = "lab13_expected_results.txt";

	@Before
	public void setUp() throws Exception {
		lab = new rizzuto_lab13();
		lab.readData(inputFilename);

		ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
		for( int i = 0; i < 3; i++ )
		{
			testData.add(new ArrayList<Integer>());
		}
				
		try
		{
			System.out.println("reading " + expectedResultsFilename);
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedResultsFilename)));
			for( int i = 0; i < testData.size(); i++ )
			{
				ArrayList<Integer> currentTestData = testData.get(i); 
				String inn;
				input.readLine();
				while( (inn = input.readLine()) != null )
				{
					if( inn.length() > 0 )
					{
						currentTestData.add(Integer.valueOf(inn));
					}
					else
					{
						break;
					}
				}
				testData.set(i, currentTestData);
				System.out.println("testData.get(" + i + ").size() = " + testData.get(i).size());
			}
			input.close();

			expectedResult1 = new Integer[testData.get(0).size()];
			for(int i = 0; i < testData.get(0).size(); i++) {
				expectedResult1[i] = testData.get(0).get(i);
			}

			expectedResult2 = new Integer[testData.get(1).size()];
			for(int i = 0; i < testData.get(1).size(); i++) {
				expectedResult2[i] = testData.get(1).get(i);
			}

			expectedResult3 = new Integer[testData.get(2).size()];
			for(int i = 0; i < testData.get(2).size(); i++) {
				expectedResult3[i] = testData.get(2).get(i);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}

	@Test
	public void testGetTotalCount() {
		assertEquals(lab.getTotalCount(), 1000, 0.001);
	}

	@Test
	public void testGetOddCount() {
		assertEquals(lab.getOddCount(), 507, 0.001);
	}

	@Test
	public void testGetEvenCount() {
		assertEquals(lab.getEvenCount(), 493, 0.001);
	}

	@Test
	public void testGetDistinctGreaterThanFiveCount() {
		assertEquals(lab.getDistinctGreaterThanFiveCount(), 94, 0.001);
	}

	@Test
	public void testGetResult1() {
		assertArrayEquals(lab.getResult1(), expectedResult1);
	}

	@Test
	public void testGetResult2() {
		assertArrayEquals(lab.getResult2(), expectedResult2);
	}

	@Test
	public void testGetResult3() {
		assertArrayEquals(lab.getResult3(), expectedResult3);
	}
}
