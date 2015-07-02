import java.io.*;
import java.util.*;
import java.io.*;

public class MakeDataSet
{
	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		int nFiles = Integer.parseInt(args[0]);
		String outputFile1 = "train.txt";
		String outputFile2 = "test.txt";
		String [] tokens = new String[2000];
		String  buf = null;
		int tokCount = 0;
		FileWriter fw1 = new FileWriter(outputFile1);
	    BufferedWriter bw1 = new BufferedWriter(fw1);
	    FileWriter fw2 = new FileWriter(outputFile2);
	    BufferedWriter bw2 = new BufferedWriter(fw2);
		try{

			for(int i = 0 ; i<nFiles;i++){

				String inputFile = i + "_aspectTerm.txt";
				System.out.println(inputFile);
				String blankLine = null;
				Scanner sc =  new Scanner(new File(inputFile));
				int sentenceCount = 0;
				while(sc.hasNextLine()){
	    			
	    			boolean flag1  = false;
	    			boolean flag2  = false;
	    			while(((buf = sc.nextLine()).compareTo("EOL")!=0 )){

	    				tokens[tokCount] = buf;
	    				//System.out.println("tokens[" + tokCount + "] = " + tokens[tokCount]);
	    				tokCount++;


	    			}

	    			sentenceCount++;
	    			if(sentenceCount > 2 && sentenceCount < 4){
	    				for(int r =0 ;r<tokCount;r++){
	    				//System.out.println("inside for" + tokens[i]);
	    					bw2.write(tokens[r]+"\n");
	    					flag2 = true;
	    					bw2.flush();
	    				}
	    				sentenceCount = 0;
	    			}else{
	    				for(int p =0 ;p<tokCount;p++){
	    				//System.oul.println("inside for" + tokens[i]);
	    					bw1.write(tokens[p]+"\n");
	    					flag1 = true;
	    					bw1.flush();
	    				}
	    			}
	    			tokCount = 0;
	    			if(flag1){
	    				bw1.write("EOL\n");
	    				bw1.flush();
	    			}
	    			if(flag2){
	    				bw2.write("EOL\n");
	    				bw2.flush();
	    			}

	    			
	    			//bw.flush();
	    		}
	    		sc.close();
	    		//bw1.close();
	    		//bw2.close();
	    	}
	    }catch(IOException ex){
			ex.printStackTrace();
		}
	}
}