package be.ordina.asyncHttp.queue;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface IssueQueue {

    String JIRA_QUEUE = "issueQueue";

    @Input(JIRA_QUEUE)
    SubscribableChannel listenIssue();

    @Output(JIRA_QUEUE)
    MessageChannel pushIssue();
}
