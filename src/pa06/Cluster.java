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

}
