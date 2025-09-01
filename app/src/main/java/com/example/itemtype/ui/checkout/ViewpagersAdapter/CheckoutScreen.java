package com.example.itemtype.ui.checkout.ViewpagersAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.itemtype.R;
import com.example.itemtype.ui.checkout.notes.AppointmentNotesFragement;
import com.example.itemtype.ui.checkout.notes.CustomerNotesFragment;
import com.example.itemtype.ui.checkout.tabs.appointmentDetailTab;
import com.example.itemtype.ui.checkout.tabs.customerDetailTab;
import com.google.android.material.tabs.TabLayout;


public class CheckoutScreen extends AppCompatActivity {

    TabLayout tabLayout;
    ImageButton backButton;
    ImageButton closeButton ;
    ViewPager2 viewPager2,viewPager3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkout_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backButton = findViewById(R.id.backButton);
        tabLayout = findViewById(R.id.tabLayout);
        closeButton = findViewById(R.id.closeButton);
        viewPager2 = findViewById(R.id.viewPager);
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager(),getLifecycle());

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        adapter.addFragment(new customerDetailTab());
        adapter.addFragment(new appointmentDetailTab());


        viewPager2.setAdapter(adapter);
        viewPager2.setUserInputEnabled(false);


        viewPager3 = findViewById(R.id.viewPager2);
        ViewPagerAdapter2 adapter2 = new ViewPagerAdapter2(getSupportFragmentManager(),getLifecycle());

        adapter2.addFragment(new CustomerNotesFragment());
        adapter2.addFragment(new AppointmentNotesFragement());

        viewPager3.setAdapter(adapter2);
        viewPager3.setUserInputEnabled(false);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
                viewPager3.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}