package jsf;


import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lib.ICalculadora;

@Named(value = "jsfCalculadora")
@RequestScoped
public class JsfCalculadora {

    @EJB
    private ICalculadora ejbCalculadora;

    private int valorA;
    private int valorB;
    private int resultado;

    public void somar() {
        resultado = ejbCalculadora.somar(valorA, valorB);
    }

    public ICalculadora getEjbCalculadora() {
        return ejbCalculadora;
    }

    public void setEjbCalculadora(ICalculadora ejbCalculadora) {
        this.ejbCalculadora = ejbCalculadora;
    }

    public int getValorA() {
        return valorA;
    }

    public void setValorA(int valorA) {
        this.valorA = valorA;
    }

    public int getValorB() {
        return valorB;
    }

    public void setValorB(int valorB) {
        this.valorB = valorB;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
