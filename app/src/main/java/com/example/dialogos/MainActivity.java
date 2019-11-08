package com.example.dialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogoPersonalizado.OnDialogoPersonalizadoListener{

    private TextView texto;
    private String usuario, contraseña;
    private final String USER = "usuario1";
    private final String PASS = "123456";
    private DialogoPersonalizado dialogo;
    private DialogoSalir dialogoS;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.Texto);
        btnSalir = findViewById(R.id.buttonSalir);


        FragmentManager fragmentManager = getSupportFragmentManager();
        dialogo = new DialogoPersonalizado();


        dialogo.show(fragmentManager, "Login");



        btnSalir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                dialogoS = new DialogoSalir();


            }
        });

    }




    @Override
    public void onPossitiveButtonClick() {

        usuario = dialogo.getUser().getText().toString();
        contraseña = dialogo.getPass().getText().toString();

        if((usuario.equals(USER))&&(contraseña.equals(PASS)))
        {

            texto.setText("Has iniciado");

        }

    }

    @Override
    public void onNegativeButtonClick() {

        finish();

    }
}
