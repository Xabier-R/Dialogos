package com.example.dialogos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoSalir extends DialogFragment {
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
                    listener.onPossitiveButtonClick();
                }
            })
            .setNegativeButton("CANCELAR",
                    new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //dialog.cancel();
                    Log.i("Dialogos", "Confirmación Denegada");
                    listener.onNegativeButtonClick();
                }
            });
    return builder.create();
    }
}

