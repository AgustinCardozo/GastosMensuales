package negocio.Gasto;

import lombok.Getter;
import negocio.Consumo.Consumo;
import negocio.Excepcion.TarjetaExcepcion;
import negocio.FormaDePago.FormaDePago;
import negocio.Persona.Persona;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Gasto {
    private String mes;
    private List<Consumo> consumos;
    private List<FormaDePago> formaDePagos;

    public Gasto(String mes){
        this.mes = mes;
        this.consumos = new ArrayList<Consumo>();
        this.formaDePagos = new ArrayList<FormaDePago>();
    }

    public void agregarConsumo(Consumo consumo){ this.consumos.add(consumo); }
    public void quitarConsumo(Consumo consumo){
        this.consumos.remove(consumo);
    }
    public void mostrarConsumos(){
        System.out.println("\t\t\t\t"+mes+"\n");
        this.consumos.stream().forEach(consumo -> System.out.println(consumo.toString()));
    }
    public void agregarFormaDePago(FormaDePago formaDePago){ this.formaDePagos.add(formaDePago); }
    public double gastoTotal(Persona persona, FormaDePago formaDePago){
        if(!this.formaDePagos.contains(formaDePago)){
            throw new TarjetaExcepcion("No se encuentro la forma de pago");
        }else{
            FormaDePago formaDePagoAxiliar = this.formaDePagos.stream().filter(medioDePago -> medioDePago == formaDePago).findAny().get();
            return formaDePagoAxiliar.consumoTotalSegun(persona);
        }
    }
}
