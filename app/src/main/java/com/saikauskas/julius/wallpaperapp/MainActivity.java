package com.saikauskas.julius.wallpaperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bttnItem1 = findViewById(R.id.bttn_item1);
        Button bttnItem2 = findViewById(R.id.bttn_item2);

        bttnItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemeActivity.class);
                String pathPic = "bg_item1";
                intent.putExtra("PATH_PIC", pathPic);
                startActivity(intent);

            }
        });

        bttnItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemeActivity.class);
                String pathPic = "bg_item2";
                intent.putExtra("PATH_PIC", pathPic);
                startActivity(intent);

            }
        });
    }
}
