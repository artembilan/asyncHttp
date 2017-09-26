package be.ordina.asyncHttp.client;

import be.ordina.asyncHttp.Issue;
import feign.Headers;
import feign.RequestLine;

public interface JiraClient {

    @RequestLine("POST /issue")
    @Headers("Content-Type: application/json")
    void createIssue(Issue issue);

}
