package com.example.Dietapp.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

public class CrearUsers extends AppCompatActivity {
    private EditText nombre, apellido1, apellido2, nombreLogin, contraseña, contraseña2,email;
    private String nombreT, apellidoT, apellido2T, nombreLoginT, contraseT, contraseT2,emailT;
    private static SQLiteDatabase db;
    AdminSQLiteOpenHelper dbHelper;
    Button boton;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuarios);

        nombre = findViewById(R.id.editNombre);
        apellido1 = findViewById(R.id.editApe1);
        apellido2 = findViewById(R.id.editApe2);
        nombreLogin = findViewById(R.id.editText4);
        contraseña = findViewById(R.id.editContra1);
        contraseña2 = findViewById(R.id.editContra2);
        email = findViewById(R.id.email);



    }

    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 10);
        SQLiteDatabase bd = admin.getWritableDatabase();

        nombreLoginT = String.valueOf(nombreLogin.getText());
        nombreT = nombre.getText().toString();
        apellidoT = String.valueOf(apellido1.getText());
        apellido2T = apellido2.getText().toString();
        contraseT = contraseña.getText().toString();
        contraseT2 = contraseña2.getText().toString();
        emailT = email.getText().toString();


        if (condiciones()) {
            ContentValues registro = new ContentValues();  //es una clase para guardar datos
            registro.put("login", nombreLoginT);
            registro.put("nombre", nombreT);
            registro.put("apellido", apellidoT);
            registro.put("apellido2", apellido2T);
            registro.put("contra", contraseT);
            registro.put("email", emailT);
            registro.put("retoagua", "");

            bd.insert("usuarios", null, registro);
            bd.close();
            nombre.setText("");
            apellido1.setText("");
            apellido2.setText("");
            nombreLogin.setText("");
            contraseña.setText("");
            contraseña2.setText("");
            email.setText("");


            Toast.makeText(this, "SE HA CREADO EL USUARIO CORRECTAMENTE",
                    Toast.LENGTH_SHORT).show();
            Intent ifds = new Intent(this, Login.class);
            startActivity(ifds);
        }
    }



    public boolean condiciones() {
        boolean condicion = false;

        //condicion para primera letra en mayusculas
        String resultado = contraseT.substring(0, 1).toUpperCase() + contraseT2.substring(1);

        //VALIDACION
        //hago mlos boolean para que al usuario que salga el mensaje de que debe arreglar concretamente el usuario
        boolean resultad1 = false;
        boolean resultad2 = false;
        boolean resultad3 = false;
        boolean resultad4 = false;
        boolean resultad5 = false;
        boolean resultad6 = false;
        boolean resultad7 = false;
        boolean resultad8 = false;
        try {
            if (nombreLoginT.length() > 5) {

                resultad1 = true;
            } else {
                Toast.makeText(getApplicationContext(), "EL NOMBRE DE USUARIO DEBE TENER AL MENOS 5 CARACTERES", Toast.LENGTH_SHORT).show();
            }

            if (!nombreLoginT.isEmpty()) {
                resultad6 = true;
            } else {
                Toast.makeText(getApplicationContext(), "EL NOMBRE DE USUARIO ESTA VACIO", Toast.LENGTH_SHORT).show();
            }
            if (!contraseT.isEmpty() || !contraseT2.isEmpty()) {
                resultad2 = true;
            } else {
                Toast.makeText(getApplicationContext(), "EL CAMPO DE CONTRASEÑA ESTA VACIO", Toast.LENGTH_SHORT).show();
            }


            if (contraseT.equals(contraseT2)) {
                if (contraseT.equals(resultado)) {
                    resultad3 = true;
                } else {
                    Toast.makeText(getApplicationContext(), "LAS CONTRASEÑAS DEBE COMENZAR EN MAYUSCULA", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "LAS CONTRASEÑAS NO COINCIDEN", Toast.LENGTH_SHORT).show();
            }


            if (contraseT.length() >= 8) {
                resultad4 = true;
            } else {
                Toast.makeText(getApplicationContext(), "LAS CONTRASEÑAS DEBEN TENER AL MENOS 8 CARACTERES ", Toast.LENGTH_SHORT).show();
            }

            if (emailT.contains("@")) {
                resultad5 = true;

            } else {
                Toast.makeText(getApplicationContext(), "LOS EMAILS DEBEN TENER UN @ ", Toast.LENGTH_SHORT).show();
            }
            if (!nombreT.isEmpty()) {
                if (!apellidoT.isEmpty()) {
                    resultad7 = true;
                } else {
                    Toast.makeText(getApplicationContext(), "NO SE HA INTRODUCIDO EL APELLIDO ", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "NO SE HA INTRODUCIDO EL NOMBRE ", Toast.LENGTH_SHORT).show();
            }
            if(comprobarNombreuser()==false)
            {
                resultad8=true;

            }

            if (resultad1 && resultad2 && resultad3 && resultad4 && resultad5 && resultad6 && resultad7 && resultad8) {

                condicion = true;
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SE HA PRODUCIDO UN ERROR, REINICIA LA APLICACION ", Toast.LENGTH_SHORT).show();

        }


        return condicion;
    }
    public boolean comprobarNombreuser()
    {
        boolean coincide=false;




        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "registro_user", null, 10);
        SQLiteDatabase bd = admin.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.

        Cursor curso = bd.rawQuery("select *  from usuarios ", null);

        curso.moveToFirst();
        while (curso.isAfterLast() == false) {
            String compararU=curso.getString(0);

            Log.i("tag",""+compararU);
            Log.i("tag",""+nombreLoginT);


            if(compararU.equals(nombreLoginT) )
            {
                Log.i("tag","dentro if");


                Toast.makeText(this, "EL NOMBRE DE USUARIO INTRODUCIDO ESTA EN USO", Toast.LENGTH_SHORT).show();
                coincide=true;

            }
            else{


            }curso.moveToNext();

        }
        bd.close();




        return coincide;
    }


}