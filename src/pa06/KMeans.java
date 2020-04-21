package pa06;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class KMeans{
    /**
    *@param OriginalData is the field that represents the original data (the entire 
    * row of samples) that we later manipulated and placed into clusters.
    *@param cluster is the list of clusters that will contain Samples 
    */
    ArrayList<Sample> OriginalData;
    ArrayList<Sample> cluster= new ArrayList<Sample>();
    public KMeans() {
        this.OriginalData = new ArrayList<Sample>();
        this.cluster = new ArrayList<Sample>();
    }
    //getter method
    public ArrayList<Sample> getClusters() {
        return this.cluster;
    }
    //getter method
    public ArrayList<Sample> getOriginalData() {
        return this.OriginalData;
	}
    public static void main(String[] args)throws FileNotFoundException {
        /**
	*@param console will take the user data from the file location to be used for the set of Samples
	*@param clusters will be the "k" value that the user chooses to be divided into k-means
	*@param mean is the kmeans variable to get the original data and clusters
	*@@param cluster1 is the first or only cluster depending on how many clusters are desired. 
	*/
	Scanner console=new Scanner(System.in);
        System.out.println("what is the file location e.g. C:/Users/redso/Desktop/s1-cb.txt");
        String location=console.nextLine();
        System.out.println("how many clusters");
        int clusters=console.nextInt();
        KMeans mean=new KMeans();
        ArrayList<Sample> OriginalData=mean.getOriginalData();
        ArrayList<Sample> cluster=mean.getClusters();
        readFile(location,OriginalData);
        Cluster cluster1=new Cluster(OriginalData, clusters,cluster);
        ArrayList<ArrayList<Sample>> nest = new ArrayList<ArrayList<Sample>>();
        //we have an array list of array lists. the main branch represents the number of clusters. The branches of the brancehs represent the data grouped with that cluster
        for(int f=0;f<clusters;f++){            nest.add(new ArrayList<Sample>());
        }
        //iterate 100 times
        for(int iteration=0;iteration<100;iteration++){
            reclassify(OriginalData,cluster,nest);
            newCluster(nest, cluster);
            nest.clear();
            for(int g=0;g<clusters;g++){
                nest.add(new ArrayList<Sample>());
            }
            
        }
        //print cluster final. 
        print(cluster);
    }
	
	/**
	* @param location is the location of the file
	* @param OriginalData is the set of Samples that we will use in the simulation
	*/
	//parses file and reads for double values to use as Samples
    public static String readFile(String location,ArrayList OriginalData) throws FileNotFoundException{
        //reads file and puts each sample into original data arraylist
        File names = new File(location);
        Scanner scnr = new Scanner(names);
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            String[] newline=line.split("\\s+");
            double[] p1 = new double[2];
            int count=0;
            for(int i=0;i<newline.length;i++){
                if(newline[i].length()==0){

                }
                else{
                    p1[count] = Double.parseDouble(newline[i]);
                    count=count+1;
                }
            }
            Sample sample=new Sample(p1);
            OriginalData.add(sample);
        }
        return "ERROR";
    }
	/**
	* This method will reclassify points into clusters as necessary. It does so
	* by using nested for loops to compare each clusterPoint to each Sample in the set so that the
	* Sample closest to that clusterPoint will be placed in the correct cluster.
	*
	*/
    public static void reclassify(ArrayList<Sample> OriginalData,ArrayList<Sample> cluster,ArrayList<ArrayList<Sample>> nest){
	    for(int i=0;i<OriginalData.size();i++){
            double count = 0;
            int ClusterIndex = 0;
            for(int j=0;j<cluster.size();j++){
                Sample samplePoint = OriginalData.get(i);
                Sample clusterPoint = cluster.get(j);
                Sample sampletest = new Sample();
                double dif=sampletest.difference(samplePoint,clusterPoint);
                if(j == 0){
                    count = dif;
                }
                if(dif<count){
                    count = dif;
                    ClusterIndex = j;
                }
            }
            nest.get(ClusterIndex).add(OriginalData.get(i));
            count = 0;
            ClusterIndex = 0;
        }
    }
    /**
    * This newCluster method will generate a new cluster in addition to the first one 
    * and fill up the remaining slots in each ArrayList of Samples based initially on the 
    * randomly generated clusterPoint, and then on the centroid which will be a Sample that 
    * represents the average of all the Samples in that specific cluster. 
    */
    public static void newCluster(ArrayList<ArrayList<Sample>> nest,ArrayList<Sample> cluster){
        for(int i=0;i<nest.size();i++){
            double sumx=0;
            double sumy=0;
            for(int j=0;j<nest.get(i).size();j++){
                sumx=sumx+nest.get(i).get(j).getvalue(0);
                sumy=sumy+nest.get(i).get(j).getvalue(1);
            }
            sumx=sumx/nest.get(i).size();
            sumy=sumy/nest.get(i).size();
            double[] test=new double[2];
            test[0]=sumx;
            test[1]=sumy;
            Sample average=new Sample(test);
            cluster.set(i,average);
        }
    
    }
	/**
	* This method will "print out the k-means simualtion by 
	* showing us going through the clusters and demonstrating
	* what Sample is assigned to what cluster based on its centroid or average value. 
	* @param xcoord and @param ycoord are used to represent the doubles that make up
	* the Sample. 
	*/
    public static void print(ArrayList<Sample> cluster){
        for(int q=0;q<cluster.size();q++){
            double xcoord = cluster.get(q).getvalue(0);
            double ycoord = cluster.get(q).getvalue(1);
            System.out.println("Cluster point "+(q+1)+" assigned to "+"("+xcoord+","+ycoord+")");
        }
    }
}
