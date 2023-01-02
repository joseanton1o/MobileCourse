package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting the converterActivity button
        Button converterActivityButton = (Button) findViewById(R.id.converterActivity);
        converterActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent showConverterActivity = new Intent(getApplicationContext(), ConverterActivity.class);
                startActivity(showConverterActivity);
            }
        });

        // Get the aboutMe button
        Button aboutMeButton = (Button) findViewById(R.id.aboutMe);
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = "https://joseanton1o.github.io/portfolio/";
                Uri webAddress = Uri.parse(link);

                Intent showAboutMe = new Intent(Intent.ACTION_VIEW, webAddress);
                if (showAboutMe.resolveActivity(getPackageManager()) != null) {
                    startActivity(showAboutMe);
                }
            }
        });

        // Get the calculatorActivity button
        Button calculatorActivityButton = (Button) findViewById(R.id.basicCalculator);
        calculatorActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showCalculatorActivity = new Intent(getApplicationContext(), CalculatorActivity.class);
                startActivity(showCalculatorActivity);
            }
        });
    }
}