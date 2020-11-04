package com.andersen.travel_agency.view;


import com.andersen.travel_agency.dao.DAOException;
import com.andersen.travel_agency.dao.DAOProvider;
import com.andersen.travel_agency.dao.TravelAgencyDAO;
import com.andersen.travel_agency.entity.Order;
import com.andersen.travel_agency.entity.Tour;
import com.andersen.travel_agency.service.ServiceException;
import com.andersen.travel_agency.service.ServiceProvider;
import com.andersen.travel_agency.service.TravelAgencyService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DAOException, IOException, ServiceException, SQLException {

        /*
            1. all tours
            2. make an order
            3. show the order
            4. update the order
         */

    }

    private static void execute(int choice) throws ServiceException {
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        TravelAgencyService travelAgencyService = serviceProvider.getTravelAgencyService();

        switch (choice) {
            case 1:
                System.out.println("List of all tours :");
                travelAgencyService.getAllTours().stream().forEach(Tour::showInfo);
                break;

            case 2:
                System.out.println("Make an order :");

                String firstName = enter("first name");
                String lastName = enter("last name");
                String passport = enter("passport");
                int tourId = Integer.parseInt(enter("tour id"));

                int res = travelAgencyService.makeOrder(firstName, lastName, passport, tourId);

                if (res > 0) {
                    System.out.println("add success");
                } else {
                    System.out.println("wrong data");
                }
                break;

            case 3:
                System.out.println("Your order :");
                String pass = enter("passport");
                Order order = travelAgencyService.showOrder(pass);

                System.out.println("[name - " + order.getUser().getFirstName() + " " + order.getUser().getLastName() + "] " +
                        "[tour - " + order.getTour().getCountry().getName() + " " + order.getTour().getHotel().getStars() + "] " +
                        "[total coast - " + order.getTour().getTotalCoast() + "]");
                break;

            case 4:
                System.out.println("update the order :");
                String p = enter("passport");
                int t = Integer.parseInt(enter("tour id"));
                int update = travelAgencyService.updateOrder(p, t);

                if (update > 0) {
                    System.out.println("the order updated");
                } else {
                    System.out.println("no order found");
                }

            default:
                System.out.println("try later");
        }
    }

    private static String enter(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the " + message);

        return scanner.next();

    }

}

