package com.andersen_trainee.xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JAXBTest {
    public static void main(String[] args) throws JAXBException {

        //marshalObject();
        unmarshalObject();
    }

    public static void marshalObject() throws JAXBException {
        Person person = new Person(1, "Tom", 22);
        Person person1 = new Person(2, "Sam", 22);
        Person person2 = new Person(3, "Nick", 22);

        List<Person> people = new ArrayList<>();
        people.add(person);
        people.add(person1);
        people.add(person2);

        People people1 = new People();
        people1.setPep(people);

        JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(people1, System.out);
    }

    public static void unmarshalObject() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("src/main/java/com/andersen_trainee/xml/jaxb/people.xml");
        People people = (People) unmarshaller.unmarshal(file);

        System.out.println(people.getPep());
    }
}
