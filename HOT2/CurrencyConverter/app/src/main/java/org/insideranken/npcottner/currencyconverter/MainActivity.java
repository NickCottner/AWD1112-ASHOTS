package org.insideranken.npcottner.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity{
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
    int totalNzdConversions;

    double amount;
    double conversion;
    DecimalFormat roundedConversion = new DecimalFormat("##0.00");

    //Conversion from Naira
    double nairaToEuro = 0.0021;
    double nairaToYen = 0.28;
    double nairaToDirham = 0.0088;
    double nairaToUs = 0.0024;
    double nairaToNzd = 0.0036;

    //Conversion from Yen
    double yenToEuro = 0.00758;
    double yenToNaira = 3.60145;
    double yenToDirham = 0.03181;
    double yenToNzd = 0.01298;
    double yenToUs = 0.0086;

    //Conversion from Dirham
    double dirhamToYen = 31.4273;
    double dirhamToEuro = 0.23819;
    double dirhamToNaira = 113.199;
    double dirhamToNzd = 0.40789;
    double dirhamToUs = 0.27;

    //Conversion From Euro
    double euroToYen = 131.937;
    double euroToNaira = 475.175;
    double euroToDirham = 4.19651;
    double euroToNzd = 1.71218;
    double euroToUs = 1.14;

    //Conversion from Us
    double usToEuro = 0.87501;
    double usToYen = 115.45;
    double usToNaira = 415.844;
    double usToDirham = 3.67253;
    double ustoNzd = 1.4984;

    //Conversion from New Zealand Dollar
    double nzdToUs = 0.66719;
    double nzdtoEuro = 0.59;
    double nzdToYen = 77.16;
    double nzdToNaira = 277.76;
    double nzdToDirham = 2.46;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmountToConvert = findViewById(R.id.etAmountToConvert);
        tvConvertedAmount = findViewById(R.id.tvConvertedAmount);
        btnConvert = findViewById(R.id.btnConvert);
        btnHelp = findViewById(R.id.btnHelp);
        btnTotals = findViewById(R.id.btnTotals);
        spinnerRegionOne  = findViewById(R.id.spinnerRegionFromCurrency);
        spinnerRegionTwo = findViewById(R.id.spinnerRegionToCurrency);

        //Region From Spinner
        String[] currencyFrom = {"USD", "JPY","NZD", "EUR", "AED", "NGN"};
        ArrayAdapter currencyFromAdapter = new ArrayAdapter<>
                (this,R.layout.support_simple_spinner_dropdown_item,currencyFrom);
        spinnerRegionOne.setAdapter(currencyFromAdapter);

        //Region To Spinner
        String[] currencyTo = {"EUR", "JPY","NZD", "USD", "AED", "NGN"};
        ArrayAdapter currencyToAdapter = new ArrayAdapter<>
                (this,R.layout.support_simple_spinner_dropdown_item,currencyTo);
        spinnerRegionTwo.setAdapter(currencyToAdapter);

        btnTotals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle totExtras = new Bundle();
                totExtras.putInt("totalUsConversions", totalUsConversions);
                totExtras.putInt("totalDirhamConversions", totalDirhamConversions);
                totExtras.putInt("totalEuroConversions", totalEuroConversions);
                totExtras.putInt("totalYenConversions", totalYenConversions);
                totExtras.putInt("totalNairaConversions", totalNairaConversions);
                totExtras.putInt("totalNzsConversions", totalNzdConversions);

                Intent totIntent = new Intent(getApplicationContext(),
                        totalsActivity.class);

                totIntent.putExtras(totExtras);
                startActivity(totIntent);

            }
        });
        btnConvert.setOnClickListener(v -> {
            boolean keepGoing = validateEnteredCurrency();
            if (keepGoing)
            {
                convertCurrency();
            }

        });
        btnHelp.setOnClickListener(v -> {
            Intent helpIntent = new Intent(getApplicationContext(),
                    helpScreen.class);
            startActivity(helpIntent);
        });
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
    @SuppressLint("SetTextI18n")
    public double convertCurrency()
    {
        //US CONVERSIONS
            if (spinnerRegionOne.getSelectedItem().toString().equals("USD"))
            {
                if (spinnerRegionTwo.getSelectedItem().toString().equals("USD"))
                {
                    etAmountToConvert.setText("");
                    etAmountToConvert.requestFocus();
                    Toast.makeText(getApplicationContext(), "You Can't Convert The Same Currency",
                            Toast.LENGTH_SHORT).show();
                }
                else if(spinnerRegionTwo.getSelectedItem().toString().equals("EUR"))
                {
                    conversion = amount * usToEuro;
                    tvConvertedAmount.setText(amount + " US Dollar = " +
                            roundedConversion.format(conversion)
                            + " Euro");
                    Toast.makeText(getApplicationContext(),amount +" US Dollar = " +
                                    roundedConversion.format(conversion) +" Euro",
                            Toast.LENGTH_LONG).show();
                    totalUsConversions++;
                }
                else if (spinnerRegionTwo.getSelectedItem().toString().equals("AED"))
                {
                    conversion = amount * usToDirham;
                    tvConvertedAmount.setText(amount + " US Dollar = " +
                            roundedConversion.format(conversion)
                            + " Emirati Dirham");
                    Toast.makeText(getApplicationContext(),amount +" US Dollar = " +
                                    roundedConversion.format(conversion) +" Emirati Dirham",
                            Toast.LENGTH_LONG).show();
                    totalUsConversions++;
                }
                else if(spinnerRegionTwo.getSelectedItem().toString().equals("NGN"))
                {
                    conversion = amount * usToNaira;
                    tvConvertedAmount.setText(amount + " US Dollar = " +
                            roundedConversion.format(conversion)
                            + " Nigerian Naira");
                    Toast.makeText(getApplicationContext(),amount +" US Dollar = " +
                                    roundedConversion.format(conversion) +" Nigerian Naira",
                            Toast.LENGTH_LONG).show();
                    totalUsConversions++;
                }
                else if (spinnerRegionTwo.getSelectedItem().toString().equals("NZD"))
                {
                    conversion = amount * ustoNzd;
                    tvConvertedAmount.setText(amount + " US Dollar = " +
                            roundedConversion.format(conversion)
                            + " New Zealand Dollar");
                    Toast.makeText(getApplicationContext(),amount +" US Dollar = " +
                                    roundedConversion.format(conversion) +" New Zealand Dollar",
                            Toast.LENGTH_LONG).show();
                    totalUsConversions++;
                }
                else if(spinnerRegionTwo.getSelectedItem().toString().equals("JPY"))
                {
                    conversion = amount * usToYen;
                    tvConvertedAmount.setText(amount + " US Dollar = " +
                            roundedConversion.format(conversion)
                            + " Japanese Yen");
                    Toast.makeText(getApplicationContext(),amount +" US Dollar = " +
                                    roundedConversion.format(conversion) +" Japanese Yen",
                            Toast.LENGTH_LONG).show();
                    totalUsConversions++;
                }
            }

        //Euro Conversions
        if (spinnerRegionOne.getSelectedItem().toString().equals("EUR"))
        {
            if (spinnerRegionTwo.getSelectedItem().toString().equals("EUR"))
            {
                etAmountToConvert.setText("");
                etAmountToConvert.requestFocus();
                Toast.makeText(getApplicationContext(), "You Can't Convert The Same Currency",
                        Toast.LENGTH_SHORT).show();
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("USD"))
            {
                conversion = amount * euroToUs;
                tvConvertedAmount.setText(amount + " Euro = " + roundedConversion.format(conversion)
                        + " US Dollar");
                Toast.makeText(getApplicationContext(),amount +" Euro = " +
                                roundedConversion.format(conversion) +" US Dollar",
                        Toast.LENGTH_LONG).show();
                totalEuroConversions++;
            }
            else if (spinnerRegionTwo.getSelectedItem().toString().equals("AED"))
            {
                conversion = amount * euroToDirham;
                tvConvertedAmount.setText(amount + " Euro = " + roundedConversion.format(conversion)
                        + " Emirati Dirham");
                Toast.makeText(getApplicationContext(),amount +" Euro = " +
                                roundedConversion.format(conversion) +" Emirati Dirham",
                        Toast.LENGTH_LONG).show();
                totalEuroConversions++;
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("NGN"))
            {
                conversion = amount * euroToNaira;
                tvConvertedAmount.setText(amount + " Euro = " + roundedConversion.format(conversion)
                        + " Nigerian Naira");
                Toast.makeText(getApplicationContext(),amount +" Euro = " +
                                roundedConversion.format(conversion) +" Nigerian Naira",
                        Toast.LENGTH_LONG).show();
                totalEuroConversions++;
            }
            else if (spinnerRegionTwo.getSelectedItem().toString().equals("NZD"))
            {
                conversion = amount * euroToNzd;
                tvConvertedAmount.setText(amount + " Euro = " + roundedConversion.format(conversion)
                        + " New Zealand Dollar");
                Toast.makeText(getApplicationContext(),amount +" Euro = " +
                                roundedConversion.format(conversion) +" New Zealand Dollar",
                        Toast.LENGTH_LONG).show();
                totalEuroConversions++;
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("JPY"))
            {
                conversion = amount * euroToYen;
                tvConvertedAmount.setText(amount + " Euro = " + roundedConversion.format(conversion)
                        + " Japanese Yen");
                Toast.makeText(getApplicationContext(),amount +" Euro = " +
                                roundedConversion.format(conversion) +" Japanese Yen",
                        Toast.LENGTH_LONG).show();
                totalEuroConversions++;
            }
        }

        //New Zealand Dollar Conversions
        if (spinnerRegionOne.getSelectedItem().toString().equals("NZD"))
        {
            if (spinnerRegionTwo.getSelectedItem().toString().equals("NZD"))
            {
                etAmountToConvert.setText("");
                etAmountToConvert.requestFocus();
                Toast.makeText(getApplicationContext(), "You Can't Convert The Same Currency",
                        Toast.LENGTH_SHORT).show();
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("USD"))
            {
                conversion = amount * nzdToUs;
                tvConvertedAmount.setText(amount + " New Zealand Dollar = " +
                        roundedConversion.format(conversion)
                        + " US Dollar");
                Toast.makeText(getApplicationContext(),amount +" New Zealand Dollar = " +
                                roundedConversion.format(conversion) +" US Dollar",
                        Toast.LENGTH_LONG).show();
                totalNzdConversions++;
            }
            else if (spinnerRegionTwo.getSelectedItem().toString().equals("AED"))
            {
                conversion = amount * nzdToDirham;
                tvConvertedAmount.setText(amount + " New Zealand Dollar = " +
                        roundedConversion.format(conversion)
                        + " Emirati Dirham");
                Toast.makeText(getApplicationContext(),amount +" New Zealand Dollar = " +
                                roundedConversion.format(conversion) +" Emirati Dirham",
                        Toast.LENGTH_LONG).show();
                totalNzdConversions++;
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("NGN"))
            {
                conversion = amount * nzdToNaira;
                tvConvertedAmount.setText(amount + " New Zealand Dollar = " +
                        roundedConversion.format(conversion)
                        + " Nigerian Naira");
                Toast.makeText(getApplicationContext(),amount +" New Zealand Dollar = " +
                                roundedConversion.format(conversion) +" Nigerian Naira",
                        Toast.LENGTH_LONG).show();
                totalNzdConversions++;
            }
            else if (spinnerRegionTwo.getSelectedItem().toString().equals("EUR"))
            {
                conversion = amount * nzdtoEuro;
                tvConvertedAmount.setText(amount + " New Zealand Dollar = " +
                        roundedConversion.format(conversion)
                        + " Euro");
                Toast.makeText(getApplicationContext(),amount +" New Zealand Dollar = " +
                                roundedConversion.format(conversion) +" Euro",
                        Toast.LENGTH_LONG).show();
                totalNzdConversions++;
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("JPY"))
            {
                conversion = amount * nzdToYen;
                tvConvertedAmount.setText(amount + " New Zealand Dollar = " +
                        roundedConversion.format(conversion)
                        + " Japanese Yen");
                Toast.makeText(getApplicationContext(),amount +" New Zealand Dollar = " +
                                roundedConversion.format(conversion) +" Japanese Yen",
                        Toast.LENGTH_LONG).show();
                totalNzdConversions++;
            }
        }
        //Emirati Dirham Conversions
        if (spinnerRegionOne.getSelectedItem().toString().equals("AED"))
        {
            if (spinnerRegionTwo.getSelectedItem().toString().equals("AED"))
            {
                etAmountToConvert.setText("");
                etAmountToConvert.requestFocus();
                Toast.makeText(getApplicationContext(), "You Can't Convert The Same Currency",
                        Toast.LENGTH_SHORT).show();
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("USD"))
            {
                conversion = amount * dirhamToUs;
                tvConvertedAmount.setText(amount + " Emirati Dirham = " +
                        roundedConversion.format(conversion)
                        + " US Dollar");
                Toast.makeText(getApplicationContext(),amount +" New Zealand Dollar = " +
                                roundedConversion.format(conversion) +" US Dollar",
                        Toast.LENGTH_LONG).show();
                totalDirhamConversions++;
            }
            else if (spinnerRegionTwo.getSelectedItem().toString().equals("NZD"))
            {
                conversion = amount * dirhamToNzd;
                tvConvertedAmount.setText(amount + " Emirati Dirham = " +
                        roundedConversion.format(conversion)
                        + " New Zealand Dollar");
                Toast.makeText(getApplicationContext(),amount +" Emirati Dirham = " +
                                roundedConversion.format(conversion) +" New Zealand Dollar",
                        Toast.LENGTH_LONG).show();
                totalDirhamConversions++;
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("NGN"))
            {
                conversion = amount * dirhamToNaira;
                tvConvertedAmount.setText(amount + " Emirati Dirham = " +
                        roundedConversion.format(conversion)
                        + " Nigerian Naira");
                Toast.makeText(getApplicationContext(),amount +" Emirati Dirham = " +
                                roundedConversion.format(conversion) +" Nigerian Naira",
                        Toast.LENGTH_LONG).show();
                totalDirhamConversions++;
            }
            else if (spinnerRegionTwo.getSelectedItem().toString().equals("EUR"))
            {
                conversion = amount * dirhamToEuro;
                tvConvertedAmount.setText(amount + " Emirati Dirham = " +
                        roundedConversion.format(conversion)
                        + " Euro");
                Toast.makeText(getApplicationContext(),amount +" Emirati Dirham = " +
                                roundedConversion.format(conversion) +" Euro",
                        Toast.LENGTH_LONG).show();
                totalDirhamConversions++;
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("JPY"))
            {
                conversion = amount * dirhamToYen;
                tvConvertedAmount.setText(amount + " Emirati Dirham = " +
                        roundedConversion.format(conversion)
                        + " Japanese Yen");
                Toast.makeText(getApplicationContext(),amount +" Emirati Dirham = " +
                                roundedConversion.format(conversion) +" Japanese Yen",
                        Toast.LENGTH_LONG).show();
                totalDirhamConversions++;
            }
        }
        //Nigerian Naira Conversions
        if (spinnerRegionOne.getSelectedItem().toString().equals("NGN"))
        {
            if (spinnerRegionTwo.getSelectedItem().toString().equals("NGN"))
            {
                etAmountToConvert.setText("");
                etAmountToConvert.requestFocus();
                Toast.makeText(getApplicationContext(), "You Can't Convert The Same Currency",
                        Toast.LENGTH_SHORT).show();
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("USD"))
            {
                conversion = amount * nairaToUs;
                tvConvertedAmount.setText(amount + " Nigerian Naira = " +
                        roundedConversion.format(conversion)
                        + " US Dollar");
                Toast.makeText(getApplicationContext(),amount +" Nigerian Naira = " +
                                roundedConversion.format(conversion) +" US Dollar",
                        Toast.LENGTH_LONG).show();
                totalNairaConversions++;
            }
            else if (spinnerRegionTwo.getSelectedItem().toString().equals("NZD"))
            {
                conversion = amount * nairaToNzd;
                tvConvertedAmount.setText(amount + " Nigerian Naira = " +
                        roundedConversion.format(conversion)
                        + " New Zealand Dollar");
                Toast.makeText(getApplicationContext(),amount +" Nigerian Naira = " +
                                roundedConversion.format(conversion) +" New Zealand Dollar",
                        Toast.LENGTH_LONG).show();
                totalNairaConversions++;
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("AED"))
            {
                conversion = amount * nairaToDirham;
                tvConvertedAmount.setText(amount + " Nigerian Naira = " +
                        roundedConversion.format(conversion)
                        + " Emirati Dirham");
                Toast.makeText(getApplicationContext(),amount +" Nigerian Naira = " +
                                roundedConversion.format(conversion) +" Emirati Dirham",
                        Toast.LENGTH_LONG).show();
                totalNairaConversions++;
            }
            else if (spinnerRegionTwo.getSelectedItem().toString().equals("EUR"))
            {
                conversion = amount * nairaToEuro;
                tvConvertedAmount.setText(amount + " Nigerian Naira = " +
                        roundedConversion.format(conversion)
                        + " Euro");
                Toast.makeText(getApplicationContext(),amount +" Nigerian Naira = " +
                                roundedConversion.format(conversion) +" Euro",
                        Toast.LENGTH_LONG).show();
                totalNairaConversions++;
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("JPY"))
            {
                conversion = amount * nairaToYen;
                tvConvertedAmount.setText(amount + " Nigerian Naira = " +
                        roundedConversion.format(conversion)
                        + " Japanese Yen");
                Toast.makeText(getApplicationContext(),amount +" Nigerian Naira = " +
                                roundedConversion.format(conversion) +" Japanese Yen",
                        Toast.LENGTH_LONG).show();
                totalNairaConversions++;
            }
        }
        //Japanese Yen Conversions
        if (spinnerRegionOne.getSelectedItem().toString().equals("JPY"))
        {
            if (spinnerRegionTwo.getSelectedItem().toString().equals("JPY"))
            {
                etAmountToConvert.setText("");
                etAmountToConvert.requestFocus();
                Toast.makeText(getApplicationContext(), "You Can't Convert The Same Currency",
                        Toast.LENGTH_SHORT).show();
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("USD"))
            {
                conversion = amount * yenToUs;
                tvConvertedAmount.setText(amount + " Japanese Yen = " +
                        roundedConversion.format(conversion)
                        + " US Dollar");
                Toast.makeText(getApplicationContext(),amount +" Japanese Yen = " +
                                roundedConversion.format(conversion) +" US Dollar",
                        Toast.LENGTH_LONG).show();
                totalYenConversions++;
            }
            else if (spinnerRegionTwo.getSelectedItem().toString().equals("NZD"))
            {
                conversion = amount * yenToNzd;
                tvConvertedAmount.setText(amount + " Japanese Yen = " +
                        roundedConversion.format(conversion)
                        + " New Zealand Dollar");
                Toast.makeText(getApplicationContext(),amount +" Japanese Yen = " +
                                roundedConversion.format(conversion) +" New Zealand Dollar",
                        Toast.LENGTH_LONG).show();
                totalYenConversions++;
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("NGN"))
            {
                conversion = amount * yenToNaira;
                tvConvertedAmount.setText(amount + " Japanese Yen = " +
                        roundedConversion.format(conversion)
                        + " Nigerian Naira");
                Toast.makeText(getApplicationContext(),amount +" Japanese Yen = " +
                                roundedConversion.format(conversion) +" Nigerian Naira",
                        Toast.LENGTH_LONG).show();
                totalYenConversions++;
            }
            else if (spinnerRegionTwo.getSelectedItem().toString().equals("EUR"))
            {
                conversion = amount * yenToEuro;
                tvConvertedAmount.setText(amount + " Japanese Yen = " +
                        roundedConversion.format(conversion)
                        + " Euro");
                Toast.makeText(getApplicationContext(),amount +" Japanese Yen = " +
                                roundedConversion.format(conversion) +" Euro",
                        Toast.LENGTH_LONG).show();
                totalYenConversions++;
            }
            else if(spinnerRegionTwo.getSelectedItem().toString().equals("AED"))
            {
                conversion = amount * dirhamToYen;
                tvConvertedAmount.setText(amount + " Japanese Yen = " +
                        roundedConversion.format(conversion)
                        + " Emirati Dirham");
                Toast.makeText(getApplicationContext(),amount +" Japanese Yen = " +
                                roundedConversion.format(conversion) +" Emirati Dirham",
                        Toast.LENGTH_LONG).show();
                totalYenConversions++;
            }
        }





        return conversion;
    }
}