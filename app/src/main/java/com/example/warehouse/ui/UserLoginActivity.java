package com.example.warehouse.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.warehouse.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLoginActivity extends AppCompatActivity {

    private EditText txt_email, txt_password;
    private Button btn_login;
    private TextView text_reg;

    private String email, password;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        txt_email = findViewById(R.id.username);
        txt_password = findViewById(R.id.password);
        text_reg = findViewById(R.id.register_text);
        btn_login = findViewById(R.id.button_login);

        firebaseAuth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = txt_email.getText().toString();
                password = txt_password.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(UserLoginActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (firebaseAuth.getCurrentUser() != null){
                        Toast.makeText(UserLoginActivity.this, "User already logged In", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent intent = new Intent(UserLoginActivity.this, ClientHomeActivity.class);
                        startActivity(intent);
                    } else {
                        firebaseAuth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(UserLoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                            finish();
                                            Intent intent = new Intent(UserLoginActivity.this, ClientHomeActivity.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(UserLoginActivity.this, "Login Failed!!!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }
            }
        });

        text_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg_intent = new Intent(UserLoginActivity.this, RegistrationActivity.class);
                startActivity(reg_intent);
            }
        });
    }

}