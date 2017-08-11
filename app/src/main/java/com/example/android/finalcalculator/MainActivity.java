package com.example.android.finalcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText editTextCurrent;
    private EditText editTextTarget;
    private EditText editTextFinalWeight;
    private Button buttonCalc;
    private TextView tvOutput;

    private double current;
    private double target;
    private double finalWeight;
    private double output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCurrent = (EditText) findViewById(R.id.editTextCurrent);
        editTextTarget = (EditText) findViewById(R.id.editTextTarget);
        editTextFinalWeight = (EditText) findViewById(R.id.editTextFinalWeight);
        buttonCalc = (Button) findViewById(R.id.buttonCalc);
        tvOutput = (TextView) findViewById(R.id.tvOutput);

        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    current = Double.parseDouble(editTextCurrent.getText().toString());
                    target = Double.parseDouble(editTextTarget.getText().toString());
                    finalWeight = Double.parseDouble(editTextFinalWeight.getText().toString());

                    current /= 100;
                    target /= 100;
                    finalWeight /= 100;
                    Log.d(TAG, "onClick: " + current + " " + target + " " + finalWeight);
                    output = (target - current * (1 - finalWeight )) / finalWeight;
//                    Log.d(TAG, "onClick: output= " + output);
                    output *= 100;
                    tvOutput.setText(String.format("%.2f", output) + "%");//rounds off thousandths
                } catch(NumberFormatException e){
                    Log.d(TAG, "onClick: no data entered");
                    //popup stating no data was entered
                }
            }
        });
    }
}
