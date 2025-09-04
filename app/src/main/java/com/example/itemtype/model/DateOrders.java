package com.example.itemtype.model;

import java.util.List;

public class DateOrders {

    private String date;
    private List<OrderData> orders;
    private int noOfOrders;

    public String getDate() {
        return date;
    }

    public List<OrderData> getOrders() {
        return orders;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }
}
