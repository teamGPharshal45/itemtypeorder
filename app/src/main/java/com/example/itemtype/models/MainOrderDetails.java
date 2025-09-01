package com.example.itemtype.models;

import java.util.ArrayList;

public class MainOrderDetails {

    ArrayList<OrdersDetails> ordersDetailsArrayList ;
    String date;

    public MainOrderDetails(ArrayList<OrdersDetails> ordersDetailsArrayList, String date) {
        this.ordersDetailsArrayList = ordersDetailsArrayList;
        this.date = date;
    }

    public ArrayList<OrdersDetails> getOrdersDetailsArrayList() {
        return ordersDetailsArrayList;
    }

    public void setOrdersDetailsArrayList(ArrayList<OrdersDetails> ordersDetailsArrayList) {
        this.ordersDetailsArrayList = ordersDetailsArrayList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
