import java.io.*;
import java.util.*;
import java.io.*;

public class localContext
{
	public static String getContext(String token, int size)
	{

	}

	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		String inputFile = "../data/all_tokens.txt";
		String outputFile = "../data/local_context.txt"; 

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
					bw.write(temp);
					bw.write("\t");
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


		}catch(IOException exp){
			exp.printStackTrace();
		}
	}

}