package com.example.tcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

         private final Timer timer = new Timer();
         TimerTask timerTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w("TAG", "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();
                        System.out.println("aquiiiiiiiiii");
                        // Log and toast
                       // String msg = getString(R.string.msg_token_fmt, token);
                        System.out.println(token);
                        Toast.makeText(Splash.this,"Your device registration token is"
                                + token, Toast.LENGTH_SHORT).show();
                    }
                });

        timerTask =  new TimerTask() {
            @Override
            public void run(){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gotoActivityLogin();
                    }
                });



            }




        };
        timer.schedule(timerTask, 2000);

    }

    private void gotoActivityLogin() {
        Intent intent= new Intent(getApplicationContext(), TelaInicial.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    finish();

    }




}