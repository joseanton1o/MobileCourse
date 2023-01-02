package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        // As the spinner are not explained in the tutorial, I found some info here:
        // https://stackoverflow.com/questions/13377361/how-to-create-a-drop-down-list

        // Fill the spinner with the values of the enum ConversionType
        Spinner conversionTypeSpinner = (Spinner) findViewById(R.id.conversorSelector);
        String [] conversionTypes = new String[ConversionType.values().length];
        for (int i = 0; i < ConversionType.values().length; i++) {
            // Get the name of the enum value, Delete the underscore, uncapitalize every word and capitalize the first letter
            conversionTypes[i] = ConversionType.values()[i].name().replace("_", " ").toLowerCase();
            //conversionTypes[i] = ConversionType.values()[i].toString();
        }

        // Create an adapter to fill the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, conversionTypes);
        // Set the spinners adapter to the previously created one.
        conversionTypeSpinner.setAdapter(adapter);

        // Convert button
        Button convertButton = (Button) findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code to execute when the button is clicked
                // Get value from EditText decimal and convert to double
                EditText numberInput = (EditText) findViewById(R.id.numberInput);
                if (numberInput.getText().toString().equals("")) {
                    // Show an alert dialog if the user didn't enter a number
                    // Found this here:
                    // https://stackoverflow.com/questions/2115758/how-do-i-display-an-alert-dialog-on-android
                    new AlertDialog.Builder(ConverterActivity.this)
                            .setTitle("Error")
                            .setMessage("Please enter a number")
                            .setPositiveButton("OK", null)
                            .show();
                    return;
                }
                Double number = Double.parseDouble(numberInput.getText().toString());

                // Get the selected conversion type, undo the changes made to the name of the enum value
                String enumName = conversionTypeSpinner.getSelectedItem().toString().toUpperCase().replace(" ", "_");
                ConversionType conversionType = ConversionType.valueOf(enumName);

                if (number < 0 && (conversionType == ConversionType.FAHRENHEIT_TO_CELSIUS || conversionType == ConversionType.CELSIUS_TO_FAHRENHEIT)) {
                    // Show an alert dialog if the user entered a negative number
                    // Found this here:
                    // https://stackoverflow.com/questions/2115758/how-do-i-display-an-alert-dialog-on-android
                    new AlertDialog.Builder(ConverterActivity.this)
                            .setTitle("Error")
                            .setMessage("Please enter a positive number for this conversion")
                            .setPositiveButton("OK", null)
                            .show();
                    return;
                }

                // Convert the number
                Double res = Conversor.convert(conversionType, number);

                // Get result text view
                TextView result = (TextView) findViewById(R.id.resultTextView);
                result.setText(res.toString());

                ConversionResult conversionResult = new ConversionResult(number, res, conversionType);
                // Use the singleton to add the conversion result to the list
                History history = History.getInstance();
                history.addConversionResult(conversionResult);

                ConversionAdapter adapter = new ConversionAdapter(ConverterActivity.this, history.getConversionResults());
                // Get the list view
                ListView listView = (ListView) findViewById(R.id.lastsConversionsList);
                listView.setAdapter(adapter); // Should be fine by now
            }
        });

        // Get the history singleton so we can fill the list view if there are any conversion results when the activity is created
        History history = History.getInstance();
        if (history.getConversionResults().size() > 0) {
            // cAdapter stands for conversion adapter
            ConversionAdapter cAdapter = new ConversionAdapter(ConverterActivity.this, history.getConversionResults());
            // Get the list view
            ListView listView = (ListView) findViewById(R.id.lastsConversionsList);
            listView.setAdapter(cAdapter); // Should be fine by now
        }


    }
}