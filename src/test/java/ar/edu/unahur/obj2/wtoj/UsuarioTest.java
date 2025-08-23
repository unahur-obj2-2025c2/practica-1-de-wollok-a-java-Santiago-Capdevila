package ar.edu.unahur.obj2.wtoj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;
import ar.edu.unahur.obj2.wtoj.contenido.Documental;
import ar.edu.unahur.obj2.wtoj.contenido.Episodio;
import ar.edu.unahur.obj2.wtoj.contenido.Serie;
import ar.edu.unahur.obj2.wtoj.contenido.Temporada;
import ar.edu.unahur.obj2.wtoj.planes.PlanBasico;

public class UsuarioTest {
        @Test
        void dadoUnUsuario_conElPlanPremision_SeCalculaCorrectamenteElCostoMensual() {

                var usuario = new Usuario();
                assertEquals(12.0, usuario.costoMensual());

        }

        @Test
        void limite() {
                List<String> cad = Arrays.asList("a", "b", "c", "d");
                List<String> sub = cad.subList(2, cad.size());
                assertEquals(2, sub.size());
                assertTrue(cad.contains("c"));
                assertTrue(cad.contains("d"));
                assertFalse(sub.contains("a"));
                assertFalse(sub.contains("b"));
        }

        @Test
        void dadoUnUsuario_alCambiarAlPlanBasico_SeCaculaCorrectamenteElCostoMensualEnFuncionALosContenidosQueSuperanElLimite() {
                var u2 = new Usuario();

                Contenido docu = new Documental("docu1", 10.0);

                Temporada t1 = new Temporada(1,
                                Arrays.asList(
                                                new Episodio("t1E1", 1, 20.0),
                                                new Episodio("t1E2", 2, 30.00),
                                                new Episodio("t1E3", 3, 40.0)));

                Temporada t2 = new Temporada(2,
                                Arrays.asList(
                                                new Episodio("t2E1", 1, 30.0),
                                                new Episodio("t2E2", 2, 40.0),
                                                new Episodio("t2E3", 3, 50.0)));

                Contenido serie = new Serie("lost", 10.0,
                                Arrays.asList(t1, t2));

                u2.verContenido(docu);
                u2.verContenido(serie);
                u2.setPlan(new PlanBasico(1));
                assertEquals(50.0, u2.costoMensual());
        }

        @Test
        void dadoUnUsuario_alCambiarAlPlanBasico_SeCaculaCorrectamenteElCostoMensualEnFuncionALosContenidosSinSuperarElLimite() {
                var u2 = new Usuario();

                Contenido docu = new Documental("docu1", 10.0);

                Temporada t1 = new Temporada(1,
                                Arrays.asList(
                                                new Episodio("t1E1", 1, 20.0),
                                                new Episodio("t1E2", 2, 30.00),
                                                new Episodio("t1E3", 3, 40.0)));

                Temporada t2 = new Temporada(2,
                                Arrays.asList(
                                                new Episodio("t2E1", 1, 30.0),
                                                new Episodio("t2E2", 2, 40.0),
                                                new Episodio("t2E3", 3, 50.0)));

                Contenido serie = new Serie("lost", 10.0,
                                Arrays.asList(t1, t2));

                u2.verContenido(docu);
                u2.verContenido(serie);
                u2.setPlan(new PlanBasico(2));
                assertEquals(5.0, u2.costoMensual());
        }

}
