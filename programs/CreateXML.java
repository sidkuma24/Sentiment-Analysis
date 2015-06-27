import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.*;
import java.io.*;

public class CreateXML
{
	public static int sentenceCount = 0;//sentence id
	public static void main(String args[]) throws IOException, ClassNotFoundException 
	{
		Scanner sc = null;
		String textFile = "text.txt";
		try
		{

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			sc = new Scanner(new File(args[0]));
			String buf="";
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("sentences");
			doc.appendChild(rootElement);

            FileWriter fw = new FileWriter(textFile);
			BufferedWriter bw = new BufferedWriter(fw);

			while(sc.hasNextLine()){

				buf=sc.nextLine();
				sentenceCount++;
				//buf=buf.trim();
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
              Element sentence = doc.createElement("sentence");
				rootElement.appendChild(sentence);
				Attr senAttr1 = doc.createAttribute("id");
				
				senAttr1.setValue(result0[0].trim());

				sentence.setAttributeNode(senAttr1);
				Attr senAttr2 = doc.createAttribute("polarity");
				//System.out.println(sc.next());
				if(result0.length>1)
				senAttr2.setValue(result0[1].trim());
				sentence.setAttributeNode(senAttr2);

				//temp2 = sc.nextLine();
				Element text = doc.createElement("text");
				if(result0.length>2){
				    bw.write(Integer.toString(sentenceCount));
					bw.write("\t");
					bw.write(result0[1].trim());
					bw.write("\t");
					bw.write(result0[2].trim());
					bw.write("\n");
					bw.flush();
				    text.appendChild(doc.createTextNode(result0[2].trim()));
					
				}
				sentence.appendChild(text);
               
                if(result0.length>3){
                	Element aspectTerms  = doc.createElement("aspectTerms");
					sentence.appendChild(aspectTerms);
                	for(int j = 3 ; j<result0.length;j++){
                		Element aspectTerm = doc.createElement("aspectTerm");
                		String [] aspectTermBuf = result0[j].split(":");
                		Attr aTAttr1 = doc.createAttribute("term");
                		if(aspectTermBuf.length>0){
                			//System.out.println("term:"+ aspectTermBuf[0]);
                	        aTAttr1.setValue(aspectTermBuf[0].trim());
                	        aspectTerm.setAttributeNode(aTAttr1);
                	    }
                   		Attr aTAttr2 = doc.createAttribute("polarity");
                   		if(aspectTermBuf.length>1){
                   			//System.out.println("polarity:"+aspectTermBuf[1]);
                            aTAttr2.setValue(aspectTermBuf[1].trim());
                             aspectTerm.setAttributeNode(aTAttr2);
                         }
                        int t = 0;
                        int f = 0;
                        String to = "";
              			String from = "";
                        //boolean found = false;

                         f = result0[2].indexOf(aspectTermBuf[0].trim());
                       
                         from = Integer.toString(f);  
                         t = f + aspectTermBuf[0].length();
                         to  = Integer.toString(t);                      

                        Attr aTAttr3 = doc.createAttribute("from");
                   		aTAttr3.setValue(from);
                        aspectTerm.setAttributeNode(aTAttr3);
                         
                         Attr aTAttr4 = doc.createAttribute("to");
                   		 aTAttr4.setValue(to);
                          aspectTerm.setAttributeNode(aTAttr4);
                         

                         
                        aspectTerms.appendChild(aspectTerm);
                	}
                }

                if(result1 != null){
                	Element aspectCategories = doc.createElement("aspectCategories");
                	sentence.appendChild(aspectCategories);
                	for(int j=0;j<result1.length;j++){
                		Element aspectCategory = doc.createElement("aspectCategory");
                		String [] aspectCatBuf = result1[j].split(":");
                		Attr aCAttr1 = doc.createAttribute("category");
                        if(aspectCatBuf.length>0){
                        	aCAttr1.setValue(aspectCatBuf[0]);
                        	aspectCategory.setAttributeNode(aCAttr1);
                        }
                        Attr aCAttr2 = doc.createAttribute("polarity");
                        if(aspectCatBuf.length>1){
                   			aCAttr2.setValue(aspectCatBuf[1]);
                            aspectCategory.setAttributeNode(aCAttr2);
                         }
                         aspectCategories.appendChild(aspectCategory);

                	}
                }
				
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("Annotation.xml"));

             
			
			// StreamResult result2 = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("XML File Created : Annotation.xml!");
		} 
		catch (ParserConfigurationException pce) 
		{
			pce.printStackTrace();
		} 
		catch (TransformerException tfe) 
		{
			tfe.printStackTrace();
		}
		 catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + textFile + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
	}
	
}
