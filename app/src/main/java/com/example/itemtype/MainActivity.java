package com.example.itemtype;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.itemtype.MenuAdapter.OrdersSubMenuAdapter;
import com.example.itemtype.ui.CancelledOrders.CancelledOrders;
import com.example.itemtype.ui.PastOrders.PastOrder;
import com.example.itemtype.ui.UpcomingOrders.UpcomingBookings;
import com.example.itemtype.ui.WaitListOrders.WaitListOrder;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ImageButton backButton , nextButton;
    TextView MenuName;
    ImageView MenuLogo;

    ConstraintLayout SubMenuParent;
    int count = 0;

    String MenuNm[] = {
            "UPCOMING","PAST","WAITLIST","CANCELLED"
    };

    int MenuImg[] = {
            R.drawable.outline_calendar_month_24, R.drawable.baseline_done_24,R.drawable.outline_access_time_24, R.drawable.outline_free_cancellation_24
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ViewPager2 viewPagerTabs = findViewById(R.id.OrderList);

        OrdersSubMenuAdapter adapter = new OrdersSubMenuAdapter(getSupportFragmentManager(),getLifecycle());

        adapter.addFragment(new UpcomingBookings());
        adapter.addFragment(new PastOrder());
        adapter.addFragment(new WaitListOrder());
        adapter.addFragment(new CancelledOrders());

        viewPagerTabs.setAdapter(adapter);
        viewPagerTabs.setUserInputEnabled(false);
        nextButton = findViewById(R.id.NextButton);
        backButton = findViewById(R.id.BackButton);
        MenuLogo = findViewById(R.id.ImgLogo);
        MenuName = findViewById(R.id.MenuName);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count>3) {
                    count = 0;
                    viewPagerTabs.setCurrentItem(count);
                }

                MenuLogo.setImageResource(MenuImg[count]);
                MenuName.setText(MenuNm[count]);
                viewPagerTabs.setCurrentItem(count);



            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                if(count<0) {
                    count = 3;
                    viewPagerTabs.setCurrentItem(count);
                }

                MenuLogo.setImageResource(MenuImg[count]);
                MenuName.setText(MenuNm[count]);
                viewPagerTabs.setCurrentItem(count);



            }
        });






    }
}