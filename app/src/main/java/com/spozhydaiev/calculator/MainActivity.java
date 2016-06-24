package com.spozhydaiev.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText firstOperandView;
    private EditText secondOperandView;

    private Button additionButton;
    private Button subtractionButton;
    private Button multiplicationButton;
    private Button divisionButton;

    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstOperandView = (EditText) findViewById(R.id.firstOperandEditText);

        secondOperandView = (EditText) findViewById(R.id.secondOperandEditText);

        resultView = (TextView) findViewById(R.id.resultTextView);

        additionButton = (Button) findViewById(R.id.additionButton);
        additionButton.setOnClickListener(this);

        subtractionButton = (Button) findViewById(R.id.subtractionButton);
        subtractionButton.setOnClickListener(this);

        multiplicationButton = (Button) findViewById(R.id.multiplicationButton);
        multiplicationButton.setOnClickListener(this);

        divisionButton = (Button) findViewById(R.id.divisionButton);
        divisionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float firstOperand = Float.parseFloat(firstOperandView.getText().toString());
        float secondOperand = Float.parseFloat(secondOperandView.getText().toString());

        float result = 0.0f;

        String operator = "";

        switch (v.getId()) {
            case R.id.additionButton:
                operator = "+";
                result = firstOperand + secondOperand;
                resultView.setText("\n" + firstOperand + " " + operator + " " + secondOperand + " = " + result);
                break;

            case R.id.subtractionButton:
                operator = "-";
                result = firstOperand - secondOperand;
                resultView.setText("\n" + firstOperand + " " + operator + " " + secondOperand + " = " + result);
                break;

            case R.id.multiplicationButton:
                operator = "*";
                result = firstOperand * secondOperand;
                resultView.setText("\n" + firstOperand + " " + operator + " " + secondOperand + " = " + result);
                break;

            case R.id.divisionButton:
                operator = "/";
                if (secondOperand == 0) {
                    resultView.setText("\nDivide by zero!");
                    break;
                }
                result = firstOperand / secondOperand;
                resultView.setText(firstOperand + " " + operator + " " + secondOperand + " = " + result);
                break;
        }
    }
}
