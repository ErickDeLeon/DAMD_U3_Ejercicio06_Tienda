package mx.edu.ittepic.damd_u3_ejercicio06_tienda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo6(this));
    }
}