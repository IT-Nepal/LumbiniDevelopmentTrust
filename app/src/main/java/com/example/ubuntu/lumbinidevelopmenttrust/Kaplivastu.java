package com.example.ubuntu.lumbinidevelopmenttrust;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Kaplivastu extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaplivastu);

        textView = findViewById(R.id.tv);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");

        textView.setText(name);

    }

}
