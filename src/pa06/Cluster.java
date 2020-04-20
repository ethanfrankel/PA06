package pa06;

import java.util.ArrayList;
import java.util.Random;
public class Cluster {
	ArrayList<Sample> clusterArray;
	ArrayList<Sample> sampleArray;
	int numClusters;

    //Step 1 is to assign random cluster points
    public Cluster(ArrayList<Sample> list, int numbercluster,ArrayList<Sample> clusters){
    	this.clusterArray = clusters;
    	this.sampleArray = list;
    	this.numClusters = numbercluster;
        //picks a random element in the array of samples to use as the cluster point
        for(int i=0;i<this.numClusters;i++){
            Random rand=new Random();
            int index = rand.nextInt(this.sampleArray.size());
            Sample clusterPoint=this.sampleArray.get(index);
            this.clusterArray.add(clusterPoint);
        }
        //test to see that clusters have been randomly chosen
        for(int j=0;j<this.clusterArray.size();j++){
            Sample x=this.clusterArray.get(j);
            System.out.println(x.getvalue(0));
            System.out.println(x.getvalue(1));
        }
    }
	
	
	
	
	public double difference(Sample s1, Sample s2) {

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
    
    public void calcClustMean() {
    	double distance=0;
    	int numOfAdds = 0; 
    	int i = 0;
    	for (i=0;i<clusterArray.size()-1;i++) {
    		distance+=difference(clusterArray.get(i),clusterArray.get(i+1));
    		numOfAdds++;
    	}
    	
    	this.clustMean = distance / numOfAdds;
    }
    
    public void addSample(Sample sample) {
    	this.sampleArray.add(sample);
    }

}
