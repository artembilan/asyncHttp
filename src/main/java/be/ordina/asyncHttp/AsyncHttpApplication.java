package be.ordina.asyncHttp;

import be.ordina.asyncHttp.queue.IssueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AsyncHttpApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncHttpApplication.class, args);
    }

    @Autowired
    IssueProducer issueProducer;

    @Bean
    CommandLineRunner createIssue() {
        return args -> issueProducer.submitIssue(new Issue("Title", "Description"));
    }
}
