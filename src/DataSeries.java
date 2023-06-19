import java.util.Arrays;

/** The DataSeries class calculates various statistics for a 1D array
 * 
 * @author Nick Nikolov
 *
 */
public class DataSeries implements IBasicStats{
	
	private String label;
	private double data[];
	private int count;
	
	
	/** The DataSeries constructor accepts the header label and initializes a 1D array of size 100
	 * 
	 * @param l (String) - header label for the column of data
	 */
	public DataSeries(String l) {
		this.label = l;
		this.data = new double [100];
		this.count = 0;
	}
	
	/**
	 * 
	 * @param n (double) - current input to be added to the data column
	 */
	
	public void add(double n) {
		data[count] = n;
		count++;
	}
	
	/** getter method for the current number of filled data rows.
	 * 
	 * @return count (int) - the number of rows that were filled with non-zero data
	 */
	
	public int size() {
		return this.count;
	}
	
	/**
	 * @return min (double) - the minimum of all values in the data column
	 */
	public double getMin() {
		double min = data[1];
		for (int i = 1; i < count; i ++) {
			if (min > data[i]) {
				min = data[i];
			}
		}
		return min;
	}
	
	/**
	 * @return max (double) - the maximum of all values in the data column
	 */
	public double getMax() {
		double max = data[1];
		for (int i = 1; i < count; i ++) {
			if (max < data[i]) {
				max = data[i];
			}
		}
		return max;
	}
	
	/**
	 * @return sum (double) - the sum of all values in the data column
	 */
	public double getSum() { //add rounding to this for display
		double sum = 0;
		for (int i = 0; i < count; i ++) {
			sum += data[i];
		}
		return sum;
	}
	
	/**
	 * @return mean (double) - the mean of all values in the data column
	 */
	public double getMean() {
		return getSum() / this.count;
	}
	
	/**
	 * 
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) { 
			sb.append(" "+data[i]);
		}
		return this.label + " " + "[" + sb + "]"; //add remainder of print data
	}


}
