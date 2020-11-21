package com.andersen_trainee.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class UserHandler extends DefaultHandler {
    private boolean hasFName = false;
    private boolean hasLName = false;
    private boolean hasAge = false;

    private List<User> users = null;
    private User user = null;

    public List<User> getUsers() {
        return users;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("user")) {
            user = new User();
            user.setId(Integer.parseInt(attributes.getValue("id")));
            if (users == null) {
                users = new ArrayList<>();
            }
        } else if (qName.equals("firstName")) {
            hasFName = true;
        } else if (qName.equals("lastName")) {
            hasLName = true;
        } else if (qName.equals("age")) {
            hasAge = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (hasFName) {
            user.setfName(new String(ch, start, length));
            hasFName = false;
        } else if (hasLName) {
            user.setlName(new String(ch, start, length));
            hasLName = false;
        } else if (hasAge) {
            user.setAge(Integer.parseInt(new String(ch, start, length)));
            hasAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("user")) {
            users.add(user);
        }
    }
}
