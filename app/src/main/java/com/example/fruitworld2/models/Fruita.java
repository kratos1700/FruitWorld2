package com.example.fruitworld2.models;


public class Fruita {
    // al ser static no fa falta instanciar  i aixi podem accedir als valors
    public static final int VALOR_MAX = 10;
    public static final int VALOR_INI=0;

    // atributs
    private String nombre;
    private String descripcion;
    private int  imagBack;
    private  int icono;
    private  int cantidad;

    // constructors

    public Fruita() {
    }

    public Fruita(String nombre, String descripcion, int imagBack, int icono, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagBack = imagBack;
        this.icono = icono;
        this.cantidad = cantidad;
    }

    // setter i getters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagBack() {
        return imagBack;
    }

    public void setImagBack(int imagBack) {
        this.imagBack = imagBack;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // metode per afegir cuantitats
    public void addCuantitat(int cantidad){
        if (this.cantidad < VALOR_MAX){
            this.cantidad+=cantidad;
        }
    }
    // metode resset
    public  void resetCuantitat(){
        this.cantidad = VALOR_INI;
    }
}
