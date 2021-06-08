    package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonadd, buttonsub, buttondiv, buttonmul, buttoneq, buttondel, buttondot;
    TextView input;
    String operand1 = "";
    String operand2 = "";
    String operator = "";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        buttonadd = (Button) findViewById(R.id.buttonadd);
        buttonsub = (Button) findViewById(R.id.buttonsub);
        buttonmul = (Button) findViewById(R.id.buttonmul);
        buttondiv = (Button) findViewById(R.id.buttondiv);
        buttondot = (Button) findViewById(R.id.buttondot);
        buttondel = (Button) findViewById(R.id.buttondel);
        buttoneq = (Button) findViewById(R.id.buttoneq);

        input = (TextView) findViewById(R.id.input);


        button0.setOnClickListener(this::setValue);
        button1.setOnClickListener(this::setValue);
        button2.setOnClickListener(this::setValue);
        button3.setOnClickListener(this::setValue);
        button4.setOnClickListener(this::setValue);
        button5.setOnClickListener(this::setValue);
        button6.setOnClickListener(this::setValue);
        button7.setOnClickListener(this::setValue);
        button8.setOnClickListener(this::setValue);
        button9.setOnClickListener(this::setValue);
        buttondot.setOnClickListener(this::setValue);

        buttonadd.setOnClickListener(this::setOperator);
        buttonsub.setOnClickListener(this::setOperator);
        buttonmul.setOnClickListener(this::setOperator);
        buttondiv.setOnClickListener(this::setOperator);

        buttondel.setOnClickListener(this::clear);

        buttoneq.setOnClickListener(this::evaluate);

    }


    public void setValue(View v)
    {
        CharSequence text = ((Button)v).getText();
        if(operator.equals(""))
        {
            operand1+=text;
        }
        else
        {
            operand2+=text;
        }
        input.setText(input.getText() + "" +text); // displaying on the textarea
    }

    public void setOperator(View v)
    {
        if(input.getText().length()!=0)
        {
            CharSequence text = ((Button)v).getText();
            if(!operator.equals(""))
            {
                evaluate(null);
            }
            operator = v.getTag().toString();    
            input.setText(input.getText() + "" +text);
        }
        else if((((Button)v).getText()+"").equals("-"))
        {
            operand1 = "-";
            input.setText("-");
        }
    }

    public void clear(View v)
    {
        operator = "";
        operand1 = "";
        operand2 = "";
        input.setText("");;
    }

    public void evaluate(View v)
    {
        if(operator.equals(""))
            return;
        double result = 0; boolean flag = true;
        switch (operator)
        {
            case "ADD":
                result = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
                break;
            case "SUB":
                result = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
                break;
            case "MUL":
                result = (Double.parseDouble(operand1) * Double.parseDouble(operand2));
                break;
            case "DIV":
                if (Double.parseDouble(operand2) == 0.0)//Check if operand2 is 0.
                    flag = false;
                else
                    result = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
                break;
        }
        operand1 = ((result % 1 != 0)) ? String.valueOf(result): String.valueOf(((int)result));
        input.setText(operand1);
        operator = "";
        operand2 = "";
        if(flag==false)
        input.setText("Error.Divide by Zero!!");
    }


}