package com.example.proove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listita extends AppCompatActivity {
    ArrayList<Integer> arl=new ArrayList<Integer>();
    ArrayAdapter<Integer> adapter;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        list=(ListView) findViewById(R.id.lista);
        numeros();

    }


    void numeros(){
        Bundle b= getIntent().getExtras().getBundle("paquete");
        int num=b.getInt("l");
        for (int i=0;i<num;i++){
            arl.add(1+i);
        }

        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arl);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(listita.this, "FUNCIONAAAAAAAAAAAA", Toast.LENGTH_SHORT).show();
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(listita.this, "estas clicando el numero"+(position+1), Toast.LENGTH_SHORT).show();
                int i=list.getSelectedItemPosition();
                arl.remove(position);
                list.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                return false;
            }
        });
    }

}
