package com.example.myapplication5675756757575;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentNumber = "";
    private double operand1 = Double.NaN;
    private double operand2;

    private char currentOperator = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        // Number buttons
        findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("0");
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("1");
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("2");
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("3");
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("4");
            }
        });

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("5");
            }
        });

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("6");
            }
        });

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("7");
            }
        });

        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("8");
            }
        });

        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed("9");
            }
        });

        // Operator buttons
        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorPressed('+');
            }
        });

        findViewById(R.id.buttonSubtract).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorPressed('-');
            }
        });

        findViewById(R.id.buttonMultiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorPressed('*');
            }
        });

        findViewById(R.id.buttonDivide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorPressed('/');
            }
        });

        // Clear button
        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        // Decimal point button
        findViewById(R.id.buttonDecimal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.contains(".")) {
                    currentNumber += ".";
                    resultTextView.setText(currentNumber);
                }
            }
        });

        // Equal button
        findViewById(R.id.buttonEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorPressed('=');
            }
        });
    }

    private void numberPressed(String number) {
        currentNumber += number;
        resultTextView.setText(currentNumber);
    }

    private void operatorPressed(char operator) {
        if (!Double.isNaN(operand1)) {
            if (!currentNumber.equals("")) {
                operand2 = Double.parseDouble(currentNumber);

                switch (currentOperator) {
                    case '+':
                        operand1 = operand1 + operand2;
                        break;
                    case '-':
                        operand1 = operand1 - operand2;
                        break;
                    case '*':
                        operand1 = operand1 * operand2;
                        break;
                    case '/':
                        operand1 = operand1 / operand2;
                        break;
                    case '=': // Handle continuous operations
                        operand1 = operand2;
                        break;
                }

                if (operator != '=') {
                    currentOperator = operator;
                }

                resultTextView.setText(String.valueOf(operand1));
                currentNumber = "";
            }
        } else {
            operand1 = Double.parseDouble(currentNumber);
            currentNumber = "";
            currentOperator = operator;
        }
    }

    private void clear() {
        operand1 = Double.NaN;
        operand2 = Double.NaN;
        currentNumber = "";
        resultTextView.setText("");
    }
}

