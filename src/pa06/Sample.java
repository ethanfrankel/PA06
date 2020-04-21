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
	int loc;
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
	void setloc(Sample s1,int index){
		s1.loc=index;
	}
	int  getloc(){
		return this.loc;
	}
	
	double difference(Sample s1, Sample s2) {
		//difference between samples
		double x=s1.getvalue(0)-s2.getvalue(0);
		x=x*x;
		double y=s1.getvalue(1)-s2.getvalue(1);
		y=y*y;
		double z=x+y;
		z=Math.sqrt(z);
		return z;
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