/*
 * Description: Two Dimensional Ragged Array Utility
 * @author Faith Fru Nchang
*/
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTest{

	private double[][] data1 = {
			{1253.65, 4.50, 2000.50, 7532.45, 3388.44}, 
			{2876.22, -3.24, 1954.66},
			{4896.23, 2.29, 5499.29},
			{2256.76, 3.26, 4286.29, 5438.48, 3794.43},
			{3184.38, 3654.65, 3455.76, 6387.23, 4265.77, 4592.45},
			{2657.46, 3265.34, 2256.38, 8935.26, 5287.34, 6598.23}
			};
	private double[][] data2 = { {5000.35}, 
								 {200.1, -3.4,   3000.1}, 
								 {3.4,   9000.2, 1.20,  34.5} };
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateHolidayBonus() {
		try 
		{
			double[] bonus1 = HolidayBonus.calculateHolidayBonus(data1);
			assertEquals(8000, bonus1[0], 0.001);
			assertEquals(3000, bonus1[1], 0.001);
			assertEquals(12000, bonus1[2], 0.001);
			assertEquals(9000, bonus1[3], 0.001);
			assertEquals(14000, bonus1[4], 0.001);
			assertEquals(21000, bonus1[5], 0.001);
			
			double[] bonus2 = HolidayBonus.calculateHolidayBonus(data2);
			assertEquals(bonus2[0], 5000, 0.1);
			assertEquals(bonus2[1], 7000, 0.1);
			assertEquals(bonus2[2], 12000, 0.1);	
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

			
	}

	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(67000, HolidayBonus.calculateTotalHolidayBonus(data1));
		assertEquals(24000, HolidayBonus.calculateTotalHolidayBonus(data2), 0.1);
	}

}
