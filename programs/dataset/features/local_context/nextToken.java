import java.io.*;
import java.util.*;
import java.io.*;

public class localContext
{
	public static void getContextWord(String filename, int n)throws IOException
	{
		Scanner scMain = new Scanner(new File(filename));


	}
	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		String inputFile = args[0];
		String outputFile = "../data/local_context.txt"; 
		String tokenFile = "../data/all_tokens.txt";
		int context = 2;
		Scanner sc_main = new Scanner(new File(inputFile));
		
		String buf  = null;

		try{
				while(sc_main.hasNextLine()){
					String [] prev = new String[2];
					String [] next =  new String[2];
					int senLength = 0;
					buf  = sc_main.nextLine();
					String temp = buf;
					String [] sentenceBuf = new String[2000]; 
					
					while(!temp.equals("EOL")){
						
						sentenceBuf[senLength] = temp;
						senLength++;
						temp = sc_main.nextLine();
					}
					String [] sentence = new String[senLength];
					for(int j =0;j<sentenceBuf.length();j++){
						sentence[j] = sentenceBuf[j];
					}
					for(int i=0;i<sentence.length();i++){
						bw.write(sentence[i]);
						if(sentence[i-2]!=null)
							bw.write("\t"+sentence[i-2]);
						else
							bw.write("\t"+"NULL");
						if(sentence[i-1]!=null)
							bw.write("\t"+sentence[i-1]);
						else
							bw.write("\t"+"NULL");
						if(sentence[i+1]!=null)
							bw.write("\t"+sentence[i+1]);
						else
							bw.write("\t"+"NULL");
						if(sentence[i+2]!=null)
							bw.write("\t"+sentence[i+2]);
						else
							bw.write("\t"+"NULL");
						bw.write("\n");
						bw.flush();
					}
					bw.write("EOL");
					bw.flush();

				}
				bw.close();
				fw.close();


		}catch(IOException exp){
			exp.printStackTrace();
		}
	}

}