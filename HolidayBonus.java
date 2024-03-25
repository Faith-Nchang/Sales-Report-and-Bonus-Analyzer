/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Two Dimensional Ragged Array Utility
 * Due: 11/13/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Faith Fru Nchang
*/
public class HolidayBonus{
	public static  final int BONUS_FOR_HIGHEST_STORE = 5000;
	public static  final int BONUS_FOR_LOWEST_STORE = 1000;
	public static  final int BONUS_FOR_EACH_STORE = 2000;
	
	/**
	 *  constructor
	 */
	public HolidayBonus()
	{
	}
	
	/**
	 * computes the holiday bonus of all the stores in a district
	 * @param data -  two dimensional array
	 * @return hotelBonuses - array of doubles
	 */
	public static double[] calculateHolidayBonus(double[][] data)
	{
		// stores the number of rows in the array
		final int NUM_OF_STORES = data.length;
		// creates an array to store the bonuses of all the stores
		double[] hotelBonuses = new double[NUM_OF_STORES];
		double currentStoreBonus = 0.0;
		for(int row =0; row < NUM_OF_STORES; row++)
		{
			for(int column = 0; column < data[row].length; column++)
			{
				// ensures the row contains the colum
				if (column < data[row].length)
				{
					// checks if the current value is the higest in the column
					if (TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, column) == row)
						currentStoreBonus += BONUS_FOR_HIGHEST_STORE;
					// checks if the current value is the lowest in the column
					else if ((TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, column) == row)&& (data[row][column] >0) )
						currentStoreBonus += BONUS_FOR_LOWEST_STORE;
					// checks if the current value is negative or 0
					else if (data[row][column] <= 0)
						currentStoreBonus +=0;
					else 
						currentStoreBonus += BONUS_FOR_EACH_STORE;
				}
			}
			// stores each store's bonus in the hotelBonuses array
			hotelBonuses[row] = currentStoreBonus;
			// for computing the next stores bonus
			currentStoreBonus=0.0;	
		}
		return hotelBonuses;
	}
	
	
	/**
	 * computes the sum of all the bonuses of the stores in a district
	 * @param data -  two dimensional array
	 * @return totalBonus
	 */
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		// an array of all the bonuses in the stores
		double[] allBonus =  calculateHolidayBonus(data);
		double totalBonus = 0.0; 
		//loops through the array and stores its value in the total bonus
		for(int i =0; i< allBonus.length; i++)
		{
			totalBonus += allBonus[i];
		}
		return totalBonus;
	}
}
