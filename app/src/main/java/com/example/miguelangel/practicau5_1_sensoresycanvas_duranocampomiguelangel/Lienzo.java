package com.example.miguelangel.practicau5_1_sensoresycanvas_duranocampomiguelangel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;

public class Lienzo extends View {
    int color;
    int width,heigth;
    boolean encendidas;
    public Lienzo(Context context) {
        super(context);
        color=Color.RED;
        encendidas=true;
    }

    public void onDraw(Canvas c){
        Paint p=new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(35);
        c.drawText("Uso de sensor de proximidad y giroscopio",150,50,p);
        c.drawText("Coloque su dedo sobre la parte superior de la pantalla",80,80,p);
        c.drawText("Para apagar las luces del arbol",270,120,p);
        c.drawText("Ó Agite hacia la derecha para cambiar el color",150,150,p);
        p.setColor(Color.rgb(118,60, 40));
        p.setStyle(Paint.Style.FILL);
        width=c.getWidth();
        heigth=c.getHeight();
        c.drawRect((width/2)-100,heigth-200,(width/2)+100,heigth-10,p);
        Path path=new Path();
        path.moveTo((width/2)-400,heigth-200);
        path.lineTo((width/2)+400,heigth-200);
        path.lineTo((width/2)+350,heigth-300);
        path.lineTo((width/2)-350,heigth-300);
        p.setColor(Color.GREEN);
        c.drawPath(path,p);
        for (int x=380,y=300;x>=80;x=x-50,y=y+100){
            path=new Path();
            path.moveTo((width/2)-x,heigth-y);
            path.lineTo((width/2)+x,heigth-y);
            path.lineTo((width/2)+(x-80),heigth-(y+100));
            path.lineTo((width/2)-(x-80),heigth-(y+100));
            c.drawPath(path,p);
        }
        int midX=width/2;
        int midY=heigth/2-250;
        dibujarLuces(c);
        path=new Path();
        path.moveTo(midX, midY);
        path.lineTo(midX+133, midY+210);
        path.lineTo(midX, midY+147);
        path.lineTo(midX-133, midY+210);
        path.lineTo(midX-112, midY+63);
        path.lineTo(midX-210, midY-49);
        path.lineTo(midX-70 ,midY-77);
        path.lineTo(midX, midY-210);
        path.lineTo(midX+70, midY-77);
        path.lineTo(midX+210, midY-49);
        path.lineTo(midX+112, midY+63);
        path.lineTo(midX+133, midY+210);
        p.setColor(Color.YELLOW);
        c.drawPath(path,p);
    }
    public void dibujarLuces(Canvas c) {
        Paint p = new Paint();
        int x1=410;
        for (int y = 230; y <= 970; y += 100) {
            int y1= heigth - y;
            int y2 = heigth - (y+40);
            x1-=50;
            for (int x = (width / 2) - x1, i = 1; x <= (width / 2) + x1; x += 50, i++) {
                int y3;
                if (i % 2 == 0) y3 = y2;
                else y3 = y1;
                p.setStyle(Paint.Style.FILL);
                if (encendidas) {
                    p.setColor(color);
                } else {
                    p.setColor(Color.WHITE);
                }
                c.drawCircle(x, y3, 20, p);
                p.setColor(Color.BLACK);
                p.setStrokeWidth(4);
                p.setStyle(Paint.Style.STROKE);
                c.drawCircle(x, y3, 20, p);
            }
        }
    }
    public void setColorLuces(int color){
        this.color=color;
    }
    public void setEncendidas(boolean encendidas){
        this.encendidas=encendidas;
    }
}
/*path=new Path();
        path.moveTo((width/2)-380,heigth-300);
        path.lineTo((width/2)+380,heigth-300);
        path.lineTo((width/2)+300,heigth-400);
        path.lineTo((width/2)-300,heigth-400);
        c.drawPath(path,p);
        path=new Path();
        path.moveTo((width/2)-330,heigth-400);
        path.lineTo((width/2)+330,heigth-400);
        path.lineTo((width/2)+250,heigth-500);
        path.lineTo((width/2)-250,heigth-500);
        c.drawPath(path,p);
        path=new Path();
        path.moveTo((width/2)-280,heigth-500);
        path.lineTo((width/2)+280,heigth-500);
        path.lineTo((width/2)+200,heigth-600);
        path.lineTo((width/2)-200,heigth-600);
        c.drawPath(path,p);
        path=new Path();
        path.moveTo((width/2)-230,heigth-600);
        path.lineTo((width/2)+230,heigth-600);
        path.lineTo((width/2)+150,heigth-700);
        path.lineTo((width/2)-150,heigth-700);
        c.drawPath(path,p);
        path=new Path();
        path.moveTo((width/2)-180,heigth-700);
        path.lineTo((width/2)+180,heigth-700);
        path.lineTo((width/2)+100,heigth-800);
        path.lineTo((width/2)-100,heigth-800);
        c.drawPath(path,p);
        path=new Path();
        path.moveTo((width/2)-130,heigth-800);
        path.lineTo((width/2)+130,heigth-800);
        path.lineTo((width/2)+50,heigth-900);
        path.lineTo((width/2)-50,heigth-900);
        c.drawPath(path,p);
        path=new Path();
        path.moveTo((width/2)-80,heigth-900);
        path.lineTo((width/2)+80,heigth-900);
        path.lineTo((width/2),heigth-1000);
        path.lineTo((width/2),heigth-1000);
        c.drawPath(path,p);*/