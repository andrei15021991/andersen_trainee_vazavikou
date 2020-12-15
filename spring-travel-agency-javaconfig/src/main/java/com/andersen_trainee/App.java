package com.andersen_trainee;

import com.andersen_trainee.config.ApplicationContext;
import com.andersen_trainee.model.Tour;
import com.andersen_trainee.service.TravelAgencyService;
import com.andersen_trainee.service.TravelAgencyServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContext.class);

        TravelAgencyService travelAgencyService = context.getBean("service", TravelAgencyServiceImpl.class);
        List<Tour> tours = travelAgencyService.getAllTours();
        tours.forEach(Tour::showInfo);

    }

}
