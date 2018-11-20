package mx.edu.ittepic.damd_u3_ejercicio06_tienda;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {

    Imagen logtipo, fondogris, iamiibos, icalcetines, icamicetas, idisfraces, igorras, ipeluches, puntero, damiibo,dcal,dcam,ddis,dgorr, dpel, boton;
    float xx = 30;

    MainActivity punActivity;

    String mensaje = "";

    public Lienzo (Context context){
        super(context);


        logtipo = new Imagen(R.drawable.logo, 100,150,this);
        fondogris = new Imagen(R.drawable.fondogris, 0,600,this);
        iamiibos = new Imagen(R.drawable.imgamiibos, xx, 640, this);
        icalcetines = new Imagen(R.drawable.imgcalcetines, xx+470, 640, this);
        icamicetas = new Imagen(R.drawable.imgcamisetas, xx+940, 640,this);
        idisfraces = new Imagen(R.drawable.imgdisfraces,xx+1410,640,this);
        igorras = new Imagen(R.drawable.imggorras,xx+1880,640,this);
        ipeluches = new Imagen(R.drawable.imgpeluches,xx+2350, 640,this);

        puntero=null;

        damiibo = new Imagen(R.drawable.desamiibos,0,1200, this);
        damiibo.hacerVisible(false);

        dcal =new Imagen(R.drawable.dcalcetines,0,1200,this);
        dcal.hacerVisible(false);

        dcam =new Imagen(R.drawable.dcamisas,0,1200,this);
        dcam.hacerVisible(false);

        ddis =new Imagen(R.drawable.ddisfraces,0,1200,this);
        ddis.hacerVisible(false);

        dgorr =new Imagen(R.drawable.dgorras,0,1200,this);
        dgorr.hacerVisible(false);

        dpel =new Imagen(R.drawable.dpeluches,0,1200,this);
        dpel.hacerVisible(false);

        boton = new Imagen(R.drawable.boton,800,2000,this);
        boton.hacerVisible(false);


        punActivity = (MainActivity) context;




    }

    @Override
    protected void onDraw(Canvas c){
        super.onDraw(c);
        Paint p = new Paint();

        c.drawColor(Color.WHITE);
        logtipo.pintar(c,p);

        fondogris.pintar(c,p);
        iamiibos.pintar(c,p);
        icalcetines.pintar(c,p);
        icamicetas.pintar(c,p);
        idisfraces.pintar(c,p);
        igorras.pintar(c,p);
        //ipeluches.pintar(c,p);

//        p.setTextSize(50);
//        p.setColor(Color.RED);
//        c.drawText(mensaje, 50, 100, p);

        damiibo.pintar(c,p);
        dcal.pintar(c,p);
        dcam.pintar(c,p);
        ddis.pintar(c,p);
        dgorr.pintar(c,p);
        dpel.pintar(c,p);

        boton.pintar(c,p);



    }

    public boolean onTouchEvent (MotionEvent e){

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if (iamiibos.estaEnArea(xp, yp)){
                    puntero = iamiibos; //puntero apunta a icono1
                    damiibo.hacerVisible(true);
                    boton.hacerVisible(true);

                    dcal.hacerVisible(false);
                    dcam.hacerVisible(false);
                    ddis.hacerVisible(false);
                    dgorr.hacerVisible(false);
                    dpel.hacerVisible(false);
                }

                if (icalcetines.estaEnArea(xp, yp)){
                    puntero = icalcetines; //puntero apunta a icono1
                    dcal.hacerVisible(true);
                    boton.hacerVisible(true);

                    damiibo.hacerVisible(false);
                    dcam.hacerVisible(false);
                    ddis.hacerVisible(false);
                    dgorr.hacerVisible(false);
                    dpel.hacerVisible(false);
                }

                if (icamicetas.estaEnArea(xp, yp)){
                    puntero = icamicetas; //puntero apunta a icono1
                    dcam.hacerVisible(true);
                    boton.hacerVisible(true);

                    damiibo.hacerVisible(false);
                    dcal.hacerVisible(false);
                    ddis.hacerVisible(false);
                    dgorr.hacerVisible(false);
                    dpel.hacerVisible(false);
                }

                if (idisfraces.estaEnArea(xp, yp)){
                    puntero = idisfraces; //puntero apunta a icono1
                    ddis.hacerVisible(true);
                    boton.hacerVisible(true);

                    damiibo.hacerVisible(false);
                    dcal.hacerVisible(false);
                    dcam.hacerVisible(false);
                    dgorr.hacerVisible(false);
                    dpel.hacerVisible(false);
                }

                if (igorras.estaEnArea(xp, yp)){
                    puntero = igorras; //puntero apunta a icono1
                    dgorr.hacerVisible(true);
                    boton.hacerVisible(true);

                    damiibo.hacerVisible(false);
                    dcal.hacerVisible(false);
                    dcam.hacerVisible(false);
                    ddis.hacerVisible(false);
                    dpel.hacerVisible(false);
                }

//                if (ipeluches.estaEnArea(xp, yp)){
//                    puntero = ipeluches; //puntero apunta a icono1
//                    dpel.hacerVisible(true);
//                    boton.hacerVisible(true);
//
//                    damiibo.hacerVisible(false);
//                    dcal.hacerVisible(false);
//                    dcam.hacerVisible(false);
//                    ddis.hacerVisible(false);
//                    dgorr.hacerVisible(false);
//                }

                if (boton.estaEnArea(xp,yp)){
                    mensaje="Boton";
                    if(puntero==iamiibos){
                        pantallAambiibos();
                    }
                    if (puntero==icalcetines){
                        pantallaCalcetines();
                    }
                    if (puntero==icamicetas){
                        pnatallaCamisetas();
                    }
                    if (puntero==idisfraces){
                        pantallaDisfraces();
                    }
                    if (puntero==igorras){
                        pantallaGorras();
                    }

                }

                break;

            case MotionEvent.ACTION_MOVE:

                if(puntero!=null){

                    if (iamiibos.estaEnArea(xp,yp)){

                        iamiibos.mover(xp);
                        icalcetines.mover(xp+470);
                        icamicetas.mover(xp+940);
                        idisfraces.mover(xp+1410);
                        igorras.mover(xp+1880);
                        //ipeluches.mover(xp+2350);
                    }

                    if (icalcetines.estaEnArea(xp,yp)){

                        iamiibos.mover(xp-470);
                        icalcetines.mover(xp);
                        icamicetas.mover(xp+470);
                        idisfraces.mover(xp+940);
                        igorras.mover(xp+1410);
                       // ipeluches.mover(xp+1880);
                    }

                    if (icamicetas.estaEnArea(xp,yp)){

                        iamiibos.mover(xp-940);
                        icalcetines.mover(xp-470);
                        icamicetas.mover(xp);
                        idisfraces.mover(xp+470);
                        igorras.mover(xp+940);
                       // ipeluches.mover(xp+1410);
                    }

                    if (idisfraces.estaEnArea(xp,yp)){

                        iamiibos.mover(xp-1410);
                        icalcetines.mover(xp-940);
                        icamicetas.mover(xp -470);
                        idisfraces.mover(xp);
                        igorras.mover(xp+470);
                       // ipeluches.mover(xp+940);
                    }

                    if (igorras.estaEnArea(xp,yp)){

                        iamiibos.mover(xp-1880);
                        icalcetines.mover(xp-1410);
                        icamicetas.mover(xp -940);
                        idisfraces.mover(xp-470);
                        igorras.mover(xp);
                       // ipeluches.mover(xp+470);
                    }

                    if (ipeluches.estaEnArea(xp,yp)){

                        iamiibos.mover(xp-2350);
                        icalcetines.mover(xp-1880);
                        icamicetas.mover(xp -1410);
                        idisfraces.mover(xp-940);
                        igorras.mover(xp-470);
                       // ipeluches.mover(xp);
                    }
                }


                break;

            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;

    }

    private void pantallaGorras() {
        Intent pantalla = new Intent(punActivity,Main6Activity.class);
        punActivity.startActivity(pantalla);
    }

    private void pantallaDisfraces() {

        Intent pantalla = new Intent(punActivity,Main5Activity.class);
        punActivity.startActivity(pantalla);
    }

    private void pnatallaCamisetas() {
        Intent pantalla = new Intent(punActivity,Main4Activity.class);
        punActivity.startActivity(pantalla);
    }

    private void pantallaCalcetines() {

        Intent pantalla = new Intent(punActivity, Main3Activity.class);
        punActivity.startActivity(pantalla);

    }

    private void pantallAambiibos() {
        Intent pantalla = new Intent(punActivity, Main2Activity.class);
        punActivity.startActivity(pantalla);
    }


}
