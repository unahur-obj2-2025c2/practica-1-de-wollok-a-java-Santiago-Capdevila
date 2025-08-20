package ar.edu.unahur.obj2.wtoj.planes;

import java.util.List;

public class PlanBasico implements Planeable{
    private Integer limite;

    public PlanBasico(Integer limite){
        this.limite = limite
    }

    @Override
    public Double costoPlan(Usuario usuario){
        Double costoBase = 5.0;
        List<Contenido> contenidos = usuario.getContenidos();
        if (limite >= contenidos.size()) {
            return costoBase;
        } else {
            List<Contenido> excedentes = contenidos.subList(limite -1, contenidos.size());
            return costoBase + excedentes.stream().mapToDouble(Contenido::costo).sum();
        }
    }
}
