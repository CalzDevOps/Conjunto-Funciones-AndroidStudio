package com.example.proove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    SeekBar barra;
EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(EditText)findViewById(R.id.cantidad);
        barra=(SeekBar)findViewById(R.id.seekBar);
        barra.setMax(10);
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
        for(int i=0;i<=progreso;i++){
            Toast.makeText(this, "estamos en "+i, Toast.LENGTH_SHORT).show();
        }
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

