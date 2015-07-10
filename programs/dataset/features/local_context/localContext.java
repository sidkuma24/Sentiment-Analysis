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
		String inputFile = "../../../../data/sentiment/features/all_tokens.txt";
		String outputFile = "../../../../data/sentiment/features/local_context.txt"; 
		//String tokenFile = "../data/all_tokens.txt";
		int context = Integer.parseInt(args[0]);
		Scanner sc_main = new Scanner(new File(inputFile));
		FileWriter fw = new FileWriter(outputFile);
	    	BufferedWriter bw = new BufferedWriter(fw);
		String buf  = null;
		int count =0;
		try{
				while(sc_main.hasNextLine()){

					String [] prev = new String[2];
					String [] next =  new String[2];
					int senLength = 0;
					buf  = sc_main.nextLine();
					String temp = buf;
					String [] sentenceBuf = new String[2000]; 
					
					while(!temp.equals("")){
						System.out.println("count = "+ count++ );
						sentenceBuf[senLength] = temp;
						senLength++;
						//System.out.println("temp:"temp+ "senBuf:"sentenceBuf[senLength]);
						temp = sc_main.nextLine();
					}
					
					String [] sentence = new String[senLength+context*3];
					//sentence[0] = "NULL";
					//sentence[1] = "NULL";
					//for(int k=0;k<context;k++){
					//	sentence[k] = "NULL";
					//}
					//sentence[senLength] = "NULL";
					//sentence[senLength+1] = "NULL";
					//sentence[senLength+2] = "NULL";
					//sentence[senLength+3] = "NULL";
					//sentence[senLength+4] = "NULL";
					for(int j =context;j<=senLength+context;j++){
						sentence[j] = sentenceBuf[j-context];
					}
					for(int i=context;i<senLength+context;i++){
						bw.write(sentence[i]);
						for(int n=context;n>=1;n--){
							bw.write("\t"+sentence[i-n]);
						}
						for(int p=context;p>=1;p--){
							bw.write("\t"+sentence[i+p]);
						}
				
						bw.write("\n");
						
						bw.flush();	
					}
					bw.write("\n");
					bw.flush();

				}
				bw.flush();
				bw.close();
				fw.close();
				sc_main.close();


		}catch(IOException exp){
			exp.printStackTrace();
		}
	}

}