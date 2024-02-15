package ejb;

import jakarta.ejb.Stateless;
import lib.ICalculadora;

@Stateless(name = "EjbCalculadora")
public class EjbCalculadora implements ICalculadora {
    @Override
    public int somar(int a, int b) {
        return a + b;
    }
}
