package com.example.retouro_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PackageFirst extends AppCompatActivity {

    private Button confirmButton;
    private Button cancelButton;
    private EditText volumeInput;
    private String volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_first);

        confirmButton = findViewById(R.id.confirmButton);
        cancelButton = findViewById(R.id.cancelButton);
        volumeInput = findViewById(R.id.volumeText);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volume = "Volumen: " + volumeInput.getText().toString() + " Liter";
                openPackageSecond();
            }
        });
    }

    public void openPackageSecond() {
        Intent intent = new Intent(this, PackageSecond.class);
        intent.putExtra("EXTRA_VOLUME", volume);
        startActivity(intent);
    }
}
