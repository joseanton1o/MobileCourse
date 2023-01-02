package com.example.tutorial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get the intent that started this activity and extract the string
        if (getIntent().hasExtra("com.example.tutorial2.SOMETHING")) {
            String text = getIntent().getExtras().getString("com.example.tutorial2.SOMETHING");
            // Set the text view as the string
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(text);
        }
    }
}