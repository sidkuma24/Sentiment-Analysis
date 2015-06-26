import java.io.*;
import java.util.*;
import java.io.*;

class Annotater
{
	public String [] aspectTerms = null;
	public String [] aspectPol = null;
	public String name = null;
	public int [] aspectTermVote ;
	public int [] aspectPolVote ;
	public int aspectTermPrintFlag ;

	public Annotater(int n)
	{
		
		aspectTerms = new String[n];
		aspectPol = new String[n];
		aspectTermVote = new int[n];
		aspectPolVote = new int[n];
		
	}
}
//System.out.println("checkString loop counter i="+ i);//for debugging
public class MajorityVoting{

	public static boolean isUniqueAspectTerm(String [] searchString, String inString)
    {
 		for(int i = 0;i<searchString.length;i++){
 			
 			if((searchString[i]!=null) && (searchString[i].compareTo(inString))==0){
				return false;
			}
		}
		return true;
    }

    public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
    }

	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		Scanner sc = null;
		String inputFile = args[0];
		String outputFile = args[0] + "_out.txt";
		String sen_id = null;
		String [] aspectTermBuf1 = null;
		String [] aspectTermBuf1_result = null;
        String [] aspectTermBuf2 = null;
		String [] aspectTermBuf2_result = null;
		String [] aspectTermBuf3 = null;
		String [] aspectTermBuf3_result = null;
		FileWriter fw = new FileWriter(outputFile);
	    BufferedWriter bw = new BufferedWriter(fw);
	    String tempAspectTerm = null;
	    Annotater [] annotater = new Annotater[3];
	    String [] aTermBuf = new String[20];

		try{

			sc = new Scanner(new File(inputFile));
			String buf = null;

			while(sc.hasNextLine()){

				buf = sc.nextLine();
				/*get the sen_id and aspect terms for all the annotaters*/
				String [] result = buf.split("\t");

				for(int j=0;j<result.length;j++){
					result[j].trim();
					//System.out.println(result[j]);
				}
				System.out.println("Sentence ID:"+result[0]);
				System.out.println("Siddharth:");
				if(result.length>1){
					aspectTermBuf1 = result[1].split(";");
					annotater[0] = new Annotater(aspectTermBuf1.length);
				
					if(aspectTermBuf1 != null){
						for(int j=0;j<aspectTermBuf1.length;j++){
							//System.out.println(aspectTermBuf1[j]);
							aspectTermBuf1_result = aspectTermBuf1[j].split(":");
							if(aspectTermBuf1_result != null){
								
								for(int k = 0 ; k < aspectTermBuf1_result.length;k++){
									aspectTermBuf1_result[k].trim();
									System.out.println(aspectTermBuf1_result[k]);
								}
								annotater[0].aspectTerms[j] = aspectTermBuf1_result[0];
								annotater[0].aspectPol[j] = aspectTermBuf1_result[1];
							}
						}
						annotater[0].name = "Siddharth";
					}
				}
				System.out.println("Geeta:");
				if(result.length>2){
					 aspectTermBuf2 = result[2].split(";");
					 annotater[1] = new Annotater(aspectTermBuf2.length);
					if(aspectTermBuf2 != null){
						for(int j=0;j<aspectTermBuf2.length;j++){
							//System.out.println(aspectTermBuf2[j]);
							aspectTermBuf2_result = aspectTermBuf2[j].split(":");
							if(aspectTermBuf2_result != null){
								for(int k = 0 ; k < aspectTermBuf2_result.length;k++){
									aspectTermBuf2_result[k].trim();
									System.out.println(aspectTermBuf2_result[k]);

								}
								annotater[1].aspectTerms[j] = aspectTermBuf2_result[0];
								annotater[1].aspectPol[j] = aspectTermBuf2_result[1];
							}
						}
						annotater[1].name = "Geeta";
					}
				}
				System.out.println("Pooja:");
			    if(result.length>3){
					aspectTermBuf3 = result[3].split(";");
					annotater[2] = new Annotater(aspectTermBuf3.length);
					if(aspectTermBuf3 != null){
						for(int j=0;j<aspectTermBuf3.length;j++){
							//System.out.println(aspectTermBuf3[j]);
							aspectTermBuf3_result = aspectTermBuf3[j].split(":");
							if(aspectTermBuf3_result != null){
								for(int k = 0 ; k < aspectTermBuf3_result.length;k++){
									aspectTermBuf1_result[k].trim();
									System.out.println(aspectTermBuf3_result[k]);

								}
								annotater[2].aspectTerms[j] = aspectTermBuf3_result[0];
								annotater[2].aspectPol[j] = aspectTermBuf3_result[1];
							}
						}
						annotater[2].name = "Pooja";
					}
				}
				System.out.println("\n");

				for(int j=0 ; j<annotater.length;j++){
					System.out.println(annotater[j].name);
					for(int k=0;k<annotater[j].aspectTerms.length;k++){
						System.out.println(annotater[j].aspectTerms[k]);
					}
				}

				/*
				 * comparing the aspect terms to find the majority vote if
				 * at least 2 are commom else choose a random aspect term and
				 * its corresponding polarity
				 */
				
				//annotater 1 and 2
				for(int i = 0;i<annotater[0].aspectTerms.length;i++){
					for(int j=0;j<annotater[1].aspectTerms.length;j++){
						if(annotater[0].aspectTerms[i].compareTo(annotater[1].aspectTerms[j]) == 0){
							annotater[0].aspectTermVote[i]++;
							System.out.println("annotater[0].aspectTermVote[i]:"+ annotater[0].aspectTermVote[i]);
							annotater[1].aspectTermVote[j]++;
						}
					}
				}

				//annotater 1 and 3
				for(int i = 0;i<annotater[0].aspectTerms.length;i++){
					for(int j=0;j<annotater[2].aspectTerms.length;j++){
						if(annotater[0].aspectTerms[i].compareTo(annotater[2].aspectTerms[j]) == 0){
							annotater[0].aspectTermVote[i]++;
							annotater[2].aspectTermVote[j]++;
						}
					}
				}

				//annotater 2 and 3
				for(int i = 0;i<annotater[1].aspectTerms.length;i++){
					for(int j=0;j<annotater[2].aspectTerms.length;j++){
						if(annotater[1].aspectTerms[i].compareTo(annotater[2].aspectTerms[j]) == 0){
							annotater[1].aspectTermVote[i]++;
							annotater[2].aspectTermVote[j]++;
						}
					}
				}
				bw.write(result[0]);
                boolean majoritySet = false;

				for(int i=0;i<annotater.length;i++){
					int aTermCount = 0;
					for(int j=0;j<annotater[i].aspectTermVote.length;j++){
						
						if(annotater[i].aspectTermVote[j]>=1){

							majoritySet = true;
							if(isUniqueAspectTerm(aTermBuf,annotater[i].aspectTerms[j])){
								aTermBuf[aTermCount++] = annotater[i].aspectTerms[j];
								bw.write("\t");
								bw.write(annotater[i].aspectTerms[j]);
								
								bw.write(":");
								bw.write(annotater[i].aspectPol[j]);
							}
						}
					}
				}
				if(!majoritySet){
					int i = randInt(0,annotater.length)-1;
					int aTermCount = 0;
					int j = randInt(0,annotater[i].aspectTermVote.length)-1;
    				if(isUniqueAspectTerm(aTermBuf,annotater[i].aspectTerms[j])){
						aTermBuf[aTermCount++] = annotater[i].aspectTerms[j];
						bw.write("\t");
						bw.write(annotater[i].aspectTerms[j]);
						bw.write(":");
						bw.write(annotater[i].aspectPol[j]);
					}
				}
				bw.write("\n");
				bw.flush();
			}
			bw.flush();

		}
		catch(IOException ex) {
           
             ex.printStackTrace();
        }

	}
}

