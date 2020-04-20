import java.util.ArrayList;
import java.util.*;
/**
 * A Sample represents a vector of doubles to be used in a clustering algorithm...
 * @author presenting
 *
 */

public class Sample {
	/**
	*@param sample is the Arraylist which stores the data (doubles) that we will be grouping into clusters.
	*@loc is an int used for testing purposes that does not influence the class
	*/
	ArrayList<Double> sample;
	int loc;
	//regular constructor for filling the arraylist of samples from file
	public Sample(double[] values) {
		this.sample = new ArrayList<Double>();
		for (int i=0; i<values.length; i++) {
			sample.add(values[i]);
		}	
	}
	//default constructor for sample class
	public Sample() {
		
	}
	//returns the value (double) associated with the appropriate sample 
	public double getvalue(int i){
		return sample.get(i);
	}
	//returns how many samples there are 
	public double getlength(){
		return sample.size();
	}
	//used for testing purposes
	public void setloc(Sample s1,int index){
		s1.loc=index;
	}
	//used for testing purpoes
	public int  getloc(){
		return this.loc;
	}
	//utilization of the Pythagorean Theorem to calculate distance, based on their associated doubles, between two Samples. 
	public double difference(Sample s1, Sample s2) {
		//difference between samples
		double x=s1.getvalue(0)-s2.getvalue(0);
		x=x*x;
		double y=s1.getvalue(1)-s2.getvalue(1);
		y=y*y;
		double z=x+y;
		z=Math.sqrt(z);
		return z;
	}
	//String representation of a Sample
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
