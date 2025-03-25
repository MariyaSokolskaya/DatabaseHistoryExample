package com.example.databaseexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    DBHelper helper;
    SQLiteDatabase sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_select);

        selectText = findViewById(R.id.selectEvent);
        findButton = findViewById(R.id.findButton);
        resultText = findViewById(R.id.resultText);

        helper = new DBHelper(getBaseContext());
        sql = helper.getReadableDatabase();

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = sql.query(DBHelper.TABLE_EVENTS, new String[]{
                        DBHelper.EVENTS_START_DATE, DBHelper.EVENTS_END_DATE,
                        DBHelper.EVENTS_NAME, DBHelper.EVENTS_PERSONES, DBHelper.EVENTS_DESCRIPTION
                        },
                        DBHelper.EVENTS_NAME + "=?",
                        new String[]{selectText.getText().toString()},
                        null, null, null);
                cursor.moveToFirst();
                while (cursor.moveToNext()){
                    int k = 0;
                    String result = "";
                    while(k < cursor.getColumnCount()){
                        result += cursor.getString(k) + "\n";
                        k++;
                    }
                    resultText.append(result + "\n\n");
//                    if (k >= 0) {
//                        result = cursor.getString(k) + " - ";
//                    }
//                    k = cursor.getColumnIndex(DBHelper.EVENTS_END_DATE);
//                    if (k >= 0){
//                        result += cursor.getString(k) + " ";
//                    }
//                    k = cursor.getColumnIndex(DBHelper.EVENTS_NAME);
//                    if(k >= 0){
//                        result += cursor.getString(k) + "\n";
//                    }
//                    k = cursor.getColumnIndex(DBHelper.EVENTS_NAME);
//                    cursor.
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!sql.isOpen()){
            sql = helper.getReadableDatabase();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        sql.close();
    }
}