package com.example.ricardodelgado.bifrost;

public class Empresa {

    private String empresa;
    private int empleados;

    public Empresa(String empresa, int empleados) {
        this.empresa = empresa;
        this.empleados = empleados;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getEmpleados() {
        return empleados;
    }

    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }
}
