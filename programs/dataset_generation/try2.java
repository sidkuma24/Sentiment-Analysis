import java.io.File;
import java.util.Stack;
import java.io.*;
import java.util.StringTokenizer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class try2 {
    public static void main(String[] args) throws FileNotFoundException{
        Document doc = null;
        DocumentBuilderFactory dbf = null;
        DocumentBuilder docBuild = null;
	File file = new File("abc.txt");
	String content,a;
	byte[] contentInBytes;
	FileOutputStream fop = new FileOutputStream(file);
	String newline = System.getProperty("line.separator");
        try {

            dbf = DocumentBuilderFactory.newInstance();
            docBuild = dbf.newDocumentBuilder();
            doc = docBuild.parse(new File("Annotation_sid.xml"));

           content= doc.getFirstChild().getTextContent();
	StringTokenizer st = new StringTokenizer(content," ।,");
	while(st.hasMoreTokens())
	{
	a=st.nextToken();
	contentInBytes= a.getBytes();
	fop.write(contentInBytes);
	fop.write(newline.getBytes());
	fop.flush();
	}		
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
