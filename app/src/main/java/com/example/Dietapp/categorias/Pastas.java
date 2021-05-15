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

import com.example.Dietapp.Categorias;
import com.example.Dietapp.categorias.popup.PopunPasta;
import com.example.Dietapp.Seguimiento;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class Pastas extends AppCompatActivity {
    float resultado,resultado2,resultado3,resultado4,resultado5;
    float total;
    private Spinner sp;
    private EditText edi;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pastas);

        sp=(Spinner)findViewById(R.id.spiPasta);

        ArrayList<String> elementos=new ArrayList<>();
        elementos.add("Selecciona el tipo de palto que has comido");
        elementos.add("Plato de arroz");
        elementos.add(" Canelones:146kcal");
        elementos.add("  Capellini/Cabello_de_ángel:353kcal");
        elementos.add("  Cappelletti/Capeletinis:164kcal");
        elementos.add(" Conchas:353kcal ");
        elementos.add("  Dampfnudel(pasta_al_vapor):274kcal ");
        elementos.add("  Espagueti:370kcal");
        elementos.add("        Espaguetis_integrales:351kcal");
        elementos.add("   Farfalle/Pajaritas/Mariposas:358kcal");
        elementos.add("  Fettuccine/Fetuccinni:353kcal");
        elementos.add("  Fideo_celofán/chino:192kcal");
        elementos.add(" Fideos_de_soja/soya:216kcal ");
        elementos.add(" Fideos_shirataki:18kcal ");
        elementos.add("  Fusilli:352kcal");
        elementos.add(" Linguine:357kcal ");
        elementos.add("  Láminas_de_lasaña:271kcal ");
        elementos.add("  Macaroni/Fideos/Macarrones:370kcal");
        elementos.add(" Masa_de_dumpling:99kcal ");
        elementos.add(" Mostaccioli:184kcal");
        elementos.add(" Orecchiette:370kcal ");
        elementos.add("   Orzo:357kcal ");
        elementos.add(" Pasta_baja_en_carbohidratos:282kcal ");
        elementos.add("  Pasta_de_grano_entero:347kcal ");
        elementos.add("    Pasta_de_huevo:384kcal");
        elementos.add("    Penne:351kcal ");
        elementos.add("  Penne_Rigate:370kcal");
        elementos.add("  Pierogi:200kcal");
        elementos.add("    Ravioles_de_verdura:84kcal");
        elementos.add("   Ravioli/Ravioles:77kcal");
        elementos.add(" Ravioli/Ravioles_de_carne:90kcal");
        elementos.add("  Ravioli/Ravioles_de_pollo:88kcal");
        elementos.add("   Ravioli/Ravioles_de_queso:193kcal ");
        elementos.add("  Rigatoni:353kcal ");
        elementos.add("  Spirelli:367kcal");
        elementos.add(" Spätzle:368kcal");
        elementos.add("  Sémola_de_trigo_duro:397kcal");
        elementos.add("  Tallarines_370kcal");
        elementos.add(" Tortellini:291kcal");
        elementos.add("  Tortellini_de_carne:302kcal");
        elementos.add(" Tortellini_de_espinacas:314kcal");
        elementos.add("  Tortellini_de_pollo:301kcal");
        elementos.add(" Tortellini_de_queso:291kcal ");
        elementos.add(" Tortellini_vegetal:289kcal ");
        elementos.add("Vermicelli:368kcal ");
        elementos.add("Plato de boloñesa");
        elementos.add("Plato de Carbonara");
        elementos.add("Plato de arroz con frijoles");
        elementos.add("Plato de spaghetis con queso");




        ArrayAdapter adp=new ArrayAdapter(Pastas.this, android.R.layout.simple_spinner_dropdown_item,elementos);
        sp.setAdapter(adp);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent , View view, int position, long id){
                String elemento=(String) sp.getAdapter().getItem(position);
                Toast toast1 = Toast.makeText(getApplicationContext(), "has seleccionado " +elemento, Toast.LENGTH_SHORT);



                edi=findViewById(R.id.numPasta);

                String res= edi.getText().toString();

                res.trim();

                if(!res.isEmpty())
                {
                    int num = Integer.parseInt(res);



                    if(position==1) { resultado=resultado+(num*146);toast1.show();edi.setText("");}
                    if(position==2) { resultado=resultado+(num*353);toast1.show();edi.setText("");}
                    if(position==3) { resultado=resultado+(num*164);toast1.show();edi.setText("");}
                    if(position==4) { resultado=resultado+(num*353);toast1.show();edi.setText("");}
                    if(position==5) { resultado=resultado+(num*274);toast1.show();edi.setText("");}
                    if(position==6) { resultado=resultado+(num*370);toast1.show();edi.setText("");}
                    if(position==7) { resultado=resultado+(num*351);toast1.show();edi.setText("");}
                    if(position==8) { resultado=resultado+(num*358);toast1.show();edi.setText("");}
                    if(position==9) { resultado=resultado+(num*353);toast1.show();edi.setText("");}
                    if(position==10) { resultado=resultado+(num*192);toast1.show();edi.setText("");}
                    if(position==11) { resultado=resultado+(num*216);toast1.show();edi.setText("");}
                    if(position==12) { resultado=resultado+(num*18);toast1.show();edi.setText("");}
                    if(position==13) { resultado=resultado+(num*352);toast1.show();edi.setText("");}
                    if(position==14) { resultado=resultado+(num*357);toast1.show();edi.setText("");}
                    if(position==15) { resultado=resultado+(num*271);toast1.show();edi.setText("");}
                    if(position==16) { resultado=resultado+(num*370);toast1.show();edi.setText("");}
                    if(position==17) { resultado=resultado+(num*99);toast1.show();edi.setText("");}
                    if(position==18) { resultado=resultado+(num*184);toast1.show();edi.setText("");}
                    if(position==19) { resultado=resultado+(num*370);toast1.show();edi.setText("");}
                    if(position==20) { resultado=resultado+(num*357);toast1.show();edi.setText("");}
                    if(position==21) { resultado=resultado+(num*282);toast1.show();edi.setText("");}
                    if(position==22) { resultado=resultado+(num*347);toast1.show();edi.setText("");}
                    if(position==23) { resultado=resultado+(num*384);toast1.show();edi.setText("");}
                    if(position==24) { resultado=resultado+(num*351);toast1.show();edi.setText("");}
                    if(position==25) { resultado=resultado+(num*370);toast1.show();edi.setText("");}
                    if(position==26) { resultado=resultado+(num*200);toast1.show();edi.setText("");}
                    if(position==27) { resultado=resultado+(num*84);toast1.show();edi.setText("");}
                    if(position==28) { resultado=resultado+(num*77);toast1.show();edi.setText("");}
                    if(position==29) { resultado=resultado+(num*90);toast1.show();edi.setText("");}
                    if(position==30) { resultado=resultado+(num*88);toast1.show();edi.setText("");}
                    if(position==31) { resultado=resultado+(num*193);toast1.show();edi.setText("");}
                    if(position==32) { resultado=resultado+(num*353);toast1.show();edi.setText("");}
                    if(position==33) { resultado=resultado+(num*367);toast1.show();edi.setText("");}
                    if(position==34) { resultado=resultado+(num*368);toast1.show();edi.setText("");}
                    if(position==35) { resultado=resultado+(num*397);toast1.show();edi.setText("");}
                    if(position==36) { resultado=resultado+(num*370);toast1.show();edi.setText("");}
                    if(position==37) { resultado=resultado+(num*291);toast1.show();edi.setText("");}
                    if(position==38) { resultado=resultado+(num*302);toast1.show();edi.setText("");}
                    if(position==39) { resultado=resultado+(num*314);toast1.show();edi.setText("");}
                    if(position==40) { resultado=resultado+(num*301);toast1.show();edi.setText("");}
                    if(position==41) { resultado=resultado+(num*291);toast1.show();edi.setText("");}
                    if(position==42) { resultado=resultado+(num*289);toast1.show();edi.setText("");}
                    if(position==43) { resultado=resultado+(num*368);toast1.show();edi.setText("");}
                    if(position==44) { resultado=resultado+(num*359);toast1.show();edi.setText("");}
                    if(position==45) { resultado=resultado+(num*359);toast1.show();edi.setText("");}
                    if(position==46) { resultado=resultado+(num*151);toast1.show();edi.setText("");}
                    if(position==47) { resultado=resultado+(num*361);toast1.show();edi.setText("");}





                } text=findViewById(R.id.ttoatalPasta);
                total=resultado+resultado2+resultado3+resultado4+resultado5;
                text.setText( "Total calorias de pasta: "+total);

            }
            @Override
            public void onNothingSelected(AdapterView<?>parent ){
                Toast toastNada = Toast.makeText(getApplicationContext(), "No has seleccioando nada", Toast.LENGTH_SHORT);

                toastNada.show();
            }
        });


    }

    public void volverMenu(View view) {
        Intent i = new Intent(this, Categorias.class );
        startActivity(i);
    }

    public void guadarDatosPasta(View view) {
        Intent intent = new Intent(this, Seguimiento.class);
        intent.putExtra("pasta", total);

        startActivity(intent);
        Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se han guardado los datos de pasta correctamente", Toast.LENGTH_SHORT);

        toastNada3.show();
        SharedPreferences myPreferencesPA = PreferenceManager.getDefaultSharedPreferences(Pastas.this);
        SharedPreferences.Editor myEditorPA = myPreferencesPA.edit();
        myEditorPA.putFloat("pasta", (int) total);
        myEditorPA.commit();







    }

    public void ayudapasta(View view) {
        startActivity(new Intent(Pastas.this, PopunPasta.class));
    }


}
