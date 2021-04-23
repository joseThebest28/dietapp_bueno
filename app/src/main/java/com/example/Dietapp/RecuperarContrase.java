package com.example.Dietapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.Dietapp.login.Login;
import com.example.myapplicationfinal.R;

public class RecuperarContrase extends AppCompatActivity {

    private EditText nombreUserContai;
    private String nombreUserContaiT;
private  Intent iD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrase);

        nombreUserContai = findViewById(R.id.editNombreUser);
        iD = new Intent(this, Login.class);
    }

    public void lnazarRecuCOn(View view) {
        try{
            nombreUserContaiT=String.valueOf(nombreUserContai.getText());


            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                    "registro_user", null, 6);
            SQLiteDatabase bd = admin.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.

            Cursor curso = bd.rawQuery("select *  from usuarios ", null);

            curso.moveToFirst();
            while (!curso.isAfterLast()) {
                String compararU=curso.getString(0);
                String compararC = curso.getString(4);

                if(compararU.equals(nombreUserContaiT) )
                {
                    Log.i("tag","dentro if");

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Contraseña ");
                    builder.setMessage("TU CONTRASEÑA ES: "+ compararC);
                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            startActivity(iD);
                        }
                    });
                    builder.setNegativeButton("Cancelar", null);

                    AlertDialog dialog = builder.create();
                    dialog.show();


                }

                else{
                    Toast.makeText(this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                }curso.moveToNext();
            }
            bd.close();

        } catch (Exception e) {

        }
    }
}