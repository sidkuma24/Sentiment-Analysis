import java.io.*;
import java.util.*;
import java.io.*;

public class combineFeature
{
	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		String inFeatureFile = args[0];
		String classFile = "../../../data/sentiment/features";

		try{

			Scanner sc = new Scanner(new File(inFeatureFile));

			while(sc.hasNextLine()){
				String buf = sc.nextLine();
				String curLine = buf;
				while(!curLine.equals("EOL")){
					String [] result  = curLine.split("\t");
				}
			}

		}catch(IOException exp){
			exp.printStackTrace();
		}


	}
}