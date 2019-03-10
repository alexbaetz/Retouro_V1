package com.example.retouro_v1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerHomeScreen extends AppCompatActivity {

    private Button startReturn;
    private ListView listOrders;

    String [] orders = new String[] {
            "Retoure vom 19.02.2019",
            "Retoure vom 28.02.2019"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home_screen);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#446B14")));

        listOrders = findViewById(R.id.orderList);

        List<String> list_orders = new ArrayList<String>(Arrays.asList(orders));

        if(getIntent().getStringExtra("EXTRA_DATE") != null) {
            list_orders.add(0,"Retoure vom " + getIntent().getStringExtra("EXTRA_DATE"));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_orders);

        listOrders.setAdapter(arrayAdapter);

        startReturn = findViewById(R.id.startReturnButton);
        startReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderNewReturn();
            }
        });

    }

    public void orderNewReturn() {
        Intent intent = new Intent(this, PackageFirst.class);
        startActivity(intent);
    }
}
