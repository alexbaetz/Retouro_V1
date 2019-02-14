package com.example.retouro_v1;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class PackageThird extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, TimeDialog.TimeDialogListener {

    Button selectDay;
    Button selectTime;
    TextView showDay;
    TextView showTime;
    TextView showVolume;
    TextView showPricemodel;

    int day, month, year;
    int dayFinal, monthFinal, yearFinal;

    String pricemodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_third);

        showVolume = (TextView) findViewById(R.id.volumeTextView);
        showPricemodel = (TextView) findViewById(R.id.priceTextView);

        selectDay = (Button) findViewById(R.id.selectDayButton);
        showDay = (TextView) findViewById(R.id.selectDayView);

        selectTime = (Button) findViewById(R.id.selectTimeButton);
        showTime = (TextView) findViewById(R.id.selectTimeView);

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
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        yearFinal = year;
        monthFinal = month + 1;
        dayFinal = dayOfMonth;

        showDay.setText(dayFinal + "." + monthFinal + "." + yearFinal);
    }

    public void openTimeDialog() {
        TimeDialog timeDialog = new TimeDialog();
        timeDialog.show(getSupportFragmentManager(),"time_dialog");
    }

    @Override
    public void applyTime(String selectedStartTime) {
        showTime.setText(selectedStartTime + " Uhr");
    }
}
