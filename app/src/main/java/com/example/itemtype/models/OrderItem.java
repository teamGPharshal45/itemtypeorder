package com.example.itemtype.models;

public class OrderItem extends ListItem{

    private OrdersDetails ordersDetails;

    public OrderItem(OrdersDetails ordersDetails) {
        this.ordersDetails = ordersDetails;
    }

    public OrdersDetails getOrdersDetails() {
        return ordersDetails;
    }

    @Override
    public int getType() {
        return TYPE_ORDER;
    }
}
