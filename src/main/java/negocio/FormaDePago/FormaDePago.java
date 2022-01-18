package negocio.FormaDePago;

import negocio.Consumo.Consumo;
import negocio.Persona.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FormaDePago {
    protected List<Consumo> consumos;

    public FormaDePago(){
        consumos = new ArrayList<Consumo>();
    }

    public void agregarConsumo(Consumo consumo){ this.consumos.add(consumo); }
    public double consumoTotal(Persona persona, FormaDePago formaDePago){
        List<Consumo> consumos = this.consumos.stream().filter(consumo -> consumo.validarPersona(persona) && consumo.getFormaDePago() == formaDePago).collect(Collectors.toCollection(ArrayList::new));
        double resultado = consumos.stream().mapToDouble(consumo -> consumo.getPrecio()).sum();
        return resultado;
    }
    public abstract double consumoTotalSegun(Persona persona);
}
