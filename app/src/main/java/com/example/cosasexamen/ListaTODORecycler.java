package com.example.cosasexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.cosasexamen.entidades.TODO;
import com.example.cosasexamen.utilidades.Utilidades;

import java.util.ArrayList;

public class ListaTODORecycler extends AppCompatActivity {

    ArrayList<TODO> listTODO;
    RecyclerView recyclerViewTODO;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_todorecycler);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "todo", null, 1);
        listTODO = new ArrayList<>();
        recyclerViewTODO= findViewById(R.id.RecyclerId);
        recyclerViewTODO.setLayoutManager(new LinearLayoutManager(this));

        consultarListaTODOS();
    }

    private void consultarListaTODOS() {
        SQLiteDatabase db = conn.getReadableDatabase();
        TODO todo = null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_TODO, null);

        while(cursor.moveToNext()){
            todo = new TODO();
            todo.setNombre(cursor.getString(0));
            todo.setCreacion(cursor.getString(1));
            todo.setFinalizacion(cursor.getString(2));
            todo.setCompletado(cursor.getString(3));
            listTODO.add(todo);
        }

    }
}
