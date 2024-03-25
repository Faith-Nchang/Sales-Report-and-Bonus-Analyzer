/*
 * Description: Two Dimensional Ragged Array Utility
 * @author Faith Fru Nchang
*/
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTest{
	private double[][] data1 = {
			{1253.65, 4.50,    2000.50, 7532.45, 3388.44}, 
			{2876.22, -3.24,   1954.66},
			{4896.23, 2.29,    5499.29},
			{2256.76, 3.26,    4286.29, 5438.48, 3794.43},
			{3184.38, 3654.65, 3455.76, 6387.23, 4265.77, 4592.45},
			{2657.46, 3265.34, 2256.38, 8935.26, 5287.34, 6598.23}
			};
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testReadFile() {
		File file  = new File("demo.txt");
		try {
			TwoDimRaggedArrayUtility.writeToFile(data1, file);
			double [][] dataSet = TwoDimRaggedArrayUtility.readFile(file);
			assertEquals(-3.24, dataSet[1][1], 0.01);
			assertEquals(6387.23, dataSet[4][3]);
		} catch (Exception e)
		{
			System.out.println("File not found");
		}
	}

	@Test
	void testWriteToFile() {
		File file = new File("demo.txt");
		try {
			TwoDimRaggedArrayUtility.writeToFile(data1, file);
			double [][] dataSet = TwoDimRaggedArrayUtility.readFile(file);
			assertEquals(1253.65, dataSet[0][0], 0.01);
			assertEquals(2256.38, dataSet[5][2]);
		} catch (Exception e)
		{
			System.out.println("File not found");
		}
		
	
	}
	@Test
	void testGetTotal() {
		assertEquals(99724.45999999999, TwoDimRaggedArrayUtility.getTotal(data1), 0.001);
	}

	@Test
	void testGetAverage() {
		assertEquals(3561.587857142857, TwoDimRaggedArrayUtility.getAverage(data1), 0.001);
	}

	@Test
	void testGetRowTotal() {
		assertEquals(14179.54, TwoDimRaggedArrayUtility.getRowTotal(data1, 0), 0.001);
		assertEquals(4827.64, TwoDimRaggedArrayUtility.getRowTotal(data1, 1), 0.001);
		assertEquals(10397.81, TwoDimRaggedArrayUtility.getRowTotal(data1, 2), 0.001);
		assertEquals(15779.22, TwoDimRaggedArrayUtility.getRowTotal(data1, 3), 0.001);
		assertEquals(25540.24, TwoDimRaggedArrayUtility.getRowTotal(data1, 4), 0.001);
		assertEquals(29000.01, TwoDimRaggedArrayUtility.getRowTotal(data1, 5), 0.001);
	}

	@Test
	void testGetColumnTotal() {
		assertEquals(17124.699999999997, TwoDimRaggedArrayUtility.getColumnTotal(data1, 0));
		assertEquals(6926.8, TwoDimRaggedArrayUtility.getColumnTotal(data1, 1));
		assertEquals(19452.88, TwoDimRaggedArrayUtility.getColumnTotal(data1, 2));
		assertEquals(28293.42, TwoDimRaggedArrayUtility.getColumnTotal(data1, 3));
		assertEquals(16735.98, TwoDimRaggedArrayUtility.getColumnTotal(data1, 4));
		assertEquals(11190.68, TwoDimRaggedArrayUtility.getColumnTotal(data1, 5));

	}

	@Test
	void testGetHighestInRow() {
		assertEquals(7532.45, TwoDimRaggedArrayUtility.getHighestInRow(data1, 0), 0.001);
		assertEquals(2876.22, TwoDimRaggedArrayUtility.getHighestInRow(data1, 1), 0.001);
		assertEquals(5499.29, TwoDimRaggedArrayUtility.getHighestInRow(data1, 2), 0.001);
		assertEquals(5438.48, TwoDimRaggedArrayUtility.getHighestInRow(data1, 3), 0.001);
		assertEquals(6387.23, TwoDimRaggedArrayUtility.getHighestInRow(data1, 4), 0.001);
		assertEquals(8935.26, TwoDimRaggedArrayUtility.getHighestInRow(data1, 5), 0.001);

	}

	@Test
	void testGetHighestInRowIndex() {
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(data1, 0), 0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(data1, 1), 0.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(data1, 2), 0.001);
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(data1, 3), 0.001);
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(data1, 4), 0.001);
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(data1, 5), 0.001);
	}

	@Test
	void testGetLowestInRow() {
		assertEquals(4.50, TwoDimRaggedArrayUtility.getLowestInRow(data1, 0), 0.001);
		assertEquals(-3.24, TwoDimRaggedArrayUtility.getLowestInRow(data1, 1), 0.001);
		assertEquals(2.29, TwoDimRaggedArrayUtility.getLowestInRow(data1, 2), 0.001);
		assertEquals(3.26, TwoDimRaggedArrayUtility.getLowestInRow(data1, 3), 0.001);
		assertEquals(3184.38, TwoDimRaggedArrayUtility.getLowestInRow(data1, 4), 0.001);
		assertEquals(2256.38, TwoDimRaggedArrayUtility.getLowestInRow(data1, 5), 0.001);

	}

	@Test
	void testGetLowestInRowIndex() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(data1, 0), 0.001);
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(data1, 1), 0.001);
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(data1, 2), 0.001);
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(data1, 3), 0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data1, 4), 0.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(data1, 5), 0.001);
	}

	@Test
	void testGetHighestInColumn() {
		assertEquals(4896.23, TwoDimRaggedArrayUtility.getHighestInColumn(data1, 0), 0.001);
		assertEquals(3654.65, TwoDimRaggedArrayUtility.getHighestInColumn(data1, 1), 0.001);
		assertEquals(5499.29, TwoDimRaggedArrayUtility.getHighestInColumn(data1, 2), 0.001);
		assertEquals(8935.26, TwoDimRaggedArrayUtility.getHighestInColumn(data1, 3), 0.001);
		assertEquals(5287.34, TwoDimRaggedArrayUtility.getHighestInColumn(data1, 4), 0.001);
		assertEquals(6598.23, TwoDimRaggedArrayUtility.getHighestInColumn(data1, 5), 0.001);

	}

	@Test
	void testGetHighestInColumnIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data1, 0), 0.001);
		assertEquals(4, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data1, 1), 0.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data1, 2), 0.001);
		assertEquals(5, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data1, 3), 0.001);
		assertEquals(5, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data1, 4), 0.001);
		assertEquals(5, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data1, 5), 0.001);
	}

	@Test
	void testGetLowestInColumn() {
		assertEquals(1253.65, TwoDimRaggedArrayUtility.getLowestInColumn(data1, 0), 0.001);
		assertEquals(-3.24, TwoDimRaggedArrayUtility.getLowestInColumn(data1, 1), 0.001);
		assertEquals(1954.66, TwoDimRaggedArrayUtility.getLowestInColumn(data1, 2), 0.001);
		assertEquals(5438.48, TwoDimRaggedArrayUtility.getLowestInColumn(data1, 3), 0.001);
		assertEquals(3388.44, TwoDimRaggedArrayUtility.getLowestInColumn(data1, 4), 0.001);
		assertEquals(4592.45, TwoDimRaggedArrayUtility.getLowestInColumn(data1, 5), 0.001);

	}

	@Test
	void testGetLowestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data1, 0), 0.001);
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data1, 1), 0.001);
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data1, 2), 0.001);
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data1, 3), 0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data1, 4), 0.001);
		assertEquals(4, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data1, 5), 0.001);
	}

	@Test
	void testGetHighestInArray() {
		assertEquals(8935.26, TwoDimRaggedArrayUtility.getHighestInArray(data1), 0.001);
	}

	@Test
	void testGetLowestInArray() {
		assertEquals(-3.24, TwoDimRaggedArrayUtility.getLowestInArray(data1), 0.001);
	}

}
