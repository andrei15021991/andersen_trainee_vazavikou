package com.andersen.travel_agency.dao;

public final class DAOTool {

    public static final String LIST_TOUR = "select t.id, t.total_coast as coast, c.name as country, h.stars, r.review from tour as t " +
                                           "inner join country as c on t.country_id=c.id " +
                                           "inner join hotel as h on t.hotel_id=h.id " +
                                           "inner join review as r on t.review_id=r.id " +
                                           "order by t.id";

    public static final String MAKE_ORDER_USER = "insert into user (first_name, last_name, passport) values (?,?,?)";

    public static final String MAKE_ORDER = "insert into order_list (tour_id, user_id) values (?,(select id from user where passport=?))";

    public static final String SHOW_ORDER = "select * from order_list as o " +
                                            "inner join user as u on o.user_id=u.id " +
                                            "inner join tour as t on o.tour_id=t.id " +
                                            "inner join country as c on t.country_id=c.id " +
                                            "inner join hotel as h on t.hotel_id=h.id " +
                                            "where u.passport=?";

    public static final String UPDATE_ORDER = "update order_list as o " +
                                              "inner join user as u on o.user_id=u.id " +
                                              "set o.tour_id=? " +
                                              "where u.passport=?";





    private DAOTool() {

    }
}
