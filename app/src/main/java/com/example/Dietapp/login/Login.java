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

import com.example.Dietapp.Categorias;
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
            String compararU = "";
            String compararC="";
            boolean dentro=false;
            if (condiciones()) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                        "registro_user", null, 17);
                SQLiteDatabase bd = admin.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.

                Cursor curso = bd.rawQuery("select *  from usuarios ", null);

                curso.moveToFirst();
                while (curso.isAfterLast() == false) {
                    compararU = curso.getString(0);
                    String nombraSQ = curso.getString(1);
                    String apeSQ = curso.getString(2);
                    String ape2SQ = curso.getString(3);
                    compararC = curso.getString(4);
                    String emailSQ = curso.getString(5);
                    String retoAgua = curso.getString(6);
                    String imagen = curso.getString(7);


                    Log.i("tag", "agua" + retoAgua);

                    curso.moveToNext();

                    if (this.comprobarCampos(compararU, compararC)) {
                        Log.i("tag", "dentro if");
                        this.recuperarDatos(compararU);

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
                        myEditor.putString("magen", imagen);


                        myEditor.commit();

                        Intent i = new Intent(this, Categorias.class);
                        startActivity(i);
dentro=true;
                    }

                }

                bd.close();

            }
            if(!dentro){

                    Toast.makeText(getApplicationContext(), "Usuario contraseña incorrectos ", Toast.LENGTH_SHORT).show();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public boolean comprobarCampos(String nom, String contraseña)
{
    boolean correcto= false;


    if (nom.equals(loginT) && contraseña.equals(contraT))
        {
            correcto=true;
        }








    return correcto;
}
        public boolean condiciones () {
            boolean inicio = false;
            boolean c1 = false;
            boolean c2 = false;
            try {

                if (!loginT.isEmpty()) {
                    c2=true;
                } else {
                    Toast.makeText(getApplicationContext(), "NO SE HA INTRODUCIDO EL NOMBRE ", Toast.LENGTH_SHORT).show();
                }
                if (!contraT.isEmpty()) {
                    c1 = true;
                } else {
                    Toast.makeText(getApplicationContext(), "NO SE HA INTRODUCIDO LA CONTRASEÑA ", Toast.LENGTH_SHORT).show();
                }
                if(c1 &&c2)
                {
                    inicio=true;
                }


            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "SE HA PRODUCIDO UN ERROR, REINICIA LA APLICACION ", Toast.LENGTH_SHORT).show();

            }


            return inicio;
        }




    public void lanzarCrearUser(View view) {
        Intent iD = new Intent(this, CrearUsers.class);
        startActivity(iD);
    }

    public void lanzarRecu(View view) {
        Intent iD = new Intent(this, RecuperarContrase.class);
        startActivity(iD);
    }

    private void recuperarDatos(String nombreUsrio) {
        float carne=0,  total=0,pescado=0,  bebidas=0, fruta=0,  deporte=0,  pastas=0,  salsas=0, verdura=0;
            SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Login.this);

            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                    "registro_user", null, 17);
            SQLiteDatabase bd = admin.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.

            Cursor curso = bd.rawQuery("select *  from comida where login='"+nombreUsrio+"' ", null);

            curso.moveToFirst();
            while (curso.isAfterLast() == false) {
                carne = curso.getFloat(1);
                total = curso.getFloat(0);
                pescado = curso.getFloat(2);
                bebidas = curso.getFloat(3);
                fruta = curso.getFloat(4);
                deporte = curso.getFloat(5);
                pastas = curso.getFloat(6);
                salsas = curso.getFloat(7);
                verdura = curso.getFloat(8);




                Log.i("tag", "agua" + carne);
                curso.moveToNext();

            }


                SharedPreferences.Editor myEditor = myPreferences.edit();
                myEditor.putFloat("carne", carne);
        myEditor.putFloat("totalacalendario", total);
        myEditor.putFloat("pescado", pescado);
        myEditor.putFloat("depor", deporte);
        myEditor.putFloat("fru", fruta);
        myEditor.putFloat("pasta", pastas);
        myEditor.putFloat("salsa", salsas);
        myEditor.putFloat("erdura", verdura);
        myEditor.putFloat("bebida", bebidas);



                Log.i("tag","valor de carne 2  "+carne);



                myEditor.commit();



            bd.close();

    }

}