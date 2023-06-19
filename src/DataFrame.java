import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** the DataFrame class reads in a csv file and stores it as a 2D double array
 * 
 * 
 * @author Nick Nikolov
 *
 */
public class DataFrame {
	private String[] headerNames;
	private double data[][];
	private int numOfRows;
	private int numOfCols;
	
	/**The DataFrame constructors accepts the properly formatted csv file and stores it in a 2D array (data)
	 * 
	 * @param fileName (String) - file name that stores the csv data
	 * @throws FileNotFoundException - if csv file is not in the working directory
	 */
	
	public DataFrame (String fileName) throws FileNotFoundException {
		Scanner reader = new Scanner (new File(fileName));
		this.headerNames = reader.nextLine().strip().split(","); //remove all trailing and leading white space from headers, and store headers as String Array
		this.data = new double [100][getNumOfCols()]; //initialize a new data object, 2D array
		
		while(reader.hasNextLine()) { // while loop until end of fild
			
			String[] currentLine = reader.nextLine().strip().split(","); //split each line at comma since data is in a csv
			
			for (int i = 0; i < currentLine.length; i++) {
				data[numOfRows][i] = Double.parseDouble(currentLine[i]);
			}
			this.numOfRows++;
		}
		reader.close(); // close file
	}
	
	/** getter method for all header names in the data set
	 * 
	 * @return headerNames (String[]) - name of all data headers
	 */
	
	public String[] getHeaderNames() {
		return this.headerNames;
	}
	
	/** getter method for number of rows in the dataset
	 * 
	 * @return numOfRows (int) - number of rows in the data set
	 */
	public int getNumOfRows() {
		return this.numOfRows;
	}
	
	/** getter method for number of columns in the dataset 
	 * 
	 * @return numOfCols (int) - number of columns in the data set
	 */
	public int getNumOfCols() {
		this.numOfCols = this.headerNames.length;		
		return this.numOfCols;
	}
	
	/** Used to print sample of the current data set
	 * @return prints 5 rows of the data set along with header names (String)
	 */
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Arrays.toString(this.headerNames) + "\n" + "-".repeat(Arrays.toString(this.headerNames).length())); // prints the headers and adds the horizontal line
		
		for (int j = 0; j < 5; j++) { 
			sb.append("\n |"); // create a new line each row
			for (int i = 0; i < numOfCols; i ++) {
				sb.append(" " + data[j][i] + " |");
			}
		}
		return sb + ""; //add remainder of print data
	}
	
	/** getColumnIndex will slice one column from the dataframe given the index of the column, store as a DataSeries object
	 * 
	 * @param i (int) - index for the column to print data from
	 * @return dataColum (DataSeries) - one column from the overall dataframe
	 */
	public DataSeries getColumnByIndex(int i) {
		DataSeries dataColumn = new DataSeries(this.headerNames[i]);
		for (int j = 0; j < this.numOfRows; j++) { // must store all rows in the dataframe for the column picked
			dataColumn.add(data[j][i]);
		}
		return dataColumn;
	}

}
