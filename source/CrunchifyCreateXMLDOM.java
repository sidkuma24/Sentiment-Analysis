
 
import java.io.File;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
 
/**
* @author Crunchify.com
*/
 
public class CrunchifyCreateXMLDOM {
 
    public static void main(String[] args) {
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElementNS("","Sentences");
            doc.appendChild(mainRootElement);
 
            // append child elements to root element
            mainRootElement.appendChild(getSentence(doc, "1", "Paypal", "Payment"));
            mainRootElement.appendChild(getSentence(doc, "2", "eBay", "Shopping"));
            mainRootElement.appendChild(getSentence(doc, "3", "Google", "Search"));
 
            // output DOM XML to console
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);
 
            System.out.println("\nXML DOM Created Successfully..");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private static Node getSentence(Document doc, String id, String name, String age) {
        Element sentence = doc.createElement("sentence");
        sentence.setAttribute("id", id);
        sentence.appendChild(getSentenceElements(doc, sentence, "text"));
        sentence.appendChild(getSentenceElements(doc, sentence, "aspect terms"));
       
        return sentence;
    }
 
    // utility method to create text node
  /*  private static Node getSentenceElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }*/
      private static Node getSentenceElements(Document doc, Element element, String name) {
        Element node = doc.createElement(name);
        
        return node;
    }
}
