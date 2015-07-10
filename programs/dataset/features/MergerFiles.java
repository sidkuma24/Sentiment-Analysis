import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergerFiles {
 
	public static void main(String[] args) {
		String sourceFile1Path = "../../../data/sentiment/features/all_tokens.txt";
		String sourceFile2Path = "../../../data/sentiment/features/all_stop_words.txt";
		String sourceFile3Path = "../../../data/sentiment/features/feature_length.txt";
 		String sourceFile4Path = "../../../data/sentiment/features/prefix_suffix.txt";
 		String sourceFile5Path = "../../../data/sentiment/features/all_aspect_tokens_freq.txt";
 		String sourceFile6Path = "../../../data/sentiment/features/1Grams.txt";
 		String sourceFile7Path = "../../../data/sentiment/features/2Grams.txt";
 		String sourceFile8Path = "../../../data/sentiment/features/3Grams.txt";
 		String sourceFile9Path = "../../../data/sentiment/features/4Grams.txt";
 		String sourceFile10Path = "../../../data/sentiment/features/5Grams.txt";
 		String sourceFile11Path = "../../../data/sentiment/features/local_context.txt";
 		String sourceFile12Path = "../../../data/sentiment/features/class.txt";


		String mergedFilePath = "../../../data/sentiment/features/merged_feature.txt";
 
		File[] files = new File[20];
		files[0] = new File(sourceFile1Path);
		files[1] = new File(sourceFile2Path);
 		files[2] = new File(sourceFile3Path);
 		files[3] = new File(sourceFile4Path);
 		files[4] = new File(sourceFile5Path);
 		files[5] = new File(sourceFile6Path);
 		files[6] = new File(sourceFile7Path);
 		files[7] = new File(sourceFile8Path);
 		files[8] = new File(sourceFile9Path);
 		files[9] = new File(sourceFile10Path);
 		files[10] = new File(sourceFile11Path);
 		files[11] = new File(sourceFile12Path);






		File mergedFile = new File(mergedFilePath);
 
		mergeFiles(files, mergedFile);
	}

	
public static void mergeFiles(File[] files, File mergedFile) {
		FileInputStream fis0,fis1,fis2,fis3,fis4,fis5,fis6,fis7,fis8,fis9,fis10,fis11;
FileWriter fstream = null;
		BufferedWriter out = null;
		try {
			fstream = new FileWriter(mergedFile, true);
			 out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		
			try {
				fis0 = new FileInputStream(files[0]);
				BufferedReader in0 = new BufferedReader(new InputStreamReader(fis0));
					fis1 = new FileInputStream(files[1]);
				BufferedReader in1 = new BufferedReader(new InputStreamReader(fis1));
				fis2 = new FileInputStream(files[2]);
				BufferedReader in2 = new BufferedReader(new InputStreamReader(fis2));
				fis3 = new FileInputStream(files[3]);
				BufferedReader in3 = new BufferedReader(new InputStreamReader(fis3));
				fis4 = new FileInputStream(files[4]);
				BufferedReader in4 = new BufferedReader(new InputStreamReader(fis4));
				fis5 = new FileInputStream(files[5]);
				BufferedReader in5 = new BufferedReader(new InputStreamReader(fis5));
				fis6 = new FileInputStream(files[6]);
				BufferedReader in6 = new BufferedReader(new InputStreamReader(fis6));
				fis7 = new FileInputStream(files[7]);
				BufferedReader in7 = new BufferedReader(new InputStreamReader(fis7));
				fis8 = new FileInputStream(files[8]);
				BufferedReader in8 = new BufferedReader(new InputStreamReader(fis8));
				fis9 = new FileInputStream(files[9]);
				BufferedReader in9 = new BufferedReader(new InputStreamReader(fis9));
				fis10 = new FileInputStream(files[10]);
				BufferedReader in10 = new BufferedReader(new InputStreamReader(fis10));
				fis11 = new FileInputStream(files[11]);
				BufferedReader in11 = new BufferedReader(new InputStreamReader(fis11));



				int i;

				String aLine0,aLine1,aLine2,aLine3,aLine4,aLine5,aLine6,aLine7,aLine8,aLine9,aLine10,aLine11;
				while ((aLine0 = in0.readLine()) != null) {
					aLine1=in1.readLine();
					String[] columns1 = aLine1.split("\\t");
					aLine2=in2.readLine();
					String[] columns2= aLine2.split("\\t");
					aLine3=in3.readLine();
					String[] columns3= aLine3.split("\\t");
					aLine4=in4.readLine();
					String[] columns4= aLine4.split("\\t");
					aLine5=in5.readLine();
					String[] columns5= aLine5.split("\\t");
					aLine6=in6.readLine();
					String[] columns6= aLine6.split("\\t");
					aLine7=in7.readLine();
					String[] columns7= aLine7.split("\\t");
					aLine8=in8.readLine();
					String[] columns8= aLine8.split("\\t");
					aLine9=in9.readLine();
					String[] columns9= aLine9.split("\\t");
					aLine10=in10.readLine();
					String[] columns10= aLine10.split("\\t");
					aLine11=in11.readLine();
					String[] columns11= aLine11.split("\\t");







					if(columns1[0].equals("EOL"))
		{
		out.write("EOL");
		out.write("\n");
		out.flush();
		continue;

		}



					out.write(aLine0);
					out.write("\t");
					out.write(columns1[1]);
					out.write("\t");
					out.write(columns2[1]);
					out.write("\t");
					for( i=1;i<=6;i++)
					{
					out.write(columns3[i]);
					out.write("\t");


					}
					
					out.write(columns4[1]);
					out.write("\t");

					for( i=0;i<=4;i++)
					{
					out.write(columns5[i]);
					out.write("\t");
					}
					for( i=0;i<=4;i++)
					{
					out.write(columns6[i]);
					out.write("\t");
					}
					for( i=0;i<=4;i++)
					{
					out.write(columns7[i]);
					out.write("\t");
					}
					for( i=0;i<=4;i++)
					{
					out.write(columns8[i]);
					out.write("\t");
						}
						for( i=0;i<=4;i++)
					{
					out.write(columns9[i]);
					out.write("\t");

					}
					
					for( i=1;i<=8;i++)
					{
						
					out.write(columns10[i]);
					out.write("\t");

					}
					

					out.write(columns11[1]);


					out.write("\n");


					
				}

				in0.close();
			} catch (IOException e) {
				e.printStackTrace();
			}


}
}
