package com.example.Dietapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.Dietapp.categorias.Carne;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Seguimiento extends AppCompatActivity {
    private TextView texC,texP,texD,texFru,aPasta,salsaT,erdura,lista, bebidasT,total ;


    private float suma;
    float carne, fruta,  deporte, pasta, pescado, salsa, verdura ,  receta,  bebidas,sum   ;
    TextView texcv;
    String strDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seguimiento);
this.guardarCloriasBAsededats();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       strDate = sdf.format(c.getTime());
        texcv=findViewById(R.id.textView20);

        texcv.setText(strDate);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Seguimiento.this);

        sum = myPreferences.getFloat("totalacalendario", 0);
        suma=suma+sum;

            texC = findViewById(R.id.textCarne);
             carne = myPreferences.getFloat("carne", 0);
            this.meterCaloriasCategoria(texC,"Carne",carne);


            texP = findViewById(R.id.textPez);
         pescado = myPreferences.getFloat("pescado", 0);
        this.meterCaloriasCategoria(texP,"Pescado",pescado);

            texD = findViewById(R.id.textdeporte);
         deporte = myPreferences.getFloat("depor",0);
        this.meterCaloriasCategoria(texD,"Deporte",deporte);

            texFru = findViewById(R.id.textFr);
         fruta = myPreferences.getFloat("fru", 0);
        this.meterCaloriasCategoria(texFru,"Fruta",fruta);


            aPasta = findViewById(R.id.textoparapastas);
         pasta = myPreferences.getFloat("pasta", 0);
        this.meterCaloriasCategoria(aPasta,"Pasta",pasta);



            salsaT = findViewById(R.id.recibirSalsa);
         salsa = myPreferences.getFloat("salsa", 0);
        this.meterCaloriasCategoria(salsaT,"Salsa",salsa);


            erdura = findViewById(R.id.textVerdura);
         verdura = myPreferences.getFloat("erdura", 0);
        this.meterCaloriasCategoria(erdura,"Verdura y Legumbres",verdura);

            lista = findViewById(R.id.recibirlistaReceta);
         receta = myPreferences.getFloat("receta", 0);
        this.meterCaloriasCategoria(lista,"Recetas",receta);

            bebidasT = findViewById(R.id.recibirlistaBebidaS);
         bebidas = myPreferences.getFloat("bebida", 0);
        this.meterCaloriasCategoria(bebidasT,"Bebidas",bebidas);


    }

    private void guardarCloriasBAsededats() {

            SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Seguimiento.this);

            String nombreGur=myPreferences.getString("nombreUser", "");
           float num=myPreferences.getFloat("depor", 0);


            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 17);
            SQLiteDatabase bd = admin.getWritableDatabase();

            String sql = "UPDATE comida SET deporte='"+num+"' where  login='"+nombreGur+"'";

            bd.execSQL(sql);
            bd.close();

    }

    public void volverMenu(View view) {
        Intent i2 = new Intent(this,Categorias.class );
        startActivity(i2);
    }
public void meterCaloriasCategoria(TextView texto,String nombre_categoria, float numero)
{
    texto.setText("Calorias de "+nombre_categoria + ": " + numero);
}



    public void recuperar(View view) {

        suma=  carne+fruta+pasta+pescado+salsa+verdura+receta-deporte+bebidas;
        total = findViewById(R.id.totalcaloriasHoy);

        String texto1 = "Hoy has obtenido Kcalorias.";
        String texto2 = " Felicidades, vas por buen camino";
        if(suma>0)
        {total.setText(texto1 +suma+ texto2);
       } if(suma<=0){//en caso de salgan por alguna razón datos negativos, que al usuario no le aparezcan datos negativos, le salga 0
            total.setText(texto1 +0.0);
        }

        texcv.setText(strDate);

    }



    public void enviarDatosCalendario(View view) {
        Intent i = new Intent(this, Micalendarrrrio.class );
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Seguimiento.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        if(suma<=0){
            myEditor.putFloat("totalacalendario", 0.0f);
        }
        else{
            myEditor.putFloat("totalacalendario", suma);
        }


        myEditor.commit();
        startActivity(i);

    }



}
