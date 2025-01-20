package com.example.paperly;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paperly.Fragment.FragmentNews;
import com.example.paperly.Fragment.FragmentSetting;
import com.example.paperly.Fragment.FragmentUtilities;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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

        /*
        Thiết lập Bottom navigation view
        */

        // Mặc định ban đầu chọn Fragment News
        BottomNavigationView nav = findViewById(R.id.bottom_navigation);
        if(savedInstanceState == null){
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.fragment_container, new FragmentNews()).
                    commit();
        }

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if(item.getItemId() == R.id.news)
                {
                    selectedFragment = new FragmentNews();
                }
                else if(item.getItemId() == R.id.utilities) {
                    selectedFragment = new FragmentUtilities();
                }
                else if(item.getItemId() == R.id.settings) {
                    selectedFragment = new FragmentSetting();
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();
                }

                return true;
            }
        });

    }
}