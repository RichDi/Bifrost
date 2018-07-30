package com.example.ricardodelgado.bifrost;

public class EnterpriseObj {

    private String nombreDeEmpresa;
    private int numeroDeEmpleados;
    private String proyectoReciente;

    EnterpriseObj(String nombreDeEmpresa, int numeroDeEmpleados, String proyectoReciente) {
        this.nombreDeEmpresa = nombreDeEmpresa;
        this.numeroDeEmpleados = numeroDeEmpleados;
        this.proyectoReciente = proyectoReciente;
    }

    public String getNombreDeEmpresa() {
        return nombreDeEmpresa;
    }

    public void setNombreDeEmpresa(String nombreDeEmpresa) {
        this.nombreDeEmpresa = nombreDeEmpresa;
    }

    public int getNumeroDeEmpleados() {
        return numeroDeEmpleados;
    }

    public void setNumeroDeEmpleados(int numeroDeEmpleados) {
        this.numeroDeEmpleados = numeroDeEmpleados;
    }

    public String getProyectoReciente() {
        return proyectoReciente;
    }

    public void setProyectoReciente(String proyectoReciente) {
        this.proyectoReciente = proyectoReciente;
    }
}
