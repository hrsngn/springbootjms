package helloworld.receiver;

import helloworld.model.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver2 {
    @JmsListener(destination = "mailbox", containerFactory = "topicListenerFactory")
    public void receiveMessage(Email email) {
        System.out.println("Receiver 2 <" + email + ">");
    }
}
