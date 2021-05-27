package com.example.Dietapp.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Dietapp.Categorias;
import com.example.myapplicationfinal.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RecuperarContrase extends AppCompatActivity {

    private EditText nombreUserContai;
    private String nombreUserContaiT;
    private Intent iD;
    Session sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrase);


        nombreUserContai = findViewById(R.id.editNombreUser);

        iD = new Intent(this, Login.class);
    }

    public void lnazarRecuCOn(View view) {
        try {

            nombreUserContaiT = String.valueOf(nombreUserContai.getText());


            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                    "registro_user", null, 11);
            SQLiteDatabase bd = admin.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.

            Cursor curso = bd.rawQuery("select *  from usuarios ", null);
boolean dentro= Boolean.parseBoolean(null);
            curso.moveToFirst();
            while (!curso.isAfterLast()) {
                String compararEmail = curso.getString(5);
                String compararus = curso.getString(0);
                String compararC = curso.getString(4);
                Log.i("tag", compararEmail);
                Log.i("tag", compararus);
                if (compararEmail.equals(nombreUserContaiT) ) {
                    Toast.makeText(this, "Email correcto", Toast.LENGTH_SHORT).show();
                    Log.i("tag", "dentro if");
dentro=true;
                    this.enviarCorre(nombreUserContaiT,compararC,compararus);


                    Toast.makeText(this, "Se ha enviado correctamente un email con su contraseña", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, Login.class);
                    startActivity(i);




                }


                curso.moveToNext();

            }
            if(dentro)
                Toast.makeText(this, "Email correcto", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Email incorrecto", Toast.LENGTH_SHORT).show();
            bd.close();

        } catch (Exception e) {

        }
    }

    private void enviarCorre(final String email,  String textoEnviar,String nombreUser) {
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //textoEnvias=String.valueOf(editTextMessage.getText());
        Properties props=new Properties();
        props.put("mail.smtp.host", "smtp.googlemail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        try{
            sesion = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return  new PasswordAuthentication("dietappapp@gmail.com","A28aaaaaaaaaa");
                }
            });
            Message message = new MimeMessage(sesion);
            message.setFrom(new InternetAddress(email));
            message.setSubject("contraseña dietapp");
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setContent("Buenos dias estimado " +nombreUser+"."+ " <br/>su contraseña de Dietapp es: "+textoEnviar, "text/html; charset=utf-8");
            Transport.send(message);


        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }







    }
