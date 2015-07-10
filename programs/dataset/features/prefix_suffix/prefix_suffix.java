import java.util.*;
import java.io.*;
import java.lang.*;
class prefix_suffix
{
	public static void main(String args[])throws FileNotFoundException, IOException, ArrayIndexOutOfBoundsException
	{
		String line;int i;
		String a=null;
		String inputFile = "../../../../data/sentiment/features/all_tokens.txt";
		String outputFile = "../../../../data/sentiment/features/prefix_suffix.txt";
		File file = new File(outputFile);
		FileReader fr=new FileReader(inputFile);
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		BufferedReader br = new BufferedReader(fr);
		while((line = br.readLine()) != null) {
      String[] columns = line.split("\\t");
      //System.out.println("my last column : "+ columns[1] );
	//String a=columns[1];
	if(columns[0].equals(""))
		{
		bw.write("");
		bw.write("\n");
		bw.flush();
		continue;
		}
	/*if(columns[1].equals("B_ASP")||columns[1].equals("I_ASP"))
	{*/
		int l=columns[0].length();
		bw.write(columns[0]);
		bw.write("\t");
		for(i=0;i<3;i++){
			if(i<l)
			{
			a=columns[0].substring(0,i+1);
			bw.write(a);
			}
			else
			bw.write("NULL");
			bw.write("\t");
			bw.flush();
		}
		
		for(i=1;i<=3;i++){
			if(i<=l)
			{
			
			bw.write(columns[0].substring(l-i,l));
			}
			else
			bw.write("NULL");
			bw.write("\t");
			bw.flush();
		}
		bw.write("\n");
		bw.flush();
}
bw.close();
}	
}
