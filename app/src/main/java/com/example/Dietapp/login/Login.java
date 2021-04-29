package com.example.Dietapp.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Dietapp.PaginaPrincipal;
import com.example.myapplicationfinal.R;

public class Login extends AppCompatActivity {
    private Toast toast1;
    private EditText login, contra;
    private String loginT, contraT;
    CheckBox chack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//prueba
        login = findViewById(R.id.textView125);
        contra = findViewById(R.id.textView15);
        chack=findViewById(R.id.checkBox);
        chack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    chack.setTextColor(0xff00ff00);
                    chack.append(" Seleccionado");
                    SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Login.this);

                    String nombreLo = myPreferences.getString("nombreUser", "");
                    String contr = myPreferences.getString("contra", "");
                    login.setText(nombreLo);
                    contra.setText(contr);
                }
                else
                {
                    chack.setText("Recordar Contraseña");
                    chack.setTextColor(0xffffffff);
                    login.setText("");
                    contra.setText("");
                }
            }
        });
    }

    public void lanzarinicio(View view) {
        try {
            loginT = String.valueOf(login.getText());
            contraT = String.valueOf(contra.getText());
            if (condiciones()) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                        "registro_user", null, 9);
                SQLiteDatabase bd = admin.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.

                Cursor curso = bd.rawQuery("select *  from usuarios ", null);

                curso.moveToFirst();
                while (curso.isAfterLast() == false) {
                    String compararU = curso.getString(0);
                    String nombraSQ = curso.getString(1);
                    String apeSQ = curso.getString(2);
                    String ape2SQ = curso.getString(3);
                    String compararC = curso.getString(4);
                    String emailSQ = curso.getString(5);
                    String retoAgua = curso.getString(6);

                    Log.i("tag", "agua"+retoAgua);


                    if (compararU.equals(loginT) && compararC.equals(contraT)) {
                        Log.i("tag", "dentro if");


                        Toast.makeText(this, "Bienvenido " + loginT, Toast.LENGTH_SHORT).show();
                        //guardar datos login
                        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Login.this);
                        SharedPreferences.Editor myEditor = myPreferences.edit();
                        myEditor.putString("nombreUser", compararU);
                        myEditor.putString("nombre", nombraSQ);
                        myEditor.putString("apellido", apeSQ);
                        myEditor.putString("apellido2", ape2SQ);
                        myEditor.putString("email", emailSQ);
                        myEditor.putString("contra", compararC);
                        myEditor.putString("agua", retoAgua);


                        myEditor.commit();

                        Intent i = new Intent(this, PaginaPrincipal.class);
                        startActivity(i);

                    } else {
                        Toast.makeText(this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                    }
                    curso.moveToNext();
                }
                bd.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public boolean condiciones () {
            boolean condicion = false;


            try {

                if (!loginT.isEmpty()) {
                    if (!contraT.isEmpty()) {
                        condicion = true;
                    } else {
                        Toast.makeText(getApplicationContext(), "NO SE HA INTRODUCIDO EL APELLIDO ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "NO SE HA INTRODUCIDO EL NOMBRE ", Toast.LENGTH_SHORT).show();
                }


            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "SE HA PRODUCIDO UN ERROR, REINICIA LA APLICACION ", Toast.LENGTH_SHORT).show();

            }


            return condicion;
        }




    public void lanzarCrearUser(View view) {
        Intent iD = new Intent(this, CrearUsers.class);
        startActivity(iD);
    }

    public void lanzarRecu(View view) {
        Intent iD = new Intent(this, RecuperarContrase.class);
        startActivity(iD);
    }


}