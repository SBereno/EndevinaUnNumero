package com.example.endevinaunnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String resultado = new String();
    private int numRandom = generarRandom();
    private String name;
    private TextView intents;
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intents = findViewById(R.id.Intents);
        contador = 0;
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
                        contador = contador + 1;
                    } else if (Integer.parseInt(numeroIntroducido) < numRandom) {
                        pista = "Prova un nombre mes gran";
                        contador = contador + 1;
                    } else {
                        pista = "Has ganado";
                        openDialog();
                    }
                    resultado = "Nombre intents: " + contador;
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
                Activity2.jugadors.add(new Jugador(name, contador));
                dialog.dismiss();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                contador = 0;
                numRandom = generarRandom();
            }
        });
    }

    public void restartClicker(View view) {
        contador = 0;
        numRandom = generarRandom();
        intents.setText("");
    }

    public static int generarRandom() {
        int numeroAleatorio = (int) (Math.random() * 100 + 1);
        return numeroAleatorio;
    }
}
