package com.example.paudyaln.lab4_problem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by paudyaln on 2/6/2018.
 */

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);



        Button calculator_btn = (Button)findViewById(R.id.calculate_button);
        calculator_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                RadioGroup radiosexbutton = (RadioGroup)findViewById(R.id.radioGroup);
                RadioButton maleradio = (RadioButton)findViewById(R.id.radioButton);
                EditText feet = (EditText) findViewById(R.id.editText2);
                EditText inches = (EditText) findViewById(R.id.editText1);
                double weight;

                int f = Integer.valueOf(feet.getText().toString());
                int i = Integer.valueOf(inches.getText().toString());

                int selectedsexgroup = radiosexbutton.getCheckedRadioButtonId();
                String Sex;
                if(selectedsexgroup == maleradio.getId()){
                    weight = 50 + (2.3 * (((f * 12)+i)-60));
                    Sex = "Male";
                }
                else {
                    weight = 45.5 + (2.3 * (((f * 12)+i)-60));
                    Sex = "Female";
                }

                Intent intent = new Intent(Calculator.this, Result.class);
                Bundle bundle = new Bundle();
                bundle.putString("sex",Sex);
                bundle.putDouble("weight", weight);
                bundle.putInt("feet", f);
                bundle.putInt("inches", i);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

}
