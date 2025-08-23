package ar.edu.unahur.obj2.wtoj.planes;

import ar.edu.unahur.obj2.wtoj.Usuario;

public class PlanPremiun implements Planeable {

    private Double costoPlan;

    public PlanPremiun(Double costoPlan) {
        this.costoPlan = costoPlan;
    }

    @Override
    public Double costoPlan(Usuario usuario) {
        return costoPlan;
    }

}
