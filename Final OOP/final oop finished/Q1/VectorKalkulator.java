//Name: Nopparat pengsuk
//ID:	6288103
//Section: 2

import java.util.Arrays;

public class VectorKalkulator {
	
	public static double[] normalize(double[] v, double a, double b)
	{
		/*********** YOUR CODE HERE **********/
		if(v == null) return v;
		if(v.length == 0 ) return v;
		// find max and min.
		double min = v[0];
		double max = v[0];
		for (double d : v) {
			if(d > max) max = d;
			if(d < min) min = d;	
		}
		int i = 0;
		double[] ans = new double[v.length];
		for (double d : v) {
			ans[i++] = a + ((d - min) * (b-a))/(max - min);
		}
		return ans;
		/*************************************/
	}
	
	public static double getDispersion(double[] v)
	{	
		/*********** YOUR CODE HERE **********/
		if(v == null) return 0;
		if(v.length == 0 ) return 0;
		//find mean
		double mean = 0;
		for (double d : v) {
			mean += d;
		}
		mean = mean/v.length;

		double sum = 0;
		for (double d : v) {
			double temp = (d - mean) * (d - mean);
			sum+= temp;
		}
		return Math.sqrt(sum/v.length);
		/*************************************/
	}
	
	
	public static double getSimilarity(double[] v, double[] u)
	{	
		/*********** YOUR CODE HERE **********/
		if(v == null || u == null) return 0;
		if(v.length == 0 || u.length == 0 || v.length != u.length) return 0;
		//find numerator
		double sumV_U = 0;
		for (int i = 0; i < v.length; i++) {
			sumV_U+= v[i] * u[i];
		}
		//find denominator
		double sumOfVpow = 0;
		for (double d : v) {
			sumOfVpow += d * d;
		}
		double sumOfUpow = 0;
		for (double d : u) {
			sumOfUpow += d * d;
		}
		return (sumV_U) / (Math.sqrt(sumOfVpow) * Math.sqrt(sumOfUpow));	//num/de
		/*************************************/
	}
	
	public static double getCorrelation(double[] v, double[] u)
	{	
		/*********** YOUR CODE HERE **********/
		if(v == null || u == null) return 0;
		if(v.length == 0 || u.length == 0 || v.length != u.length) return 0;
		//find mean of u and v
		double meanV = 0, meanU = 0;
		for (double d : u) {
			meanU += d;
		}
		for (double d : v) {
			meanV += d;
		}
		meanU = meanU/u.length;
		meanV = meanV/v.length;
		//find correlation
		double lazy = 0;
		for (int i = 0; i < v.length; i++) {
			lazy += (v[i] - meanV) * (u[i] - meanU);
		}
		double lazy2 = 0;
		for (int i = 0; i < v.length; i++) {
			lazy2 += (v[i] - meanV) * (v[i] - meanV);
		}
		double lazy3 = 0;
		for (int i = 0; i < u.length; i++) {
			lazy3 += (u[i] - meanU) * (u[i] - meanU);
		}
		double almost = Math.sqrt(lazy2 * lazy3);
		return lazy/almost;
		
		
		/*************************************/
	}
	
	public static final double[][] TS = {
			{1.0,2.0,3.0}
			,{1.0,2.0,3.0, 4.0, 5.0}
			, {2.0, 2.0, 4.0, 4.0, 5.0}
			, {-196.98,207.86,243.70,264.56,-214.30,-126.94,-164.64,-32.06,181.67,-396.00,-73.63,-427.30,-446.77,-474.93,-267.93,102.66,50.89,-235.12,-113.04,-124.76}
			,{-288.989,-68.393,-362.069,36.873,-429.698,-486.577,467.129,252.667,-8.407,373.118,-125.544,177.174,-124.259,-48.189,-272.786,126.882,496.493,-467.062,-235.184,96.166}
			, null
	};
	
	public static void testStudent()
	{
		System.out.println(">> DATA");
		for(int i = 0; i < TS.length; i++)
		{
			System.out.println("["+i+"]"+Arrays.toString(TS[i]));
		}
		
		System.out.println("\n>> Test Normalization");
		for(int i = 0; i < TS.length; i++)
		{
			System.out.println("NORM ["+i+"] = "+Arrays.toString(normalize(TS[i], 0, 1)));
		}
		
		System.out.println("\n>> Test Dispersion");
		for(int i = 0; i < TS.length; i++)
		{
			System.out.println("DISP ["+i+"] = "+getDispersion(TS[i]));
		}
		
		System.out.println("\n>> Test Similarity");
		System.out.println("SIM (TS[1],TS[2]) = "+getSimilarity(TS[1], TS[2]));
		System.out.println("SIM (TS[3],TS[4]) = "+getSimilarity(TS[3], TS[4]));
		System.out.println("SIM (TS[2],TS[3]) = "+getSimilarity(TS[2], TS[3]));
		System.out.println("SIM (TS[0],TS[5]) = "+getSimilarity(TS[0], TS[5]));
		
		System.out.println("\n>> Test Correlation");
		System.out.println("CORR (TS[1],TS[2]) = "+getCorrelation(TS[1], TS[2]));
		System.out.println("CORR (TS[3],TS[4]) = "+getCorrelation(TS[3], TS[4]));
		System.out.println("CORR (TS[2],TS[3]) = "+getCorrelation(TS[2], TS[3]));
		System.out.println("CORR (TS[0],TS[5]) = "+getCorrelation(TS[0], TS[5]));
	}

	public static void main(String[] args)
	{
		testStudent();
	}
}
