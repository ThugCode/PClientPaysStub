package metier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/***
 * Classe de d'interaction SOAP
 * @author LETOURNEUR - GERLAND
 *
 */
public class EnvoiMessageSOAP {

	private SOAPConnection connection;
	private SOAPConnectionFactory soapConnFactory;
	private MessageFactory messageFactory;
	private SOAPMessage message;
	private SOAPPart soapPart;
	private SOAPEnvelope envelope;
	private SOAPBody body;
	private SOAPElement bodyElement;
	private TransformerFactory transformerFactory;
	private Transformer transformer;
	private Source sourceContent;
	
	public void connexion() {
		try {
			soapConnFactory = SOAPConnectionFactory.newInstance();
			connection = soapConnFactory.createConnection();
			
		} catch (Exception e) { System.out.println(e.getMessage());}
	}

	/***
	 * Création de l'objet message
	 * On construit les différentes parties du message SOAP
	 * Il est possible de créer le message à partir d'un fichier externe.
	 * @param operation
	 * @param param
	 * @param destination
	 */
	public void creationMessage(String operation, String param, String destination) {
		try {
			//Construction du message
			messageFactory = MessageFactory.newInstance();
			message = messageFactory.createMessage();
			soapPart = message.getSOAPPart();
			envelope = soapPart.getEnvelope();
			body = envelope.getBody();
			// Création de l'élément principal et du namespace
			QName bodyName = new QName(destination, operation, "m");
			// Création de l'enveloppe
			bodyElement = body.addBodyElement(bodyName);
			// Création des paramêtres
			QName qn1 = new QName("search");
			bodyElement.addChildElement(qn1).addTextNode(param);
			// Sauvegarde du message
			message.saveChanges();
			
		} catch (Exception e) { System.out.println(e.getMessage()); }

	}

	/***
	 * Envoi du message 
	 * dans le cas d'un message synchrone, l'envoi 
	 * et la réception s'effectuent en une seule étape.
	 * @param destination
	 * @param operation
	 * @return
	 */
	public Object EmmissionReception(String destination, String operation)
	{
		
		Object returnObject = null;
		
		try {
			// On contrôle l'entrée
			System.out.println("\nENVOI:\n");
			message.writeTo(System.out);
			System.out.println();
			// On envoie le message en définissant la destination
			SOAPMessage reply = connection.call(message, destination);
			// Traitement de la réponse en contrôlant la sortie
			System.out.println("\nREQUEST:\n");
			soapPart = reply.getSOAPPart();
			envelope = soapPart.getEnvelope();
			body = envelope.getBody();
			
			// Affichage du résultat
			System.out.println(operation.toUpperCase());
						
			if(operation.equals("getTousLesPays")) {
				Node firstchild = body.getFirstChild();
				NodeList listeNoeud = firstchild.getChildNodes();
				
				List<Pays> listePays = new ArrayList<Pays>();
				
				for(int i=0; i<listeNoeud.getLength(); i++) {
					Node n = listeNoeud.item(i);
					NodeList l = n.getChildNodes();
					
					Node nbHNode = l.item(0);
					int nbH = Integer.parseInt(nbHNode.getTextContent());
					
					Node nomCapitaleNode = l.item(1);
					String nomCapitale = nomCapitaleNode.getTextContent();
					
					Node nomPaysNode = l.item(2);
					String nomPays = nomPaysNode.getTextContent();
					
					Pays pays = new Pays(nomPays, nomCapitale, nbH, false);
					
					listePays.add(pays);
				}
				
				returnObject =  listePays;
			}
			else if (operation.equals("searchPays")) {
				
				Node firstchild = body.getFirstChild();
				NodeList listeNoeud = firstchild.getChildNodes();
				
				ArrayList<Pays> liste = new ArrayList<Pays>();
				
				for(int i=0; i<listeNoeud.getLength(); i++) {
					Node m = listeNoeud.item(i);
					NodeList p = m.getChildNodes();
				
					Node nbHNode = p.item(0);
					int nbH = Integer.parseInt(nbHNode.getTextContent());
					
					Node nomCapitaleNode = p.item(1);
					String nomCapitale = nomCapitaleNode.getTextContent();
					
					Node nomPaysNode = p.item(2);
					String nomPays = nomPaysNode.getTextContent();
					
					Node recherchePaysNode = p.item(3);
					String recherchePays = recherchePaysNode.getTextContent();
					
					Pays pays = new Pays(nomPays, nomCapitale, nbH, Boolean.parseBoolean(recherchePays));
					
					liste.add(pays);
				}
				
				returnObject = liste;
			}
			
			
			// on crée le transformeur pour visualiser le message
			transformerFactory = TransformerFactory.newInstance();
			transformer = transformerFactory.newTransformer();
			// On extrait le contenu du corps BODY
			sourceContent = reply.getSOAPPart().getContent();
			// Sortie de la transformation
			StreamResult unresult = new StreamResult(System.out);
			transformer.transform(sourceContent, unresult);
			
			// on ferme la connexion
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return returnObject;
	}
}
