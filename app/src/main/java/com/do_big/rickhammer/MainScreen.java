package com.do_big.rickhammer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainScreen extends AppCompatActivity {
    EditText baseprize, surfacearea, drawer;
    Spinner spinner_wood;
    TextView result;
    Button btnCalculate;
    float mPrize, mSurface, mDrawer, total;
    String woodType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //bindind UI

        baseprize = findViewById(R.id.etBasePrize);
        surfacearea = findViewById(R.id.etSurfaceArea);
        drawer = findViewById(R.id.etDrawer);
        baseprize = findViewById(R.id.etBasePrize);
        btnCalculate = findViewById(R.id.btnCalculate);
        spinner_wood = findViewById(R.id.spinner_wood);
        result = findViewById(R.id.TextResult);

        //Assiqning value to variables
        mPrize = Float.parseFloat(baseprize.getText().toString());
        mSurface = Float.parseFloat(surfacearea.getText().toString());
        mDrawer = Float.parseFloat(drawer.getText().toString());

        // Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, (List<String>) spinner_wood);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner_wood.setAdapter(spinnerArrayAdapter);
        woodType = spinner_wood.getSelectedItem().toString();

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to calculate values
                calculatePrize();
            }
        });

    }

    private void calculatePrize() {
        if (mSurface > 1000) {
            //250 will add for more than 1000 surface Area

            total = mPrize + (30 * mDrawer) + 250;
        } else {
            total = mPrize + (30 * mDrawer) + 100;
        }


        switch (woodType) {
            case "Mahogany":
                total += 150;
                break;
            case "Oak":
                total += 125;
                break;

            case "Pine":

                total += 0;
                break;
            default:

                break;


        }

result.setText("Total Prize "+total);
    }
}
