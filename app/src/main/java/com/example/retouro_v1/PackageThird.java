package com.example.retouro_v1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class PackageThird extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, TimeDialog.TimeDialogListener {

    private Button selectDay;
    private Button selectTime;
    private Button confirmButton;
    private Button cancelButton;
    private TextView showDay;
    private TextView showTime;
    private TextView showVolume;
    private TextView showPricemodel;

    int day, month, year;
    int dayFinal, monthFinal, yearFinal;

    String pricemodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_third);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#446B14")));

        showVolume = (TextView) findViewById(R.id.volumeTextView);
        showPricemodel = (TextView) findViewById(R.id.priceTextView);

        selectDay = (Button) findViewById(R.id.selectDayButton);
        showDay = (TextView) findViewById(R.id.selectDayView);

        selectTime = (Button) findViewById(R.id.selectTimeButton);
        showTime = (TextView) findViewById(R.id.selectTimeView);

        confirmButton = (Button) findViewById(R.id.confirmButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        showVolume.setText(getIntent().getStringExtra("EXTRA_VOLUME"));
        showPricemodel.setText(getIntent().getStringExtra("EXTRA_PRICEMODEL"));

        selectDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendarDate = Calendar.getInstance();
                year = calendarDate.get(Calendar.YEAR);
                month = calendarDate.get(Calendar.MONTH);
                day = calendarDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(PackageThird.this, PackageThird.this, year, month, day);
                datePickerDialog.show();
            }
        });

        selectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimeDialog();
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmOrder();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        yearFinal = year;
        monthFinal = month + 1;
        dayFinal = dayOfMonth;

        if (monthFinal < 10) {
            showDay.setText(dayFinal + "." + "0" + monthFinal + "." + yearFinal);
        } else {
            showDay.setText(dayFinal + "." + monthFinal + "." + yearFinal);
        }

    }

    public void openTimeDialog() {
        TimeDialog timeDialog = new TimeDialog();
        timeDialog.show(getSupportFragmentManager(),"time_dialog");
    }

    @Override
    public void applyTime(String selectedStartTime) {
        showTime.setText(selectedStartTime + " Uhr");
    }

    public void confirmOrder() {
        Intent intent = new Intent(this, CustomerHomeScreen.class);
        intent.putExtra("EXTRA_DATE", showDay.getText().toString());
        intent.putExtra("EXTRA_TIME", showTime.getText().toString());
        startActivity(intent);
    }
}
