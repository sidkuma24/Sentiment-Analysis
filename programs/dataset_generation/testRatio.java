import java.io.*;
import java.util.*;
import java.io.*;

public class testRatio
{
	public static void main(String args[])
	{
		int nAspectToks = 0;
		int nNonAspectToks = 0;
		String inputFile = args[0];
		 String [] tokens = new String [2000];
		 String buf = null;
		  int tokCount = 0;
		  Scanner sc  = null;
		
		try{

	    	sc = new Scanner(new File(inputFile)); 

	    	while(sc.hasNextLine()){
	    			
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
						nNonAspectToks++;
					}else{
						nAspectToks++;
					}	


	    		}
	    	
	    		tokCount=0; 
	    	
	    		
	    		
	    		
	  	 	}
	  	 	System.out.println("No of aspect tokens = " + nAspectToks);
	  	 	System.out.println("No of non aspect tokens = " + nNonAspectToks);

	  	 	
	    }
	    catch(IOException ex) {
           
             ex.printStackTrace();
        }


	}
}