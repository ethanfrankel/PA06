import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class KMeans{
    ArrayList<Sample> OriginalData;
    ArrayList<Sample> cluster= new ArrayList<Sample>();
    public KMeans() {
        this.OriginalData = new ArrayList<Sample>();
        this.cluster = new ArrayList<Sample>();
    }
    public ArrayList<Sample> getClusters() {
        return this.cluster;
    }
    public ArrayList<Sample> getOriginalData() {
        return this.OriginalData;
	}
    public static void main(String[] args)throws FileNotFoundException {
        Scanner console=new Scanner(System.in);
        System.out.println("what is the file location e.g. C:/Users/redso/Desktop/s1-cb.txt");
        String location=console.nextLine();
        System.out.println("how many clusters");
        int clusters=console.nextInt();
        //Everything below this line in main method left to see how the classes and code interract.
        //In the final version we will take this code out
        KMeans mean=new KMeans();
        //initializes the 2 array lists
        ArrayList<Sample> OriginalData=mean.getOriginalData();
        ArrayList<Sample> cluster=mean.getClusters();
        //the method that reads and sorts the data into original data
        readFile(location,OriginalData);
        //how to use the difference class
        Sample z=OriginalData.get(0);
        Sample c=OriginalData.get(1);
        Sample sampletest=new Sample();
        System.out.println("DIFFERENCE BETWEEN 2 SAMPLES: "+sampletest.difference(z,c));
        //An example of how to fill the cluster array with random samples
        Cluster cluster1=new Cluster(OriginalData, clusters,cluster);
    }
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
}