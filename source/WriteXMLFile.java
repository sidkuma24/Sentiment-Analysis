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
 
public class WriteXMLFile {
 
	public static void main(String argv[]) {
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("sentences");
		doc.appendChild(rootElement);
 
		// staff elements
		Element sentence = doc.createElement("sentence");
		rootElement.appendChild(sentence);
 
		// set attribute to staff element
		Attr attr = doc.createAttribute("id");
		attr.setValue("1");
		sentence.setAttributeNode(attr);
 
		// shorten way
		// staff.setAttribute("id", "1");
 
		// firstname elements
		Element text = doc.createElement("text");
		text.appendChild(doc.createTextNode("sample text 1"));
		sentence.appendChild(text);
 
		// lastname elements
		Element aspectTerms = doc.createElement("aspect terms");
		aspectTerms.appendChild(doc.createTextNode("aspect term"));
		sentence.appendChild(aspectTerms);
      /*
	   for(int i=0;i<10;i++){
	   	 Element aspect_term = doc.createElement("aspect term");
	   	 aspect_term.appendChild(doc.createTextNode("aspect term 1"));
	   	 aspect_terms.appendChild(aspect_term);
	   }*/
 
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("testfile.xml"));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}