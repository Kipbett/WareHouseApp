package com.example.warehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class ManagerHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home);

        Toolbar toolbar_manager = findViewById(R.id.tool_bar_manager);
        setSupportActionBar(toolbar_manager);

        drawerLayout = findViewById(R.id.drawer_layout_manager);
        NavigationView navigationView = findViewById(R.id.nav_view_manager);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar_manager,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_manager, new ManagerHome())
                    .commit();
            navigationView.setCheckedItem(R.id.show_ware_house_manager);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.show_ware_house_manager:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_manager, new ManagerHome())
                        .commit();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }

    }
}