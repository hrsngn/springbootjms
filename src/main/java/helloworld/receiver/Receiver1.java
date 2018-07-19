package helloworld.receiver;

import helloworld.model.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver1 {
    @JmsListener(destination = "mailbox")
    public void receiveMessage(Email email) {
        System.out.println("Receiver 1 <" + email + ">");
    }
}
