import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.*;
import java.util.*;
 
public class GetTextFromXML {
 
  public static void main(String args[]) {
 
  	String outputFile = "all_text.txt";

    try {

    	FileWriter fw = new FileWriter(outputFile);
	    BufferedWriter bw = new BufferedWriter(fw);
 
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
				bw.write(text);

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
