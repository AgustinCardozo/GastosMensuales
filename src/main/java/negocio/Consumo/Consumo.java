package negocio.Consumo;

import lombok.Getter;
import negocio.FormaDePago.FormaDePago;
import negocio.Persona.Persona;

@Getter
public class Consumo {
    private String descripcion;
    private Persona persona;
    private double precio;
    private FormaDePago formaDePago;

    public Consumo(String descripcion, Persona persona, double precio, FormaDePago formaDePago){
        this.descripcion = descripcion;
        this.persona = persona;
        this.formaDePago = formaDePago;
        this.precio = precio;
        formaDePago.agregarConsumo(this);
    }

    public boolean validarPersona(Persona persona){
        return this.persona == persona;
    }
    @Override
    public String toString(){
        return descripcion + "(" + persona + ")\t Importe: " + precio + "\t" + formaDePago.toString();
    }
}
