package org.insideranken.npcottner.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinnerRegionOne;
    Spinner spinnerRegionTwo;
    EditText etAmountToConvert;
    TextView tvConvertedAmount;
    Button btnConvert;
    Button btnHelp;
    Button btnTotals;

    int totalUsConversions;
    int totalEuroConversions;
    int totalDirhamConversions;
    int totalYenConversions;
    int totalNairaConversions;
    int totalNzdConvervsions;

    double amount;
    double amountConverted;

    //Conversion From World Currency to US
    double dirhamToUs = 0.27;
    double euroToUs = 1.14;
    double yenToUs = 0.0086;
    double nairaToUs = 0.0024;
    double nzdToUs = .66719;

    //Conversion from Naira
    double nairaToEuro = 0.0021;
    double nairaToYen = 0.28;
    double nairaToDirham = 0.0088;

    //Conversion from Yen
    double yenToEuro = 0.00758;
    double yenToNaira = 3.60145;
    double yenToDirham = 0.03181;
    double yenToNzd = 0.01298;

    //Conversion from Dirham
    double dirhamToYen = 31.4273;
    double dirhamToEuro = 0.23819;
    double dirhamToNaira = 113.199;
    double dirhamToNzd = 0.40789;

    //Conversion From Euro
    double euroToYen = 131.937;
    double euroToNaira = 475.175;
    double euroToDirham = 4.19651;
    double euroToNzd = 1.71218;

    //Conversion from Us
    double usToEuro = 0.87501;
    double usToYen = 115.45;
    double usToNaira = 415.844;
    double usToDirham = 3.67253;
    double ustoNzd = 1.4984;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmountToConvert = findViewById(R.id.etAmountToConvert);
        tvConvertedAmount = findViewById(R.id.tvConvertedAmount);
        btnConvert = findViewById(R.id.btnConvert);
        btnHelp = findViewById(R.id.btnHelp);
        btnTotals = findViewById(R.id.btnTotals);

        //First Array Regions
        spinnerRegionOne = findViewById(R.id.spinnerRegionFromCurrency);
        if(spinnerRegionOne != null)
        {
            spinnerRegionOne.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence>regionOneAdapter = ArrayAdapter.createFromResource(this,
                R.array.regionOneSpinner, android.R.layout.simple_spinner_item);
        regionOneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinnerRegionOne != null)
        {
            spinnerRegionOne.setAdapter(regionOneAdapter);
        }

        //Second Array Regions
        spinnerRegionTwo = findViewById(R.id.spinnerRegionToCurrency);
        if(spinnerRegionTwo != null)
        {
            spinnerRegionTwo.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence>regionTwoAdapter = ArrayAdapter.createFromResource(this,
                R.array.regionTwoSpinner, android.R.layout.simple_spinner_item);
        regionOneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinnerRegionTwo != null)
        {
            spinnerRegionTwo.setAdapter(regionTwoAdapter);
        }
        btnTotals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle totExtras = new Bundle();
                totExtras.putInt("totalUsConversions", totalUsConversions);
                totExtras.putInt("totalDirhamConversions", totalDirhamConversions);
                totExtras.putInt("totalEuroConversions", totalEuroConversions);
                totExtras.putInt("totalYenConversions", totalYenConversions);
                totExtras.putInt("totalNairaConversions", totalNairaConversions);
                totExtras.putInt("totalNzsConversions", totalNzdConvervsions);

                Intent totIntent = new Intent(getApplicationContext(),
                        totalsActivity.class);

                totIntent.putExtras(totExtras);
                startActivity(totIntent);

            }
        });
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean keepGoing = validateEnteredCurrency();
                if (keepGoing)
                {
                    amountConverted = convertCurrency(amount);
                }

            }
        });
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helpIntent = new Intent(getApplicationContext(),
                        helpScreen.class);
                startActivity(helpIntent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public boolean validateEnteredCurrency()
    {
        try {
            amount = Double.parseDouble(etAmountToConvert.getText().toString());

            if (TextUtils.isEmpty(etAmountToConvert.getText()))
            {
                amount = 0;
                etAmountToConvert.setText("");
                etAmountToConvert.requestFocus();
                throw new NumberFormatException();
            }
            else if (amount < 0)
            {
                amount = 0;
                etAmountToConvert.setText("");
                etAmountToConvert.requestFocus();
                throw new Exception();
            }
        }
        catch (NumberFormatException nfe)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No Currency Inputted, Please Enter Amount > 0",
                    Toast.LENGTH_LONG);
            toast.show();
            return false;
        }
        catch (Exception e)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Currency Inputted is < 0, Please Enter An Amount > 0",
                    Toast.LENGTH_LONG);
            toast.show();
            return false;
        }
        return true;
    }
    public double convertCurrency(double a)
    {





        return a;
    }
}