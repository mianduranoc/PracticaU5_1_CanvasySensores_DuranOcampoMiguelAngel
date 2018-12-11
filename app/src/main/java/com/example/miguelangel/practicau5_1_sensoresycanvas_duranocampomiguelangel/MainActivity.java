package com.example.miguelangel.practicau5_1_sensoresycanvas_duranocampomiguelangel;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView hola,hello;
    SensorManager sensorManager;
    Sensor proximidad, giroscopio;
    SensorEventListener prOyente,girOyente;
    Lienzo lienzo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lienzo=new Lienzo(this);
        setContentView(lienzo);
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        proximidad=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        giroscopio=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        hola=findViewById(R.id.hola);
        hello=findViewById(R.id.hello);
        if (proximidad==null){
            Toast.makeText(this, "Sensor de proximidad no presente", Toast.LENGTH_SHORT).show();
        }
        else if (giroscopio==null){
            Toast.makeText(this, "Sensor de giroscopio no presente", Toast.LENGTH_SHORT).show();
        }
        else{
            prOyente=new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    if (event.values[0]<proximidad.getMaximumRange()){
                        lienzo.setEncendidas(false);
                        lienzo.invalidate();
                    }
                    else{
                        lienzo.setEncendidas(true);
                        lienzo.invalidate();
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {

                }
            };
            girOyente=new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    int []colores={Color.BLUE,Color.CYAN,Color.YELLOW,Color.GRAY,Color.MAGENTA,Color.RED,Color.rgb(166,94,46),Color.rgb(130,137,143),Color.rgb(28,84,45),Color.rgb(37,109,123)};
                    int pos=(int)(Math.random()*(colores.length-1));
                    if (event.values[2]<-0.5f){
                        lienzo.setColorLuces(colores[pos]);
                        lienzo.invalidate();
                    }

                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {

                }
            };
        }

    }
    protected void onResume(){
        super.onResume();
        if (proximidad!=null){
            sensorManager.registerListener(prOyente,proximidad,SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (giroscopio!=null){
            sensorManager.registerListener(girOyente,giroscopio,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    protected void onPause(){
        super.onPause();
        if (proximidad!=null){
            sensorManager.unregisterListener(prOyente);
        }
        if (giroscopio!=null){
            sensorManager.unregisterListener(girOyente);
        }
    }
}
