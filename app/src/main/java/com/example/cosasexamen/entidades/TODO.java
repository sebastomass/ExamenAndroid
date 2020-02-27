package com.example.cosasexamen.entidades;

public class TODO {

    public TODO(String nombre, String creacion, String finalizacion, String completado) {
        this.nombre = nombre;
        this.creacion = creacion;
        this.finalizacion = finalizacion;
        this.completado = completado;
    }


    private String nombre;
    private String creacion;
    private String finalizacion;

    public TODO() {

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCreacion() {
        return creacion;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }

    public String getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(String finalizacion) {
        this.finalizacion = finalizacion;
    }

    public String getCompletado() {
        return completado;
    }

    public void setCompletado(String completado) {
        this.completado = completado;
    }

    private String completado;






}
