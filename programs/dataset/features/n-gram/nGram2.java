import java.io.*;
import java.util.*;
import java.io.*;

public class nGram2
{
	public static int maxIndex = 0;
	public static String nGrams(String token , int n)throws StringIndexOutOfBoundsException
	{
		String ngram = "";

		int maxStartIndex = token.length() - n;
		if(maxStartIndex > maxIndex){
			maxIndex = maxStartIndex;
		}
		for(int i = 0; i <= maxStartIndex; i++){
			ngram = ngram + token.substring(i,i+n) ;
			ngram = ngram + "\t";
		}
		if(maxStartIndex<21){
			for(;maxStartIndex<22;maxStartIndex++){
				ngram = ngram + "null";
				ngram = ngram + "\t";
			}
		}
		
		//int lastTabIndex = ngram.lastIndexOf("\t");
		 		
		 return ngram ;   //.substring(0,tabStartIndex);
	}
	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		String inputFile = "../data/all_tokens.txt";
		String outputFile = "../data/nGrams.txt"; 

		try{
			Scanner sc = new Scanner(new File(inputFile));
			FileWriter fw = new FileWriter(outputFile);
			BufferedWriter bw = new BufferedWriter(fw); 
			String buf = null;

			while(sc.hasNextLine())
			{
				buf = sc.nextLine();
				String temp = buf;
				while(!temp.equals("EOL")){
					//System.out.println("Token inner: "+temp);
					bw.write(temp + "\t");
					bw.write(nGrams(temp,1));
					bw.write(nGrams(temp,2));
					bw.write(nGrams(temp,3));
					bw.write(nGrams(temp,4));
					bw.write(nGrams(temp,5));
					bw.newLine();
					bw.flush();
					temp = sc.nextLine();

				}
				bw.write(temp+ "\n");
				bw.flush();
				//System.out.println("Token outter: "+temp);
			}
			bw.close();
			fw.close();
			sc.close();
			System.out.println(maxIndex);

		}catch(IOException exp){
			exp.printStackTrace();
		}


	}


}