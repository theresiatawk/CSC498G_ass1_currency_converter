package com.lau.ass1currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usd_input;
    EditText lbp_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usd_input = (EditText) findViewById(R.id.usd_id);
        lbp_input = (EditText) findViewById(R.id.lbp_id);
    }
    public void onConvert(View v){
//        int usd_rate = 22000;
//        String usd_value = usd_input.getText().toString();
//        int i = Integer.valueOf((String) usd_value);
//        int value_converted_to_lbp = i * usd_rate;
//        lbp_input.setText(value_converted_to_lbp);
        Toast.makeText(getApplicationContext(), "Hello",Toast.LENGTH_LONG).show();
    }
}