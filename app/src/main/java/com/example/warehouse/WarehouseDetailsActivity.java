package com.example.warehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class WarehouseDetailsActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private static final int MY_PERMISSION_REQUEST_TO_SEND_SMS = 0;
    Button button_message, button_call;
    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse_details);

        button_call = findViewById(R.id.call);
        button_message = findViewById(R.id.message);

        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });

        button_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String num = button_call.getText().toString();
        String message = button_message.getText().toString();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)){
                
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSION_REQUEST_TO_SEND_SMS);
            }
        }
    }

    private void makeCall() {

        String num = button_call.getText().toString();

        if (num.trim().length() > 0){
            if (ContextCompat.checkSelfPermission(WarehouseDetailsActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(WarehouseDetailsActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tell" + num;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case REQUEST_CALL:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    makeCall();
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }

                break;

            case MY_PERMISSION_REQUEST_TO_SEND_SMS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    SmsManager smsManager = SmsManager.getDefault();

                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(this, "SMS Sent", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "SMS Failed", Toast.LENGTH_SHORT).show();
                    return;
                }

        }
    }
}