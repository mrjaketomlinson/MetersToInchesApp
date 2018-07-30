package com.jacob.meterstoinches;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText enterMeters;
    private Button convertButton;
    private TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterMeters = (EditText) findViewById(R.id.metersEditText);
        convertButton = (Button) findViewById(R.id.convertButton);
        resultTextView = (TextView) findViewById(R.id.resultID);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1 m = 39.3701 in
                double multiplier = 39.3701;
                double result = 0.0;

                // Use an if statement so that the app doesn't crash when the user doesn't enter anything.
                if (enterMeters.getText().toString().equals("")) {
                    resultTextView.setText(R.string.error_message);
                    resultTextView.setTextColor(Color.RED);
                } else {
                    double meterValue = Double.parseDouble(enterMeters.getText().toString()); // We are taking whatever we are getting from the user and parsing it from a string into a double.
                    result = meterValue * multiplier;
                    resultTextView.setTextColor(Color.DKGRAY);
                    resultTextView.setText(String.format("%.2f", result) + " inches"); // This converts the double into a string with only two decimal points.
                }
            }
        });

    }
}
