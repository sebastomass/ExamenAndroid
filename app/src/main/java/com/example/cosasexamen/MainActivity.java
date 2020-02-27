package com.example.cosasexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.cosasexamen.entidades.TODO;
import com.example.cosasexamen.utilidades.Utilidades;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<TODO> listTODO;
    RecyclerView recyclerViewTODO;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        conn = new ConexionSQLiteHelper(getApplicationContext(), "todo", null, 1);
        listTODO = new ArrayList<>();
        recyclerViewTODO= findViewById(R.id.RecyclerId);
        recyclerViewTODO.setLayoutManager(new LinearLayoutManager(this));

        consultarListaTODOS();

        AdapterDatos adapter = new AdapterDatos(listTODO);
        recyclerViewTODO.setAdapter(adapter);


        FloatingActionButton fab = findViewById(R.id.floatingActionButton3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InsertTODO.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void consultarListaTODOS() {
        SQLiteDatabase db = conn.getReadableDatabase();
        TODO todo = null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_TODO + " WHERE " + Utilidades.CAMPO_COMPLETADO + " = 'false'", null);

        while(cursor.moveToNext()){
            todo = new TODO();
            todo.setNombre(cursor.getString(0));
            todo.setCreacion(cursor.getString(1));
            todo.setFinalizacion(cursor.getString(2));
            todo.setCompletado(cursor.getString(3));
            listTODO.add(todo);
        }
    }

    public void gotoTODOCompleted(MenuItem item) {
        Intent goCompleted = new Intent(this, CompletedTasks.class);
        startActivity(goCompleted);
    }
}
