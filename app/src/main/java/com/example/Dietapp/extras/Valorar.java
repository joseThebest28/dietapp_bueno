package com.example.Dietapp.extras;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.Dietapp.Categorias;
import com.example.Dietapp.login.Login;
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

public class Valorar extends AppCompatActivity {
    RatingBar rating;
    EditText texto;
    float numeroRatinIntroducido;
    private String textoEdit, nombreUSer;
    private Intent iD;
    Session sesion;
    ProgressDialog pro;
    boolean mensaje = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valorar);
        rating = findViewById(R.id.ratingBar);
        texto = findViewById(R.id.editTextValorar);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Valorar.this);

        nombreUSer = myPreferences.getString("nombreUser", "");


    }

    private void antesenviarcorreo() {
        pro = ProgressDialog.show(this, "enviando comentario", "por favor espere", false, false);
        mensaje = true;
    }

    private void despuesEnviocorreo() {

        Toast.makeText(this, "Se ha enviado correctamente su comentario", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Categorias.class);
        startActivity(i);

    }


    private void enviarCorre(final float numeroRating, String textoEnviar, String nombreUsr) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.googlemail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        try {
            sesion = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("dietappapp@gmail.com", "A28aaaaaaaaaa");
                }
            });
            Message message = new MimeMessage(sesion);
            message.setFrom(new InternetAddress("dietappapp@gmail.com"));
            message.setSubject("comentario usaurio dietapp");
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("dietappapp@gmail.com"));
            message.setContent("El usuario:  " + nombreUsr + " ha dado una calificación de: " + numeroRating + " y ha dejado el siguiente comentario: " + textoEnviar, "text/html; charset=utf-8");
            Transport.send(message);


        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void enviarCOmentario(View view) {
        textoEdit = String.valueOf(texto.getText());
        numeroRatinIntroducido = rating.getRating();
        this.antesenviarcorreo();
        if (mensaje = true)
            this.enviarCorre(numeroRatinIntroducido, textoEdit, nombreUSer);
        this.despuesEnviocorreo();
    }

}