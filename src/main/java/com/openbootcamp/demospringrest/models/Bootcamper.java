package com.openbootcamp.demospringrest.models;

public class Bootcamper {
    //Datos
    private String nombre;
    private double valor;

    //Constructor
    public Bootcamper(){};

    public Bootcamper(String nombre, double valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    //getter
    public String getNombre(){
        return nombre;
    }
    public double getValor(){
        return valor;
    }

    //setter
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
