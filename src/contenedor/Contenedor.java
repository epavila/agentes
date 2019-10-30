package contenedor;

import agentes.Agente1;
import agentes.Agente2;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Contenedor {

    private AgentContainer agentContainer;

    public void contenedor() {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        runtime.setCloseVM(true);

        //profile: contenedor, port, name
        //host = null, pon la ip que tiene la maquina
        Profile profile = new ProfileImpl(null, 1099, null);
        agentContainer = runtime.createMainContainer(profile);

        iniciarAgentes();
    }


    private void iniciarAgentes(){
        try {
            agentContainer.createNewAgent("Agente2", Agente2.class.getName(), null).start();
            agentContainer.createNewAgent("Agente1", Agente1.class.getName(), null).start();
        } catch (StaleProxyException e) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, e);
        }
    }


}
