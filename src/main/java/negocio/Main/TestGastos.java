package negocio.Main;

import negocio.Consumo.Consumo;
import negocio.FormaDePago.Efectivo;
import negocio.Gasto.Gasto;
import negocio.Persona.Titular;
import negocio.Persona.Persona;
import negocio.FormaDePago.Banco;
import negocio.FormaDePago.Tarjeta;
import negocio.FormaDePago.TipoDeTarjeta;

public class TestGastos {
    public static void main(String[] args) {
        Efectivo efectivo = Efectivo.getEfectivoInstance();
        Tarjeta tarjetaBBVA = new Tarjeta(Titular.JOHANNA, Banco.BBVA, TipoDeTarjeta.VISA);
        Tarjeta tarjetaGaliciaVisa = new Tarjeta(Titular.JOHANNA, Banco.GALICIA, TipoDeTarjeta.VISA);
        Tarjeta tarjetaGaliciaMaster = new Tarjeta(Titular.JOHANNA, Banco.GALICIA, TipoDeTarjeta.MASTER);
        Consumo consumo1 = new Consumo("PSA 6/6", Persona.AMBOS, 3552, tarjetaBBVA);
        Consumo consumo2 = new Consumo("HBO", Persona.AMBOS, 300, tarjetaBBVA);
        Consumo consumo3 = new Consumo("Topper 6/6", Persona.JOHANNA, 735, tarjetaGaliciaVisa);
        Consumo consumo4 = new Consumo("Fiter", Persona.AMBOS, 2600, tarjetaGaliciaVisa);
        Consumo consumo5 = new Consumo("Fiter", Persona.AMBOS, 2600, tarjetaGaliciaMaster);
        Consumo consumo6 = new Consumo("Alquiler", Persona.AMBOS, 12000, efectivo);
        Consumo consumo7 = new Consumo("Expensa", Persona.AMBOS, 2200, efectivo);
        Gasto gastoEnero = new Gasto("Enero");

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
        gastoEnero.mostrarConsumos();
//        tarjetaBBVA.totalSegun(Banco.BBVA, TipoDeTarjeta.VISA);
//        System.out.println("\nTOTAL "+tarjetaBBVA.getBancoEmisor()+" "+ tarjetaBBVA.getTipoDeTarjeta() +":"+tarjetaBBVA.totalSegun(Banco.BBVA, TipoDeTarjeta.VISA));
//        System.out.println("TOTAL consumo BBVA: "+tarjetaBBVA.consumoTotal(Persona.AMBOS));
//        tarjetaGaliciaVisa.totalSegun(Banco.GALICIA, TipoDeTarjeta.VISA);
//        System.out.println("TOTAL "+tarjetaGaliciaVisa.getBancoEmisor()+" "+ tarjetaGaliciaVisa.getTipoDeTarjeta() +":"+tarjetaGaliciaVisa.totalSegun(Banco.GALICIA, TipoDeTarjeta.VISA));
//        tarjetaGaliciaMaster.totalSegun(Banco.GALICIA, TipoDeTarjeta.MASTER);
//        System.out.println("TOTAL "+tarjetaGaliciaMaster.getBancoEmisor()+" "+ tarjetaGaliciaMaster.getTipoDeTarjeta() +":"+tarjetaGaliciaMaster.totalSegun(Banco.GALICIA, TipoDeTarjeta.MASTER));

//        List<Consumo> consumos = gastoEnero.getConsumos().stream().filter(consumo -> consumo.validarPersona(Persona.AMBOS) && consumo.getTarjeta() == tarjetaBBVA).collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(consumos.stream().mapToDouble(consumo -> consumo.getPrecio()).sum());

//        System.out.println("Conjunto BBVA: "+gastoEnero.gastoTotalSegun(Persona.AMBOS, tarjetaBBVA));
//        System.out.println(tarjetaBBVA.consumoTotalSegun(Persona.AMBOS));
        System.out.println("\nConjunto BBVA: "+gastoEnero.gastoTotal(Persona.AMBOS, tarjetaBBVA));
//        System.out.println("Conjunto Gcia: "+gastoEnero.gastoTotalSegun(Persona.AMBOS, tarjetaGaliciaVisa));
//        System.out.println(tarjetaGaliciaVisa.consumoTotalSegun(Persona.AMBOS));
        System.out.println("Conjunto Gcia: "+gastoEnero.gastoTotal(Persona.AMBOS, tarjetaGaliciaVisa));
//        gastoEnero.gastoTotalSegun(Persona.JOHANNA, tarjetaGaliciaVisa);
//        System.out.println("Joha Gcia: "+gastoEnero.gastoTotalSegun(Persona.JOHANNA, tarjetaGaliciaVisa));
//        System.out.println(tarjetaGaliciaVisa.consumoTotal(Persona.JOHANNA));
//        tarjetaGaliciaVisa.consumoTotalSegun(Persona.JOHANNA);
//        System.out.println("Joha Gcia: "+tarjetaGaliciaVisa.consumoTotalSegun(Persona.JOHANNA));
//        System.out.println("Joha: "+gastoEnero.gastoTotalPersona(Persona.JOHANNA, tarjetaGaliciaVisa));
//        System.out.println(tarjetaGaliciaVisa.consumoTotalSegun(Persona.JOHANNA));
        System.out.println("Joha: "+gastoEnero.gastoTotal(Persona.JOHANNA, tarjetaGaliciaVisa));
        //System.out.println(gastoEnero.gastoTarjetaTotal(Persona.JOHANNA, tarjetaGaliciaVisa));
//        System.out.println("Agus: "+gastoEnero.gastoTotalPersona(Persona.AGUSTIN, tarjetaGaliciaVisa));
//        System.out.println(tarjetaGaliciaVisa.consumoTotalSegun(Persona.AGUSTIN));
//        System.out.println(tarjetaGaliciaVisa.consumoTotal(Persona.AGUSTIN));
        System.out.println("Agus: "+gastoEnero.gastoTotal(Persona.AGUSTIN, tarjetaGaliciaVisa));
        System.out.println("Ambos efectivo: "+gastoEnero.gastoTotal(Persona.AMBOS, efectivo));
        System.out.println("Joha efectivo: "+gastoEnero.gastoTotal(Persona.JOHANNA, efectivo));
        System.out.println("Agus efectivo: "+gastoEnero.gastoTotal(Persona.AGUSTIN, efectivo));

    }
}
