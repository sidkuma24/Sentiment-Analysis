import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.*;
import java.util.*;
 
public class GetClassFromXML {
	public static int totalTokens = 0;
	public static int totalAspectTokens = 0;
 
  public static void main(String args[]) {
 
  //	String outputFile = "class.txt";
  	String outputFile = "../../data/sentiment/features/class.txt";
//  	String aspectTermFile = "../../data/sentiment/features/all_aspect_terms.txt";
 // String aspectTokens = "../../data/sentiment/features/all_aspect_tokens";

    try {

    	FileWriter fw = new FileWriter(outputFile);
	    BufferedWriter bw = new BufferedWriter(fw);

 		//	FileWriter fw2 = new FileWriter(aspectTermFile);
	  //  BufferedWriter bw2 = new BufferedWriter(fw2);

	    //FileWriter fw3 = new FileWriter(aspectTokens);
	    //BufferedWriter bw3 = new BufferedWriter(fw3);

	    File xmlFile1 = new File(args[0]);
		DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
		Document doc1 = dBuilder1.parse(xmlFile1);

		
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc1.getDocumentElement().normalize();
		//doc2.getDocumentElement().normalize();
		//doc3.getDocumentElement().normalize();
		
 
		//System.out.println("Root element :" + doc1.getDocumentElement().getNodeName());
		//System.out.println("Root element :" + doc2.getDocumentElement().getNodeName());
		//System.out.println("Root element :" + doc3.getDocumentElement().getNodeName());

		NodeList nList1 = doc1.getElementsByTagName("sentence");
		////NodeList nList2 = doc2.getElementsByTagName("sentence");
		//	NodeList nList3 = doc3.getElementsByTagName("sentence");
 
		
 
		for (int temp = 0; temp < nList1.getLength(); temp++) {	
			Node nNode1 = nList1.item(temp);
 			//System.out.println("\nCurrent Element :" + nNode1.getNodeName());
 
			if (nNode1.getNodeType() == Node.ELEMENT_NODE){
 
				Element eElement1 = (Element) nNode1;
				NodeList nodeList = nNode1.getChildNodes();
				Element ele = (Element) nodeList;
				String text = ele.getElementsByTagName("text").item(0).getTextContent();
				StringTokenizer st = new StringTokenizer(text," ।,");
				String [] tokText = new String [st.countTokens()];
				int tokCount = 0;
				while(st.hasMoreTokens())
				{
                   tokText[tokCount]=st.nextToken();
                   tokCount++;
				} 
				totalTokens = totalTokens + tokCount;
				//System.out.println("No of tokens = " + tokCount);
				String [] tokValue = new String[tokText.length];
				Boolean[] tokFlag = new Boolean[tokText.length];
				Arrays.fill(tokFlag, Boolean.FALSE);
				String [] aspectTermBuffer = new String[200];
				//String [] termsOfAspectTerm = new String[100];
				boolean aspectTermPresent = false;
				boolean flag1 = false;
				boolean flag2 = false;
				for(int j = 0; j < nodeList.getLength(); j++){
					Node nNode1_1 = nodeList.item(j);
					//System.out.println("\nCurrent Element :" + nNode1.getNodeName());
					if(nNode1_1.getNodeName() == "aspectTerms"){
						aspectTermPresent = true;
						//Element ele =  (Element) nNode1_1;
						NodeList nodeList1 = nNode1_1.getChildNodes();
						outer:
						for(int k =0;k<nodeList1.getLength();k++){
							Node nNode1_2 = nodeList1.item(k);
							Element ele1 = (Element) nNode1_2;
							//System.out.println("term:" + ele1.getAttribute("term"));
							//System.out.println("polarity:" + ele1.getAttribute("polarity"));
							aspectTermBuffer[k] = ele1.getAttribute("term");
							//System.out.println("aspect terms:"+ aspectTermBuffer[k]);
							//bw2.write(aspectTermBuffer[k]);
							//bw2.newLine();
							//bw2.flush();
							//System.out.println(ele1.getAttribute("term"));
						//String [] termsOfAspectTerm = aspectTermBuffer[k].split(" |,| ,|, ");
							StringTokenizer atTokenizer = new StringTokenizer(aspectTermBuffer[k],", ");
							String [] termsOfAspectTerm = new String[atTokenizer.countTokens()];
							int tc = 0;
							while(atTokenizer.hasMoreTokens())
							{
                			   termsOfAspectTerm[tc]=atTokenizer.nextToken();
                			   tc++;
							}
							
							//for(int i = 0;i<termsOfAspectTerm.length;i++){
							//	System.out.println(termsOfAspectTerm[i]);
							//}
							
							String allTokens = "../../data/sentiment/features/all_tokens.txt";
							//for(int q = 0 ;q<tokText.length;){
							BufferedReader br = new BufferedReader(new FileReader(allTokens));
							String line = null;
							while((line = br.readLine())!=null){
							//	int count = 1;
								if(termsOfAspectTerm[0].equals(line)){
									//tokValue[q] = "B_ASP";
									bw.write(line+"\t"+"B_ASP"+"\n");
								//	tokFlag[q] = true;
									//totalAspectTokens+=termsOfAspectTerm.length;
									//bw.write(tokText[q]+ "\t" + "B_ASP\n");
									bw.flush();
									if(termsOfAspectTerm.length>1){
										for(int count =1;count<termsOfAspectTerm.length;count++){
											String iToken = br.readLine();
											//if(termsOfAspectTerm[count].equals(iToken)){
												//tokValue[q+count] = "I_ASP";
												//tokFlag[q+count] = true;
												bw.write(iToken+"\t"+"I_ASP"+"\n");
												
												//bw.write( tokText[q+count]+ "\t" + "I_ASP\n");
												bw.flush();
											//}
										}
									}
									
								}else if(line.equals("")){
									bw.write(""+"\n");
									bw.flush();
								}else{
									bw.write(line+"\t"+"0"+"\n");
									bw.flush();
								}	

								
								//q+=count;
							 	bw.flush();
							}
							
							br.close();
						} 
						//System.out.println("term:" + ele.getAttribute("term"));
						//System.out.println("polarity:" + ele.getAttribute("polarity"));
					}
				
				
				}
			}
		}
		bw.flush();
		bw.close();
	}catch (Exception e) {
		e.printStackTrace();
    }
  }
 
}
