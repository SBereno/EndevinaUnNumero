package com.example.endevinaunnumero;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialogo extends AppCompatDialogFragment {

    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {

    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = requireActivity().getLayoutInflater();
    builder.setView(inflater.inflate(R.layout.dialog, null))
            .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    EditText nombre = getDialog().findViewById(R.id.Nom);
                    Jugador player = new Jugador();
                    player.nomJugador = nombre.getText().toString();
                }
            })
            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //LoginDialogFragment.this.getDialog().cancel();
                }
            });
        return builder.create();
    }
}
