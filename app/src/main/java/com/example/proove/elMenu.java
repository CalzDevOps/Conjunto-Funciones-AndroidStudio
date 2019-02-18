package com.example.proove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class elMenu extends AppCompatActivity {
TextView t;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_menu);
        t=(TextView)findViewById(R.id.aqui);
        t2=(TextView)findViewById(R.id.aqui2);
        Bundle b=getIntent().getExtras().getBundle("paquete");

        String valor=Integer.toString(getIntent().getExtras().getInt("numero"));
        t.setText(""+valor);

        String paquete=b.getString("string");
        t2.setText(paquete);
    }
}
