import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.*;
import java.util.*;
 
public class ReadXML {
 
  public static void main(String args[]) {
 
  	String outputFile = "aspect_terms_out.txt";

    try {

    	FileWriter fw = new FileWriter(outputFile);
	    BufferedWriter bw = new BufferedWriter(fw);
 
	    File xmlFile1 = new File(args[0]);
		DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
		Document doc1 = dBuilder1.parse(xmlFile1);

		File xmlFile2 = new File(args[1]);
		DocumentBuilderFactory dbFactory2 = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder2 = dbFactory2.newDocumentBuilder();
		Document doc2 = dBuilder2.parse(xmlFile2);
 
		File xmlFile3 = new File(args[2]);
		DocumentBuilderFactory dbFactory3 = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder3 = dbFactory3.newDocumentBuilder();
		Document doc3 = dBuilder3.parse(xmlFile3);
 		String [] text = null;
 
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc1.getDocumentElement().normalize();
		doc2.getDocumentElement().normalize();
		doc3.getDocumentElement().normalize();
		
 
		//System.out.println("Root element :" + doc1.getDocumentElement().getNodeName());
		//System.out.println("Root element :" + doc2.getDocumentElement().getNodeName());
		System.out.println("Root element :" + doc3.getDocumentElement().getNodeName());

		NodeList nList1 = doc1.getElementsByTagName("sentence");
		NodeList nList2 = doc2.getElementsByTagName("sentence");
		NodeList nList3 = doc3.getElementsByTagName("sentence");
 
		//System.out.println("----------------------------");
 
		for (int temp = 0; temp < nList1.getLength(); temp++) {
			
			//first annotater
			Node nNode1 = nList1.item(temp);
 			//System.out.println("\nCurrent Element :" + nNode1.getNodeName());
 
			if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
 
				Element eElement1 = (Element) nNode1;
 
				//System.out.println("sentence id : " + eElement1.getAttribute("id"));
				bw.write(eElement1.getAttribute("id"));
				bw.write("\t");
				///System.out.println("apectTerms : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
				//System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
				//System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
				//System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
				NodeList nodeList = nNode1.getChildNodes();
				for(int j = 0; j < nodeList.getLength(); j++){
					Node nNode1_1 = nodeList.item(j);
					//System.out.println("\nCurrent Element :" + nNode1.getNodeName());
					if(nNode1_1.getNodeName() == "aspectTerms"){
						Element ele =  (Element) nNode1_1;
						NodeList nodeList1 = nNode1_1.getChildNodes();
						for(int k =0;k<nodeList1.getLength();k++){
							Node nNode1_2 = nodeList1.item(k);
							Element ele1 = (Element) nNode1_2;
							//System.out.println("term:" + ele1.getAttribute("term"));
							//System.out.println("polarity:" + ele1.getAttribute("polarity"));
							bw.write(ele1.getAttribute("term"));
							bw.write(":");
							bw.write(ele1.getAttribute("polarity"));
							bw.write(";");
							bw.flush();
						} 
						//System.out.println("term:" + ele.getAttribute("term"));
						//System.out.println("polarity:" + ele.getAttribute("polarity"));
					}
				}
 				
			}
			bw.write("\t");
			// second annotater
			Node nNode2 = nList2.item(temp);
 			//System.out.println("\nCurrent Element :" + nNode2.getNodeName());
 
			if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
 
				Element eElement2 = (Element) nNode2;
 
				//System.out.println("sentence id : " + eElement2.getAttribute("id"));
				///System.out.println("apectTerms : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
				//System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
				//System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
				//System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
				NodeList nodeList = nNode2.getChildNodes();
				for(int j = 0; j < nodeList.getLength(); j++){
					Node nNode2_1 = nodeList.item(j);
					//System.out.println("\nCurrent Element :" + nNode1.getNodeName());
					if(nNode1.getNodeName() == "aspectTerms"){
						Element ele =  (Element) nNode2_1;
						NodeList nodeList1 = nNode2_1.getChildNodes();
						for(int k =0;k<nodeList1.getLength();k++){
							Node nNode2_2 = nodeList1.item(k);
							Element ele1 = (Element) nNode2;
							//System.out.println("term:" + ele1.getAttribute("term"));
							//System.out.println("polarity:" + ele1.getAttribute("polarity"));
								bw.write(ele1.getAttribute("term"));
							bw.write(":");
							bw.write(ele1.getAttribute("polarity"));
							bw.write(";");
							bw.flush();
						} 
						//System.out.println("term:" + ele.getAttribute("term"));
						//System.out.println("polarity:" + ele.getAttribute("polarity"));
					}
				}
 				
			}
				bw.write("\t");
			//third annotater
			Node nNode3 = nList3.item(temp);
 			System.out.println("\nCurrent Element :" + nNode3.getNodeName());
 
			if (nNode3.getNodeType() == Node.ELEMENT_NODE) {
 
				Element eElement3 = (Element) nNode3;
 
				System.out.println("sentence id : " + eElement3.getAttribute("id"));
				///System.out.println("apectTerms : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
				//System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
				//System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
				//System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
				NodeList nodeList = nNode3.getChildNodes();
				for(int j = 0; j < nodeList.getLength(); j++){
					Node nNode3_1 = nodeList.item(j);
					//System.out.println("\nCurrent Element :" + nNode1.getNodeName());
					if(nNode3_1.getNodeName() == "aspectTerms"){
						Element ele =  (Element) nNode3_1;
						NodeList nodeList1 = nNode3_1.getChildNodes();
						for(int k =0;k<nodeList1.getLength();k++){
							Node nNode3_2 = nodeList1.item(k);
							Element ele1 = (Element) nNode3_2;
							System.out.println("term:" + ele1.getAttribute("term"));
							System.out.println("polarity:" + ele1.getAttribute("polarity"));
								bw.write(ele1.getAttribute("term"));
							bw.write(":");
							bw.write(ele1.getAttribute("polarity"));
							bw.write(";");
							bw.flush();
						} 
						//System.out.println("term:" + ele.getAttribute("term"));
						//System.out.println("polarity:" + ele.getAttribute("polarity"));
					}
				}
 				bw.flush();
			}
			bw.write("\n");
	
		}
    }catch (Exception e) {
		e.printStackTrace();
    }
  }
 
}