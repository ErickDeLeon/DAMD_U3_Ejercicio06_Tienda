package mx.edu.ittepic.damd_u3_ejercicio06_tienda;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Imagen5 {


    Bitmap icono;
    float x,y;
    boolean visible;

    public Imagen5(int recurso, float _x, float _y, Lienzo5 l){

        icono = BitmapFactory.decodeResource(l.getResources(),recurso);
        x = _x;
        y = _y;

        visible = true;
    }

    public void pintar (Canvas c, Paint p){
        if (visible) {
            c.drawBitmap(icono, x, y, p);
        }
    }

    public void hacerVisible(boolean v){
        visible = v;
    }

    public boolean estaEnArea(float xp, float yp){

        float x2, y2;

        if(!visible) {
            return false;
        }

        x2 = x+icono.getWidth();
        y2 = y+icono.getHeight();

        if(xp>=x && xp<=x2){
            if(yp>=y && yp<=y2){
                return true;
            }
        }
        return false;
    }

    public void mover( float yp){
        y = yp - (icono.getHeight()/2);
    }


}
