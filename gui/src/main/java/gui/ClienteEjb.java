package gui;

import lib.Calculadora;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;
import java.util.logging.Logger;

public class ClienteEjb {
    public int somar(int a, int b) {

        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            InitialContext ejbRemoteContext = new InitialContext(props);
            Calculadora beanRemote = (Calculadora) ejbRemoteContext.lookup("ejb:/web/EjbCalculadora!lib.Calculadora");
            return beanRemote.somar(a, b);

        } catch (NamingException ex) {
            Logger logger = Logger.getLogger(ClienteEjb.class.getName());
            logger.severe("Erro ao tentar fazer lookup do EJB");
            logger.severe(ex.getMessage());
            return -1;
        }
    }
}
