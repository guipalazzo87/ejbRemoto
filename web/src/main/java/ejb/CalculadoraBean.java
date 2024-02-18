package ejb;

import jakarta.ejb.Stateless;
import lib.Calculadora;

@Stateless(name = "CalculadoraBean")
public class CalculadoraBean implements Calculadora {
    @Override
    public int somar(int a, int b) {
        return a + b;
    }
}
