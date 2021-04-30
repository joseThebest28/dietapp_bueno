package com.example.Dietapp.extras;

import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Dietapp.Ajustes;
import com.example.myapplicationfinal.R;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Color extends AppCompatActivity {
ConstraintLayout mlay;
int defaultcolor;
Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mlay=findViewById(R.id.layoutActivity);
        defaultcolor= ContextCompat.getColor(Color.this,R.color.colorPrimary);
        boton=findViewById(R.id.buttonColor);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
    }

    private void openColorPicker() {
        AmbilWarnaDialog  coloPicker= new AmbilWarnaDialog(this, defaultcolor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
defaultcolor=color;
mlay.setBackgroundColor(defaultcolor);
            }
        });coloPicker.show();
    }
}