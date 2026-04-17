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

        if (!wagaStr.isEmpty() && !wzrostStr.isEmpty()) {
            float wagaWartosc = Float.parseFloat(wagaStr);
            float wzrostWartosc = Float.parseFloat(wzrostStr);

            // 1. Obliczenie BMI (wzór: waga / wzrost_w_metrach^2)
            float wzrostMetry = wzrostWartosc / 100;
            float bmi = wagaWartosc / (wzrostMetry * wzrostMetry);

            // 2. Interpretacja wyniku przy użyciu drabinki if-else if
            String kategoria;
            if (bmi < 18.5) {
                kategoria = "Niedowaga";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                kategoria = "Waga prawidłowa";
            } else if (bmi >= 25 && bmi < 29.9) {
                kategoria = "Nadwaga";
            } else {
                kategoria = "Otyłość";
            }

            // 3. Wyświetlenie sformatowanego wyniku
            // %.2f oznacza zaokrąglenie do 2 miejsc po przecinku
            tvWynik.setText(String.format("Twoje BMI: %.2f\nStatus: %s", bmi, kategoria));

        } else {
            // Mały bonus: Toast to krótka wiadomość systemowa na dole ekranu
            android.widget.Toast.makeText(this, "Wprowadź wszystkie dane!", android.widget.Toast.LENGTH_SHORT).show();
        }
    }
}