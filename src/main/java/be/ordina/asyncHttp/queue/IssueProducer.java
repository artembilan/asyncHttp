package be.ordina.asyncHttp.queue;

import be.ordina.asyncHttp.Issue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MutableMessageBuilder;

@EnableBinding(IssueQueue.class)
public class IssueProducer {
    private final Log log = LogFactory.getLog(getClass());

    private IssueQueue notificationChannel;

    public IssueProducer(IssueQueue notificationChannel) {
        this.notificationChannel = notificationChannel;
    }

    public void submitIssue(Issue issue) {
        notificationChannel.pushIssue().send(MutableMessageBuilder.withPayload(issue).build());
        log.info("Enqueued Issue: " + issue);
    }

}