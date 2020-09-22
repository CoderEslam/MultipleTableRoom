package com.example.multipletableroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.multipletableroom.Database.MyViewModel;
import com.example.multipletableroom.Database.Repository;
import com.example.multipletableroom.Tables.Chapter;

public class MainActivity extends AppCompatActivity {

    Chapter chapter;
    Button load;
    public MyViewModel meroviewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meroviewModel = new MyViewModel(getApplication());

        load=findViewById(R.id.btnLoad);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //meroviewModel.insertChapter(chapter);
                Toast.makeText(MainActivity.this, "CLICKED", Toast.LENGTH_SHORT).show();
                meroviewModel.getVolleyDetails();
            }
        });




    }
}