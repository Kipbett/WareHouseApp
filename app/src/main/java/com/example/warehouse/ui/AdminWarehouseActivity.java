package com.example.warehouse.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.warehouse.R;
import com.example.warehouse.models.Warehouses;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminWarehouseActivity extends AppCompatActivity {

    EditText name_ware, owner_ware, phone_ware, email_ware, location_ware;

    Button add, cancel;

    String name, owner, phone, email, location;

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
        location_ware = findViewById(R.id.ware_location);

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
                Warehouses warehouses = new Warehouses();

                name = name_ware.getText().toString().trim();
                owner = owner_ware.getText().toString().trim();
                phone = phone_ware.getText().toString().trim();
                email = email_ware.getText().toString().trim();
                location = location_ware.getText().toString().trim();

                warehouses.setWarehouse_name(name);
                warehouses.setLocation(location);
                warehouses.setOwner(owner);
                warehouses.getOwner_phone(phone);
                warehouses.setOwner_email(email);

                reference = firebaseDatabase.getReference().child("warehouses");
                reference.child(phone).setValue(warehouses);
            }
        });
    }
}