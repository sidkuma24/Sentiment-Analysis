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
						br.mark(4);
					}
					//System.out.println("inner line:"+ currentLine);
					String [] previous =  new String[2];
					Sgtring [] next =  new String[2];
					int pc =  0;
					int nc = 0;
					while(pc<context){
				 		previous[pc]=br.readLine();
				 		System.out.println(previous[pc]);
				 		pc++:
				 	}
				 	while

				
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