package hu.domparse.a5igrx;

//a projekt sz�m�ra sz�ks�ges library-k
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMReadA5igrx {

	public static void main(String[] args) {

		//az �rtelmez� l�trehozza a dokumentumot �s objektumot �p�t fel bel�le
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();


		//dinamikus t�mbben t�roltam el a elementek neveit
		ArrayList<String> a = new ArrayList();
		a.add("db");
		a.add("designok");
		a.add("honlap_motor");
		a.add("k�sz_blokk_design");
		a.add("k�sz_blokk_design_emailc�m");
		a.add("widgetek");
		

		//try-catch blokkba kell z�rni, mert az olvas�s kiv�telt dobhat 
		//pl. ha nincs ilyen dokumentum
		try
		{
			//XML dokumentum hely�nek meghat�roz�sa az �tvonal megad�s�val,
			//Java-ban \\ seg�ts�g�vel lehts�ges 
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("D:\\XMLFeladatA5igrx\\DOMParseA5IGRX\\XMLA5igrx.xml"));


			//az �sszes sz�veget node-ba helyezi teljes m�lys�gig majd
			//szepar�lja text nodeokra
			document.getDocumentElement().normalize();
			

			//be�ll�tjuk a root elementet a dokumentumb�l
			Element rootNode = document.getDocumentElement();
			System.out.println("Root element: " + rootNode.getNodeName());
			

			//ciklust k�sz�tettem az ArrayList bej�r�s�hoz
			for (int i = 0; i < a.size(); i++) {
			
			//beleraktam az ArrayList adott iter�ci�j�hoz f�z�d� elemet
			NodeList nodeList = document.getElementsByTagName(a.get(i));
			System.out.println("-------------------");
			for (int j = 0; j < nodeList.getLength(); j++)
			{
				//Meghat�roz�dik a jelenlegi element
				Node actualNode = nodeList.item(j);
				System.out.println("Curent Element: " + actualNode.getNodeName());
				

		//IF-ELSE szerkezettel vizsg�ltam meg, hogy �ppen melyik �gban j�r a ciklus
		//aktu�lis elem (db) gyerekelemeinek ki�rat�sa
		if(a.get(i).equals("db")==true)
		{
			//aktu�lis element be�ll�t�dik, ki�rodnak a Node elemei
			Element actualElement = (Element) actualNode;
		
			System.out.println("K�sz Blokk ID: " + 
				actualElement.getElementsByTagName("KBlokkid")   //aktu�lis elem adatainak lek�r�se
				.item(0)
				.getTextContent());

			System.out.println("Design ID: " + 
				actualElement.getElementsByTagName("Design_id")
				.item(0)
				.getTextContent());

			System.out.println();		//Ki�rat�dik az eredm�ny
		}
		

		//aktu�lis elem (designok) gyerekelemeinek ki�rat�sa
		else if(a.get(i).equals("designok")==true)
		{
			Element actualElement = (Element) actualNode;
			
						
			System.out.println("Design ID: " + 
				actualElement.getElementsByTagName("Design_id")
				.item(0)
				.getTextContent());
			
			System.out.println("Design n�v: " + 
				actualElement.getElementsByTagName("design_n�v")
				.item(0)
				.getTextContent());
											
			System.out.println("K�p URL: " + 
				actualElement.getElementsByTagName("K�p_URL")
				.item(0)
				.getTextContent());
			
			System.out.println("K�sz�t� neve: " + 
				actualElement.getElementsByTagName("K�sz�t�_neve")
				.item(0)
				.getTextContent());
			
			System.out.println("Haszn�latok sz�ma: " + 
				actualElement.getElementsByTagName("Haszn�latok_sz�ma")
				.item(0)
				.getTextContent());
			
			System.out.println("Design Verzi� sz�ma: " + 
				actualElement.getElementsByTagName("Verziosz�m")
				.item(0)
				.getTextContent());
			
			System.out.println();
	}

		//aktu�lis elem (honlap_motor) gyerekelemeinek ki�rat�sa
		else if(a.get(i).equals("honlap_motor")==true)
		{
			Element actualElement = (Element) actualNode;
											
			System.out.println("Honlap Motor Verzi�sz�ma: " + 
					actualElement.getElementsByTagName("Verziosz�m")
					.item(0)
					.getTextContent());
	
			System.out.println("Komponensek verzi� sz�ma: " + 
					actualElement.getElementsByTagName("Komponens_verzi�sz�m")
					.item(0)
					.getTextContent());
			System.out.println();	}

		
		//aktu�lis elem (k�sz_blokk_design) gyerekelemeinek ki�rat�sa
		else if(a.get(i).equals("k�sz_blokk_design")==true)
		{
			Element actualElement = (Element) actualNode;
			
								
			System.out.println("KBlokkid: " + 
						actualElement.getElementsByTagName("KBlokkid")
						.item(0)
						.getTextContent());
											
			System.out.println("Blokk_n�v: " + 
						actualElement.getElementsByTagName("Blokk_n�v")
						.item(0)
						.getTextContent());
													
			System.out.println("Melyik design r�sz blokkja: " + 
					actualElement.getElementsByTagName("Melyik_design_r�sz_blokkja")
					.item(0)
					.getTextContent());
			
			System.out.println("Icon k�p�nek URL-je: " + 
					actualElement.getElementsByTagName("C�l_url")
					.item(0)
					.getTextContent());
													
			System.out.println();
		}

		//aktu�lis elem (k�sz_blokk_design_emailc�m) gyerekelemeinek ki�rat�sa
		else if(a.get(i).equals("k�sz_blokk_design_emailc�m")==true)
		{
			Element actualElement = (Element) actualNode;

									
			System.out.println("K�sz Blokk k�sz�t�j�nek emailc�me: " + 
					actualElement.getElementsByTagName("emailc�m")
					.item(0)
					.getTextContent());
												
			System.out.println("K�sz Blokk ID: " + 
					actualElement.getElementsByTagName("KBlokkid")
					.item(0)
					.getTextContent());
					
		System.out.println();   
		}
		
		//aktu�lis elem (widgetek) gyerekelemeinek ki�rat�sa
		else if(a.get(i).equals("widgetek")==true)
		{
			Element actualElement = (Element) actualNode;

			System.out.println("Widget ID: " + 
					actualElement.getElementsByTagName("Widget_ID")
					.item(0)
					.getTextContent());
			
			System.out.println("Widget neve: " +
					actualElement.getElementsByTagName("Widget_neve")
					.item(0)
					.getTextContent());
					
			System.out.println("Haszn�latok sz�ma: " +
					actualElement.getElementsByTagName("Haszn�latok_sz�ma")
					.item(0)
					.getTextContent());
			
			System.out.println("Widget be�ll�t�sok: " + 
					actualElement.getElementsByTagName("Widget_be�ll�t�sok")
					.item(0)
					.getTextContent());

														
			System.out.println();
			}
			}
			}
			}
		catch(Exception e) {		

				//a program fut�sa sor�n dob�dott hib�k miatt volt sz�ks�ges ez a catch �g a szerkezetbe
				e.printStackTrace();
			}
	}
}
