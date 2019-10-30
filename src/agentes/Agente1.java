package agentes;


import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import modelo.Persona;

import java.io.Serializable;

public class Agente1 extends Agent {

    @Override
    protected void setup() {
        //System.out.println("Nombre del Agente >> " + getName());
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.printf("he muerto");
    }

    class Comportamiento extends CyclicBehaviour {

        //Es el cerebro del agente
        @Override
        public void action() {
            System.out.println("Nombre del Agente >> " + getName());
            //mensajes.Mensaje.enviarMsj("Agente2", getAgent(), "Hola agente 2", "esp", "AG1aAG2001", ACLMessage.INFORM);

            //cuando es comunicacion unidireccional
            /*
            mensajes.Mensaje.enviarMsj("Agente2", getAgent(), "Hola agente 2", "esp", "AG1aAG2001", ACLMessage.REQUEST);
            ACLMessage aclMessage = blockingReceive();
            System.out.println(aclMessage);
             */

            Persona persona = new Persona("Edison", "Avila", "1234", "Orquideas");
            mensajes.Mensaje.enviarMsj("Agente2", getAgent(), persona, "esp", "AG1aAG2001", ACLMessage.REQUEST);
            ACLMessage aclMessage = blockingReceive();
            System.out.println(aclMessage);

            //doWait(2000);
            //doDelete(); //mato el proceso y luego ejecuta takeDown()
        }
    }

}
