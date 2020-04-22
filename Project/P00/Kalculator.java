//Name: Nopparat Pengsuk
//ID: 6288103
//Section: sec 2
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math; 

public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	//**************************************
	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */
	Kalculator()
	{
		//******INSERT YOUR CODE HERE***********
		
		//**************************************
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	private ArrayList lst = new ArrayList();
	private Double[] ary = new Double[0];

	public void addNumber(double number)
	{	//******INSERT YOUR CODE HERE***********
		lst.add(number);

		// -------store number in  ary--------- \\
		ary = Arrays.copyOf(ary, ary.length +1);
		ary[ary.length-1] = number ;


		//**************************************
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(lst.isEmpty()){
			lst.add(0);	
			lst.clear();
		}else lst.remove(0);
		
		

		//**************************************
	}
	
	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		int size =lst.size();
		if(lst.isEmpty()){
			lst.add(0);
			lst.clear();
		}else lst.remove(size-1);
		
		

		//**************************************
	}
	
	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	private double sum =0;



	public double getSum()
	{
		//******INSERT YOUR CODE HERE***********
		for (Object object : lst) {
			sum += (double)object;
		}
		
		return sum;
		//**************************************
	}
	
	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		if(lst.isEmpty()){
			return 0;
		}
		return sum/lst.size();
		//**************************************
	}
	
	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		//******INSERT YOUR CODE HERE***********
		if(lst.size()<2) return 0;
		double mean = sum/lst.size();
		int size = lst.size() - 1;
		double sumOflst = 0;
		for (Double double1 : ary) {
			double x = (double1 - mean) * (double1 - mean);
			sumOflst += x;
		}
		double y = sumOflst/size;
		double std = Math.sqrt(y);
		
		return std;
		//**************************************
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
		if(lst.isEmpty()){
			return 0;
		}
		double max = (double) lst.get(0);
		for (Object object : lst) {
			if((double)object > max){
				max = (double)object;
			}
		}
		return max;
		//**************************************
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		//******INSERT YOUR CODE HERE***********
		if(lst.isEmpty()){
			return 0;
		}
		double min =(double)lst.get(0);
		for (Object object : lst) {
			if((double)object < min){
				min = (double)object;
			}
		}
		return min;
		//**************************************
	}
	
	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		
		double[] Max = new double[3];
		if(lst.isEmpty() || lst.size() < k)
		return null;
		int count = 0;
		int i = ary.length;
		while (count!=3) {
			Max[count] = ary[i-1];
			count ++;
			i --;
		}
		
		return Max;
		
		//**************************************
	}
	
	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		double[] Min = new double[3];
		if(lst.isEmpty() || lst.size() < k)
		return null;
		for (int i = 0; i < 3; i++) {
			Min[i] = ary[i];
		}

		return Min;
		//**************************************
	}
	
	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{
		//******INSERT YOUR CODE HERE***********
		sorting();
		System.out.println("DATA["+lst.size()+"]:"+lst);
		//**************************************
	}
	// just sort nothing speacial \\
	public void sorting(){
		Arrays.sort(ary);
		
	}
}
