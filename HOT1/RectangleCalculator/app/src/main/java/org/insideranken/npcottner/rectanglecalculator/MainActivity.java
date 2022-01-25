package org.insideranken.npcottner.rectanglecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Decimal Paces
    final DecimalFormat pattern = new DecimalFormat("##0.00");

    //Rectangle Height Constants
    final double MINHEIGHT = 1.0;
    final double MAXHEIGHT = 1000.0;
    final String NHI = "No Height Inputted!";
    final String OORHI = "Height Must Be Between (" + MINHEIGHT + "and " + MAXHEIGHT + ")";

    //Rectangle Width Constants
    final double MINWIDTH = 1;
    final double MAXWIDTH = 1000.0;
    final String NWI = "No Width Inputted!";
    final String OORWI = "Width Must Be Between (" + MINWIDTH + "and " + MAXWIDTH + ")";

    //Invalid Height and Weight Inputted
    String badHeightInputted = "";
    String badWidthInputted = "";

    //Android Widgets
    EditText etHeight;
    EditText etWidth;
    TextView tvResults;
    Button btnCalculate;
    Button btnClear;
    Button btnExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //References Program Widgets
        etHeight = findViewById(R.id.etHeight);
        etWidth = findViewById(R.id.etWidth);
        tvResults = findViewById(R.id.tvResults);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        btnExit = findViewById(R.id.btnExit);

        //Focus on height
        etHeight.requestFocus();

        btnCalculate.setOnClickListener(v -> calculateAP(v));
        btnClear.setOnClickListener(v -> clearProgram(v));
        btnExit.setOnClickListener(v -> exitProgram(v));
    }
    public void calculateAP(View v)
    {
        String calculation;
        double height;
        double width = 0;
        double area;
        double perimeter;
        boolean retVal = false;

        if(TextUtils.isEmpty(etHeight.getText()))
        {
            String output = NHI;
            Toast toast = Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG);
            toast.show();
            retVal = true;
        }
        if(TextUtils.isEmpty(etWidth.getText()))
        {
            String output = NWI;
            Toast toast = Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG);
            toast.show();
            retVal = true;
        }
        if (retVal)
        {
            buildBadOutputStr();
            return;
        }

        height = validateInputtedHeight();
        if(height == 0)
        {
            badHeightInputted = OORHI;
            buildBadOutputStr();
            return;
        }

        width = validateInputtedWidth();
        if(width == 0)
        {
            badWidthInputted = OORWI;
            buildBadOutputStr();
            return;
        }
        area = calculateArea(height, width);
        perimeter = calculatePerimeter(height, width);

        buildGoodOutputStr(area,perimeter);
    }
    public double validateInputtedHeight()
    {
        double h = 0;
        badHeightInputted = "";

        h = Double.parseDouble(etHeight.getText().toString());

        if((h < MINHEIGHT) || (h > MAXHEIGHT))
        {
            badHeightInputted = OORHI;
            h = 0;
        }
        return h;
    }
    public double validateInputtedWidth()
    {
        double w = 0;
        badWidthInputted = "";

        w = Double.parseDouble(etWidth.getText().toString());

        if((w < MINWIDTH) || (w > MAXWIDTH))
        {
           badWidthInputted = OORWI;
            w = 0;
        }
        return w;
    }
    public double calculateArea(double w, double h)
    {
        return (w * h);
    }
    public double calculatePerimeter(double w, double h)
    {
        return (2 * (w + h));
    }
    public void buildGoodOutputStr(double area, double perimeter)
    {
        String output = "Area = " + pattern.format(area) + "\n";
               output += "Perimeter = " + pattern.format(perimeter);

               displayAP(output);
        Toast toast = Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG);
        toast.show();
    }
    public void buildBadOutputStr()
    {
        String output = badHeightInputted + "\n" + badWidthInputted;

               displayAP(output);
    }
    public void displayAP(String os)
    {
        tvResults.setText(os);
    }
    public void clearProgram(View v)
    {
        etHeight.setText("");
        etWidth.setText("");
        tvResults.setText("");
        etHeight.requestFocus();
    }
    public void exitProgram(View v)
    {
        this.finishAffinity();
    }
}