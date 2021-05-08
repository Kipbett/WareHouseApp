package com.example.warehouse.ui.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.warehouse.R;
import com.example.warehouse.models.Warehouses;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class AdminWarehouseActivity extends AppCompatActivity {

    EditText name_ware, owner_ware, phone_ware, email_ware;

    Button add, cancel;

    String name, owner, phone, email, location, address;

    Location locate;
    Geocoder geocoder;
    List<Address> addresses;
    double lat, lng;
    int latestLocationIndex;

    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;

    public static final String firebase_URL = "https://warehouse-303320-default-rtdb.firebaseio.com/";

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(firebase_URL);
    private DatabaseReference reference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_warehouse);

        name_ware = findViewById(R.id.ware_name);
        owner_ware = findViewById(R.id.ware_owner);
        email_ware = findViewById(R.id.ware_owner_email);
        phone_ware = findViewById(R.id.ware_owner_number);

        geocoder = new Geocoder(this, Locale.getDefault());
        
        permissionPop();

        add = findViewById(R.id.add_ware);
        cancel = findViewById(R.id.cancel);

        //String userId = reference.push().getKey();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
                Warehouses warehouses = new Warehouses();
                AdminWarehouseActivity adminWarehouseActivity = new AdminWarehouseActivity();

                name = name_ware.getText().toString().trim();
                owner = owner_ware.getText().toString().trim();
                phone = phone_ware.getText().toString().trim();
                email = email_ware.getText().toString().trim();
                location = getCurrentLocation();

                warehouses.setWarehouse_name(name);
                warehouses.setLocation(location);
                warehouses.setOwner(owner);
                warehouses.getOwner_phone(phone);
                warehouses.setOwner_email(email);
                warehouses.setLongitude(lng);
                warehouses.setLatitude(lat);

                reference = firebaseDatabase.getReference().child("warehouses");
                reference.child(name).setValue(warehouses);
            }
        });
    }

    private void permissionPop() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if(!locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) || !locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Location Permission");
            builder.setIcon(R.drawable.common_google_signin_btn_icon_dark_focused);
            builder.setMessage("The app need to access your location");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(AdminWarehouseActivity.this, "App will not work well!!!", Toast.LENGTH_SHORT).show();
                }
            });

            Dialog dialog = builder.create();
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } else {
            Toast.makeText(this, "Location is on.", Toast.LENGTH_SHORT).show();
        }
    }

    private void getLocation() {
        new AlertDialog.Builder(this)
                .setTitle("")
                .setMessage("")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AdminWarehouseActivity.this, "Application Wont Work Properly", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                            ActivityCompat.requestPermissions(
                                    AdminWarehouseActivity.this,
                                    new String[]{ACCESS_FINE_LOCATION},
                                    REQUEST_CODE_LOCATION_PERMISSION
                            );
                        } else {
                            getCurrentLocation();
                        }
                    }
                })
                .setIcon(R.drawable.common_google_signin_btn_icon_light_normal)
        .setCancelable(true)
        .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION && grantResults.length > 0){
            getCurrentLocation();
        } else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("MissingPermission")
    public String getCurrentLocation() {

        final LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setFastestInterval(3000);

        LocationServices.getFusedLocationProviderClient(AdminWarehouseActivity.this)
                .requestLocationUpdates(locationRequest, new LocationCallback(){
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(AdminWarehouseActivity.this)
                                .removeLocationUpdates(this);

                        if (locationResult != null && locationResult.getLocations().size() > 0){
                            latestLocationIndex = locationResult.getLocations().size() - 1;
                            lat = locationResult.getLocations().get(latestLocationIndex).getLatitude();
                            lng = locationResult.getLocations().get(latestLocationIndex).getLongitude();
                            try {
                                addresses = geocoder.getFromLocation(lat, lng, 1);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            address = addresses.get(0).getAddressLine(0);
                        }
                    }
                }, Looper.getMainLooper());

        return address;

        //return latestLocationIndex;
    }
}