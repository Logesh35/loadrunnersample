package com.logesh.loadrunnerpoc;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private BottomSheetBehavior bottomSheetBehavior;


    BottomNavigationView bottomNavigationView;
    View bottomSheetView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Check this out", "Main activity");
        //This is the layout file which is going to be displayed
        setContentView(R.layout.activity_main2);
        // calling the init function
        init();


        // Activating Course Fragment while the application runs for the first time
        getSupportFragmentManager().beginTransaction().replace(R.id.homePageFrameLayout, new FragmentDashboard()).commit();

    }

    private void init() {
        bottomSheetView = findViewById(R.id.bottomSheet);
        //Creating and sending bottom navigation views object and bottom navigation view listener object
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);



    }


    public BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){

                        case R.id.navigation_dashboard:
                            selectedFragment = new FragmentDashboard();
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
}