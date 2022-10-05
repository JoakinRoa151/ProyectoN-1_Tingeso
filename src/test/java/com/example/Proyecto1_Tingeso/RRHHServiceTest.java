package com.example.Proyecto1_Tingeso;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.Proyecto1_Tingeso.services.RRHHService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:test.properties")
public class RRHHServiceTest {

    RRHHService rrhhService= new RRHHService();
    @Test
    public void obtenerSueldoFijo() {
        String categoria="A";
        double sueldoFijo=rrhhService.obtenerSueldoFijo(categoria);
        assertEquals(1700000,sueldoFijo,0.0);

        categoria="B";
        sueldoFijo=rrhhService.obtenerSueldoFijo(categoria);
        assertEquals(1200000,sueldoFijo,0.0);

        categoria="C";
        sueldoFijo=rrhhService.obtenerSueldoFijo(categoria);
        assertEquals(800000,sueldoFijo,0.0);

    }
    @Test
    public void bonificacionHorasExtras(){
        String categoria="A";
        double cantidadHorasExtra=4;
        double bonificacionHorasExtra= rrhhService.bonificacionHorasExtras(categoria,cantidadHorasExtra);
        assertEquals(100000,bonificacionHorasExtra,0.0);

        categoria="B";
        bonificacionHorasExtra= rrhhService.bonificacionHorasExtras(categoria,cantidadHorasExtra);
        assertEquals(80000,bonificacionHorasExtra,0.0);

        categoria="C";
        bonificacionHorasExtra= rrhhService.bonificacionHorasExtras(categoria,cantidadHorasExtra);
        assertEquals(40000,bonificacionHorasExtra,0.0);

    }
    @Test
    public void descuentoCotizacionPrevisional(){
        double sueldoParcial=1700000;
        double descuentoCotizacionPrevisional= rrhhService.descuentoCotizacionPrevisional(sueldoParcial);
        assertEquals(170000,descuentoCotizacionPrevisional,0.0);
    }
    @Test
    public void descuentoCotizacionSalud(){
        double sueldoParcial=1700000;
        double descuentoCotizacionSalud= rrhhService.descuentoCotizacionSalud(sueldoParcial);
        assertEquals(136000,descuentoCotizacionSalud,0.0);
    }
    @Test
    public void bonificacionTiempoServicio(){
        int aniosServicio=25;
        double bonificacionTiempoServicio= rrhhService.bonificacionTiempoServicio(aniosServicio);
        assertEquals(0.17,bonificacionTiempoServicio,0.0);

        aniosServicio=20;
        bonificacionTiempoServicio= rrhhService.bonificacionTiempoServicio(aniosServicio);
        assertEquals(0.14,bonificacionTiempoServicio,0.0);

        aniosServicio=15;
        bonificacionTiempoServicio= rrhhService.bonificacionTiempoServicio(aniosServicio);
        assertEquals(0.11,bonificacionTiempoServicio,0.0);

        aniosServicio=10;
        bonificacionTiempoServicio= rrhhService.bonificacionTiempoServicio(aniosServicio);
        assertEquals(0.08,bonificacionTiempoServicio,0.0);

        aniosServicio=5;
        bonificacionTiempoServicio= rrhhService.bonificacionTiempoServicio(aniosServicio);
        assertEquals(0.05,bonificacionTiempoServicio,0.0);

    }



}
