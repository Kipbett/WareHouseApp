package com.example.warehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
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
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage("0725585698", null, "Hello, I'd Love to enquire about your warehouse.", pi,null);
    }

    private void makeCall() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+0700403306));
        startActivity(callIntent);
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
                    sendMessage();
                    Toast.makeText(this, "SMS Sent", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "SMS Failed", Toast.LENGTH_SHORT).show();
                    return;
                }

        }
    }
}