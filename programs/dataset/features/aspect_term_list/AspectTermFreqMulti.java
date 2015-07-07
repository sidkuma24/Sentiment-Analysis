import java.io.*;
import java.util.*;
import java.io.*;

public class AspectTermFreqMulti
{
	public static void main(String args[])throws IOException, ClassNotFoundException
	
	{
			String inputFile = args[0];
			String outputFile = "aspectTerm_list2.txt";
			String [] delim ={" ","-",":",","};
			try{
				Scanner sc = new Scanner(new File(inputFile));

				FileWriter fw = new FileWriter(outputFile);
	    		BufferedWriter bw = new BufferedWriter(fw);

				while(sc.hasNextLine()){
					String buf  = sc.nextLine();
					boolean multi = false;
					for(int i = 0; i<delim.length;i++){
						String result[] = buf.split(delim[i]);
						if(result.length>1){
							multi = true;
						}
					}

					if(multi){
						bw.write(buf);
						bw.newLine();
						bw.flush();
					}

				}
				bw.close();
				fw.close();
				sc.close();

			}catch(IOException ex){
				ex.printStackTrace();
			}


	}
}