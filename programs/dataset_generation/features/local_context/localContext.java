import java.io.*;
import java.util.*;
import java.io.*;

public class localContext
{
	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		String inputFile = "../data/all_tokens.txt";
		String outputFile = "../data/local_context.txt"; 

		try{
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(outputFile);
			BufferedWriter bw = new BufferedWriter(fw); 
			String buf = null;
			String currentLine  = null;
			int context = 2;

			while((currentLine =  br.readLine())!=null){

				while(!(currentLine = br.readLine()).equals("EOL")){
					if(!currentLine.equals("null")){
						br.mark(2*context+1);
					}
					int pc = 0;
					String [] prev = new String[context];
					String [] next =  new String[context];
					String curToken = null;
					while(pc< context){
						prev[pc] = br.readLine();
						pc++;
					}
					curToken = br.readline();
					while(nc<context){
						next[nc] = br.readline();
						nc++;
					}
					if(!currentLine.equals("null")){
						br.reset();
					}
				 	

				
				}
				//System.out.println("outter line: "+ currentLine);
				
			}
			br.close();
			fr.close();
			bw.close();
			fw.close();


		}catch(IOException exp){
			exp.printStackTrace();
		}
	}

}