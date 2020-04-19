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

	//regular constructor for filling the arraylist of samples from file
	public Sample(double[] values) {
		this.sample = new ArrayList<Double>();
		for (int i=0; i<values.length; i++) {
			sample.add(values[i]);
		}
	}
	//default constructor if you want to use difference class
	public Sample() {

	}
	double getvalue(int i){
		return sample.get(i);
	}
	double getlength(){
		return sample.size();
	}

	double difference(Sample s1, Sample s2) {
		//difference between samples
		System.out.println(s1);
		System.out.println(s2);
		double SumofSquare=0;
		for(int i=0;i<s2.getlength();i++){
			double sum=s1.getvalue(i)-s2.getvalue(i);
			sum=sum*sum;
			SumofSquare=SumofSquare+sum;
		}
		return Math.sqrt(SumofSquare);
	}

	public String toString() {
		String string = "(";
	    for (int i = 0; i < this.sample.size(); i++) {
	      //this if statement essentially does not print a comma after the last item in list
	      if (i == this.sample.size() - 1) {
	        string = string + this.sample.get(i);
	      }
	      else {
	        string = string + this.sample.get(i) + ", ";
	      }
	    }
	    string = string + ")";
	    return string;
	}
}
