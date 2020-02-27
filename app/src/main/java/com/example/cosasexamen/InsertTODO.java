package com.example.cosasexamen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cosasexamen.utilidades.Utilidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InsertTODO extends AppCompatActivity {
    EditText campoNombre;
    TextView campoFechaCreacion;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_todo);
        TextView date = findViewById(R.id.creationDate);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date.setText(dtf.format(now));
        this.campoNombre = findViewById(R.id.nameInput);
        this.campoFechaCreacion = date;

    }

    public void addNewTODO(View view) {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "todo", null, 1);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_CREACION, campoFechaCreacion.getText().toString());
        values.put(Utilidades.CAMPO_FINALIZACION, "");
        values.put(Utilidades.CAMPO_COMPLETADO, "true");
        Long idResultante = db.insert(Utilidades.TABLA_TODO, null, values);
        Toast.makeText(getApplicationContext(), "Añadida nueva Tarea, con la id: " + idResultante, Toast.LENGTH_SHORT).show();

    }
}
