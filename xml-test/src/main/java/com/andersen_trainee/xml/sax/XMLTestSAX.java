package com.andersen_trainee.xml.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLTestSAX {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        UserHandler handler = new UserHandler();
        File file = new File("src/com/andersen_trainee/xml/sax/user.xml");
        SAXParser parser = factory.newSAXParser();

        parser.parse(file, handler);

        List<User> users = handler.getUsers();
        System.out.println(users);




    }
}
