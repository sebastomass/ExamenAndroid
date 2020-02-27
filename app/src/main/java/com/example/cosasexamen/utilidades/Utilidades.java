package com.example.cosasexamen.utilidades;

public class Utilidades {

    //Constantes campos tabla usuario
    public static final String TABLA_TODO = "todo";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CREACION = "creaciondate";
    public static final String CAMPO_FINALIZACION = "finalizationdate";
    public static final String CAMPO_COMPLETADO = "completed";
    public static final String CREAR_TABLA_TODO="CREATE TABLE "+TABLA_TODO+"("+CAMPO_NOMBRE+" TEXT, "+CAMPO_CREACION+" TEXT, "+CAMPO_FINALIZACION+" TEXT, "+CAMPO_COMPLETADO+" TEXT)";

}
