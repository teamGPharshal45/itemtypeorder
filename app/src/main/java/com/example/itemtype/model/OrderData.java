package com.example.itemtype.model;

import java.util.List;

public class OrderData {
    private String duration;
    private String total;
    private String paymentTag;
    private String statusTag;
    private String staffMember;
    private String startTime;
    private String endTime;
    private String orderTitle;
    private String customerName;
    private String phoneNo;
    private List<Services> service;


    public String getDuration() {
        return duration;
    }

    public String getTotal() {
        return total;
    }

    public String getPaymentTag() {
        return paymentTag;
    }

    public String getStatusTag() {
        return statusTag;
    }

    public String getStaffMember() {
        return staffMember;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public List<Services> getService() {
        return service;
    }
}
