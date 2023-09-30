package org.cibertec.edu.pe.xml;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class leerXML {
	public static void main(String[] args) {
		try {
			// Crear instancia de la clase DocumentBuilderFactory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// Crear instancia de la clase DocumentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Obtener el documento XML
			Document documento = builder.parse(new File("concesionario.xml"));

			NodeList listaCoches = documento.getElementsByTagName("coche");
			// Recuperar las etiquetas
			for(int i = 0; i < listaCoches.getLength(); i++) {
				Node nodo = listaCoches.item(i);
				if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element)nodo;
					NodeList hijos = e.getChildNodes();
					for(int j = 0; j < hijos.getLength(); j++) {
						Node hijo = hijos.item(j);
						if(hijo.getNodeType() == Node.ELEMENT_NODE)
							System.out.println("Propiedad:" + hijo.getNodeName() + 
									", Valor:" + hijo.getTextContent());
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
