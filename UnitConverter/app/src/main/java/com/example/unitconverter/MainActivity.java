package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // Set variables for each of the input and output elements
    Spinner unitSpinner;
    public TextView textResult1;
    public TextView textResult2;
    public TextView textResult3;
    public TextView textUnit1;
    public TextView textUnit2;
    public TextView textUnit3;
    public TextView textError;
    public EditText unitInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        // Set up the spinner with the strings obtained from strings.xml
        unitSpinner = findViewById(R.id.unitSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(adapter);
        unitSpinner.setOnItemSelectedListener(this);

        // Assign each declared variable to it's relevant element
        textResult1 = findViewById(R.id.textResult1);
        textResult2 = findViewById(R.id.textResult2);
        textResult3 = findViewById(R.id.textResult3);
        textUnit1 = findViewById(R.id.textUnit1);
        textUnit2 = findViewById(R.id.textUnit2);
        textUnit3 = findViewById(R.id.textUnit3);
        textError = findViewById(R.id.textError);
        unitInput = findViewById(R.id.textBoxInput);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    // Function for executing calculations when the measure button is pressed
    public void measureClick(View view){
        // If the spinner is selecting the wrong unit, set the error and do not calculate
        if(unitSpinner.getSelectedItemPosition() != 0) {
            textError.setText("Please ensure that you select Metres in the dropdown box.");
            return;
        }

        // Set the units to the correct values and clear any error message
        textUnit1.setText("Centimetres");
        textUnit2.setText("Feet");
        textUnit3.setText("Inches");
        textError.setText("");

        // Obtain the value from the input and ensure that it isn't empty
        String inputString = unitInput.getText().toString();
        if (TextUtils.isEmpty(inputString)) {inputString = "0";}
        double input = Double.parseDouble(inputString);

        // Set the value of each result to the correct answer
        double resultDouble1 = input*100;
        String result1 = String.format("%.2f",resultDouble1);
        textResult1.setText(result1);

        double resultDouble2 = input*3.28084;
        String result2 = String.format("%.2f",resultDouble2);
        textResult2.setText(result2);

        double resultDouble3 = input*39.370079;
        String result3 = String.format("%.2f",resultDouble3);
        textResult3.setText(result3);
    }

    // Function for executing calculations when the temperature button is pressed
    public void temperatureClick(View view){
        // If the spinner is selecting the wrong unit, set the error and do not calculate
        if(unitSpinner.getSelectedItemPosition() != 1) {
            textError.setText("Please ensure that you select Celsius in the dropdown box.");
            return;
        }

        // Set the units to the correct values and clear any error message
        textUnit1.setText("Fahrenheit");
        textUnit2.setText("Kelvin");
        textUnit3.setText("");
        textError.setText("");

        // Obtain the value from the input and ensure that it isn't empty
        String inputString = unitInput.getText().toString();
        if (TextUtils.isEmpty(inputString)) {inputString = "0";}
        double input = Double.parseDouble(inputString);

        // Set the value of each result to the correct answer
        double resultDouble1 = (input*4.5)+32;
        String result1 = String.format("%.2f",resultDouble1);
        textResult1.setText(result1);

        double resultDouble2 = input+273.15;
        String result2 = String.format("%.2f",resultDouble2);
        textResult2.setText(result2);

        textResult3.setText("");
    }

    // Function for executing calculations when the weight button is pressed
    public void weightClick(View view){
        // If the spinner is selecting the wrong unit, set the error and do not calculate
        if(unitSpinner.getSelectedItemPosition() != 2) {
            textError.setText("Please ensure that you select Kilograms in the dropdown box.");
            return;
        }

        // Set the units to the correct values and clear any error message
        textUnit1.setText("Grams");
        textUnit2.setText("Ounces(Oz)");
        textUnit3.setText("Pounds(lb)");
        textError.setText("");

        // Obtain the value from the input and ensure that it isn't empty
        String inputString = unitInput.getText().toString();
        if (TextUtils.isEmpty(inputString)) {inputString = "0";}
        double input = Double.parseDouble(inputString);

        // Set the value of each result to the correct answer
        double resultDouble1 = input*1000;
        String result1 = String.format("%.2f",resultDouble1);
        textResult1.setText(result1);

        double resultDouble2 = input*35.274;
        String result2 = String.format("%.2f",resultDouble2);
        textResult2.setText(result2);

        double resultDouble3 = input*2.205;
        String result3 = String.format("%.2f",resultDouble3);
        textResult3.setText(result3);
    }
}