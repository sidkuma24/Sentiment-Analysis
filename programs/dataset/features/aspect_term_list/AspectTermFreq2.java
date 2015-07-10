import java.io.*;
import java.util.*;
import java.io.*;

public class AspectTermFreq2
{
	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		String tokenFile = "../../../../data/sentiment/features/all_tokens.txt";
		String aspectTokenFile = "../../../../data/sentiment/features/freq_aspect_tokens.txt";
		String outputFile = "../../../../data/sentiment/features/all_tokens_freq.txt";

		try{
			Scanner sc0 = new Scanner(new File(tokenFile));
			FileWriter fw = new FileWriter(outputFile);
			BufferedWriter bw = new BufferedWriter(fw);
			String buf  = null;

			while(sc0.hasNextLine()){
				buf = sc0.nextLine();
				String temp = buf;

				while(!temp.equals("")){
					Scanner sc1 = new Scanner(new File(aspectTokenFile));
					boolean isFreq = false;
					while(sc1.hasNextLine()){
						String temp2 = sc1.nextLine();
						if(temp.equals(temp2)){
							isFreq = true;
						}
					}
					sc1.close();
					if(isFreq){
						bw.write(temp + "\t" + "1" + "\n");
						bw.flush();

					}else{
						bw.write(temp + "\t"+"0"+ "\n");
						bw.flush();
					}

				temp = sc0.nextLine();
				}
				bw.write("EOL\n");
			}
			bw.close();
			fw.close();
			sc0.close();

		}catch(IOException exp){
			exp.printStackTrace();
		}
	}
}