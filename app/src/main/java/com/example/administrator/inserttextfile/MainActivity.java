package com.example.administrator.inserttextfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showTextView (View v) {

    try {
        //ambil data dari textfile.txt
        InputStream inputStream = getAssets().open("textfile.txt");

        //simpan di buffer sementara dalam byte array
        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();

        //rubah format di buffer ke string
       String textToView = new String (buffer);

        //tampilkan data atau text yang ada di buffer ke textView
        TextView textview1 = (TextView)findViewById(R.id.textView);
        textview1.setText(textToView);

    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
}
