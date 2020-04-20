import java.util.ArrayList;
import java.util.Random;
/**
* Cluster is a grouping of Samples that split the overall population into subdivisions 
* in which all members or samples share similar characterisitcs, in this case distance 
* or proximity to one another. 
*/
public class Cluster {
    //Step 1 is to assign random cluster points
    public Cluster(ArrayList<Sample> list, int numbercluster,ArrayList<Sample> clusters){
        //A for loop to pick a random element in the array of samples to use as the cluster point
         /**
         *@param list is the overall data set made out of Samples
         *@param numbercluster is the number of clusters there are
         *@param clusters is another ArrayList but instead to hold the samples which belong to
         *their respective cluster. 
         */
            for(int i=0;i<numbercluster;i++){
            Random rand=new Random();
            int index = rand.nextInt(list.size());
            System.out.println("Initial cluster "+(i+1)+"  at index "+index+" of original data");
            Sample ClusterPoint=list.get(index);
            clusters.add(ClusterPoint);
          /**
          * Each cluster will have a randomly assigned clusterPoint that will be the beginning
          * basis for each. We add @param clusterPoint to @param clusters because it will be
          * the first point that we can test distance to other points with. 
          * @param index helps us generate a random number from 0 to however many elements
          * there are in our overall list of Samples.
          *
          */
        }
        //a test to see that clusters have been randomly chosen
        for(int j=0;j<clusters.size();j++){
            Sample x=clusters.get(j);
            
        }
    }
}
