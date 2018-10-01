package com.example.anphoqua.sqlite;

import android.Manifest;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextTenSV;
    EditText editTextTuoiSV;
    Button buttonThemSV;
    TextView textView;
    QuanLySinhVien qlhd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTenSV = findViewById(R.id.editTextTenSVID);
        editTextTuoiSV = findViewById(R.id.editTextTuoiSVID);
        buttonThemSV = findViewById(R.id.buttonThemSVID);
        textView = findViewById(R.id.textViewID);

        qlhd = new QuanLySinhVien(MainActivity.this);
        textView.setText(qlhd.xemSinhVien());

        buttonThemSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themSinhVien();
            }
        });

    }

    public void themSinhVien()
    {
        qlhd = new QuanLySinhVien(MainActivity.this);
        qlhd.themSinhVien(editTextTenSV.getText().toString(), Integer.parseInt(editTextTuoiSV.getText().toString()));
        String chuoi = qlhd.xemSinhVien();
        textView.setText(chuoi);
    }


}
