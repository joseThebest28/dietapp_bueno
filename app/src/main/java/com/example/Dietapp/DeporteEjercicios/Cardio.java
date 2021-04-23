package com.example.Dietapp.DeporteEjercicios;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dietapp.categorias.CategoDeporte;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class Cardio extends AppCompatActivity {


    private Spinner sp;
    private EditText edi;
    private EditText edi2;
    private double resultado;
    private double resultad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardio);
        sp=(Spinner)findViewById(R.id.espi2);

        ArrayList<String> elementos=new ArrayList<>();
        elementos.add("Selecciona el tipo de cardio");
        elementos.add("Andar");
        elementos.add("Bicicleta");
        elementos.add("Natación");
        elementos.add("Escalada");
        elementos.add("Zumba, aerobic u otras actividades de baile ");
        elementos.add("Esquí");


        ArrayAdapter adp=new ArrayAdapter(Cardio.this, android.R.layout.simple_spinner_dropdown_item,elementos);
        sp.setAdapter(adp);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent , View view, int position, long id){
                String elemento=(String) sp.getAdapter().getItem(position);
                Toast toast1 = Toast.makeText(getApplicationContext(), "has seleccionado " +elemento, Toast.LENGTH_SHORT);



                edi=findViewById(R.id.minutos);
                edi2=findViewById(R.id.horas);
                String res= edi.getText().toString();
                String res2= edi2.getText().toString();
                res.trim();
                res2.trim();
                if(!res.isEmpty()&&!res2.isEmpty())
                {int num = Integer.parseInt(res);
                    double num2 = Integer.parseInt(res2);


                    if(position==1) {//Andar
                        num2=num2*60;
                        resultado=(num+num2)*10;
                        toast1.show();}

                    if(position==2) {//Bicicleta
                        num2=num2*60;
                        resultado=(num+num2)*15;; toast1.show();}

                    if(position==3) {//Natación
                        num2=num2*60;
                        resultado=(num+num2)*20;; toast1.show();}

                    if(position==4) {//Escalada
                        num2=num2*60;
                        resultado=(num+num2)*17;; toast1.show();}

                    if(position==5) {//Zumba, aerobic u otras actividades de baile
                        num2=num2*60;
                        resultado=(num+num2)*22;; toast1.show();}

                    if(position==6) {//Esquí
                        num2=num2*60;
                        resultado=(num+num2)*12; toast1.show();}



                }
                TextView text=findViewById(R.id.textR);

                text.setText( "Total calorias consumidas moviendote: "+resultado);}
            @Override
            public void onNothingSelected(AdapterView<?>parent ){
                Toast toastNada = Toast.makeText(getApplicationContext(), "No has seleccioando nada", Toast.LENGTH_SHORT);

                toastNada.show();
            }
        });
    }

    public void guardar(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Cardio.this);

        double num = myPreferences.getInt("depor", 0);
        num=num+resultado;
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("depor", (int) num);
        myEditor.commit();
        edi.setText("");
        edi2.setText("");
        Intent i = new Intent(this, CategoDeporte.class );
        startActivity(i);
    }


}
