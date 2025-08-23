package ar.edu.unahur.obj2.wtoj;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;
import ar.edu.unahur.obj2.wtoj.planes.PlanPremiun;
import ar.edu.unahur.obj2.wtoj.planes.Planeable;

public class Usuario {
    private Planeable plan = new PlanPremiun(12.0);
    private List<Contenido> contenidos = new ArrayList<>();

    public void verContenido(Contenido contenido) {
        contenidos.add(contenido);
    }

    public Double costoMensual() {
        return plan.costoPlan(this);
    }

    public Planeable getPlan() {
        return plan;
    }

    public void setPlan(Planeable plan) {
        this.plan = plan;
    }

    public List<Contenido> getContendios() {
        return new ArrayList<>(contenidos);
    }

    public void limpiarContenidos() {
        contenidos.clear();
    }

}
