package hu.domparse.a5igrx;

//a projekt számára szükséges library-k
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

		//az értelmezõ létrehozza a dokumentumot és objektumot épít fel belõle
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();


		//dinamikus tömbben tároltam el a elementek neveit
		ArrayList<String> a = new ArrayList();
		a.add("db");
		a.add("designok");
		a.add("honlap_motor");
		a.add("kész_blokk_design");
		a.add("kész_blokk_design_emailcím");
		a.add("widgetek");
		

		//try-catch blokkba kell zárni, mert az olvasás kivételt dobhat 
		//pl. ha nincs ilyen dokumentum
		try
		{
			//XML dokumentum helyének meghatározása az útvonal megadásával,
			//Java-ban \\ segítségével lehtséges 
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("D:\\XMLFeladatA5igrx\\DOMParseA5IGRX\\XMLA5igrx.xml"));


			//az összes szöveget node-ba helyezi teljes mélységig majd
			//szeparálja text nodeokra
			document.getDocumentElement().normalize();
			

			//beállítjuk a root elementet a dokumentumból
			Element rootNode = document.getDocumentElement();
			System.out.println("Root element: " + rootNode.getNodeName());
			

			//ciklust készítettem az ArrayList bejárásához
			for (int i = 0; i < a.size(); i++) {
			
			//beleraktam az ArrayList adott iterációjához fûzõdõ elemet
			NodeList nodeList = document.getElementsByTagName(a.get(i));
			System.out.println("-------------------");
			for (int j = 0; j < nodeList.getLength(); j++)
			{
				//Meghatározódik a jelenlegi element
				Node actualNode = nodeList.item(j);
				System.out.println("Curent Element: " + actualNode.getNodeName());
				

		//IF-ELSE szerkezettel vizsgáltam meg, hogy éppen melyik ágban jár a ciklus
		//aktuális elem (db) gyerekelemeinek kiíratása
		if(a.get(i).equals("db")==true)
		{
			//aktuális element beállítódik, kiírodnak a Node elemei
			Element actualElement = (Element) actualNode;
		
			System.out.println("Kész Blokk ID: " + 
				actualElement.getElementsByTagName("KBlokkid")   //aktuális elem adatainak lekérése
				.item(0)
				.getTextContent());

			System.out.println("Design ID: " + 
				actualElement.getElementsByTagName("Design_id")
				.item(0)
				.getTextContent());

			System.out.println();		//Kiíratódik az eredmény
		}
		

		//aktuális elem (designok) gyerekelemeinek kiíratása
		else if(a.get(i).equals("designok")==true)
		{
			Element actualElement = (Element) actualNode;
			
						
			System.out.println("Design ID: " + 
				actualElement.getElementsByTagName("Design_id")
				.item(0)
				.getTextContent());
			
			System.out.println("Design név: " + 
				actualElement.getElementsByTagName("design_név")
				.item(0)
				.getTextContent());
											
			System.out.println("Kép URL: " + 
				actualElement.getElementsByTagName("Kép_URL")
				.item(0)
				.getTextContent());
			
			System.out.println("Készítõ neve: " + 
				actualElement.getElementsByTagName("Készítõ_neve")
				.item(0)
				.getTextContent());
			
			System.out.println("Használatok száma: " + 
				actualElement.getElementsByTagName("Használatok_száma")
				.item(0)
				.getTextContent());
			
			System.out.println("Design Verzió száma: " + 
				actualElement.getElementsByTagName("Verzioszám")
				.item(0)
				.getTextContent());
			
			System.out.println();
	}

		//aktuális elem (honlap_motor) gyerekelemeinek kiíratása
		else if(a.get(i).equals("honlap_motor")==true)
		{
			Element actualElement = (Element) actualNode;
											
			System.out.println("Honlap Motor Verziószáma: " + 
					actualElement.getElementsByTagName("Verzioszám")
					.item(0)
					.getTextContent());
	
			System.out.println("Komponensek verzió száma: " + 
					actualElement.getElementsByTagName("Komponens_verziószám")
					.item(0)
					.getTextContent());
			System.out.println();	}

		
		//aktuális elem (kész_blokk_design) gyerekelemeinek kiíratása
		else if(a.get(i).equals("kész_blokk_design")==true)
		{
			Element actualElement = (Element) actualNode;
			
								
			System.out.println("KBlokkid: " + 
						actualElement.getElementsByTagName("KBlokkid")
						.item(0)
						.getTextContent());
											
			System.out.println("Blokk_név: " + 
						actualElement.getElementsByTagName("Blokk_név")
						.item(0)
						.getTextContent());
													
			System.out.println("Melyik design rész blokkja: " + 
					actualElement.getElementsByTagName("Melyik_design_rész_blokkja")
					.item(0)
					.getTextContent());
			
			System.out.println("Icon képének URL-je: " + 
					actualElement.getElementsByTagName("Cél_url")
					.item(0)
					.getTextContent());
													
			System.out.println();
		}

		//aktuális elem (kész_blokk_design_emailcím) gyerekelemeinek kiíratása
		else if(a.get(i).equals("kész_blokk_design_emailcím")==true)
		{
			Element actualElement = (Element) actualNode;

									
			System.out.println("Kész Blokk készítõjének emailcíme: " + 
					actualElement.getElementsByTagName("emailcím")
					.item(0)
					.getTextContent());
												
			System.out.println("Kész Blokk ID: " + 
					actualElement.getElementsByTagName("KBlokkid")
					.item(0)
					.getTextContent());
					
		System.out.println();   
		}
		
		//aktuális elem (widgetek) gyerekelemeinek kiíratása
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
					
			System.out.println("Használatok száma: " +
					actualElement.getElementsByTagName("Használatok_száma")
					.item(0)
					.getTextContent());
			
			System.out.println("Widget beállítások: " + 
					actualElement.getElementsByTagName("Widget_beállítások")
					.item(0)
					.getTextContent());

														
			System.out.println();
			}
			}
			}
			}
		catch(Exception e) {		

				//a program futása során dobódott hibák miatt volt szükséges ez a catch ág a szerkezetbe
				e.printStackTrace();
			}
	}
}
