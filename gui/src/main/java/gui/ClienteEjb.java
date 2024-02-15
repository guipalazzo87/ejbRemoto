package gui;

import lib.ICalculadora;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class ClienteEjb {
    public int somar(int a, int b) {

        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            InitialContext ejbRemoteContext = new InitialContext(props);
            ICalculadora beanRemote = (ICalculadora) ejbRemoteContext.lookup("ejb:/web/EjbCalculadora!lib.ICalculadora");
            return beanRemote.somar(a, b);

        } catch (NamingException ex) {
            System.out.println("ERRO");
            ex.printStackTrace();
            return -1;
        }
    }
}
