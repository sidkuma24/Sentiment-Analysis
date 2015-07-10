import java.util.*;
import java.io.*;
class featurelength
{
	public static void main(String args[])throws FileNotFoundException, IOException
	{
		String line,c3,c0;
		String outFile = "../../../../data/sentiment/features/feature_length.txt";
		File file = new File(outFile);
		FileReader fr=new FileReader("../../../../data/sentiment/features/all_tokens.txt");
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		BufferedReader br = new BufferedReader(fr);
		while((line = br.readLine()) != null) {
      		String[] columns = line.split("\\t");
		
 		
		


		
		c0=columns[0];
		if(c0.equals(""))
		{
		bw.write("");
		bw.write("\n");
		bw.flush();
		continue;

		}
		int x= c0.length();
		bw.write(columns[0]);
		bw.write("\t");
		bw.write(String.valueOf(x) );
		
		bw.write("\n");
		bw.flush();
    		
		

		
   }
bw.close();
	}
}	
