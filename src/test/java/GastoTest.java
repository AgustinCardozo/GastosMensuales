import negocio.Consumo.Consumo;
import negocio.FormaDePago.Efectivo;
import negocio.Gasto.Gasto;
import negocio.Persona.Titular;
import negocio.Persona.Persona;
import negocio.FormaDePago.Banco;
import negocio.FormaDePago.Tarjeta;
import negocio.FormaDePago.TipoDeTarjeta;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GastoTest {
    static Tarjeta tarjetaBBVA;
    static Tarjeta tarjetaGaliciaVisa;
    static Tarjeta tarjetaGaliciaMaster;
    static Efectivo efectivo;

    static Consumo consumo1;
    static Consumo consumo2;
    static Consumo consumo3;
    static Consumo consumo4;
    static Consumo consumo5;
    static Consumo consumo6;
    static Consumo consumo7;

    static Gasto gastoEnero;

    @BeforeClass
    public static void init(){
        tarjetaBBVA = new Tarjeta(Titular.JOHANNA, Banco.BBVA, TipoDeTarjeta.VISA);
        tarjetaGaliciaVisa = new Tarjeta(Titular.JOHANNA, Banco.GALICIA, TipoDeTarjeta.VISA);
        tarjetaGaliciaMaster = new Tarjeta(Titular.JOHANNA, Banco.GALICIA, TipoDeTarjeta.MASTER);
        efectivo = Efectivo.getEfectivoInstance();
        consumo1 = new Consumo("PSA 6/6", Persona.AMBOS, 3552, tarjetaBBVA);
        consumo2 = new Consumo("HBO", Persona.AMBOS, 300, tarjetaBBVA);
        consumo3 = new Consumo("Topper 6/6", Persona.JOHANNA, 735, tarjetaGaliciaVisa);
        consumo4 = new Consumo("Fiter", Persona.AMBOS, 2600, tarjetaGaliciaVisa);
        consumo5 = new Consumo("Fiter", Persona.AMBOS, 2600, tarjetaGaliciaMaster);
        consumo6 = new Consumo("Alquiler", Persona.AMBOS, 12000, efectivo);
        consumo7 = new Consumo("Expensa", Persona.AMBOS, 2200, efectivo);
        gastoEnero = new Gasto("Enero");

        gastoEnero.agregarConsumo(consumo1);
        gastoEnero.agregarConsumo(consumo2);
        gastoEnero.agregarConsumo(consumo3);
        gastoEnero.agregarConsumo(consumo4);
        gastoEnero.agregarConsumo(consumo5);
        gastoEnero.agregarConsumo(consumo6);
        gastoEnero.agregarConsumo(consumo7);

        gastoEnero.agregarFormaDePago(tarjetaBBVA);
        gastoEnero.agregarFormaDePago(tarjetaGaliciaVisa);
        gastoEnero.agregarFormaDePago(tarjetaGaliciaMaster);
        gastoEnero.agregarFormaDePago(efectivo);
    }

    @Test
    public void cantidadDeConsumoEs7(){
        Assert.assertEquals(7, gastoEnero.getConsumos().size(),0);
    }
    @Test
    public void gastoConjuntoEnTarjetaBBVAVisa(){
        Assert.assertEquals(3852.0, gastoEnero.gastoTotal(Persona.AMBOS, tarjetaBBVA), 0);
    }
    @Test
    public void gastoConjuntoEnTarjetaGaliciaVisa(){
        Assert.assertEquals(2600.0, gastoEnero.gastoTotal(Persona.AMBOS, tarjetaGaliciaVisa), 0);
    }
    @Test
    public void gastoJohaEnTarjetaGaliciaVisa(){
        Assert.assertEquals(2035.0, gastoEnero.gastoTotal(Persona.JOHANNA, tarjetaGaliciaVisa), 0);
    }
    @Test
    public void gastoAgusEnTarjetaGaliciaVisa(){
        Assert.assertEquals(1300.0, gastoEnero.gastoTotal(Persona.AGUSTIN, tarjetaGaliciaVisa), 0);
    }
    @Test
    public void gastoConjuntoEnEfectivo(){
        Assert.assertEquals(14200.0, gastoEnero.gastoTotal(Persona.AMBOS, efectivo), 0);
    }
    @Test
    public void gastoJohaoEnEfectivo(){
        Assert.assertEquals(7100.0, gastoEnero.gastoTotal(Persona.JOHANNA, efectivo), 0);
    }
}
