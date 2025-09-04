package com.example.itemtype;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.itemtype.model.JsonOrderRepository;
import com.example.itemtype.model.OrdersResponse;
import com.example.itemtype.ui.CancelledOrders.CancelledOrders;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RunWith(AndroidJUnit4.class)
public class CancelledOrderTest {

    FragmentScenario<CancelledOrders> fragmentScenario;

    @Test
    public void OrdersFragment()
    {


        Context context = ApplicationProvider.getApplicationContext();
        OrdersResponse ordersResponseMock = new OrdersResponse();
        try {
            InputStream is = context.getResources().openRawResource(R.raw.dummy_orders);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);

            Gson gson = new Gson();
            ordersResponseMock =  gson.fromJson(json, OrdersResponse.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonOrderRepository mockRepository = Mockito.mock(JsonOrderRepository.class);

        Mockito.when(mockRepository.getCancelledOrders()).thenReturn(ordersResponseMock);




        fragmentScenario = FragmentScenario.launchInContainer(CancelledOrders.class,null , new FragmentFactory(){
            @NonNull
            @Override
            public Fragment instantiate(
                    @NonNull ClassLoader classLoader,
                    @NonNull String className
            ){
                CancelledOrders fragment = new CancelledOrders();

                fragment.setJsonOrderRepository(mockRepository);

                return fragment;
            }
        });

        onView(withId(R.id.orders)).check(matches(isDisplayed()));


    }


}
