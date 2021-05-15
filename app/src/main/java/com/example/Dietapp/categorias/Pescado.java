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
        elementos.add("Selecciona el tipo de pescado que has comido");
        elementos.add("abadejo: 111kcal");
        elementos.add("anchoa de banco: 159kcal");
        elementos.add("anguila:236kcal");
        elementos.add("arenque: 203kcal");
        elementos.add("atun: 132kcal");
        elementos.add("boquerón/anchoa: 131kcal");
        elementos.add("bacalao: 105kcal");
        elementos.add("balistes:93kcal");
        elementos.add("boga: 149kcal");
        elementos.add("brema: 135kcal");
        elementos.add("besugo: 88kcal");
        elementos.add("caballa/verdel:212kcal");
        elementos.add("capellán: 124kcal");
        elementos.add("carpa: 162kcal");
        elementos.add("caviar: 264kcal");
        elementos.add("corvina: 81kcal");
        elementos.add("cabracho: 91kcal");
        elementos.add("congrio: 107kcal");
        elementos.add(" dorada: 77kcal");
        elementos.add("dorado: 85kcal");
        elementos.add("esglefino: 90kcal");
        elementos.add("esturión: 135kcal");
        elementos.add("fletán/halibut: 111kcal");
        elementos.add("gallineta nórdica: 94kcal");
        elementos.add("lenguado: 86kcal");
        elementos.add("lisa: 150kcal");
        elementos.add("lubina/ródalo: 124kcal");
        elementos.add("lucio: 113kcal");
        elementos.add("lucioperca: 84kcal");
        elementos.add("maruca: 128kcal");
        elementos.add("merluza: 71kcal");
        elementos.add("mero/cherna: 118kcal");
        elementos.add("palitos de pescado: 290kcal");
        elementos.add("palometa/japuta: 187kcal");
        elementos.add("panga: 67kcal");
        elementos.add("pargo rojo: 87kcal");
        elementos.add("pejerrey: 106kcal");
        elementos.add("pescadilla: 116kcal");
        elementos.add("peto: 109kcal");
        elementos.add("pez espada/emperador: 172kcal");
        elementos.add("platija: 86kcal");
        elementos.add("rape: 97kcal");
        elementos.add("rodaballo: 122kcal");
        elementos.add("sabalote: 190kcal");
        elementos.add("salmón: 206kcal");
        elementos.add("sardina: 208kcal");
        elementos.add("solla: 91kcal");
        elementos.add("surubí: 110kcal");
        elementos.add("sábalo: 252kcal");
        elementos.add("tiburón: 130kcal");
        elementos.add("trucha: 190kcal");
        elementos.add("gallo: 81kcal");
        elementos.add("jurel/chicharro: 117kcal");
        elementos.add("liba/eglefino/merlán: 84kcal");
        elementos.add("raya: 97kcal");
        elementos.add("salmón: 206kcal");
        elementos.add("salmonete: 109kcal");
        elementos.add("sushi: 150kcal");
        elementos.add("zapatilla: 77kcal");






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

                    if(position==1) { resultado= resultado+(num* 111); toast1.show();}
                    if(position==2) { resultado= resultado+(num*159); toast1.show();}
                    if(position==3) { resultado= resultado+(num*236); toast1.show();}
                    if(position==4) { resultado= resultado+(num*203); toast1.show();}
                    if(position==5) { resultado= resultado+(num*132); toast1.show();}
                    if(position==6) { resultado= resultado+(num*131); toast1.show();}
                    if(position==7) { resultado= resultado+(num*105); toast1.show();}
                    if(position==8) { resultado= resultado+(num*93); toast1.show();}
                    if(position==9) { resultado= resultado+(num*149); toast1.show();}
                    if(position==10) { resultado= resultado+(num*135); toast1.show();}
                    if(position==11) { resultado= resultado+(num* 84); toast1.show();}
                    if(position==12) { resultado= resultado+(num* 88); toast1.show();}
                    if(position==13) { resultado= resultado+(num*212); toast1.show();}
                    if(position==14) { resultado= resultado+(num*124); toast1.show();}
                    if(position==15) { resultado= resultado+(num*162); toast1.show();}
                    if(position==16) { resultado= resultado+(num*264); toast1.show();}
                    if(position==17) { resultado= resultado+(num*81); toast1.show();}
                    if(position==18) { resultado= resultado+(num*91); toast1.show();}
                    if(position==19) { resultado= resultado+(num*107); toast1.show();}
                    if(position==20) { resultado= resultado+(num*77); toast1.show();}
                    if(position==21) { resultado= resultado+(num*85); toast1.show();}
                    if(position==22) { resultado= resultado+(num*90); toast1.show();}
                    if(position==23) { resultado= resultado+(num*135); toast1.show();}
                    if(position==24) { resultado= resultado+(num*111); toast1.show();}
                    if(position==25) { resultado= resultado+(num*94); toast1.show();}
                    if(position==26) { resultado= resultado+(num*86); toast1.show();}
                    if(position==27) { resultado= resultado+(num*150); toast1.show();}
                    if(position==28) { resultado= resultado+(num*124); toast1.show();}
                    if(position==29) { resultado= resultado+(num*113); toast1.show();}
                    if(position==30) { resultado= resultado+(num*84); toast1.show();}
                    if(position==31) { resultado= resultado+(num*128); toast1.show();}
                    if(position==32) { resultado= resultado+(num*71); toast1.show();}
                    if(position==33) { resultado= resultado+(num*118); toast1.show();}
                    if(position==34) { resultado= resultado+(num*290); toast1.show();}
                    if(position==35) { resultado= resultado+(num*187); toast1.show();}
                    if(position==36) { resultado= resultado+(num*67); toast1.show();}
                    if(position==37) { resultado= resultado+(num*87); toast1.show();}
                    if(position==38) { resultado= resultado+(num*106); toast1.show();}
                    if(position==39) { resultado= resultado+(num*116); toast1.show();}
                    if(position==40) { resultado= resultado+(num*109); toast1.show();}
                    if(position==41) { resultado= resultado+(num*172); toast1.show();}
                    if(position==42) { resultado= resultado+(num*86); toast1.show();}
                    if(position==43) { resultado= resultado+(num* 97); toast1.show();}
                    if(position==44) { resultado= resultado+(num*122); toast1.show();}
                    if(position==45) { resultado= resultado+(num*190); toast1.show();}
                    if(position==46) { resultado= resultado+(num*206); toast1.show();}
                    if(position==47) { resultado= resultado+(num*208); toast1.show();}
                    if(position==48) { resultado= resultado+(num*91); toast1.show();}
                    if(position==49) { resultado= resultado+(num*110); toast1.show();}
                    if(position==50) { resultado= resultado+(num*252); toast1.show();}
                    if(position==51) { resultado= resultado+(num*130); toast1.show();}
                    if(position==52) { resultado= resultado+(num*190); toast1.show();}
                    if(position==53) { resultado= resultado+(num*81); toast1.show();}
                    if(position==54) { resultado= resultado+(num*117); toast1.show();}
                    if(position==55) { resultado= resultado+(num*84); toast1.show();}
                    if(position==56) { resultado= resultado+(num*97); toast1.show();}
                    if(position==57) { resultado= resultado+(num*206); toast1.show();}
                    if(position==58) { resultado= resultado+(num*109); toast1.show();}
                    if(position==59) { resultado= resultado+(num*85.4f); toast1.show();}
                    if(position==60) { resultado= resultado+(num*77); toast1.show();}




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

        elementos2.add(" almeja: 148kcal");
        elementos2.add("almeja fina/chirla: 76.6 kcal");
        elementos2.add("berberecho: 76kcal");
        elementos2.add("bígaro: 94kcal");
        elementos2.add("boca: 86kcal");
        elementos2.add("bogavante: 90kcal");
        elementos2.add("buey de mar: 130kcal");
        elementos2.add("busano: 79kcal");
        elementos2.add("calamar: 175kcal");
        elementos2.add("camarón: 82kcal");
        elementos2.add("cangrejo de mar: 124kcal");
        elementos2.add("cangrejo de rio: 82kcal");
        elementos2.add("cañailla: 91kcal");
        elementos2.add("caracol:80kcal");
        elementos2.add("centollo: 127kcal");
        elementos2.add("cigalas: 69kcal");
        elementos2.add("coquina: 75kcal");
        elementos2.add("gambas: 75kcal");
        elementos2.add("langosta: 89kcal");
        elementos2.add("langostino: 75kcal");
        elementos2.add("langostinos tigre: 90kcal");
        elementos2.add("lapa: 86kcal");
        elementos2.add("mejillón: 172kcal");
        elementos2.add("navaja: 92.5kcal");
        elementos2.add("nécora: 125kal");
        elementos2.add("ostra: 41kcal");
        elementos2.add("pecho: 86kcal");
        elementos2.add("percebe: 66kcal");
        elementos2.add("pota: 120kcal");
        elementos2.add("pulpo: 164kcal");
        elementos2.add("sepia: 75.3kcal");
        elementos2.add("vieira: 111kcal");



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

                    if(position==1) { resultado2=resultado2+(num2*148); toastMP.show();}
                    if(position==2) { resultado2=resultado2+(num2* 76.6f); toastMP.show();}
                    if(position==3) { resultado2=resultado2+(num2*76); toastMP.show();}
                    if(position==4) { resultado2=resultado2+(num2*94); toastMP.show();}
                    if(position==5) { resultado2=resultado2+(num2*86); toastMP.show();}
                    if(position==6) { resultado2=resultado2+(num2*90); toastMP.show();}
                    if(position==7) { resultado2=resultado2+(num2*130); toastMP.show();}
                    if(position==8) { resultado2=resultado2+(num2*79); toastMP.show();}
                    if(position==9) { resultado2=resultado2+(num2*175); toastMP.show();}
                    if(position==10) { resultado2=resultado2+(num2*82); toastMP.show();}
                    if(position==11) { resultado2=resultado2+(num2*124); toastMP.show();}
                    if(position==12) { resultado2=resultado2+(num2*82); toastMP.show();}
                    if(position==13) { resultado2=resultado2+(num2*91); toastMP.show();}
                    if(position==14) { resultado2=resultado2+(num2*80); toastMP.show();}
                    if(position==15) { resultado2=resultado2+(num2*127); toastMP.show();}
                    if(position==16) { resultado2=resultado2+(num2* 69); toastMP.show();}
                    if(position==17) { resultado2=resultado2+(num2*75); toastMP.show();}
                    if(position==18) { resultado2=resultado2+(num2*75); toastMP.show();}
                    if(position==19) { resultado2=resultado2+(num2*89); toastMP.show();}
                    if(position==20) { resultado2=resultado2+(num2*75); toastMP.show();}
                    if(position==21) { resultado2=resultado2+(num2*90); toastMP.show();}
                    if(position==22) { resultado2=resultado2+(num2*86); toastMP.show();}
                    if(position==23) { resultado2=resultado2+(num2*172); toastMP.show();}
                    if(position==24) { resultado2=resultado2+(num2*92.5f); toastMP.show();}
                    if(position==25) { resultado2=resultado2+(num2* 125); toastMP.show();}
                    if(position==26) { resultado2=resultado2+(num2* 41); toastMP.show();}
                    if(position==27) { resultado2=resultado2+(num2*86); toastMP.show();}
                    if(position==28) { resultado2=resultado2+(num2*66); toastMP.show();}
                    if(position==29) { resultado2=resultado2+(num2*120); toastMP.show();}
                    if(position==30) { resultado2=resultado2+(num2*164); toastMP.show();}
                    if(position==31) { resultado2=resultado2+(num2*75.3f); toastMP.show();}
                    if(position==32) { resultado2=resultado2+(num2*111); toastMP.show();}



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
