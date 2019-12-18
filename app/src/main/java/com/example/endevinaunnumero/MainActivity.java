package com.example.endevinaunnumero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private String resultado = new String();
    private int numRandom = generarRandom();
    private String name;
    private TextView intents;
    private int contador;
    static File photoFile;
    static final int REQUEST_TAKE_PHOTO = 1;
    String currentPhotoPath;

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
                dialog.dismiss();
                dispatchTakePictureIntent();
                persistencia(name, contador);
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

    public void persistencia(String nom, int intents) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(openFileOutput("HallOfFame.txt", Context.MODE_APPEND));
            osw.write(nom + ";" + intents + ";" + photoFile.toString());
            osw.append("\r\n");
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restartClicker(View view) {
        contador = 0;
        numRandom = generarRandom();
        intents.setText("Nombre intents:");
    }

    public static int generarRandom() {
        int numeroAleatorio = (int) (Math.random() * 100 + 1);
        return numeroAleatorio;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.endevinaunnumero.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
}
