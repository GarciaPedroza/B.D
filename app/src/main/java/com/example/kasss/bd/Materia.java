package com.example.kasss.bd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


    public class Materia extends ActionBarActivity {

     private RecyclerView recycler;
        private RecyclerView.Adapter adapter;
        private RecyclerView.LayoutManager lManager;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_materia);

            List<ModeloMateria> items = new ArrayList<>();

            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "materia", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            Cursor fila = bd.rawQuery("select id_materia, nombre, creditos, semestre from materias", null);
            for(fila.moveToFirst(); !fila.isAfterLast(); fila.moveToNext()){

                items.add (new ModeloMateria(fila.getString(0), fila.getString(1), fila.getString(2), fila.getString(3)));
            }

            recycler = (RecyclerView) findViewById(R.id.materias);
            recycler.setHasFixedSize(true);


            lManager = new LinearLayoutManager(this);
            recycler.setLayoutManager(lManager);


            adapter = new MateriaAdapter(items);
            recycler.setAdapter(adapter);
            bd.close();
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_materia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
