package com.andersen_trainee.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLTestDOM {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File("src/com/andersen_trainee/xml/dom/product.xml");
        Document document = builder.parse(file);

        NodeList nodeList = document.getElementsByTagName("product");
        List<Product> products = new ArrayList<>();

        parseXMLDocument(nodeList, products);
        showResultOfXMLParsing(products);


    }

    private static void parseXMLDocument(NodeList nodeList, List<Product> productList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Product product = new Product();
            Element element = (Element) nodeList.item(i);

            product.setId(Integer.parseInt(element.getAttribute("id")));
            product.setName(element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue());
            product.setPrice(Integer.parseInt(element.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue()));

            productList.add(product);
        }
    }

    private static void showResultOfXMLParsing(List<Product> productList) {
        for (Product p : productList) {
            System.out.println(p);
        }
    }


}
