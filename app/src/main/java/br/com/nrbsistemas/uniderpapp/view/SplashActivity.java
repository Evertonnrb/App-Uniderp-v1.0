package br.com.nrbsistemas.uniderpapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import br.com.nrbsistemas.uniderpapp.R;

public class SplashActivity extends AppCompatActivity {

    private static final int TEMPO = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, TEMPO);
    }


}
