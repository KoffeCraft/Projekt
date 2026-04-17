package com.lusia.projekt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.lusia.projekt.R;

public class MainActivity extends AppCompatActivity {

    // 1. Deklaracja zmiennych dla elementów UI
    private EditText etWaga;
    private EditText etWzrost;
    private Button btnOblicz;
    private TextView tvWynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Inicjalizacja zmiennych - powiązanie z ID z pliku XML
        etWaga = findViewById(R.id.etWaga);
        etWzrost = findViewById(R.id.etWzrost);
        btnOblicz = findViewById(R.id.btnOblicz);
        tvWynik = findViewById(R.id.tvWynik);

        // Tutaj w następnym kroku dodamy obsługę kliknięcia
    }
}