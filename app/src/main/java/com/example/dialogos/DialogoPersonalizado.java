package com.example.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class DialogoPersonalizado extends DialogFragment {

    OnDialogoPersonalizadoListener listener;
    private  EditText user,pass;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View mivista = inflater.inflate(R.layout.dialogo, null);
        builder.setView(mivista)
                .setPositiveButton("Entrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onPossitiveButtonClick();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        listener.onNegativeButtonClick();
                    }
                });

        user= mivista.findViewById(R.id.username);
        pass= mivista.findViewById(R.id.password);
        return builder.create();

    }


    public interface OnDialogoPersonalizadoListener{
        void onPossitiveButtonClick(
        );

        void onNegativeButtonClick(

        );

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            listener = (OnDialogoPersonalizadoListener) context;

        } catch (ClassCastException e) {

            throw new ClassCastException(context.toString() +" no Implemento OnDialogoConfirmacionListener");
        }
    }

    public EditText getUser() {
        return user;
    }

    public EditText getPass() {
        return pass;
    }
}