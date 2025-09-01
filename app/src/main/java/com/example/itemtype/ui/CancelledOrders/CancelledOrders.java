package com.example.itemtype.ui.CancelledOrders;

import android.os.Bundle;
import android.util.Log;
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
import com.example.itemtype.models.MainOrderDetails;
import com.example.itemtype.models.OrderItem;
import com.example.itemtype.models.OrdersDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CancelledOrders extends Fragment {

    RecyclerView recyclerView;
    List<MainOrderDetails> mainOrderDetailsArrayList = new ArrayList<>();

    OrdersAdapter adapter;


    List<ListItem> itemArrayList;
    Random random = new Random();
    TestDataGenerator dataGenerator = new TestDataGenerator();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cancelled_orders, container, false);
        recyclerView = view.findViewById(R.id.orders);
        CreateDatesOrder();

        return view;
    }

    public void CreateDatesOrder()
    {


        for (int i=0;i<5;i++)
        {
            ArrayList<OrdersDetails> childList = new ArrayList<>();

            int num = 2 + random.nextInt(4);

            for(int j=0;j<num;j++){
                childList.add(dataGenerator.GetRandomOrder());
            }

            String date = "2025-08-"+(20+i);

            mainOrderDetailsArrayList.add(new MainOrderDetails(childList,date));

        }


        itemArrayList = new ArrayList<>();

        for (MainOrderDetails details:mainOrderDetailsArrayList)
        {
            itemArrayList.add(new DateItem(details.getDate()));

            for (OrdersDetails order:details.getOrdersDetailsArrayList())
            {
                itemArrayList.add(new OrderItem(order));
            }
        }


       Log.d("Cancelled orders","ItemsCount = "+itemArrayList.size());

        adapter = new OrdersAdapter(getContext(),itemArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


    }




}