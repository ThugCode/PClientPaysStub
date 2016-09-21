package metier;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.util.Iterator;
import org.w3c.dom.Node;

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

	// fonction connexion

	// on construit une connexion
	public void connexion() {
		try {

			soapConnFactory = SOAPConnectionFactory.newInstance();
			connection = soapConnFactory.createConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Cr�ation de l�objet message
	// On construit les diff�rentes parties du message SOAP
	// Il est possible de cr�er le message � partir d�un fichier externe.
	// Cr�ation de l�objet message
	// On construit les diff�rentes parties du message SOAP
	// Il est possible de cr�er le message � partir d�un fichier externe.
	public void creationMessage(String operation, String destination) {
		try {
			messageFactory = MessageFactory.newInstance();
			message = messageFactory.createMessage();
			soapPart = message.getSOAPPart();
			envelope = soapPart.getEnvelope();
			body = envelope.getBody();
			// On cr�e l'�l�ment principal et le namespace'
			QName bodyName = new QName(destination, operation, "m");
			// On cr�e l�enveloppe
			bodyElement = body.addBodyElement(bodyName);
			// On passe les param�tres
			QName qn1 = new QName("opera");
			bodyElement.addChildElement(qn1).addTextNode(Float.toString(a));
			QName qn2 = new QName("operb");
			bodyElement.addChildElement(qn2).addTextNode(Float.toString(b));
			// On sauve le message
			message.saveChanges();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	// Envoi du message
	// dans le cas d�un message synchrone, l�envoi et la r�ception s�effectuent
	// en une seule �tape.
	// Envoi du message
	// dans le cas d�un message synchrone, l�envoi et la r�ception s�effectuent
	// en une seule �tape.
	public void EmmissionReception(String destination, String operation)
	// Les param�tres float a, float b et int oper
	// ne servent que pour l�affichage des r�sultats
	// Le message � �mettre contient :

	{
		try {
			// On contr�le l'entr�e
			System.out.println("\nENVOI:\n");
			message.writeTo(System.out);
			System.out.println();
			// On envoie le message et on attend la r�ponse
			// On d�finit la destination
			// On envoie le message
			SOAPMessage reply = connection.call(message, destination);
			// traitement de la r�ponse
			// On contr�le la sortie
			System.out.println("\nREQUEST:\n");
			soapPart = reply.getSOAPPart();
			envelope = soapPart.getEnvelope();
			body = envelope.getBody();
			// on examine les �l�ments renvoy�s dans une liste
			Iterator iter = body.getChildElements();
			Node resultOuter = ((Node) iter.next()).getFirstChild();
			Node result = resultOuter.getFirstChild();
			// on affiche le r�sultat
			System.out.println(operation + " : " + result.getNodeValue());
			// on cr�e le transformeur pour visualiser le message
			transformerFactory = TransformerFactory.newInstance();
			transformer = transformerFactory.newTransformer();
			// On extrait le contenu du corps BODY
			sourceContent = reply.getSOAPPart().getContent();
			// Sortie de la transformation
			StreamResult unresult = new StreamResult(System.out);
			transformer.transform(sourceContent, unresult);
			System.out.println();
			// on ferme la connexion
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
