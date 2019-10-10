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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Jugador player = new Jugador();
    String resultado = new String();
    private int numRandom = generarRandom();
    private String name;
    TextView intents = findViewById(R.id.Intents);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final EditText numberInput = findViewById(R.id.NumberInput);
        final Button button = findViewById(R.id.button);
        final Button hall = findViewById(R.id.Hall);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroIntroducido = numberInput.getText().toString();
                String pista = null;
                if (numeroIntroducido.equals("")) {
                    Toast.makeText(MainActivity.this, "Introduce un numero.", Toast.LENGTH_SHORT).show();
                } else {
                    if (Integer.parseInt(numeroIntroducido) > numRandom) {
                        pista = "Prova un nombre mes petit";
                        player.setContadorIntents(player.getContadorIntents() + 1);
                    } else if (Integer.parseInt(numeroIntroducido) < numRandom) {
                        pista = "Prova un nombre mes gran";
                        player.setContadorIntents(player.getContadorIntents() + 1);
                    } else {
                        pista = "Has ganado";
                        openDialog();
                    }
                    resultado = "Nombre intents: " + String.valueOf(player.getContadorIntents());
                    intents.setText(resultado);
                    Context context = getApplicationContext();
                    CharSequence text = pista;
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    numberInput.getText().clear();
                }
            }
        });
    }

    public void abrirActivity2(View view) {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        intent.putExtra("Intents", player.contadorIntents);
        startActivity(intent);
    }

    public void openDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        dialog.setCancelable(false);
        dialog.setTitle("Usuario");
        dialog.show();
        Button register = dialog.findViewById(R.id.botonDialog);
        Button cancelar = dialog.findViewById(R.id.botonDialogC);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText textName = dialog.findViewById(R.id.etNombre);
                name = textName.getText().toString();
                player.setNomJugador(name);
                Activity2.jugadors.add(player);
                dialog.dismiss();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                player.setContadorIntents(0);
                numRandom = generarRandom();
            }
        });
    }

    public void restartClicker(View view) {
        player.setContadorIntents(0);
        numRandom = generarRandom();
        player.setNomJugador("");
        intents.setText("");
    }

    public static int generarRandom() {
        int numeroAleatorio = (int) (Math.random() * 100 + 1);
        return numeroAleatorio;
    }
}
