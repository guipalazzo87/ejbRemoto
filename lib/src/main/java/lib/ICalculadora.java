package lib;

import jakarta.ejb.Remote;

@Remote
public interface ICalculadora {
    int somar(int a, int b);
}
