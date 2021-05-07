package com.example.Dietapp.categorias;

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

import com.example.Dietapp.PaginaPrincipal;
import com.example.Dietapp.Seguimiento;
import com.example.Dietapp.categorias.popup.PopupPescado;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class Pescado extends AppCompatActivity {
    private Spinner sp;
    private Spinner sp2;

    private EditText edi;
    private EditText edi2;

    private TextView fina;
    private float resultado;
    private float resultado2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pescado);
        sp=(Spinner)findViewById(R.id.Sp1);

        ArrayList<String> elementos=new ArrayList<>();
        elementos.add("Selecciona el tipo de crustaceo que has comido");
        elementos.add("Cigala");
        elementos.add("Cangrejo");
        elementos.add("Bogabante");
        elementos.add("Percebe");

        ArrayAdapter adp=new ArrayAdapter(Pescado.this, android.R.layout.simple_spinner_dropdown_item,elementos);
        sp.setAdapter(adp);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent , View view, int position, long id){
                String elemento=(String) sp.getAdapter().getItem(position);
                Toast toast1 = Toast.makeText(getApplicationContext(), "has seleccionado " +elemento, Toast.LENGTH_SHORT);



                edi=findViewById(R.id.numP1);
                String res= edi.getText().toString();
                res.trim();
                if(!res.isEmpty())
                {int num = Integer.parseInt(res);


                    if(position==1) {//Cigala
                        resultado= num*85.4f; toast1.show();}

                    if(position==2) {//Cangrejo
                        resultado=num*101; toast1.show();}

                    if(position==3){//Bogabante
                        resultado=num*83; toast1.show();}

                    if(position==4){//Percebe
                        resultado=num*6.6f; toast1.show();}

                }}
            @Override
            public void onNothingSelected(AdapterView<?>parent ){
                Toast toastNada = Toast.makeText(getApplicationContext(), "No has seleccioando nada", Toast.LENGTH_SHORT);

                toastNada.show();
            }
        });
        sp2=(Spinner)findViewById(R.id.spP2);

        ArrayList<String> elementos2=new ArrayList<>();
        elementos2.add("Selecciona el molusco que has comido");
        elementos2.add("Almeja");
        elementos2.add("Caracol");
        elementos2.add("Calamar");
        elementos2.add("Pulpo");

        ArrayAdapter adp2=new ArrayAdapter(Pescado.this, android.R.layout.simple_spinner_dropdown_item,elementos2);
        sp2.setAdapter(adp2);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent , View view, int position, long id){
                String elemento2=(String) sp2.getAdapter().getItem(position);
                Toast toastMP = Toast.makeText(getApplicationContext(), "has seleccionado " +elemento2, Toast.LENGTH_SHORT);



                edi2=findViewById(R.id.numP2);
                String res2= edi2.getText().toString();
                res2.trim();
                if(!res2.isEmpty())
                {int num2 = Integer.parseInt(res2);

                    if(position==1) {
                        //Almeja
                        resultado2=num2*74; toastMP.show();}
                    if(position==2) {
                        //Caracol
                        resultado2=num2*7.8f; toastMP.show();}
                    if(position==3){
                        //Calamar
                        resultado2=num2*175; toastMP.show();}
                    if(position==4){
                        //Pulpo
                        resultado2=num2*69; toastMP.show();}



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
    float totalSuma;

    public void enviar(View view) {
        Intent intent = new Intent(this, Seguimiento.class);
        intent.putExtra("calorias pescado", totalSuma);

        startActivity(intent);
        Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se han guardado los datos de pescado correctamente", Toast.LENGTH_SHORT);

        toastNada3.show();
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Pescado.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("pescado",  totalSuma);
        myEditor.commit();
    }

    public void ver(View view) {
        fina=findViewById(R.id.totalP);
        totalSuma=resultado+resultado2;
        fina.setText("total calorias pescado: " + totalSuma);
        if(totalSuma==0)
        {
            Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se estan cargando los datos,pruebe otra vez en unos instantes, gracias por su espera.", Toast.LENGTH_SHORT);

            toastNada3.show();
        }
    }

    public void ayudapez(View view) {
        startActivity(new Intent(Pescado.this, PopupPescado.class));
    }
}
