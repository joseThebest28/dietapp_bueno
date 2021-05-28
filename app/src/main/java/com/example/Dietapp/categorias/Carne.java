package com.example.Dietapp.categorias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dietapp.Categorias;
import com.example.Dietapp.DeporteEjercicios.AbdominalesEj.Abdominales;
import com.example.Dietapp.categorias.popup.PopupCarne;
import com.example.Dietapp.Seguimiento;
import com.example.Dietapp.categorias.popup.PopupCarne2;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class Carne extends AppCompatActivity {
    private Spinner sp;
    private Spinner sp2;
    private Spinner sp3;
    private EditText edi;
    private EditText edi2;
    private EditText edi3;
    private TextView fina;
    private float resultado;
    private float resultado2;
    private float resultado3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carne);

        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Carne.this);
        float num = myPreferences.getFloat("carne", 0);
        Log.i("tag","valor de carne en carne "+num);

        total=total+num;

        sp=(Spinner)findViewById(R.id.espi);

        ArrayList<String> elementos=new ArrayList<>();
        elementos.add("Selecciona la carne que has comido(nº kcal cada 100 gr)");
        elementos.add("Filete de ternera: 150kcal");
        elementos.add("Filete de caballo: 120kcal");
        elementos.add("Filete de buey: 160kcal");
        elementos.add("Filete de vaca: 140kcal");

        ArrayAdapter adp=new ArrayAdapter(Carne.this, android.R.layout.simple_spinner_dropdown_item,elementos);
        sp.setAdapter(adp);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent , View view, int position, long id){
                String elemento=(String) sp.getAdapter().getItem(position);
                Toast toast1 = Toast.makeText(getApplicationContext(), "has seleccionado " +elemento, Toast.LENGTH_SHORT);



                edi=findViewById(R.id.numC1);
                String res= edi.getText().toString();
                res.trim();
                if(!res.isEmpty())
                {int num = Integer.parseInt(res);


                if(position==1) {
                    //filete de ternera
                    resultado=num*150; toast1.show();
                    Log.i("tag",resultado+"resul");}
                if(position==2) {
                    //fielete de caballo
                    resultado=num*120; toast1.show();}
                if(position==3){
                    //fielete de buey
                    resultado=num*160; toast1.show();}
                if(position==4){
                    //fielete de vaca
                    resultado=num*140; toast1.show();}
            }}
            @Override
            public void onNothingSelected(AdapterView<?>parent ){
                Toast toastNada = Toast.makeText(getApplicationContext(), "No has seleccioando nada", Toast.LENGTH_SHORT);

                toastNada.show();
            }
        });
        sp2=(Spinner)findViewById(R.id.spiC2);

        ArrayList<String> elementos2=new ArrayList<>();
        elementos2.add("Selecciona la carne que has comido(nº kcal por cda 100 gramos)");
        elementos2.add("pechuga de pollo: 11kcal");
        elementos2.add("patas de pollo: 43kcal");
        elementos2.add("conta muslo de pollo: 109kcal");
        elementos2.add("alitas de pollo: 217kcal");
        elementos2.add("muslo de pollo: 214kcal");
        elementos2.add("solomillo de pollo: 113kcal");
        elementos2.add("paletilla de conejo: 143kcal");
        elementos2.add("lomo de conejo: 143kcal");
        elementos2.add(" 1 costilla de conejo: 66kcal");
        elementos2.add(" solomillo de cerdo: 158kcal");
        elementos2.add(" cinta de lomo de cerdo: 136kcal");
        elementos2.add(" chuletas de lomo(de palo) de cerdo : 27.1kcal");
        elementos2.add(" cadera/babilla de cerdo: 271kcal");
        elementos2.add(" paletilla de cerdo: 169kcal");
        elementos2.add(" aguja de cerdo: 151kcal");
        elementos2.add(" costillas de cerdo: 292kcal");
        elementos2.add(" codillo de cerdo: 171kcal");
        elementos2.add(" magro de cerdo: 156kcal");
        elementos2.add(" panceta de cerdo: 467kcal");
        elementos2.add(" tocino de cerdo: 665kcal");
        elementos2.add("papada de cerdo: 673kcal");
        elementos2.add("morro de cerdo: 201kcal");
        elementos2.add("pechuga de pavo: 109.5kcal");
        elementos2.add("lomo de pavo: 215kcal");
        elementos2.add("muslitos de pavo: 114kcal");
        elementos2.add("pierna de pavo: 125kcal");
        elementos2.add("cuartos traseros de pavo: 114kcal");
        elementos2.add(" alitas de pavo: 229kcal");
        elementos2.add(" jamon de pavo:: 128.57kcal");
        elementos2.add(" salchichas de pavo: 88kcal");
        elementos2.add(" 1 hamburguesas de pavo: 217kcal");
        elementos2.add(" fiambre de pavo: 61.2kcal");








        ArrayAdapter adp2=new ArrayAdapter(Carne.this, android.R.layout.simple_spinner_dropdown_item,elementos2);
        sp2.setAdapter(adp2);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent , View view, int position, long id){
                String elemento2=(String) sp2.getAdapter().getItem(position);
                Toast toast2 = Toast.makeText(getApplicationContext(), "has seleccionado " +elemento2, Toast.LENGTH_SHORT);



                edi2=findViewById(R.id.phone6);
                String res2= edi2.getText().toString();
                res2.trim();
                if(!res2.isEmpty())
                {int num2 = Integer.parseInt(res2);

                if(position==1) {
                    //pechuga de pollo
                    resultado2=num2*11;toast2.show();
                   }
                if(position==2) {
                    //patas de pollo
                    resultado2=num2*43;toast2.show();}
                if(position==3){
                    //contra muslo de pollo*
                    resultado2=num2*109; toast2.show();}
                    if(position==4){
                        //alitas de pollo
                        resultado2=num2*217; toast2.show();}
                    if(position==5){
                        //muslo de pollo
                        resultado2=num2*214; toast2.show();}
                    if(position==6){
                        //solomillo de pollo
                        resultado2=num2*113; toast2.show();}

                    if (position == 7) {  resultado2=num2*143;  toast2.show();}//paletilla de conejo
                    if (position == 8) {  resultado2=num2*143;  toast2.show();}//lomo de conejo
                    if (position == 9) {  resultado2=num2*66;  toast2.show();}//costilla de conejo
                    if (position == 10) {  resultado2=num2*158;  toast2.show();}//solomillo de cerdo
                    if (position == 11) {  resultado2=num2*136;  toast2.show();}// cinta de lomo de cerdo
                    if (position == 12) {  resultado2=num2*27.1f;  toast2.show();}//  chuletas de lomo(de palo) de cerdo
                    if (position == 13) {  resultado2=num2*271;  toast2.show();}// cadera/babilla de cerdo
                    if (position == 14) {  resultado2=num2*169;  toast2.show();}//  paletilla de cerdo
                    if (position == 15) {  resultado2=num2*151;  toast2.show();}// aguja de cerdo
                    if (position == 16) {  resultado2=num2*292;  toast2.show();}// costillas de cerdo
                    if (position == 17) {  resultado2=num2*171;  toast2.show();}//  codillo de cerdo
                    if (position == 18) {  resultado2=num2*156;  toast2.show();}//    magro de cerdo
                    if (position == 19) {  resultado2=num2*467;  toast2.show();}//  panceta de cerdo
                    if (position == 20) {  resultado2=num2*665;  toast2.show();}// tocino de cerdo
                    if (position == 21) {  resultado2=num2*673;  toast2.show();}// papada de cerdo
                    if (position == 22) {  resultado2=num2*201;  toast2.show();}// morro de cerdo
                    if (position == 23) {  resultado2=num2*109.5f;  toast2.show();}//  pechuga de pavo
                    if (position == 24) {  resultado2=num2*215;  toast2.show();}//   lomo de pavo
                    if (position == 25) {  resultado2=num2*114;  toast2.show();}//  muslitos de pavo
                    if (position == 26) {  resultado2=num2*125;  toast2.show();}//    pierna de pavo
                    if (position == 27) {  resultado2=num2*114;  toast2.show();}//  cuartos traseros de pavo
                    if (position == 28) {  resultado2=num2*229;  toast2.show();}//   alitas de pavo
                    if (position == 29) {  resultado2=num2*128.57f;  toast2.show();}//   jamon de pavo
                    if (position == 30) {  resultado2=num2*88;  toast2.show();}//    salchichas de pavo
                    if (position == 31) {  resultado2=num2*217;  toast2.show();}//    1 hamburguesas de pavo
                    if (position == 32) {  resultado2=num2*61.2f;  toast2.show();}//    fiambre de pavo


            }}
            @Override
            public void onNothingSelected(AdapterView<?>parent ){

            }
        });
        sp3=(Spinner)findViewById(R.id.spiC3);

        ArrayList<String> elementos3=new ArrayList<>();
        elementos3.add("Selecciona el embutido que has comido");
        elementos3.add("andouille: 232kcal");
        elementos3.add("bacon/panceta/tocino: 407kcal");
        elementos3.add("bockwust: 301kcal");
        elementos3.add("bratwurst: 297kcal");
        elementos3.add("chorizo: 455kcal");
        elementos3.add("corned beef: 153kcal");
        elementos3.add("fuet:422kcal");
        elementos3.add("jamón cocida: 133kcal");
        elementos3.add("kielbasa: 309kcal");
        elementos3.add("knackwurst: 307kcal");
        elementos3.add("landjäger/salchicha: 352kcal");
        elementos3.add("leberwurst: 326kcal");
        elementos3.add("lomo embutido: 200kcal");
        elementos3.add("lyoner: 247kcal");
        elementos3.add("mettwurst: 310kcal");
        elementos3.add("mortadela: 311kcal");
        elementos3.add("pastrami: 133kcal");
        elementos3.add( "prociutto: 195kcal");
        elementos3.add( "salami/salame:336kcal");
        elementos3.add( "salchicha/chorizo: 230kcal");
        elementos3.add( "salchicha/chorizo picante: 259kcal");
        elementos3.add("salchicha/chorizo ahumado: 301kcal");
        elementos3.add("salchicha italiana/chorizo criollo: 149kcal");
        elementos3.add("salchicha parrillera: 840kcal");
        elementos3.add("frankfurt/salchicha de viena: 305kcal");
        elementos3.add("salchichón: 247kcal");
        elementos3.add("sobrasada: 598kcal");
        elementos3.add("weisswurst/salchicha blanca: 313kcal");


        ArrayAdapter adp3=new ArrayAdapter(Carne.this, android.R.layout.simple_spinner_dropdown_item,elementos3);
        sp3.setAdapter(adp3);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent , View view, int position, long id){
                String elemento3=(String) sp3.getAdapter().getItem(position);
                Toast toast3 = Toast.makeText(getApplicationContext(), "has seleccionado " +elemento3, Toast.LENGTH_SHORT);



                edi3=findViewById(R.id.phone10);
                String res3= edi3.getText().toString();
                res3.trim();
                if(!res3.isEmpty()) {
                    int num3 = Integer.parseInt(res3);
                    if (position == 1) {  resultado3 = num3  +232;  toast3.show();}
                    if (position == 2) { resultado3 = num3 +407;  toast3.show();}
                    if (position == 3) {resultado3 = num3 +301;  toast3.show();}
                    if (position == 4) { resultado3 = num3 +297;  toast3.show();}
                    if (position == 5) { resultado3 = num3 +455;  toast3.show();}
                    if (position == 6) { resultado3 = num3 +153;  toast3.show();}
                    if (position == 7) { resultado3 = num3 +422;  toast3.show();}
                    if (position == 8) { resultado3 = num3 +133;  toast3.show();}
                    if (position == 9) { resultado3 = num3 +309;  toast3.show();}
                    if (position == 10) { resultado3 = num3 +307;  toast3.show();}
                    if (position == 11) { resultado3 = num3 +352;  toast3.show();}
                    if (position == 12) { resultado3 = num3 +326;  toast3.show();}
                    if (position == 13) { resultado3 = num3 +200;  toast3.show();}
                    if (position == 14) { resultado3 = num3 +247;  toast3.show();}
                    if (position == 15) { resultado3 = num3 +310;  toast3.show();}
                    if (position == 16) { resultado3 = num3 +311;  toast3.show();}
                    if (position == 17) { resultado3 = num3 +133;  toast3.show();}
                    if (position == 18) { resultado3 = num3 +195;  toast3.show();}
                    if (position == 19) { resultado3 = num3 +336;  toast3.show();}
                    if (position == 20) { resultado3 = num3 +230;  toast3.show();}
                    if (position == 21) { resultado3 = num3 +259;  toast3.show();}
                    if (position == 22) { resultado3 = num3 +301;  toast3.show();}
                    if (position == 23) { resultado3 = num3 +149;  toast3.show();}
                    if (position == 24) { resultado3 = num3 +840;  toast3.show();}
                    if (position == 25) { resultado3 = num3 +305;  toast3.show();}
                    if (position == 26) { resultado3 = num3 +247;  toast3.show();}
                    if (position == 27) { resultado3 = num3 +598;  toast3.show();}
                    if (position == 28) { resultado3 = num3 +313;  toast3.show();}


                



            }}
            @Override
            public void onNothingSelected(AdapterView<?>parent ){

            }
        });

    }


        public void volverMenu(View view) {
            Intent i = new Intent(this, Categorias.class );
            startActivity(i);

        }
private float total;

    public void enviar(View view) {

        Intent intent = new Intent(this, Seguimiento.class);
        //intent.putExtra("calorias carne", total);

        startActivity(intent);
        Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se han guardado los datos de carne correctamente", Toast.LENGTH_SHORT);

        toastNada3.show();

        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Carne.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("carne",total);
        this.guardarenbaseDAtos(total);
        myEditor.commit();

    }

    public void ver(View view) {
        fina=findViewById(R.id.totalP);
        total=resultado+resultado2+resultado3;
        fina.setText("total calorias carne: " + total);
        if(total==0)
        {
            Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se estan cargando los datos,pruebe otra vez en unos instantes, gracias por su espera.", Toast.LENGTH_SHORT);

            toastNada3.show();
        }
    }
    public void guardarenbaseDAtos(float numerooo) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Carne.this);

        String nombreGur=myPreferences.getString("nombreUser", "");
        float num = myPreferences.getFloat("carne", 0);


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 17);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String sql = "UPDATE comida SET carne='"+numerooo+"' where  login='"+nombreGur+"'";
        Log.i("tag","valor gaurdar"+ numerooo);
        bd.execSQL(sql);
        bd.close();
    }

    public void ayuda(View view) {

        startActivity(new Intent(Carne.this, PopupCarne.class));
    }

    public void ayuda2dfs(View view) {
        startActivity(new Intent(Carne.this, PopupCarne2.class));
    }
}
