package jsf;


import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lib.Calculadora;

@Named(value = "jsfCalculadora")
@RequestScoped
public class JsfCalculadora {

    @EJB
    private Calculadora calculadoraBean;

    private int valorA;
    private int valorB;
    private int resultado;

    public void somar() {
        resultado = calculadoraBean.somar(valorA, valorB);
    }

    public Calculadora getCalculadoraBean() {
        return calculadoraBean;
    }

    public void setCalculadoraBean(Calculadora calculadoraBean) {
        this.calculadoraBean = calculadoraBean;
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
