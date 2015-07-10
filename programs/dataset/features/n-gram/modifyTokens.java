import java.io.*;
import java.util.*;
import java.io.*;


public class modifyTokens
{
	public static void main(String args[])throws IOException, ClassNotFoundException
	{

		String outputFile = "mod_tokens.txt";
		String inputFile = "../../../../data/sentiment/features/all_tokens.txt";
		String buf = null;
		int size = Integer.parseInt(args[0]);
		
	

		try{
			Scanner sc = new Scanner(new File(inputFile));
			
			FileWriter fw = new FileWriter(outputFile);
	    	BufferedWriter bw = new BufferedWriter(fw);

	    	while(sc.hasNextLine()){
	    		buf = sc.nextLine();
	    		String temp = buf;
	    		while(!temp.equals("")){
					
					String token = temp;
					if(token.length()>size){
						token = token.substring(0,0+size);
					}else{
						for(int j = token.length();j<=size+1;j++){
							token = token + "_";
						}
					}
					bw.write(token + "\n");
					bw.flush();
					temp = sc.nextLine();
	    		}
	    		bw.write("\n");
	    		bw.flush();
	    		
	    	
	    	}
	    	bw.close();
	    	fw.close();
	    	sc.close();


		}catch(IOException excp){
			excp.printStackTrace();
		}	
	}
}