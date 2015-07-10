import java.io.*;
import java.util.*;
import java.io.*;

public class StopWords
{
	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		String inputFile = "../../../../data/sentiment/features/all_tokens.txt";
		String outputFile = "../../../../data/sentiment/features/all_stop_words.txt";
		String stop_words_list = "stop_words_list.txt"; 

		try{
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
			String token = null;
			while((token = br.readLine())!=null)
			{
				boolean isStopWord = false;
				if(!token.equals("")){
					BufferedReader br1 = new BufferedReader(new FileReader(stop_words_list));
					String stopWord = null;
					while((stopWord = br1.readLine())!=null){
						if(token.equals(stopWord)){
							isStopWord = true;
						}
					}
					br1.close();
					if(isStopWord){
						bw.write(token+"\t"+"1"+"\n");
						bw.flush();
					}else{
						bw.write(token+"\t"+"0"+"\n");
						bw.flush();
					}
				}else{
					bw.write(""+"\n");
					bw.flush();
				}
				
				
			
			}
			br.close();
			bw.close();
			//fw.close();
			//sc.close();


		}catch(IOException exp){
			exp.printStackTrace();
		}
		
	}
}