package com.example.endevinaunnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Jugador player = new Jugador();
    String resultado = new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final int numRandom = new Random().nextInt(100) + 1;

        final EditText numberInput = findViewById(R.id.NumberInput);
        Button button = findViewById(R.id.button);
        final Button hall = findViewById(R.id.Hall);
        final TextView intents = findViewById(R.id.Intents);

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
                    openDialog();
                }
                player.contadorIntents++;
                resultado = "Nombre intents: " + String.valueOf(player.contadorIntents);
                intents.setText(resultado);
                Context context = getApplicationContext();
                CharSequence text = pista;
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                numberInput.getText().clear();
            }
        });
    }
    public void abrirActivity2(View view) {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        intent.putExtra("Intents", player.contadorIntents);
        startActivity(intent);
    }
    public void openDialog() {
        Dialogo dialogo = new Dialogo();
        dialogo.show(getSupportFragmentManager(), "dialog");
    }
}
