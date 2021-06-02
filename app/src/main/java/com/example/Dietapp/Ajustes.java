package com.example.Dietapp;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dietapp.categorias.Carne;
import com.example.Dietapp.extras.ContadroVasosAgua;
import com.example.Dietapp.extras.Pagina_reto;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.Dietapp.login.Login;
import com.example.myapplicationfinal.R;

import java.io.File;
import java.util.Calendar;

import yuku.ambilwarna.AmbilWarnaDialog;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.getInstance;

public class Ajustes extends AppCompatActivity {
    TextView texto, nombreED, apellidoED, apellido2ED, emailED, retos;
    ImageView imagen;
    Button botonImagen, botonRetos, botonAgua, botonColor;
    ScrollView xml;
    int colorDefecto;


    private final String CARPETA_RAIZ = "misImagenesPrueba/";
    private final String RUTA_IMAGEN = CARPETA_RAIZ + "misFotos";

    final int COD_SELECCIONA = 10;
    final int COD_FOTO = 20;
    String path;
    String nombreUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);


        texto = findViewById(R.id.textView23);
        nombreED = findViewById(R.id.textView24);
        apellidoED = findViewById(R.id.textView39);
        apellido2ED = findViewById(R.id.textView40);
        emailED = findViewById(R.id.textView38);
        retos = findViewById(R.id.textView395);


        botonRetos = findViewById(R.id.bRetos);
        botonRetos.setVisibility(View.INVISIBLE);

        botonAgua = findViewById(R.id.bcontadorAgua);
        botonAgua.setVisibility(View.INVISIBLE);

        xml = findViewById(R.id.layoutAjustes);
        colorDefecto = ContextCompat.getColor(com.example.Dietapp.Ajustes.this, R.color.colorPrimary);
        botonColor = findViewById(R.id.bcolor);
        botonColor.setVisibility(View.INVISIBLE);


        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Ajustes.this);
        nombreUser = myPreferences.getString("nombreUser", "");
        String nombre = myPreferences.getString("nombre", "");
        String apellido = myPreferences.getString("apellido", "");
        String apellido2 = myPreferences.getString("apellido2", "");
        String emal = myPreferences.getString("email", "");
        String agua = myPreferences.getString("agua", "");


        texto.setText("Nombre usuario-----> " + nombreUser);
        nombreED.setText("Nombre ---------------->  " + nombre);
        apellidoED.setText("Apellido ---------------->  " + apellido);
        apellido2ED.setText("Apellido2 -------------->  " + apellido2);
        emailED.setText("Email -------------------->  " + emal);
        retos.setText(agua);


        this.borrarDAtosDiario();


        imagen = findViewById(R.id.imageView29);


        String imagenU = myPreferences.getString("magen", "");
        Log.i("tag", "images:" + imagenU);

        if (!imagenU.equals("")) {
            imagen.setImageURI(Uri.parse(imagenU));
        }
        imagen.getResources();


        botonImagen = findViewById(R.id.button43);
        if (validaPermisos()) {
            botonImagen.setEnabled(true);
        } else {
            botonImagen.setEnabled(false);
        }
    }


    public void verMAs(View view) {
        botonRetos.setVisibility(View.VISIBLE);
        botonAgua.setVisibility(View.VISIBLE);
        botonColor.setVisibility(View.VISIBLE);
    }


    public void iraRetos(View view) {
        Intent ifds = new Intent(this, Pagina_reto.class);
        startActivity(ifds);
    }

    AdminSQLiteOpenHelper admin;

    public void cerrarSesio(View view) {
        admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 17);
        final Intent ifds = new Intent(this, Login.class);
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("¿Estas seguro de cerrar sesión?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Ajustes.this);
                        SharedPreferences.Editor myEditor = myPreferences.edit();
                        myEditor.putString("nombreUser", "");
                        myEditor.putString("nombre", "");
                        myEditor.putString("apellido", "");
                        myEditor.putString("apellido2", "");
                        myEditor.putString("email", "");
                        myEditor.putString("contra", "");
                        myEditor.putInt("valoragua", 0);
                        myEditor.putFloat("valoragua2", 0);
                        myEditor.putFloat("recetas", 0);
                        myEditor.putFloat("bebida", 0);
                        myEditor.putString("magen", "");
                        myEditor.putFloat("carne", 0);
                        myEditor.putFloat("pescado", 0);
                        myEditor.putFloat("depor", 0);
                        myEditor.putFloat("fru", 0);
                        myEditor.putFloat("pasta", 0);
                        myEditor.putFloat("salsa", 0);
                        myEditor.putFloat("erdura", 0);
                        myEditor.putFloat("receta", 0);
                        myEditor.putFloat("bebida", 0);

                        myEditor.apply();
                        myEditor.commit();


                        startActivity(ifds);
                    }


                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();


    }


    public void iraContadorAgua(View view) {
        Intent ifds = new Intent(this, ContadroVasosAgua.class);
        startActivity(ifds);

    }

    public void borrarDAtosDiario() {
        //si son las 23 borrar todos los datos introducidos por el usuario, ya que han sido los datos del dia anterior.

        //obtener la hora actual
        Calendar calendario = getInstance();
        int hora, minutos, segundos;
        hora = calendario.get(HOUR_OF_DAY);
        minutos = calendario.get(MINUTE);
        segundos = calendario.get(SECOND);


        //comparar los minutos segundo y horas a las 23  se reseten los datos
        while ((hora == 23 && minutos == 00 && segundos == 00)) {
            //borrar registrocunado llegadas las doce de la noche

            SharedPreferences myPreferencesPA = PreferenceManager.getDefaultSharedPreferences(Ajustes.this);
            SharedPreferences.Editor myEditorPA = myPreferencesPA.edit();
            myEditorPA.putFloat("pasta", 0);
            myEditorPA.putFloat("carne", 0);
            myEditorPA.putFloat("fru", 0);
            myEditorPA.putFloat("depor", 0);
            myEditorPA.putFloat("pescado", 0);
            myEditorPA.putFloat("salsa", 0);
            myEditorPA.putFloat("salsa", 0);
            myEditorPA.putFloat("erdura", 0);
            myEditorPA.putFloat("valoragua", 0);
            myEditorPA.putFloat("valoragua2", 0);
            myEditorPA.putFloat("recetas", 0);
            myEditorPA.putString("magen", "");
            myEditorPA.apply();
            myEditorPA.commit();
//cambio el valor actual del reto, y lo pongo vacio, ya que el reto se debe cumplir una vez ald ia, por lo que a las once se pone vacio
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 17);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String sql = "UPDATE usuarios SET retoagua=''";
            bd.execSQL(sql);
            String sql2 = "UPDATE usuarios SET img=''";
            bd.execSQL(sql2);

            String sql3 = "UPDATE comida SET total='0.0', carne ='0.0', pescado ='0.0', bebidas ='0.0', fruta ='0.0', deporte ='0.0', pastas ='0.0', salsas ='0.0',verdura ='0.0',recetas='0.0' where login='" + nombreUser + "' ";
            bd.execSQL(sql3);
            bd.close();
        }

        Log.i("taf", "" + hora);
        Log.i("taf", "" + minutos);

    }


    public void abrirColorPicker(View view) {
        AmbilWarnaDialog coloPicker = new AmbilWarnaDialog(this, colorDefecto, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                colorDefecto = color;
                xml.setBackgroundColor(colorDefecto);
            }
        });
        coloPicker.show();
    }

    private boolean validaPermisos() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        if ((checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED) &&
                (checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
            return true;
        }

        if ((shouldShowRequestPermissionRationale(CAMERA)) ||
                (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE))) {
            cargarDialogoRecomendacion();
        } else {
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, CAMERA}, 100);
        }

        return false;
    }

    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(Ajustes.this);
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, CAMERA}, 100);
            }
        });
        dialogo.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100) {
            if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                botonImagen.setEnabled(true);
            } else {
                solicitarPermisosManual();
            }
        }

    }

    private void solicitarPermisosManual() {
        final CharSequence[] opciones = {"si", "no"};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(Ajustes.this);
        alertOpciones.setTitle("¿Desea configurar los permisos de forma manual?");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("si")) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Los permisos no fueron aceptados", Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
            }
        });
        alertOpciones.show();
    }


    public void onclick(View view) {
        cargarImagen();
    }

    private void cargarImagen() {

        final CharSequence[] opciones = {"Tomar Foto", "Cargar Imagen", "Cancelar"};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(Ajustes.this);
        alertOpciones.setTitle("Seleccione una Opción");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("Tomar Foto")) {
                    Toast.makeText(getApplicationContext(), "OPCIÓN SELECCIONADA EN DESARROLLO, SENTIMOS LAS MOLESTIAS ", Toast.LENGTH_SHORT).show();
                } else {
                    if (opciones[i].equals("Cargar Imagen")) {
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent, "Seleccione la Aplicación"), COD_SELECCIONA);
                    } else {
                        dialogInterface.dismiss();
                    }
                }
            }
        });
        alertOpciones.show();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            // switch (requestCode){
            //   case COD_SELECCIONA:
            Uri miPath = data.getData();
            imagen.setImageURI(miPath);
            this.guardarimagne(miPath);

            Log.i("tag", "valor" + String.valueOf(miPath));
            //     break;

                /*case COD_FOTO:
                    MediaScannerConnection.scanFile(this, new String[]{path}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.i("Ruta de almacenamiento","Path: "+path);
                                }
                            });

                    Bitmap bitmap= BitmapFactory.decodeFile(path);
                    imagen.setImageBitmap(bitmap);

                    break;
            }*/


        }
    }

    private void guardarimagne(Uri ur) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Ajustes.this);
        SharedPreferences.Editor editor = myPreferences.edit();
        editor.putString("magen", String.valueOf(ur));
        editor.apply();
        editor.commit();

        String nombreUser = myPreferences.getString("nombreUser", "");
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 17);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String sql = "UPDATE usuarios SET img='" + String.valueOf(ur) + "'  where login='" + nombreUser + "'";
        bd.execSQL(sql);

        Log.i("tag", String.valueOf(ur));
    }

    public void volverMenu(View view) {
        Intent ifds = new Intent(this, Categorias.class);
        startActivity(ifds);

    }
}
