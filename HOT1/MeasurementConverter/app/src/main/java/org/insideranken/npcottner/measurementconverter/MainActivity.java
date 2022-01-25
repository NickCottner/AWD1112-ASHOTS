package org.insideranken.npcottner.measurementconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.MalformedInputException;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    final DecimalFormat pattern = new DecimalFormat("##0.00");
    final double MTOKM = 1.6093;
    final double KMTOM = 0.6214;
    final double MINDISTANCE = 1;
    final double MAXDISTANCE= 1000;
    final String NDI = "No Distance Inputted";
    final String OORDI = "Distance Must Be Between (" + MINDISTANCE + " - "
            + MAXDISTANCE + ")";

    String badDistanceInputted = "";

   TextView tvTitle;
   EditText etDistance;
   TextView tvResults;
   Button btnConvertMileToKm;
   Button btnConvertKmToMiles;
   Button btnClear;
   Button btnExit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvConversionTitle);
        etDistance = findViewById(R.id.tvDistance);
        tvResults = findViewById(R.id.tvResults);
        btnConvertMileToKm = findViewById(R.id.btnConvertMilesToKm);
        btnConvertKmToMiles = findViewById(R.id.btnConvertKmToMiles);
        btnClear = findViewById(R.id.btnClear);
        btnExit = findViewById(R.id.btnExit);
        etDistance.requestFocus();

        btnConvertMileToKm.setOnClickListener(v -> convertMilesToKm(v));
        btnConvertKmToMiles.setOnClickListener(v -> convertKmToMiles(v));
        btnClear.setOnClickListener(v -> clearProgram(v));
        btnExit.setOnClickListener(v -> exitProgram(v));
    }
    public void convertMilesToKm(View v)
    {
        tvTitle.setText("Miles to Kilometers Converter");

        double distanceInMiles;
        double conversion;
        boolean retVal = false;

        if(TextUtils.isEmpty(etDistance.getText()))
        {
            String output = NDI;
            Toast toast = Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG);
            toast.show();
            retVal = true;
        }
        if(retVal)
        {
            buildErrorOutput();
        }
        distanceInMiles = validateDistanceInMiles();
        if (distanceInMiles == 0)
        {
            badDistanceInputted = OORDI;
            buildErrorOutput();
            return;
        }

        conversion = convertMToKm(distanceInMiles);
        buildMConversionStr(conversion, distanceInMiles);
    }
    public void convertKmToMiles(View v)
    {
        tvTitle.setText("Kilometers to Miles Converter");

        double distanceInKilometers;
        double conversion;
        boolean retVal = false;

        if(TextUtils.isEmpty(etDistance.getText()))
        {
            String output = NDI;
            Toast toast = Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG);
            toast.show();
            retVal = true;
        }
        if(retVal)
        {
            buildErrorOutput();
        }
        distanceInKilometers = validateDistanceInKilometers();
        if (distanceInKilometers == 0)
        {
            badDistanceInputted = OORDI;
            buildErrorOutput();
            return;
        }

        conversion = convertKmToM(distanceInKilometers);
        buildKMConversionStr(conversion, distanceInKilometers);

    }
    public double validateDistanceInMiles()
    {
        double DIM = 0;
        badDistanceInputted = "";

        DIM = Double.parseDouble(etDistance.getText().toString());

        if((DIM < MINDISTANCE) || (DIM > MAXDISTANCE))
        {
            badDistanceInputted = OORDI;
            DIM = 0;
        }
        return DIM;
    }
    public double validateDistanceInKilometers()
    {
        double DIKM = 0;
        badDistanceInputted = "";

        DIKM = Double.parseDouble(etDistance.getText().toString());

        if((DIKM < MINDISTANCE) || (DIKM > MAXDISTANCE))
        {
            badDistanceInputted = OORDI;
            DIKM = 0;
        }
        return DIKM;
    }
    public double convertMToKm(double DIM)
    {
        return DIM * MTOKM;
    }
    public double convertKmToM(double DIKM)
    {
        return DIKM * KMTOM;
    }
    public void buildMConversionStr(double DIM, double conversion)
    {
        String output = "There are " + pattern.format(conversion) + " Kilometers in "
                        + pattern.format(DIM) + " miles";
        displayConversion(output);
        Toast toast = Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG);
        toast.show();

    }
    public void buildKMConversionStr(double DIKM, double conversion)
    {
        String output = "There are " + pattern.format(conversion) + " Miles in " +
                            pattern.format(DIKM) + " kilometers";
        displayConversion(output);
        Toast toast = Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG);
        toast.show();
    }
    public void buildErrorOutput()
    {
        String output = badDistanceInputted;

        displayError(output);
    }
    public void displayConversion(String c)
    {
        tvResults.setText(c);
    }
    public void displayError(String er)
    {
        tvResults.setText(er);
    }
    public void clearProgram(View v)
    {
        etDistance.setText("");
        tvTitle.setText("Conversion Title");
        tvResults.setText("Conversion Results");
        etDistance.requestFocus();
    }
    public void exitProgram(View v)
    {this.finishAffinity();}




}