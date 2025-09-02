package com.example.itemtype.ui.UpcomingOrders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itemtype.R;
import com.example.itemtype.dummydatagenerators.TestDataGenerator;
import com.example.itemtype.models.DateItem;
import com.example.itemtype.models.ListItem;
import com.example.itemtype.models.OrderItem;
import com.example.itemtype.ui.CancelledOrders.OrdersAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class UpcomingBookings extends Fragment  {

    RecyclerView recyclerView;

    Random random = new Random();
    TestDataGenerator dataGenerator = new TestDataGenerator();
    private List<ListItem> itemArrayList;
    OrdersAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming_bookings, container, false);
        recyclerView = view.findViewById(R.id.orders);
        CreateDatesOrder();


        return view;
    }

    public void CreateDatesOrder()
    {
        itemArrayList = new ArrayList<>();


        for (int i=0;i<5;i++)
        {
            String date = "2025-08-"+(20+i);

            itemArrayList.add(new DateItem(date));

            int num = 2 + random.nextInt(20);

            for(int j=0;j<num;j++){
                itemArrayList.add(new OrderItem(dataGenerator.GetRandomOrder()));
            }


        }



        adapter = new OrdersAdapter(getContext(),itemArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);





    }
}