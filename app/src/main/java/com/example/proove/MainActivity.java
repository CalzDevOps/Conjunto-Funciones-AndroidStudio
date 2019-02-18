package com.example.proove;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    SeekBar barra;
    Button boton;
    EditText text;
    TextView tiempo;
    boolean contador=false;
    CountDownTimer ct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(EditText)findViewById(R.id.cantidad);
        tiempo=(TextView)findViewById(R.id.tiempo);
        barra=(SeekBar)findViewById(R.id.seekBar);
        boton=(Button)findViewById(R.id.boton);
        barra.setMax(600);
        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                actualizar(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    void actualizar(int progreso){

        int sec=progreso % 60;
        int min=Math.round(progreso/60);
        if(sec<=9){
            tiempo.setText(min +":"+"0"+sec);

        }else{
            tiempo.setText(min +":"+sec);

        }
        /*for(int i=0;i<=progreso;i++){
            Toast.makeText(this, "estamos en "+i, Toast.LENGTH_SHORT).show();
        }*/
    }

    public void contar(View view){
        if(contador==false){
            contador=true;
            barra.setEnabled(false);
            boton.setText("STOP");
            //myBarr.setVisibility(View.INVISIBLE);
            ct=new CountDownTimer(barra.getProgress()*1000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    int time= (int)millisUntilFinished/1000;
                    actualizar(time);
                }

                @Override
                public void onFinish() {
                    reset();
                }
            }.start();
        }else{
            reset();
        }

    }
    void reset(){
        tiempo.setText("10:00");
        barra.setEnabled(true);
        barra.setMax(600);
        boton.setText("Dale chicha");
        ct.cancel();
        contador=false;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate= getMenuInflater();
        inflate.inflate(R.menu.menucito,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i=null;
        Bundle b=new Bundle();

        if(item.getItemId()==R.id.alMenu){

            i=new Intent(this,elMenu.class);
            String num=text.getText().toString();
            b.putString("string","amigossssss");
            i.putExtra("numero",54);

        }
        if(item.getItemId()==R.id.lista){

            i=new Intent(this,listita.class);
            String num=text.getText().toString();
            int n=Integer.parseInt(num);
            b.putInt("l",n);
            b.putString("string","amigossssss");

        }
        i.putExtra("paquete",b);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }
}

