package com.andersen_trainee.xml.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "people")
@XmlAccessorType(XmlAccessType.FIELD)
public class People {
    @XmlElement(name = "person", type = Person.class)
    private List<Person> pep = new ArrayList<>();

    public People(){

    }

    public List<Person> getPep() {
        return pep;
    }

    public void setPep(List<Person> pep) {
        this.pep = pep;
    }
}
