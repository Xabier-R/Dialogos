package com.example.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoSalir extends DialogFragment {
    DialogoSalir.OnDialogoSalirListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(
            @Nullable
                    Bundle savedInstanceState) {
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());

    builder.setMessage("¿Confirma la accion selecionada?")
            .setTitle("Confirmacion")
            .setPositiveButton("ACEPTAR",new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //dialog.cancel();
                    Log.i("Dialogos", "Confirmación Aceptada.");
                    listener.onPossitiveSalirButtonClick();
                }
            })
            .setNegativeButton("CANCELAR",
                    new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //dialog.cancel();
                    Log.i("Dialogos", "Confirmación Denegada");
                    listener.onNegativeSalirButtonClick();
                }
            });

    return builder.create();
    }


    public interface OnDialogoSalirListener{
        void onPossitiveSalirButtonClick(
        );

        void onNegativeSalirButtonClick(

        );

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            listener = (DialogoSalir.OnDialogoSalirListener) context;

        } catch (ClassCastException e) {

            throw new ClassCastException(context.toString() +" no Implemento OnDialogoConfirmacionListener");
        }
    }




}

