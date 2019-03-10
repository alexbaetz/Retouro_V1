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
    ExpandingList expandingList;
    private Button prime;
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

        expandingList = (ExpandingList) findViewById(R.id.expanding_list_main);

        ExpandingItem item = expandingList.createNewItem(R.layout.expanding_layout);
        ((TextView) item.findViewById(R.id.item_title)).setText("IT WOKRS");

        item.createSubItems(2);

        View subItemZero = item.getSubItemView(0);
        ((TextView) subItemZero.findViewById(R.id.sub_title)).setText("Cool");

        View subItemOne = item.getSubItemView(1);
        ((TextView) subItemOne.findViewById(R.id.sub_title)).setText("Uncool");

        item.setIndicatorColor(R.color.colorAccent);

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
