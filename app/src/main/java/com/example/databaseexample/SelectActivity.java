package com.example.databaseexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.databaseexample.databinding.ActivityMainBinding;

public class SelectActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    EditText selectText;
    Button findButton;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_select);

        selectText = findViewById(R.id.selectEvent);
        findButton = findViewById(R.id.findButton);
        resultText = findViewById(R.id.resultText);

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}