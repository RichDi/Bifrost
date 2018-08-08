package com.example.ricardodelgado.bifrost;

public class ProyectObj {

    private String titulo;
    private String descipcion;

    ProyectObj(String titulo, String descipcion) {
        this.titulo = titulo;
        this.descipcion = descipcion;
    }

    public ProyectObj() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }
}
