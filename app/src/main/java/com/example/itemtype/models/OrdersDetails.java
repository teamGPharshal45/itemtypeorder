package com.example.itemtype.models;

public class OrdersDetails {
    private String startTime;
    private String endTime;
    private String orderTitle;
    private String customerName;
    private String statusTag;
    private String paymentTag;


    public OrdersDetails(String startTime, String endTime, String orderTitle, String customerName, String statusTag, String paymentTag) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.orderTitle = orderTitle;
        this.customerName = customerName;
        this.statusTag = statusTag;
        this.paymentTag = paymentTag;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatusTag() {
        return statusTag;
    }

    public void setStatusTag(String statusTag) {
        this.statusTag = statusTag;
    }

    public String getPaymentTag() {
        return paymentTag;
    }

    public void setPaymentTag(String paymentTag) {
        this.paymentTag = paymentTag;
    }
}
