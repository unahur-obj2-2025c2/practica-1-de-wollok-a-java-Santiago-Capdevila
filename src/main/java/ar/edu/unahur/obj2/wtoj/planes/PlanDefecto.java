package ar.edu.unahur.obj2.wtoj.planes;

import ar.edu.unahur.obj2.wtoj.usuario.Usuario;

public class PlanDefecto implements PlanSuscribible{

    @Override
    public Double costoPlan(Usuario usuario) {
        return 0.0;
    }
    
}
