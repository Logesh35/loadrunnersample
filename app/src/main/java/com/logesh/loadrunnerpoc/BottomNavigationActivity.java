package com.logesh.loadrunnerpoc;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {
    private static final String TAG = "BottomNavigationActivit";
    ToggleFilter mToggleFilter;
    BottomNavigationView bottomNavigationView;

    public BottomNavigationActivity(MainActivity2 mainActivity) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigate);
        init();
    }


    public void BottomNavigationActivity(ToggleFilter toggleFilter) {
        mToggleFilter = toggleFilter;
    }

    private void init() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        //Creating and sending bottom navigation views object and bottom navigation view listener object
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    // This function gets fired up while clicking on bottom navigation bar
    public BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){

                        case R.id.navigation_dashboard:
                            selectedFragment = new FragmentDashboard();
                            mToggleFilter.toggleFilterButton(true);
                            break;
                        case R.id.navigation_my_search:
                            selectedFragment = new FragmentFindloads();
                            break;
                        case R.id.navigation_wishlist:
                            selectedFragment = new FragmentMyorders();
                            break;
                        case R.id.navigation_notification:
                            selectedFragment = new FragmentNotification();
                            break;

                        case R.id.navigation_profile:
                            selectedFragment = new FragmentProfile();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.homePageFrameLayout, selectedFragment).commit();
                    return true;
                }
            };

    interface ToggleFilter {
        void toggleFilterButton(boolean status);
    }
}

