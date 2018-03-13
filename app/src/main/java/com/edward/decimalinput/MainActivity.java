package com.edward.decimalinput;

import com.edward.decimalinput.textwatcher.DecimalInputTextWatcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText decimalInputEt1 = findViewById(R.id.decimal_input_et1);
        //不限制整数位数和小数位数
        decimalInputEt1.addTextChangedListener(new DecimalInputTextWatcher(decimalInputEt1));

        EditText decimalInputEt2 = findViewById(R.id.decimal_input_et2);
        //不限制整数位数，限制小数位数为2位
        decimalInputEt2.addTextChangedListener(new DecimalInputTextWatcher(decimalInputEt2, DecimalInputTextWatcher.Type.decimal, 2));

        EditText decimalInputEt3 = findViewById(R.id.decimal_input_et3);
        //限制整数位数为4位，不限制小数位数
        decimalInputEt3.addTextChangedListener(new DecimalInputTextWatcher(decimalInputEt3, DecimalInputTextWatcher.Type.integer, 4));

        EditText decimalInputEt4 = findViewById(R.id.decimal_input_et4);
        //限制整数位数为4位，小数位数为2位
        decimalInputEt4.addTextChangedListener(new DecimalInputTextWatcher(decimalInputEt4, 4, 2));
    }
}
