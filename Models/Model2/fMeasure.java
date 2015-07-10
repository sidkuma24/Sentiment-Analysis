import java.io.*;
import java.util.*;
import java.io.*;

public class fMeasure
{

	public static String inFile= "output";
	public static String outFile = "model_evaluation.txt";

	public static float Recall(float tp,float fn)
	{
		float recall = tp/(tp+fn);
		return recall;
	}

	public static float Precision(float tp, float fp)
	{
		float prec = tp/(tp + fp);
		return prec;

	}

	public static void main(String args[])throws IOException, ClassNotFoundException
	{
		 int tn  = 0;
		 int tp = 0;
		 int fn = 0;
		 int fp =0;
		 int tokCount = 0;
 
		try{
			Scanner sc = new Scanner(new File(inFile));
		//	String buf = null;
			while(sc.hasNextLine()){
				String buf = sc.nextLine();
				String curLine = buf;
				while(!curLine.equals("EOL")){
					tokCount++;
					String [] result = curLine.split("\t");
					//System.out.println("inner token:"+result[0]);
					if(result.length >40){
					//System.out.println("tokens true class: "+result[result.length-2] + "token predicted class:" + result[result.length-1]);
						if(result[result.length-2].equals(result[result.length-1])){
							if(result[result.length-2].equals("0")){
								tn++;
							}else{
								tp++;
							}
						}else{
							if(result[result.length-2].equals("0")){
								fp++;
							}else{
								fn++;
							}

						}
					}
					curLine = sc.nextLine();

				}
				tokCount++;
				String [] temp = buf.split("\t");
			//System.out.println("outter tokens:"+curLine);				
			}
			sc.close();
			float prec = Precision(tp,fp)*100;
			float recall = Recall(tp,fn)*100;
			float fm = (2*prec*recall)/(prec+recall);
			System.out.println("True Positive = "+tp);
			System.out.println("True Negative = "+tn);
			System.out.println("False positive ="+fp);
			System.out.println("False Negative = "+fn);
			System.out.println();
			System.out.println("Precision="+prec);
			System.out.println("Recall="+recall);

			System.out.println("F-Measure="+fm);

		}catch(IOException exp){
			exp.printStackTrace();
		}
	}


}