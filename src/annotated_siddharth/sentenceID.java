import java.io.*;
import java.util.*;
import java.io.*;

public class sentenceID
{
	public static int sentenceCount = 0;
	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		Scanner sc = null;
		String senIDPrefix = args[1];
		String textFile = null;
		String outFile = "./ID/"+"id_" + args[0]; 
		FileWriter fw = new FileWriter(outFile);
	    BufferedWriter bw = new BufferedWriter(fw);


		try{

			sc = new Scanner(new File(args[0]));
			String buf = null;

			while(sc.hasNextLine()){

				buf = sc.nextLine();
				sentenceCount++;
					String [] result = buf.split("category=",2);
				   //for (int x=0; x<result.length; x++)
                     // System.out.println(result[x]);
				   
               	String [] result0 = result[0].split("\t");
               	String [] result1 = null;
               	    //for (int x=0; x<result0.length; x++)
                     //System.out.println(result0[x]);
                if(result.length > 1){
                    	result1 = result[1].split("\t");
               	       // for (int x=0; x<result1.length; x++)
                       // System.out.println(result1[x]);
                }
                String senID = Integer.toString(sentenceCount);
                String finalSenID = senIDPrefix +"_"+ senID;
                if(result0.length>2 ){
                
				    bw.write(finalSenID);
					bw.write("\t");
					bw.write(result0[1]);
					bw.write("\t");
					bw.write(result0[2]);
					if(result0.length>3){
						for(int j = 3 ; j<result0.length;j++){
							bw.write("\t");
							bw.write(result0[j]);
						}

					}
					if(result.length>1){
						bw.write("\t");
						bw.write("category="+result[1]);
					}
					bw.write("\n");
					bw.flush();
					//bw.close();
				}
			    
			}
		}
		catch(IOException ex) {
           
             ex.printStackTrace();
        }
          
    }
}