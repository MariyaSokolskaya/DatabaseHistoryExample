package com.example.databaseexample;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.databaseexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    SQLiteDatabase sql;
    EditText startDateText, endDateText, nameEventText, personEventText, descrEventText;
    Button writeButton;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        dbHelper = new DBHelper(getBaseContext());
        sql = dbHelper.getWritableDatabase();

        startDateText = binding.content.startDate;
        endDateText = binding.content.endDate;
        nameEventText = binding.content.nameEvent;
        personEventText = binding.content.personEvent;
        descrEventText = binding.content.descrEvent;
        writeButton = binding.content.writeButton;

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO добавление записи в базу данных
                String startText = startDateText.getText().toString();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!sql.isOpen()){
            sql = dbHelper.getWritableDatabase();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        sql.close();
    }
}