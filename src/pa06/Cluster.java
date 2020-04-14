import java.util.ArrayList;
import java.util.Random;
public class Cluster {
    //Step 1 is to assign random cluster points
    public Cluster(ArrayList<Sample> list, int numbercluster,ArrayList<Sample> clusters){
        //picks a random element in the array of samples to use as the cluster point
        for(int i=0;i<numbercluster;i++){
            Random rand=new Random();
            int index = rand.nextInt(list.size());
            Sample ClusterPoint=list.get(index);
            clusters.add(ClusterPoint);
        }
        //test to see that clusters have been randomly chosen
        for(int j=0;j<clusters.size();j++){
            Sample x=clusters.get(j);
            System.out.println(x.getvalue(0));
            System.out.println(x.getvalue(1));
        }
    }
}