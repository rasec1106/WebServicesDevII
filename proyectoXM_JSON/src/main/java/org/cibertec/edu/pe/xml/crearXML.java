package org.cibertec.edu.pe.xml;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class crearXML {
	public static void main(String[] args) {
		
		try {
			// Crear instancia de la clase DocumentBuilderFactory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// Crear instancia de la clase DocumentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Crear instancia de la clase DOMImplementation
			DOMImplementation implementation = builder.getDOMImplementation();
			
			// Crear un documento con un elemento raiz
			Document documento = implementation.createDocument(null,"concesionario", null);
			documento.setXmlVersion("1.0");
			
			// Crear los elementos
			Element coches = documento.createElement("coches");
			Element coche = documento.createElement("coche");
			
			// Matricula
			Element matricula = documento.createElement("matricula");
			Text textMatricula = documento.createTextNode("ABC-123");
			matricula.appendChild(textMatricula);
			coche.appendChild(matricula);
			
			// Marca
			Element marca = documento.createElement("marca");
			Text textMarca = documento.createTextNode("ACME");
			marca.appendChild(textMarca);
			coche.appendChild(marca);
			
			// Precio
			Element precio = documento.createElement("precio");
			Text textPrecio = documento.createTextNode("30000");
			precio.appendChild(textPrecio);
			coche.appendChild(precio);
			
			// Añadir el elemento coche a elemento coches
			coches.appendChild(coche);
			
			// Añadir el elemento coches al root
			documento.getDocumentElement().appendChild(coches);
			
			// Asociar el objeto documento a la clase Source
			DOMSource source = new DOMSource(documento);
			
			// Crear el archivo XML y guardar el resultado de la creacion
			Result result = new StreamResult(new File("concesionario.xml"));
			
			Transformer transformar = TransformerFactory.newInstance().newTransformer();
			transformar.transform(source, result);
			
		} catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
