package com.andersen_trainee;

import com.andersen_trainee.dao.TravelAgencyDAO;
import com.andersen_trainee.dao.TravelAgencyDAOImpl;
import com.andersen_trainee.model.Tour;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TravelAgencyDAO travelAgencyDAO = context.getBean("dao", TravelAgencyDAOImpl.class);

        List<Tour> tours = travelAgencyDAO.getAllTours();
        tours.forEach(Tour::showInfo);

        context.close();
    }
}
