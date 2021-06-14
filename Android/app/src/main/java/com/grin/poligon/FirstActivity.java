package com.grin.poligon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.grin.poligon.alpha.AlphaActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        startActivity(new Intent(FirstActivity.this, AlphaActivity.class));
        finish();
    }
}