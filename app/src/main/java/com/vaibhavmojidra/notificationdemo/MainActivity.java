package com.vaibhavmojidra.notificationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText EmailTB, PassTB;
    Button LoginB;
    private static final String TAG = "MainActivity";
    private String email,pass;
    private FirebaseAuth mAuth;
    private Context context;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmailTB = findViewById(R.id.EmailTB);
        PassTB = findViewById(R.id.PassTB);
        LoginB = findViewById(R.id.Login);
        mAuth = FirebaseAuth.getInstance();
        intent = new Intent(MainActivity.this,SendNotif.class);

        Log.d(TAG, "onCreate: ");
      // this.startActivity(new Intent(MainActivity.this,SendNotif.class));
        onClickListnerEvent();
    }

    private void onClickListnerEvent() {
        Log.d(TAG, "onClickListnerEvent: ");
        if (FirebaseAuth.getInstance().getCurrentUser()!= null) {
            startActivity(intent);
        } else {
            LoginB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    email = EmailTB.getText().toString().trim();
                    pass = PassTB.getText().toString().trim();

                    if(email == null){
                        Toast.makeText(context, "Email Error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(pass == null){
                        Toast.makeText(context, "Pass Error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d(TAG, "onComplete: ");
                            startActivity(intent);
                        }
                    });
                }
            });
        }
    }
}
