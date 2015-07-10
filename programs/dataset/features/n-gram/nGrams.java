import java.io.*;
import java.util.*;
import java.io.*;

public class nGrams
{
	public static int maxIndex = 0;
	public static String nGrams(String token , int n)
	{
		String ngram = "";

		int maxStartIndex = token.length() - n;
		if(maxStartIndex > maxIndex){
			maxIndex = maxStartIndex;
		}
		for(int i = 0; i <= 4; i++){
			ngram = ngram + token.substring(i,i+n) ;
			ngram = ngram + "\t";
		}
		//int lastTabIndex = ngram.lastIndexOf("\t");
		 		
		 return ngram ;   //.substring(0,tabStartIndex);
	}
	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		String inputFile = "mod_tokens.txt";
		String outputFile = "../../../../data/sentiment/features/"+args[0]+"Grams.txt"; 
		int size = Integer.parseInt(args[0]);
		try{
			Scanner sc = new Scanner(new File(inputFile));
			FileWriter fw = new FileWriter(outputFile);
			BufferedWriter bw = new BufferedWriter(fw); 
			String buf = null;

			while(sc.hasNextLine())
			{
				buf = sc.nextLine();
				String temp = buf;
				while(!temp.equals("")){
					//System.out.println("Token inner: "+temp);
					//bw.write(temp + "\t");
					bw.write(nGrams(temp,size));
					//bw.write(nGrams(temp,2));
					//bw.write(nGrams(temp,3));
					//bw.write(nGrams(temp,4));
					//bw.write(nGrams(temp,5));
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