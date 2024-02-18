package lib;

import jakarta.ejb.Remote;

@Remote
public interface Calculadora {
    int somar(int a, int b);
}
