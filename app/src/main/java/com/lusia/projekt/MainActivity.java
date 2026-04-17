package com.lusia.projekt;

import android.os.Bundle;
import android.view.View;
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

        etWaga = findViewById(R.id.etWaga);
        etWzrost = findViewById(R.id.etWzrost);
        btnOblicz = findViewById(R.id.btnOblicz);
        tvWynik = findViewById(R.id.tvWynik);

        // 3. Ustawienie nasłuchiwania na kliknięcie przycisku
        btnOblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obliczBMI();
            }
        });
    }

    // 4. Metoda pobierająca dane i przygotowująca do obliczeń
    private void obliczBMI() {
        String wagaStr = etWaga.getText().toString();
        String wzrostStr = etWzrost.getText().toString();

        // Sprawdzenie czy pola nie są puste (podstawa programowa: instrukcja warunkowa)
        if (!wagaStr.isEmpty() && !wzrostStr.isEmpty()) {
            float wagaWartosc = Float.parseFloat(wagaStr);
            float wzrostWartosc = Float.parseFloat(wzrostStr);

            // Tutaj w następnym kroku dodamy matematykę i wyświetlanie
            tvWynik.setText("Dane pobrane: " + wagaWartosc + " kg");
        } else {
            tvWynik.setText("Błąd: Wypełnij wszystkie pola!");
        }
    }
}