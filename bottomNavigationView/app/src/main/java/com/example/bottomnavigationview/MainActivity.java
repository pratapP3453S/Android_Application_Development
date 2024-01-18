package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.btmNavView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id==R.id.nav_home){
                    layoutLoad(new HomeFragment(), false);
                }
                else if (id==R.id.nav_contacts){
                    layoutLoad(new ContactFragment(), false);
                }
                else if(id==R.id.nav_search){
                    layoutLoad(new SearchFragment(), false);
                }
                else if (id==R.id.nav_utilities) {
                    layoutLoad(new UtilitiesFragment(), false);
                }
                else {
                    layoutLoad(new ProfileFragment(), true);
                }


                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.nav_profile);

    }
    public void layoutLoad(Fragment fragment, boolean flag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(flag){
            fragmentTransaction.remove(fragment);
            fragmentTransaction.add(R.id.container, fragment);
        }
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}