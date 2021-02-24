package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    TextView result_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        result_tv = findViewById(R.id.result_Tv);
    }

    public void onEqual(View view){
        if (operator.equals("")) {
            result_tv.setText(result);
            result = "";
        }else{
            String RHS = result_tv.getText().toString();
            result = calculate(result,operator,RHS);
            result_tv.setText(result);
            result = "";
            operator = "";
        }
    }
    String result = "";
    String operator = "";
    public void onClickOperator(View view){
        Button onClicked = ((Button) view);
        if (operator.equals("")){
            operator = onClicked.getText().toString();
            result = result_tv.getText().toString();
            result_tv.setText("");
        }else {
            String RHS = result_tv.getText().toString();
            result = calculate(result,operator,RHS);
            operator = onClicked.getText().toString();
            result_tv.setText("");
        }

    }

    private String calculate(String lhs, String operator, String rhs) {
        double n1 = Double.parseDouble(lhs);
        double n2 = Double.parseDouble(rhs);
        double res = 0.0;
        if (operator.equals("+")){
            res = n1 + n2;
        }else if (operator.equals("-")){
            res = n1 - n2;
        }else if (operator.equals("*")){
            res = n1 * n2;
        }else if (operator.equals("/")){
            res = n1 / n2;
        }
        return res+"";
    }

    public void onClickDigit(View view){
        Button onClicked = ((Button) view);
        result_tv.append(onClicked.getText().toString());
    }
}