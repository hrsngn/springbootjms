package helloworld;

import javax.jms.ConnectionFactory;

import helloworld.model.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@ComponentScan("helloworld")
@EnableJms
public class Application {

    public static void main(String[] args) {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
//        JmsTemplate jmsTemplatetopic = context.getBean("jmsTemplateTopic");
//        JmsTemplate jmsTemplateTopic = context.getBean(jmsTemplateTopic);

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
//        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
//        jmsTemplatetopic.convertAndSend("mailbox", new Email("info@example.com", "hello, this is topic !"));
    }

}