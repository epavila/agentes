package mensajes;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

import java.io.IOException;
import java.io.Serializable;

public class Mensaje {

    public static void enviarMsj(String receptor, Agent emisor, String contenido, String lenguaje, String id_conversation, int tipo) {

        ACLMessage aclMessage = new ACLMessage(tipo);
        AID aid = new AID(); //receptor
        aid.setLocalName(receptor);

        aclMessage.addReceiver(aid);
        aclMessage.setSender(emisor.getAID());
        aclMessage.setLanguage(lenguaje);
        aclMessage.setContent(contenido);
        aclMessage.setConversationId(id_conversation);
        emisor.send(aclMessage);
    }

    public static void enviarMsj(String receptor, Agent emisor, Serializable contenido, String lenguaje, String id_conversation, int tipo) {
        try {
            ACLMessage aclMessage = new ACLMessage(tipo);
            AID aid = new AID(); //receptor
            aid.setLocalName(receptor);

            aclMessage.addReceiver(aid);
            aclMessage.setSender(emisor.getAID());
            aclMessage.setLanguage(lenguaje);

            aclMessage.setContentObject(contenido);

            aclMessage.setConversationId(id_conversation);
            emisor.send(aclMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
