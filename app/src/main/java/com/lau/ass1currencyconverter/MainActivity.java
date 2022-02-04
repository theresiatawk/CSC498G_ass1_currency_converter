package com.lau.ass1currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usd_input;
    EditText lbp_input;
    int lbp_usd_rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Linking the USD plain text in the layout to usd_input variable by id
         & Linking the LBP plain text in the layout to lbp_input variable */
        usd_input = (EditText) findViewById(R.id.usd_id);
        lbp_input = (EditText) findViewById(R.id.lbp_id);
        // Assuming that the rate is fixed on 22000
        lbp_usd_rate = 22000;
    }
    /*Once clicking on the convert button this method will be executed
    & it will convert either from LBP to USD or vice versa */
    public void onConvert(View v) {
        // Geting the object displayed and converting it to string with removing spaces
        String usd_value = usd_input.getText().toString().replaceAll(" ","");
        String lbp_value = lbp_input.getText().toString().replaceAll(" ","");

        if (usd_value.length() == 0 && lbp_value.length() == 0) {
            String message = "Error: You should fill one of the field.";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
        else if (usd_value.length() != 0 && lbp_value.length() != 0) {
            String message = "Error: You should fill only one of the field not both";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
        // Converting from USD to LBP
        else if (usd_value.length() != 0) {
            try {
                Double from_usd = Double.parseDouble(usd_value);
                double to_lbp = from_usd * lbp_usd_rate;
                int lbp_value_to_display = (int) to_lbp;
                // setting the answer in the lbp plain text
                lbp_input.setText(lbp_value_to_display + "");
                Toast.makeText(getApplicationContext(),lbp_value_to_display + " LBP", Toast.LENGTH_LONG).show();
            }
            catch(NumberFormatException e){
                Toast.makeText(getApplicationContext(),"Error: The Format is Incorrect. Please Enter a correct number", Toast.LENGTH_LONG).show();
            }
        }
        // Converting from LBP to USD
        else {
            try {
                Double from_lbp = Double.parseDouble(lbp_value);
                double to_usd = from_lbp / lbp_usd_rate;
                // setting the answer in the usd plain text
                usd_input.setText(to_usd + "");
                Toast.makeText(getApplicationContext(),to_usd + " USD", Toast.LENGTH_LONG).show();
            }
            catch(NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Error: The Format is Incorrect. Please Enter a correct number", Toast.LENGTH_LONG).show();
            }
        }
    }
}