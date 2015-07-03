import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.*;
import java.util.*;
 
public class parseText {
 
  public static void main(String args[]) {
 
  //	String outputFile = "class.txt";
  	String outputFile = "all_tokens.txt";
  	String aspectTermFile = "aspectTerms.txt";

    try {

    	FileWriter fw = new FileWriter(outputFile);
	    BufferedWriter bw = new BufferedWriter(fw);

 		FileWriter fw2 = new FileWriter(aspectTermFile);
	    BufferedWriter bw2 = new BufferedWriter(fw2);

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
 
		System.out.println("no of sentences= "+ nList1.getLength());
 
		for (int temp = 0; temp < nList1.getLength()/2; temp++) {		//nList1.getLength()
			
			//first annotater
			Node nNode1 = nList1.item(temp);
 			//System.out.println("\nCurrent Element :" + nNode1.getNodeName());
 
			if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
 
				Element eElement1 = (Element) nNode1;
 
				System.out.println("sentence id : " + eElement1.getAttribute("id"));
				//bw.write(eElement1.getAttribute("id"));
				//bw.write("\t");
				///System.out.println("apectTerms : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
				//System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
				//System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
				//System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
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
				String [] tokValue = new String[tokText.length];
				Boolean[] tokFlag = new Boolean[tokText.length];
				Arrays.fill(tokFlag, Boolean.FALSE);
				String [] aspectTermBuffer = new String[20];
				String [] termsOfAspectTerm = new String[10];
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
							bw2.write(aspectTermBuffer[k]);
							bw2.newLine();
							System.out.println(ele1.getAttribute("term"));
							termsOfAspectTerm = aspectTermBuffer[k].split(" ");
							
							//for(int i = 0;i<termsOfAspectTerm.length;i++){
							//	System.out.println(termsOfAspectTerm[i]);
							//}
							inner:
							for(int q = 0 ;q<tokText.length;){
								int count = 1;
								if(termsOfAspectTerm[0].compareTo(tokText[q]) == 0){
									tokValue[q] = "B_ASP";
									tokFlag[q] = true;
									//bw.write(tokText[q]+ "\t" + "B_ASP\n");
									//bw.flush();
									if(termsOfAspectTerm.length>1){
										for(;count<termsOfAspectTerm.length;count++){
											if(termsOfAspectTerm[count].compareTo(tokText[q+count]) == 0){
												tokValue[q+count] = "I_ASP";
												tokFlag[q+count] = true;
												//bw.write( tokText[q+count]+ "\t" + "I_ASP\n");
												//bw.flush();
											}
										}
									}
									
								}
									

								
								q+=count;
							 //	bw.flush();
							}
						
						} 
						//System.out.println("term:" + ele.getAttribute("term"));
						//System.out.println("polarity:" + ele.getAttribute("polarity"));
					}
				
				
				}
				for(int r=0;r<tokText.length;r++){
					if(tokFlag[r]){
						//bw.write(tokText[r] + "\t" + tokValue[r] + "\n");
						bw.write(tokText[r] + "\n");
						bw.flush();
					}
					else{
						//bw.write(tokText[r] + "\t" + "0" + "\n");
						bw.write(tokText[r] + "\n");
						bw.flush();
					}
				}
				bw.write("EOL");

				
						//System.out.println(text);
			}

					
			bw.write("\n");	
 			bw.flush();
			}
			//bw.write("\t");
					//System.out.println("term:" + ele.getAttribute("term"));
						//System.out.println("polarity:" + ele.getAttribute("polarity"));
					
			
 				
			
		bw.write("");
	bw.flush();
	bw.close();
		
    }catch (Exception e) {
		e.printStackTrace();
    }
  }
 
}
