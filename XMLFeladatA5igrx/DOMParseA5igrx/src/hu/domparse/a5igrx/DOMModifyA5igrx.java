package hu.domparse.a5igrx;

//a projekthez sz�ks�ges library-k
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMModifyA5igrx {

	public static void main(String[] args) {

	       try {
			
		//XML dokumentum hely�nek meghat�roz�sa az �tvonal megad�s�val
	       	String filepath ="D:\\XMLFeladatA5igrx\\DOMParseA5IGRX\\XMLA5igrx.xml";

	        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	        Document doc = docBuilder.parse(filepath);

	        // Staff element lek�r�se k�zvetlen�l n�v alapj�n
	        Node staff = doc.getElementsByTagName("designok").item(0);

	
	        // Staff element gyerek node-jainak iter�ci�ja
	        NodeList list = staff.getChildNodes();

	        for (int i = 0; i < list.getLength(); i++) {
	                   Node node = list.item(i);

	           
	           if ("K�sz�t�_neve".equals(node.getNodeName())) {
	            node.setTextContent("Nyilas Viktor A5IGRX");
	           }
	        }

	        // A tartalom be�r�sa az XML file-ba
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File(filepath));
	        transformer.transform(source, result);

	        System.out.println("Done");

	       } catch (ParserConfigurationException pce) {
	        pce.printStackTrace();
	       } catch (TransformerException tfe) {
	        tfe.printStackTrace();
	       } catch (IOException ioe) {
	        ioe.printStackTrace();
	       } catch (SAXException sae) {
	        sae.printStackTrace();
	       }
	}
}
