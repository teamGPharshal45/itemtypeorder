package com.example.itemtype.dummydatagenerators;

import com.example.itemtype.models.OrdersDetails;

import java.util.Random;

public class TestDataGenerator {
    private String[] Names = { "Alice Shammer" , "Bob Kallis" , "Harshal Mali" ,"George Buller" , "Abhishek Kolhe"};
    private String[] Status = {"Accepted","Pending","Failed"};
    private String[] Payment = {"Paid","Pending"};
    private String[] Titles = {"Haircut","Facial","Spa","Manicure","Massage"};
    private String[] Time ={"8:00 AM" , "9:00 AM", "10:00 AM" , "11:00 AM" , "12:00 PM" , "1:00 PM"};

    Random random = new Random();

    public OrdersDetails GetRandomOrder()
    {
        String startTime = Time[random.nextInt(Time.length)];
        String endTime = Time[random.nextInt(Time.length)];
        String title = Titles[random.nextInt(Titles.length)];
        String name = Names[random.nextInt(Names.length)];
        String status = Status[random.nextInt(Status.length)];
        String pay = Payment[random.nextInt(Payment.length)];

        return new OrdersDetails(startTime,endTime,title,name,status,pay);
    }

}
