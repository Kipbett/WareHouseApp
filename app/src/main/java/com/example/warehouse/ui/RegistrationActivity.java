package com.example.warehouse.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.warehouse.R;
import com.example.warehouse.models.RegUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    EditText usernname, email, phone, password, confirm_password;

    TextView login;

    Button btn_register;

    String u_name, u_email,u_phone, u_password, u_confirm_password;

    public static final String firebase_URL = "https://warehouse-303320-default-rtdb.firebaseio.com/";

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(firebase_URL);
    private DatabaseReference reference = firebaseDatabase.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        usernname = findViewById(R.id.reg_username);
        email = findViewById(R.id.reg_email);
        phone = findViewById(R.id.reg_phone);
        password = findViewById(R.id.reg_password);
        confirm_password = findViewById(R.id.reg_confirm_password);
        login = findViewById(R.id.text_login);

        btn_register = findViewById(R.id.button_register);

        //String userId = reference.push().getKey();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login_intent = new Intent(RegistrationActivity.this, UserLoginActivity.class);
                startActivity(login_intent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RegUser regUser = new RegUser();

                u_name = usernname.getText().toString();
                u_email = email.getText().toString();
                u_phone = phone.getText().toString();
                u_password = password.getText().toString();
                u_confirm_password = confirm_password.getText().toString();

                regUser.setEmail(u_email);
                regUser.setPassword(u_password);
                regUser.setPhone(u_phone);
                regUser.setUsername(u_name);

                if (u_password.equals(u_confirm_password)){
                    reference = firebaseDatabase.getReference().child("user");
                    reference.child(u_phone).setValue(regUser);
                } else {
                    Toast.makeText(RegistrationActivity.this, "Passwords do not match!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}