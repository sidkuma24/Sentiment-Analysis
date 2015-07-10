import java.util.*;
import java.io.*;

public class Tokenize{
	public static int totalTokens = 0;

	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		String inputFile = args[0];
		String outputFile = "all_tokens.txt";//args[0].substring(0,args[0].length-5) + "_tokens.txt";
		int tokCount = 0;

		try{

			//Scanner sc =  new Scanner(new File(inputFile));
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			FileWriter fw = new FileWriter(outputFile);
	    	BufferedWriter bw = new BufferedWriter(fw);
	    	String line = null;
	    	while((line = br.readLine())!=null){
	    		//String buf = sc.nextLine();
	    		//System.out.println(line);
	    		if(line.equals("<s>") || line.equals("")){
	    			//sc.nextLine();
	    		}
	    		else if(line.equals("</s>")){
	    			bw.write("EOL");
	    			bw.newLine();
	    			bw.newLine();
	    			//sc.nextLine();
	    			bw.flush();
	    		}else{
	    			String [] result = line.split("\t");
	    			String token = result[1];
	    			bw.write(token);
	    			tokCount++;
	    			bw.newLine();
	    			//sc.nextLine();
	    			bw.flush();
	    		}

	    	//br.flush();
	    	}
	    	bw.close();
	    	br.close();
	    	//sc.close();
	    	fw.close();
	    	System.out.println("total tokens="+tokCount);

		}catch(IOException exp){
			exp.printStackTrace();
		}
	}
}