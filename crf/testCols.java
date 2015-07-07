import java.io.*;
import java.util.*;
import java.io.*;

public class testCols
{
	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		String inputFile = "./sentiment/train.txt";
		//String outputFile = "test_out.txt";
		int rowNum = 0;

		try{
			Scanner sc = new Scanner(new File(inputFile));

			//String buf = sc.nextLine();
			//String [] result = buf.split("\t");
			//System.out.println("no of cols = "+ result.length);
			String curSen = null;
			while(sc.hasNextLine()){
				curSen = sc.nextLine();
				rowNum++;
				String [] col = curSen.split("\t");
				if(curSen.equals("EOL")){
					System.out.println(curSen);
				}
				else if(col.length != 40){
					System.out.println("row:"+rowNum + "\t"+"no of cols="+ col.length);

					return;
				}else{
					System.out.println( "rows:" + rowNum +" has " + col.length + "cols");
				}


			}
		}catch(IOException exp){
			exp.printStackTrace();
		}

	}
}