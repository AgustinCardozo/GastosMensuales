package negocio.FormaDePago;

import lombok.Getter;
import negocio.Excepcion.PersonaExcepcion;
import negocio.Persona.Persona;
import negocio.Persona.Titular;

@Getter
public class Tarjeta extends FormaDePago{
    private Titular titular;
    private Banco bancoEmisor;
    private TipoDeTarjeta tipoDeTarjeta;

    public Tarjeta(Titular titular, Banco bancoEmisor, TipoDeTarjeta tipoDeTarjeta){
        super();
        this.titular = titular;
        this.bancoEmisor = bancoEmisor;
        this.tipoDeTarjeta = tipoDeTarjeta;
    }

    //Calcula gastos individuales + gastos conjuntos
    @Override
    public double consumoTotalSegun(Persona persona){
        if(persona == Persona.AMBOS){
            return consumoTotal(Persona.AMBOS, this);
        }
        else {
            double gastosConjunto = (consumoTotal(Persona.AMBOS, this)) / 2;
            if(persona == Persona.JOHANNA)
                return  gastosConjunto + consumoTotal(Persona.JOHANNA, this);
            else if(persona == persona.AGUSTIN)
                return gastosConjunto + consumoTotal(Persona.AGUSTIN, this);
            else
                throw new PersonaExcepcion("Persona invalida");
        }
    }
    @Override
    public String toString() {
        return bancoEmisor + "(" + titular +") " + tipoDeTarjeta;
    }
}
