package pa06;

import java.util.ArrayList;
import java.util.*;
/**
 * A Sample represents a vector of doubles to be used in a clustering algorithm...
 * @author presenting
 *
 */

public class Sample {
	ArrayList<Double> sample;
	
	public Sample(double[] values) {
		this.sample = new ArrayList<Double>();
		for (int i=0; i<values.length; i++) {
			sample.add(values[i]);
		}	
	}
	double getvalue(int i){
		return sample.get(i);
	}
	double getlength(){
		return sample.size();
	}
	public static void main(String[] args) {
		System.out.println("testing for the Sample class.");
		//add samples
		double[] p1 = {1d, 2d, 3.14, 2.71};
		double[] p2 = {0.1, 1.1, 2.1, 3.1};
		Sample s1 = new Sample(p1);
		Sample s2 = new Sample(p2);
		System.out.println("s1 = "+s1);
		System.out.println("s2 = "+s2);
		System.out.println(difference(s1, s2));
		//create an arraylist of all samples
		ArrayList<Sample> SampleList = new ArrayList<Sample>();
		SampleList.add(s1);
		SampleList.add(s2);
		//call the cluster class to pick a cluster point
		Cluster cluster=new Cluster(SampleList);
	}

	public static double difference(Sample s1, Sample s2) {
		//variance of samples as described in part 1
		double SumofSquare=0;
		for(int i=0;i<s2.getlength();i++){
			double sum=s1.getvalue(i)-s2.getvalue(i);
			sum=sum*sum;
			SumofSquare=SumofSquare+sum;
		}
		return Math.sqrt(SumofSquare);
	}
	
	public String toString() {
		String toString = "[";
	    for (int i = 0; i < this.sample.size(); i++) {
	      //this if statement essentially does not print a comma after the last item in list
	      if (i == this.sample.size() - 1) {
	    	toString = toString + this.sample.get(i);
	      }
	      else {
	    	toString = toString + this.sample.get(i) + ", ";
	      }
	    }
	    toString = toString + "]";
	    return toString;
	}
}