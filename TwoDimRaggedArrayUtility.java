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


import java.io.*;
import java.util.Scanner;
public class TwoDimRaggedArrayUtility {
	private static final int MAX_ROW = 10;
	private static final int MAX_COLUMN = 10;
	
	public TwoDimRaggedArrayUtility()
	{
		
	}
	
	/**
	 *  reads the values of a file into an array
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		// Stores the doubles from a file as a string
		String[][] temporaryArray = new String[MAX_ROW][MAX_COLUMN];
		
		int lineNumber = 0; // the current line number in the file
		// an input file object
		try (Scanner inFile = new Scanner(file))
		{
			// reads all the lines in the file
			while(inFile.hasNext())
			{
				// tokenize each line and store it in an array
				String[] line = inFile.nextLine().split(" ");
				for(int i =0; i < line.length; i++)
				{
					// stores each element of the tokenized string in the temporary array
					temporaryArray[lineNumber][i] = line[i];
				}
				lineNumber++;
			}
		
			int rows = 0;
			// determines the rows in the array
			for(int i = 0; i<10; i++)
			{
				if (temporaryArray[i][0] != null)
					rows++;
		  
			} 
			// creates a two- dimensional ragged array
			double[][] array = new double[rows][];
		
			int columns = 0;
			// loops through the rows of the temporay array
			for(int i = 0; i<rows; i++)
			{
				// loops through the columns of the temporary array 
				for (int j = 0; j< 10; j++)
				{
					
					if (temporaryArray[i][j] != null)
						columns++;
				}
				// creates a row in the ragged array
				array[i] = new double[columns];
				//stores the value of the temporary array's row in the array
				for(int column =0; column <columns; column++)
				{
					array[i][column] = Double.parseDouble(temporaryArray[i][column]);
				}
				// sets the number of columns for the next row to 0
				columns = 0;
			} 
		
			inFile.close();
			return array;
		}
		
	}
	
	/**
	 * writes the value of an array to a file
	 * @param data - two dimensional array
	 * @param outputFile - file to write the values
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		// creates a PrintWriter object
		try (PrintWriter outFile = new PrintWriter(outputFile))
		{
			
			for(int row =0; row < data.length; row++)
			{
				for (int column =0; column < data[row].length; column++) 
				{
					// writes each value of the data array's row in a line of the file
					outFile.print(data[row][column] +" ");
				}
				// prints a new line in the file
				outFile.println();
			}
			outFile.close();
		}
	}
	
	/**
	 *  returns the sum of all the elements in the two Dimensional ragged array
	 * @param data - two dimensional ragged array
	 * @return total - sum of all the elements in the array
	 */
	public static double getTotal(double[][] data)
	{
		// computes the sum of all the values in the array
		double total = 0.0;
		for(int i =0; i < data.length; i++)
		{
			for(int j =0; j< data[i].length; j++)
			{
				total += data[i][j];
			}
		}
		return total;
	}
	
	/**
	 * computes the average of all the elements in the array
	 * @param data - two dimensional array
	 * @return average -  the average of the elements in the two dimensional array
	 */
	public static double getAverage(double[][] data)
	{
		int numberOfElements = 0;
		double total = 0.0;
		for(int i =0; i < data.length; i++)
		{
			for(int j =0; j< data[i].length; j++)
			{
				// computes the total
				total += data[i][j];
				// increments the number elements in the array
				numberOfElements++;
			}
		}
		//computes the average
		double average = total / numberOfElements;
		return average;
	}
	
	/**
	 * computes the sum of all the elements in a row
	 * @param data - two dimensional array
	 * @param row - row index
	 * @return rowTotal - sum of the row
	 */
	public static double getRowTotal(double[][] data, int row)
	{
		double rowTotal = 0.0;
		for(int column=0; column < data[row].length; column++)
		{
			// sums all the values of a row
			rowTotal += data[row][column];
		}
		
		return rowTotal;
	}
	
	/**
	 *  sums a column of the  two dimensional array
	 * @param data -  two dimensional array
	 * @param column - column index
	 * @return
	 */
	public static double getColumnTotal(double[][] data, int column)
	{
		double columnTotal = 0.0;
		for(int row =0; row < data.length; row++)
		{
			// ensures the row contains the column
			if (column < data[row].length)
				columnTotal += data[row][column];
		}
		return columnTotal;
	}
	
	/**
	 * gets the highest value of a row
	 * @param data -  two dimensional array
	 * @param row - row index
	 * @return higestInRow
	 */
	public static double getHighestInRow(double[][] data, int row)
	{
		// stores the highest value in a row
		double highestInRow = data[row][0];
		for(int column =1; column < data[row].length; column++)
		{
			if(highestInRow < data[row][column])
			{
				highestInRow =  data[row][column];
			}
		}
		return highestInRow;
		
	}
	
	
	
	/**
	 * gets the index of the highest value in a row
	 * @param data -  two dimensional array
	 * @param row - row index
	 * @return index 
	 */
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		// gest the higest value in the row
		double highestElement = getHighestInRow(data, row);
		int index =0; // stores the index of the highest value in the array
		for (int j =0; j< data[row].length; j++)
		{
			if (data[row][j] == highestElement)
				index = j;
		}
		return index;
		
	}
	
	/**
	 * finds the lowest value in the row
	 * @param data -  two dimensional array
	 * @param row - row index
	 * @return lowestInRow
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		// stores the lowest value in the row
		double lowestInRow = data[row][0];
		for(int column =0; column < data[row].length; column++)
		{
			if (data[row][column] < lowestInRow)
			{
				lowestInRow = data[row][column];
			}
		}
		return lowestInRow;
	}
	
	/**
	 *  finds the index of the lowest element in a row
	 * @param data -  two dimensional array
	 * @param row - row index
	 * @return index
	 */
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		// gets the lowest value in a row 
		double lowestInRow = getLowestInRow(data, row);
		int index = 0; // stores the index of the  lowest value in a row
		for(int column = 0; column < data[row].length; column++)
		{
			if (data[row][column] == lowestInRow)
				index = column;
		}
		return index;
	}
	
	/** 
	 * gets the highest value in a column
	 * @param data -  two dimensional array
	 * @param column - column index
	 * @return highestInColumn
	 */
	public static double getHighestInColumn(double[][] data, int column)
	{
		// stores the higest value in a columnn
		double highestInColumn = 0;
		for(int row=0; row< data.length; row++)
		{
			// ensures the row contains the column
			if (column < data[row].length)
			{
				if(data[row][column] > highestInColumn)
					highestInColumn = data[row][column];
			}
		}
		return highestInColumn;
	}
	
	/**
	 * gets the index of the highest value in a column
	 * @param data -  two dimensional array
	 * @param column - column index
	 * @return index
	 */
	public static int getHighestInColumnIndex(double[][] data, int column)
	{
		// gets the highest value in the column
		double highestInColumn = getHighestInColumn(data, column);
		int index = 0; // the index of the highest value in a column
		for(int row =0; row < data.length; row++)
		{
			if (column < data[row].length)
			{
				// ensures the row contains the column
				if (data[row][column] == highestInColumn)
					index = row;
			}
			else
				continue;
			
		}
		return index;
	}
	
	/**
	 * gets the lowest value in a column
	 * @param data -  two dimensional array
	 * @param column - column index
	 * @return lowestInColum
	 */
	public static double getLowestInColumn(double[][] data, int column)
	{
		// gets the highest value in the column as the lowest value
		double lowestInColumn = getHighestInColumn(data, column);
		for( int row = 0; row < data.length; row++)
		{
			// ensures the row contains the column
			if (column < data[row].length)
			{
				// checks if the current value is less than the lowestInColumn
				if (data[row][column] < lowestInColumn)
				{
					lowestInColumn = data[row][column];
				}
			}
		}
		return lowestInColumn;
	}
	
	
	/**
	 *  gets the index of the lowest value in a column
	 * @param data -  two dimensional array
	 * @param column - column index
	 * @return index
	 */
	public static int getLowestInColumnIndex(double[][] data, int column)
	{
		// gets the lowest in the column
		double lowestInColumn = getLowestInColumn(data, column);
		int index =0; // stores the index of the lowest in a column
		for(int row =0; row < data.length; row++)
		{
			// ensures the row contains the column
			if (column < data[row].length)
			{
				if (data[row][column] == lowestInColumn)
					index = row;
			}
		}
		return index;
	}
	
	/**
	 * 
	 *  finds the highest element in the array
	 * @param data -  two dimensional array
	 * @return highestInArray
	 */
	public static double getHighestInArray(double[][] data)
	{
		double highestInArray = data[0][0];
		for (int row =0; row < data.length; row++)
		{
			for (int column =0; column < data[row].length; column++)
			{
				if (data[row][column] > highestInArray)
					highestInArray = data[row][column];
			}
		}
		return highestInArray;
	}
	
	/**
	 * finds the lowest elements in the array
	 * @param data -  two dimensional array
	 * @return lowestInArray
	 */
	public static double getLowestInArray(double[][] data)
	{
		// stores the lowest value in an array
		double lowestInArray = data[0][0];
		for (int row =0; row < data.length; row++)
		{
			for (int column =0; column < data[row].length; column++)
			{
				if (data[row][column] < lowestInArray)
					lowestInArray = data[row][column];
			}
		}
		return lowestInArray;
	}
}
