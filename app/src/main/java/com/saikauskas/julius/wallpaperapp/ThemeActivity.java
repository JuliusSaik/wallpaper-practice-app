package com.saikauskas.julius.wallpaperapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        ActivityCompat.requestPermissions(ThemeActivity.this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        String newString;
        FrameLayout theme_prieview = findViewById(R.id.theme_preview);
        Button bttnBack = findViewById(R.id.bttnBack);
        Button bttnSetAsWallapper = findViewById(R.id.bttnSetAsWallpaper);

        Button bttnDownload = findViewById(R.id.bttnDownload);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
            } else {
                newString = extras.getString("PATH_PIC");

                if (newString.equals("bg_item1")) {
                    theme_prieview.setBackgroundResource(R.drawable.bg_item1);

                    bttnSetAsWallapper.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            WallpaperManager wlp = WallpaperManager.getInstance(getApplicationContext());

                            try {
                                wlp.setResource(+R.drawable.bg_item1);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    bttnDownload.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //save image to sd card
                            Bitmap bitmap;
                            OutputStream outputStream;

                            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_item1);

                            File filepath = Environment.getExternalStorageDirectory();
                            File dir = new File(filepath+"/App Wallpapers/");
                            dir.mkdir();

                            File file = new File(dir, "mybackground1.png");

                            try {
                                outputStream = new FileOutputStream(file);
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

                                outputStream.flush();
                                outputStream.close();

                                Toast.makeText(ThemeActivity.this, "Wallpaper saved", Toast.LENGTH_SHORT).show();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                } else if (newString.equals("bg_item2")) {

                    theme_prieview.setBackgroundResource(R.drawable.bg_item2);

                    bttnSetAsWallapper.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            WallpaperManager wlp = WallpaperManager.getInstance(getApplicationContext());

                            try {
                                wlp.setResource(+R.drawable.bg_item2);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    bttnDownload.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //save image to sd card
                            Bitmap bitmap;
                            OutputStream outputStream;

                            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_item2);

                            File filepath = Environment.getExternalStorageDirectory();
                            File dir = new File(filepath+"/App Wallpapers/");
                            dir.mkdir();

                            File file = new File(dir, "mybackground2.png");

                            try {
                                outputStream = new FileOutputStream(file);
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

                                outputStream.flush();
                                outputStream.close();

                                Toast.makeText(ThemeActivity.this, "Wallpaper saved", Toast.LENGTH_SHORT).show();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }

            }

            bttnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });

        }
    }
}
