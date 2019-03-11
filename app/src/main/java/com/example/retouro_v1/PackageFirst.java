package com.example.retouro_v1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class PackageFirst extends AppCompatActivity {

    private Button confirmButton;
    private Button cancelButton;
    private EditText volumeInput;
    private Spinner spinner;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private String volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_first);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#446B14")));

        confirmButton = findViewById(R.id.confirmButton);
        cancelButton = findViewById(R.id.cancelButton);
        spinner = findViewById(R.id.spinner1);
        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        String[] items = new String[]{"DHL", "DPD", "UPS", "GLS", "HERMES"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        spinner.setAdapter(adapter);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1.isChecked()) {
                    volume = checkBox1.getText().toString();
                    openPackageSecond();
                } else if (checkBox2.isChecked()) {
                    volume = checkBox2.getText().toString();
                    openPackageSecond();
                } else if (checkBox3.isChecked()) {
                    volume = checkBox3.getText().toString();
                    openPackageSecond();
                }

            }
        });
    }

    public void openPackageSecond() {
        Intent intent = new Intent(this, PackageSecond.class);
        intent.putExtra("EXTRA_VOLUME", volume);
        startActivity(intent);
    }
}
