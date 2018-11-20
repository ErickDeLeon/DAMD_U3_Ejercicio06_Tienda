package mx.edu.ittepic.damd_u3_ejercicio06_tienda;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {

    Imagen3 fondogris, titulo, articulo01, articulo02,articulo03, articulo04, infoart01, infoart02, infoart03, infoart04, img01, img02, img03, img04, btnregresar, puntero;
    Main3Activity punActivity3;

    public Lienzo3 (Context context){
        super(context);

        fondogris = new Imagen3(R.drawable.fondogrisvert,100, 0,this);
        titulo = new Imagen3(R.drawable.titulocalcetines, 700, 10,this);

        articulo01 = new Imagen3(R.drawable.cal01, 140, 30, this);
        articulo02 = new Imagen3(R.drawable.cal02, 140, 800, this);
        articulo03 = new Imagen3(R.drawable.cal03, 140, 1570, this);
        articulo04 = new Imagen3(R.drawable.cal04,140,2340, this);


        img01 = new Imagen3(R.drawable.calimg01, 900, 450, this);
        infoart01 = new Imagen3(R.drawable.calinfo01, 650, 950,this);
        img01.hacerVisible(false);
        infoart01.hacerVisible(false);

        img02 = new Imagen3(R.drawable.calimg02, 900, 450, this);
        infoart02 = new Imagen3(R.drawable.calinfo02, 650, 950,this);
        img02.hacerVisible(false);
        infoart02.hacerVisible(false);

        img03 = new Imagen3(R.drawable.calimg03, 900, 450, this);
        infoart03 = new Imagen3(R.drawable.calinfo03, 650, 950,this);
        img03.hacerVisible(false);
        infoart03.hacerVisible(false);

        img04 = new Imagen3(R.drawable.ambimg04, 900, 450, this);
        infoart04 = new Imagen3(R.drawable.ambinfo04, 650, 950,this);
        img04.hacerVisible(false);
        infoart04.hacerVisible(false);

        btnregresar = new Imagen3(R.drawable.botonregresar, 1000,2100,this);

        punActivity3 = (Main3Activity) context;

        puntero = null;
    }


    protected void onDraw(Canvas c){
        super.onDraw(c);

        Paint p = new Paint();

        c.drawColor(Color.WHITE);
        fondogris.pintar(c,p);
        titulo.pintar(c,p);

        articulo01.pintar(c,p);
        articulo02.pintar(c,p);
        articulo03.pintar(c,p);
        articulo04.pintar(c,p);

        img01.pintar(c,p);
        infoart01.pintar(c,p);

        img02.pintar(c,p);
        infoart02.pintar(c,p);

        img03.pintar(c,p);
        infoart03.pintar(c,p);

        img04.pintar(c,p);
        infoart04.pintar(c,p);

        btnregresar.pintar(c,p);

    }


    public boolean onTouchEvent(MotionEvent e){

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:

                if (articulo01.estaEnArea(xp,yp)){
                    puntero = articulo01;

                    img01.hacerVisible(true);
                    infoart01.hacerVisible(true);

                    img02.hacerVisible(false);
                    infoart02.hacerVisible(false);
                    img03.hacerVisible(false);
                    infoart03.hacerVisible(false);
                    img04.hacerVisible(false);
                    infoart04.hacerVisible(false);

                }

                if (articulo02.estaEnArea(xp,yp)){
                    puntero = articulo02;
                    img02.hacerVisible(true);
                    infoart02.hacerVisible(true);

                    img01.hacerVisible(false);
                    infoart01.hacerVisible(false);
                    img03.hacerVisible(false);
                    infoart03.hacerVisible(false);
                    img04.hacerVisible(false);
                    infoart04.hacerVisible(false);
                }

                if (articulo03.estaEnArea(xp,yp)){
                    puntero = articulo03;

                    img03.hacerVisible(true);
                    infoart03.hacerVisible(true);

                    img01.hacerVisible(false);
                    infoart01.hacerVisible(false);
                    img02.hacerVisible(false);
                    infoart02.hacerVisible(false);
                    img04.hacerVisible(false);
                    infoart04.hacerVisible(false);
                }

                if (articulo04.estaEnArea(xp,yp)){
                    puntero = articulo04;
                    img04.hacerVisible(true);
                    infoart04.hacerVisible(true);

                    img01.hacerVisible(false);
                    infoart01.hacerVisible(false);
                    img02.hacerVisible(false);
                    infoart02.hacerVisible(false);
                    img03.hacerVisible(false);
                    infoart03.hacerVisible(false);
                }

                if (btnregresar.estaEnArea(xp,yp)){
                    puntero = btnregresar;
                    cambiarAHome();
                }

                break;

            case MotionEvent.ACTION_MOVE:

                if(puntero!=null){
                    if(articulo01.estaEnArea(xp,yp)){
                        articulo01.mover(yp);
                        articulo02.mover(yp+770);
                        articulo03.mover(yp+1540);
                        articulo04.mover(yp+2310);
                    }

                    if(articulo02.estaEnArea(xp,yp)){
                        articulo01.mover(yp-770);
                        articulo02.mover(yp);
                        articulo03.mover(yp+770);
                        articulo04.mover(yp+1540);
                    }

                    if(articulo03.estaEnArea(xp,yp)){
                        articulo01.mover(yp-1540);
                        articulo02.mover(yp-770);
                        articulo03.mover(yp);
                        articulo04.mover(yp+770);
                    }
                    if(articulo04.estaEnArea(xp,yp)){
                        articulo01.mover(yp-2310);
                        articulo02.mover(yp-1540);
                        articulo03.mover(yp-770);
                        articulo04.mover(yp);
                    }

                }

                break;

            case MotionEvent.ACTION_UP:

                puntero = null;
                break;
        }
        invalidate();
        return true;
    }

    private void cambiarAHome() {

        Intent home = new Intent(punActivity3,MainActivity.class);
        punActivity3.startActivity(home);

    }


}
