import java.io.*;
import java.util.*;
import java.io.*;


public class AspectTermFreq
{
	public static void main(String args[])throws IOException, ClassNotFoundException
	{

		String outputFile = "../../../../data/sentiment/features/freq_aspect_tokens.txt";
		String aspectTokenFile = "../../../../data/sentiment/features/all_aspect_tokens";
		String buf = null;
		String aspectTerm = null;
		
		int f1 = 4;

		try{
			Scanner sc = new Scanner(new File(aspectTokenFile));
			
			FileWriter fw = new FileWriter(outputFile);
	    	BufferedWriter bw = new BufferedWriter(fw);

	    	while(sc.hasNextLine()){
	    		buf = sc.nextLine();
	    		int aspectTermFreq = 0;
	    		aspectTerm = buf;
	    	//	System.out.println("the at being searhed: "+aspectTerm);
	    		Scanner sc2 = new Scanner(new File(aspectTokenFile));
	    		while(sc2.hasNextLine()){
	    			String at = sc2.nextLine();
	    			if(at.compareTo(aspectTerm)==0){
	    				//System.out.println("inside if :" + at);
	    				aspectTermFreq++;
	    			}
	    		}
	    	//	System.out.println("f of the at="+aspectTermFreq);
	    		if(aspectTermFreq > f1 ){
	    			boolean alreadyPresent = false;
	    			Scanner sc3 = new Scanner(new File(outputFile));
	    			while(sc3.hasNextLine()){
	    				String line = sc3.nextLine();
	    				if(aspectTerm.compareTo(line)==0){
	    					alreadyPresent = true;
	    				}

	    			}
	    			sc3.close();
	    			if(!alreadyPresent){
	    				bw.write(aspectTerm);
	    				bw.newLine();
	    				bw.flush();
	    			}
	    		}
	    		sc2.close();

	    	}
	    	bw.close();
	    	fw.close();
	    	sc.close();


		}catch(IOException excp){
			excp.printStackTrace();
		}	
	}
}