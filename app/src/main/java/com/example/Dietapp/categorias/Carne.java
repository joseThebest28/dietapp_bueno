package com.example.Dietapp.categorias;

import android.content.Intent;
import android.content.SharedPreferences;
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

import com.example.Dietapp.PaginaPrincipal;
import com.example.Dietapp.categorias.popup.PopupCarne;
import com.example.Dietapp.Seguimiento;
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
    private int resultado;
    private int resultado2;
    private int resultado3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carne);

        sp=(Spinner)findViewById(R.id.espi);

        ArrayList<String> elementos=new ArrayList<>();
        elementos.add("Selecciona la carne que has comido");
        elementos.add("Filete de ternera");
        elementos.add("Filete de caballo");
        elementos.add("Filete de buey");
        elementos.add("Filete de vaca");

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
        elementos2.add("Selecciona la carne que has comido");
        elementos2.add("Filete de pollo");
        elementos2.add("Filete de pavo");
        elementos2.add("Lomo de cerdo");

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
                    //filete de pollo
                    resultado2=num2*40; toast2.show();}
                if(position==2) {
                    //fielete de pavo
                    resultado2=num2*30;toast2.show();}
                if(position==3){
                    //fielete de cerdo
                    resultado2=num2*60; toast2.show();}



            }}
            @Override
            public void onNothingSelected(AdapterView<?>parent ){

            }
        });
        sp3=(Spinner)findViewById(R.id.spiC3);

        ArrayList<String> elementos3=new ArrayList<>();
        elementos3.add("Selecciona el ambutido que has comido");
        elementos3.add("chorizo");
        elementos3.add("morcilla");
        elementos3.add("longaniza");

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

                    if (position == 1) {
                        //chorizo
                        resultado3 = num3 * 170;
                        toast3.show();
                    }

                if(position==2) {
                    //morcilla
                    resultado3=num3*150;
                    toast3.show();}
                if(position==3){
                    //longaniza
                    resultado3=num3*130;
                    toast3.show();}



            }}
            @Override
            public void onNothingSelected(AdapterView<?>parent ){

            }
        });

    }
    public void volverCategorias(View view) {
        Intent i = new Intent(this, Categorias.class );
        startActivity(i);
    }

        public void volverMenu(View view) {
            Intent i = new Intent(this, PaginaPrincipal.class );
            startActivity(i);

        }
private int total;

    public void enviar(View view) {
        Intent intent = new Intent(this, Seguimiento.class);
        intent.putExtra("calorias carne", total);

        startActivity(intent);
        Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se han guardado los datos de carne correctamente", Toast.LENGTH_SHORT);

        toastNada3.show();
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Carne.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("carne", (int) total);
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

    public void ayuda(View view) {

        startActivity(new Intent(Carne.this, PopupCarne.class));
    }
}
