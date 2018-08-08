package com.example.ricardodelgado.bifrost;

public class EnterpriseObj {

    private String nombreDeEmpresa;
    private int numeroDeEmpleados;
    private int numeroDeProyectos;

    EnterpriseObj(String nombreDeEmpresa, int numeroDeEmpleados, int numeroDeProyectos) {
        this.nombreDeEmpresa = nombreDeEmpresa;
        this.numeroDeEmpleados = numeroDeEmpleados;
        this.numeroDeProyectos = numeroDeProyectos;
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

    public int getNumeroDeProyectos() {
        return numeroDeProyectos;
    }

    public void setNumeroDeProyectos(int numeroDeProyectos) {
        this.numeroDeProyectos = numeroDeProyectos;
    }
}
