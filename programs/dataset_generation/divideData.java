import java.io.*;
import java.util.*;
import java.io.*;


class ClassFileLine{
	public String token = null;
	public String tokenAspect = null;



}
class Sentence{
	public String [] tokens = null;
	public int nAspectTerms = 0;
	public int nNonAspectTerms = 0;

	public Sentence(int n)
	{
		tokens = new String[n];
	}
}
public class divideData{

	public static int nAspectTerms = 0;
	public static int nNonAspectTerms = 0;    
	
	public static int [] aspectTokenCount = new int[20];
	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		int upperLimit = Integer.parseInt(args[1]) + 1;
		int lowerLimit = upperLimit - 2;
		Scanner sc = null;
		String inputFile = args[0];
		String outputFile = args[1] + "_aspectTerm.txt";
		
		FileWriter fw = new FileWriter(outputFile);
	    BufferedWriter bw = new BufferedWriter(fw);
	    String buf = null;
	    String [] tokens = new String [2000];
	    int tokCount = 0;
	    try{

	    	sc = new Scanner(new File(inputFile)); 

	    	while(sc.hasNextLine()){
	    			boolean flag  = false;
	    		while((buf = sc.nextLine()).compareTo("EOL")!=0){
	    			//System.out.print(buf);
	    			tokens[tokCount] = buf;

	    			//.out.println("tokens[" + tokCount + "] = " + tokens[tokCount]);
	    			tokCount++;
	    			String [] result = buf.split("\t");

	    			for(int j=0;j<result.length;j++){
						result[j].trim();
					}
					if(result[1].compareTo("0")==0){
						nNonAspectTerms++;
					}else{
						nAspectTerms++;
					}	


	    		}
	    		//System.out.println(nAspectTerms);
	    		if( nAspectTerms < upperLimit && nAspectTerms >lowerLimit ){
	    		//	System.out.println("inside if");
	    			for(int i =0 ;i<tokCount;i++){
	    				//System.out.println("inside for" + tokens[i]);
	    				bw.write(tokens[i]+"\n");
	    				flag = true;
	    				bw.flush();
	    			}
	    		}
	    		tokCount=0; 
	    		nAspectTerms =0;
	    		nNonAspectTerms =0;
	    		bw.flush();
	    		if(flag)
	    		bw.write("EOL\n");
	    		//bw.flush();
	    		
	  	 	}
	  	 	bw.close();
	    }
	    catch(IOException ex) {
           
             ex.printStackTrace();
        }

	}
}