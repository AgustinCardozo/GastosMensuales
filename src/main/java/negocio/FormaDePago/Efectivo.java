package negocio.FormaDePago;

import negocio.Persona.Persona;

public class Efectivo extends FormaDePago{
    private static Efectivo efectivoInstance = null;

    private Efectivo(){ super(); }

    public static Efectivo getEfectivoInstance(){
        if(efectivoInstance == null)
            efectivoInstance = new Efectivo();
        return efectivoInstance;
    }
    @Override
    public double consumoTotalSegun(Persona persona) {
        if(persona == Persona.AMBOS)
            return this.consumoTotal(persona, this);
        else
            return this.consumoTotal(Persona.AMBOS, this) / 2;
    }
}
