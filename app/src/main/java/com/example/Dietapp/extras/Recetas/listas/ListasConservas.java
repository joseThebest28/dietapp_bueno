package com.example.Dietapp.extras.Recetas.listas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class ListasConservas extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresConservas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        String[] valoresConservas= new String[]{ "selecciona tipo conservas","tomate frito: 87.6kcal",
                "tomates en conserva: 18.23kcal","latas de atún","maiz dulce","sardina en aceite de oliva",
                "mejillones fritos en escabeche","pimientos de piquillo","ventresca en aceite d eoliva",
                "anchoas en aceite de oliva","ostras en vinagreta","navajas en aceite de oliva","melva canutera",
                "filetes de caballa en aceite de girasol","huevas de bacalao en aceite",
        "lulas de caldeirada","berberechos al natural","chipirones en su tinta","caviar de erizo",""};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresConservas);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +87.6f; }
                if (position == 2) { suma = suma +18.23f; }
                if (position == 3) { suma = suma +109; }
                if (position == 4) { suma = suma +217; }
                if (position == 5) { suma = suma +214; }
                if (position == 6) { suma = suma +113; }




                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasConservas.this);
                SharedPreferences.Editor myEditor = myPreferencesG.edit();
                myEditor.putFloat("caloriasLista",total);
                myEditor.commit();
                Log.i("tag","calorias final"+total);
                suma=0;
            }});

    }
    public void realizarBusqueda(View view) {
        ArrayList<String> listaBusca=new ArrayList<>();
        textoEditT=String.valueOf(textoEdit.getText());
        for(int i=0;i<valoresConservas.length;i++)
            if(valoresConservas[i].contains(textoEditT))
            {
                listaBusca.add(valoresConservas[i]);
            }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}