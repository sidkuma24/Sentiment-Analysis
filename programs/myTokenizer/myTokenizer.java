import java.io.*;
import java.util.*;


public class myTokenizer
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("all_aspect_terms.txt"));
		BufferedReader br1 = new BufferedReader(new FileReader("all_tokens.txt"));
	//	BufferedReader hindi.output = new BufferedReader(new FileReader("all_aspect_terms.txt"));
	//	BufferedReader br2 = new BufferedReader(new FileReader("all_tokens.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("class.txt") );
		
		
		int n_sentences = 5993;
		
		try{
			for(int i=0;i<n_sentences;i++){
				System.out.println("iter:"+i);
				String [] sentenceBuf = new String[1000];
				int tokCount = 0;
				String token = null;
				while(!(token = br1.readLine()).equals("EOL")){
				System.out.println(token);
					sentenceBuf[tokCount] = token;
					tokCount++;
				}
				String aspectTerm = null;
				String [] aspectTermBuf = new String[20];
				int aTokCount =0;
				while(!(aspectTerm = br.readLine()).equals("EOL")){
					aspectTermBuf[aTokCount] = aspectTerm;
					//System.out.println(aspectTerm);
					aTokCount++;
				}
				int count = 1;
				Process p;
				if(aTokCount>0){
					for(int t=0;t<aTokCount;t++){
						BufferedWriter bwTemp = new BufferedWriter(new FileWriter("hindi.input") );
						bwTemp.write(aspectTermBuf[t]);
						p = Runtime.getRuntime().exec("sh ./tokenizer.sh");
						p.waitFor();
						BufferedReader brTemp = new BufferedReader(new FileReader("hindi.output"));
						String buf = null;
						String [] aspectTokens = new String[50];
						int aspectTokenCount = 0;
						while((buf=brTemp.readLine())!=null){
							if(buf.equals("<Sentence id=\"1\">") || buf.equals("</Sentence>")){

							}else{
								String [] result = buf.split("\t");
								aspectTokens[aspectTokenCount] = result[0];
								aspectTokenCount++;
							}
						}
						int c=0;
						while(aspectTokenCount>0){

							System.out.println(aspectTokens[c++]);
							aspectTokenCount--;
						}

					}
					/*for(int j=0;j<tokCount;j+=count){
						count = 1;
						for(int k=0;k<aTokCount;k++){
								//System.out.println("sentence token  = "+sentenceBuf[j]);
								//System.out.println("aspectTerm length = "+aspectTermBuf[k].length());
								if(sentenceBuf[j].length()<=aspectTermBuf[k].length()){
									System.out.println("outter if :"+sentenceBuf[j]);
									System.out.println("outter if :"+aspectTermBuf[k]);
									//System.out.println(aspectTermBuf[k].substring(0,sentenceBuf[j].length()));
									if(sentenceBuf[j].equals(aspectTermBuf[k].substring(0,sentenceBuf[j].length()))){
										System.out.println("aspectTerm:"+aspectTermBuf[k]);
										System.out.println("sentence token:"+sentenceBuf[j]);
										bw.write(sentenceBuf[j]+"\t"+"B_ASP"+"\n");
										bw.flush();
										System.out.println("sentence token length :"+sentenceBuf[j].length());
										System.out.println("aspectTerm length"+aspectTermBuf[k].length());
										String remAspectTerm = aspectTermBuf[k].substring(sentenceBuf[j].length(),aspectTermBuf[k].length()).trim();
										System.out.println("remaining AT:"+remAspectTerm);
										int remLength =  remAspectTerm.length();
										String prevToken = null;
										String nextToken = null;
										System.out.println("remaining length:"+remLength);
										while(remLength>0){
											nextToken = sentenceBuf[j+count];
											bw.write(nextToken+"\t"+"I_ASP"+"\n");
											System.out.println("remaining length"+remLength);
											remAspectTerm = remAspectTerm.substring(nextToken.length(),remAspectTerm.length());
											remAspectTerm =  remAspectTerm.trim();
											remLength = remAspectTerm.length();
											count++;
										}
									}else{
										bw.write(sentenceBuf[j]+"\t"+"0"+"\n");
										bw.flush();
										//count++;
									}
								}else{
									bw.write(sentenceBuf[j]+"\t"+"0"+"\n");
									bw.flush();
									//count++;
								}

						}
					}*/
				}else{
					for(int p=0;p<tokCount;p++){
						//System.out.println(sentenceBuf[p]);
						bw.write(sentenceBuf[p]+"\t"+"0"+"\n");

						bw.flush();
					}
				}
				bw.write("EOL"+"\t"+"0"+"\n");
				bw.newLine();
				bw.flush();
			}
			bw.close();
			br.close();
			br1.close();

			
		}catch(IOException exp){
				exp.printStackTrace();
			}
	}
}
