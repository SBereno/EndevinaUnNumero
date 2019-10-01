package com.example.endevinaunnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.endevinaunnumero.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final int numRandom = new Random().nextInt(100) + 1;

        final EditText numberInput = findViewById(R.id.NumberInput);
        Button button = findViewById(R.id.button);
        final Button hall = findViewById(R.id.Hall);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroIntroducido = numberInput.getText().toString();
                String pista = null;

                if (Integer.parseInt(numeroIntroducido) > numRandom){
                    pista = "Prova un nombre mes petit";
                } else if (Integer.parseInt(numeroIntroducido) < numRandom){
                    pista = "Prova un nombre mes gran";
                } else {
                    pista = "Has ganado";
                    hall.setVisibility(View.VISIBLE);
                }
                Context context = getApplicationContext();
                CharSequence text = pista;
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                numberInput.getText().clear();
            }
        });
    }
    public void sendMessage(View view) {

    }
}
