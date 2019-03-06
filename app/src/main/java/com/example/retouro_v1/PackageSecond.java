package com.example.retouro_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PackageSecond extends AppCompatActivity {

    private TextView packageVolume;
    private Button prime;
    String volume;
    String pricemodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_second);

        packageVolume = (TextView) findViewById(R.id.volumeTextView);
        packageVolume.setText(getIntent().getStringExtra("EXTRA_VOLUME"));

        volume = packageVolume.getText().toString();

        prime = (Button) findViewById(R.id.primeButton);
        prime.setOnClickListener(new View.OnClickListener() {
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
