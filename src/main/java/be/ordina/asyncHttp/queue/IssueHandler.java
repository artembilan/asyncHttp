package be.ordina.asyncHttp.queue;

import be.ordina.asyncHttp.Issue;
import be.ordina.asyncHttp.client.JiraClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import static be.ordina.asyncHttp.queue.IssueQueue.JIRA_QUEUE;

@EnableBinding(IssueQueue.class)
@Component
public class IssueHandler {

    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    private JiraClient jiraClient;

    @StreamListener(JIRA_QUEUE)
    public void handleDrop(Issue issue) {
        if (issue != null) {
            log.info("Dequeued Issue: " + issue);
            jiraClient.createIssue(issue);
        }
    }
}
