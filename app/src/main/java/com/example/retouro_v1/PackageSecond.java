package com.example.retouro_v1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;

public class PackageSecond extends AppCompatActivity {

    private TextView packageVolume;
    private TextView primeDescription;
    private TextView saferDescription;
    ExpandingList expandingList;
    private Button prime;
    private Button safer;
    private Button getPrime;
    private Button getSafer;
    String volume;
    String pricemodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_second);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#446B14")));

        packageVolume = (TextView) findViewById(R.id.volumeTextView);
        packageVolume.setText(getIntent().getStringExtra("EXTRA_VOLUME"));

        volume = packageVolume.getText().toString();

        primeDescription = (TextView) findViewById(R.id.primeDescription);
        saferDescription = (TextView) findViewById(R.id.saferDescription);
        getPrime = (Button) findViewById(R.id.confirmPrime);
        getSafer = (Button) findViewById(R.id.confirmSafer);

        saferDescription.setVisibility(View.GONE);
        getSafer.setVisibility(View.GONE);

        prime = (Button) findViewById(R.id.primeButton);
        prime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saferDescription.setVisibility(View.GONE);
                getSafer.setVisibility(View.GONE);
                primeDescription.setVisibility(View.VISIBLE);
                getPrime.setVisibility(View.VISIBLE);
            }
        });

        safer = (Button) findViewById(R.id.saferButton);
        safer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primeDescription.setVisibility(View.GONE);
                getPrime.setVisibility(View.GONE);
                saferDescription.setVisibility(View.VISIBLE);
                getSafer.setVisibility(View.VISIBLE);
            }
        });

        getPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pricemodel = "Preismodell: Prime";
                openPackageThird();
            }
        });
    }

    public void openPackageThird() {
        Intent intent = new Intent(this, PackageThird.class);
        intent.putExtra("EXTRA_VOLUME", volume);
        intent.putExtra("EXTRA_PRICEMODEL", pricemodel);
        startActivity(intent);
    }
}
