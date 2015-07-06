import java.io.*;
import java.util.*;
import java.io.*;


public class modifyTokens
{
	public static void main(String args[])throws IOException, ClassNotFoundException
	{

		String outputFile = "mod_tokens.txt";
		String inputFile = "../data/all_tokens.txt";
		String buf = null;

		
	

		try{
			Scanner sc = new Scanner(new File(inputFile));
			
			FileWriter fw = new FileWriter(outputFile);
	    	BufferedWriter bw = new BufferedWriter(fw);

	    	while(sc.hasNextLine()){
	    		buf = sc.nextLine();
	    		String temp = buf;
	    		while(!temp.equals("EOL")){
					
					String token = temp;
					if(token.length()>9){
						token = token.substring(0,0+9);
					}else{
						for(int j = token.length();j<=10;j++){
							token = token + "_";
						}
					}
					bw.write(token + "\n");
					bw.flush();
					temp = sc.nextLine();
	    		}
	    		bw.write("EOL\n");
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