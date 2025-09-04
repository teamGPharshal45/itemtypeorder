package com.example.itemtype.ui.CancelledOrders;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itemtype.R;
import com.example.itemtype.dummydatagenerators.TestDataGenerator;
import com.example.itemtype.model.DateOrders;
import com.example.itemtype.model.JsonOrderRepository;
import com.example.itemtype.model.OrderData;
import com.example.itemtype.model.OrdersResponse;
import com.example.itemtype.models.DateItem;
import com.example.itemtype.models.ListItem;
import com.example.itemtype.models.OrderItem;
import com.example.itemtype.models.OrdersDetails;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CancelledOrders extends Fragment {

    RecyclerView recyclerView;

    OrdersAdapter adapter;


    List<ListItem> itemArrayList;
    Random random = new Random();
    TestDataGenerator dataGenerator = new TestDataGenerator();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cancelled_orders, container, false);
        recyclerView = view.findViewById(R.id.orders);
        JsonOrderRepository repository = new JsonOrderRepository(getContext());

OrdersResponse ordersResponse = repository.getCancelledOrders();

if(ordersResponse!=null) {
    CreateDatesOrder(ordersResponse);
}

        return view;
    }





    public void CreateDatesOrder(OrdersResponse ordersResponse)
    {
        itemArrayList = new ArrayList<>();

        for(DateOrders dateOrders : ordersResponse.getDates())
        {
            itemArrayList.add(new DateItem(dateOrders.getDate()));

            for (OrderData orderData : dateOrders.getOrders())
            {
                OrdersDetails ordersDetails = new OrdersDetails(orderData.getStartTime(),orderData.getEndTime(),orderData.getOrderTitle(),orderData.getCustomerName(),orderData.getStatusTag(),orderData.getPaymentTag());
                itemArrayList.add(new OrderItem(ordersDetails));
            }
        }



        adapter = new OrdersAdapter(getContext(),itemArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);





    }




}