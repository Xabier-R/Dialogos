package com.example.dialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogoPersonalizado.OnDialogoPersonalizadoListener {

    private TextView texto;
    private EditText usuario,contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.Texto);
        usuario = findViewById(R.id.username);
        contraseña = findViewById(R.id.password);



        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogoPersonalizado DG=new DialogoPersonalizado();
        DG.show(fragmentManager,"Login");


    }


    @Override
    public void onPossitiveButtonClick() {

        if((usuario.getText().toString().equals("DM2"))&&(usuario.getText().toString().equals("DM2")))
        {

            texto.setText("Has iniciado");

        }

    }

    @Override
    public void onNegativeButtonClick() {




    }
}
