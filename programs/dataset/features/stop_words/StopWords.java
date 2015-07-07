import java.io.*;
import java.util.*;
import java.io.*;

public class StopWords
{
	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		String inputFile = "../data/all_tokens.txt";
		String outputFile = "../data/all_stop_words.txt";
		//String stop_words_list = args[0]; 

		try{
			Scanner sc = new Scanner(new File(inputFile));
			

			//FileWriter fw = new FileWriter(outputFile);
			//BufferedWriter bw = new BufferedWriter(fw);

			while(sc.hasNextLine())
			{
			String buf = sc.nextLine();
				String temp = buf;
				while(!temp.equals("EOL")){
					//Scanner sc1 = new Scanner(new File(stop_words_list));
					/*boolean isStopWord = false;
					while(sc1.hasNextLine()){
						String stopWord = sc1.nextLine();
						
						if(stopWord.equals(temp)){
							isStopWord = true;
						}
					}
					if(isStopWord){
					//	bw.write(temp + "\t" + "1" + "\n");
					//	bw.flush();
					}else{
					//	bw.write(temp + "\t" + "0" + "\n" );
					//	bw.flush();
					}
					//bw.flush();
					sc1.close();*/
					
					temp = sc.nextLine();
				}
				System.out.println("outter token:" +temp);
				//bw.write("EOL" + "\n");
				//bw.flush();
			}
		//	bw.close();
		//	fw.close();
			sc.close();


		}catch(IOException exp){
			exp.printStackTrace();
		}
		
	}
}