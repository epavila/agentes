package agentes;


import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.Logger;
import modelo.Persona;

import java.util.logging.Level;

public class Agente2 extends Agent {

    @Override
    protected void setup() {
        //System.out.println("Nombre del Agente >> " + getName());
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("he muerto");
    }

    class Comportamiento extends CyclicBehaviour {

        //Es el cerebro del agente
        @Override
        public void action() {
            //blockingReceive(); //bloquea la ejecucion del hilo hasta nueva orden
            //doWait(2000);
            //doDelete(); //mato el proceso y luego ejecuta takeDown()

            System.out.println("Nombre del Agente >> " + getName());
            ACLMessage aclMessage = blockingReceive();
            System.out.println(aclMessage);

            try {
                Persona persona = (Persona) aclMessage.getContentObject();
            } catch (UnreadableException ex) {
                Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
            }


            mensajes.Mensaje.enviarMsj("Agente1", getAgent(), "Hola agente 1", "esp", "AG1aAG2001", ACLMessage.REQUEST);

        }
    }

}
