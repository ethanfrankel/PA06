package pa06;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Cluster {
    
    //accept an arraylist of samples and pick a random sample
    public Cluster(ArrayList<Sample> list){
        //picks a random element in the array of samples to use as the cluster point
        Random rand=new Random();
        int index = rand.nextInt(list.size());
        Sample ClusterPoint=list.get(index);
        //printing to verify that the clusterpoint and the random value agree
        System.out.println(ClusterPoint);
        System.out.println(index);
    }
}