package com.example.itemtype.model;



import android.content.Context;

import com.example.itemtype.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonOrderRepository {

    private final Context context;

    public JsonOrderRepository(Context context) {
        this.context = context;
    }

    public OrdersResponse getCancelledOrders()
    {
        try {
            InputStream is = context.getResources().openRawResource(R.raw.cancelledorders);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);

            Gson gson = new Gson();
            return gson.fromJson(json, OrdersResponse.class);




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public OrdersResponse getPastOrders()
    {
        try {
            InputStream is = context.getResources().openRawResource(R.raw.past_orders);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);

            Gson gson = new Gson();
            return gson.fromJson(json, OrdersResponse.class);




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public OrdersResponse getUpcomingOrders()
    {
        try {
            InputStream is = context.getResources().openRawResource(R.raw.upcoming_orders);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);

            Gson gson = new Gson();
            return gson.fromJson(json, OrdersResponse.class);




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public OrdersResponse getWaitlistOrders()
    {
        try {
            InputStream is = context.getResources().openRawResource(R.raw.waitlist_orders);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);

            Gson gson = new Gson();
            return gson.fromJson(json, OrdersResponse.class);




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
