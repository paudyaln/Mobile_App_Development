package com.example.paudyaln.lab4_problem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by paudyaln on 2/6/2018.
 */

public class Result extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        TextView psex, pweight, pheight;

        psex = (TextView)findViewById(R.id.publishsex);
        pheight = (TextView)findViewById(R.id.publishheight);
        pweight = (TextView)findViewById(R.id.publishstdweight);

        Intent intentResult = getIntent();
        Bundle bundle = intentResult.getExtras();

        String sex = bundle.getString("sex");
        Double weight = bundle.getDouble("weight");
        Integer feet = bundle.getInt("feet");
        Integer inches = bundle.getInt("inches");

        psex.setText(" " + sex.toString());
        pheight.setText(" " + feet.toString() + "'" + inches.toString()+"''");
        pweight.setText(" " + weight.toString() + " Kg");

    }
}
