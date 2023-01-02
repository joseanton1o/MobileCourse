package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Get the calculate button and set the onClickListener
        Button calculateButton = (Button) findViewById(R.id.calculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the EditTexts and the TextViews
                EditText number1 = (EditText) findViewById(R.id.operand1);
                EditText number2 = (EditText) findViewById(R.id.operand2);
                TextView result = (TextView) findViewById(R.id.result);
                // Check whether the numbers are valid or not
                String n1 = number1.getText().toString();
                String n2 = number2.getText().toString();
                if (n1.equals("") || n2.equals("")) {
                    result.setText("Invalid numbers");
                    return;
                }
                // Get the values from the EditTexts
                Double num1 = Double.parseDouble(n1);
                Double num2 = Double.parseDouble(n2);


                // Get operation from spinner
                Spinner operation = (Spinner) findViewById(R.id.operation);
                String operationSelected = operation.getSelectedItem().toString();
                // Calculate the result
                // Switch statement to check which operation was selected
                switch (operationSelected) {
                    case "+":
                        result.setText(Double.toString(num1 + num2));
                        break;
                    case "-":
                        result.setText(Double.toString(num1 - num2));
                        break;
                    case "*":
                        result.setText(Double.toString(num1 * num2));
                        break;
                    case "/":
                        result.setText(Double.toString(num1 / num2));
                        break;
                }

            }
        });
    }
}