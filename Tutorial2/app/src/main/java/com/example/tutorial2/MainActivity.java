package com.example.tutorial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attempts to launch an activity within our own app
        // Reference to the button to go to the second activity
        Button secondActivityBtn = (Button) findViewById(R.id.secondActivityBtn); // R look into the resources, id look into the id folder, secondActivity look for the secondActivity button
        // Set a click listener on the button
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // An intent is an object that is used to start another activity
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class); // getApplicationContext() is the context of the current activity, SecondActivity.class is the class of the activity we want to start
                // Show how to pass data to the next activity
                startIntent.putExtra("com.example.tutorial2.SOMETHING", "Hello World!"); // putExtra is a method of the intent class, the first parameter is the key, the second parameter is the value
                startActivity(startIntent);
            }
        });

        // Attempt to launch an activity outside our app
        Button googleBtn = (Button) findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Make the button go to google
                String google = "http://www.google.com";
                Uri webAddress = Uri.parse(google); // parse the string into a URI

                // Create an intent to go to google
                Log.d("MainActivity", "onClick: " + webAddress);
                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webAddress); // ACTION_VIEW is an action that is used to view data, webaddress is the URI
                if (gotoGoogle.resolveActivity(getPackageManager()) != null) { // resolveActivity is a method of the intent class, getPackageManager is a method of the context class, it returns a package manager that can be used to query information about the package
                    startActivity(gotoGoogle);
                }
                /*
                As we are on Android 11 gotoGoogle.resolveActivity(getPackageManager()) is always null
                To fix this we need to add the following to the AndroidManifest.xml file:
                <queries>
                    <intent>
                        <!-- This is the intent that we want to query for. -->
                        <action android:name="android.intent.action.VIEW" />
                        <category android:name="android.intent.category.BROWSABLE" />
                        <data android:scheme="https" />
                    </intent>
                </queries>
                This solution was found here: https://stackoverflow.com/questions/62535856/intent-resolveactivity-returns-null-in-api-30

                 */
            }
        });
    }
}