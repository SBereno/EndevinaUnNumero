package com.example.endevinaunnumero;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialogo extends AppCompatDialogFragment {

    private EditText textIntroduit;
    private String nom;

    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {

    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = requireActivity().getLayoutInflater();
    builder.setView(inflater.inflate(R.layout.dialog, null))
            .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    textIntroduit = getDialog().findViewById(R.id.Nom);
                    nom = textIntroduit.getText().toString();
                }
            })
            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //LoginDialogFragment.this.getDialog().cancel();
                }
            });
        return builder.create();
    }

    public EditText getTextIntroduit() {
        return textIntroduit;
    }

    public void setTextIntroduit(EditText textIntroduit) {
        this.textIntroduit = textIntroduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
