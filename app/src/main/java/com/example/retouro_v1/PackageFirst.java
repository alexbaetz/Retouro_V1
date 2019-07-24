package com.example.retouro_v1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PackageFirst extends AppCompatActivity {

    private Button confirmButton;
    private Button cancelButton;
    private EditText volumeInput;
    private Spinner spinner;
    private ListView listDistricts;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private String volume;
    private String district = "";

    String [] districts = new String[] {
            "Altstadt-Lehel",
            "Au-Haidhausen",
            "Laim",
            "Ludwigvorstadt-Isarvorstadt",
            "Maxvorstadt",
            "Neuhausen-Nymphenburg",
            "Obergiesing",
            "Schwabing-Freimann",
            "Schwabing-West",
            "Schwanthalerhöhe",
            "Sendling"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_first);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#446B14")));

        confirmButton = findViewById(R.id.confirmButton);
        cancelButton = findViewById(R.id.cancelButton);
        spinner = findViewById(R.id.spinner1);
        listDistricts = findViewById(R.id.districtList);
        //checkBox1 = findViewById(R.id.checkBox);
        //checkBox2 = findViewById(R.id.checkBox2);
        //checkBox3 = findViewById(R.id.checkBox3);

        String[] items = new String[]{"Fahrrad", "Lastenrad", "E-Bike"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        spinner.setAdapter(adapter);

        List<String> list_districts = new ArrayList<String>(Arrays.asList(districts));

        ArrayAdapter<String> adapterList = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_districts);

        listDistricts.setAdapter(adapterList);

        listDistricts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                district = listDistricts.getItemAtPosition(i).toString();
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(checkBox1.isChecked()) {
                    volume = checkBox1.getText().toString();
                    openPackageThird();
                } else if (checkBox2.isChecked()) {
                    volume = checkBox2.getText().toString();
                    openPackageThird();
                } else if (checkBox3.isChecked()) {
                    volume = checkBox3.getText().toString();
                    openPackageThird();
                }*/
                openPackageThird();
            }
        });
    }

    public void openPackageSecond() {
        Intent intent = new Intent(this, PackageSecond.class);
        intent.putExtra("EXTRA_VOLUME", volume);
        startActivity(intent);
    }

    public void openPackageThird() {
        Intent intent = new Intent(this, PackageThird.class);
        intent.putExtra("EXTRA_DISTRICT", district);
        //intent.putExtra("EXTRA_PRICEMODEL", pricemodel);
        startActivity(intent);
    }
}
