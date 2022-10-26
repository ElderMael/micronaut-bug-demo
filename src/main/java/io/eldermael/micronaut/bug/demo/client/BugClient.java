package io.eldermael.micronaut.bug.demo.client;


import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

import java.util.Map;

@Client("http://localhost:8080")
public interface BugClient {

  @Post("/bug")
  Map<String, Object> postToBuggyEndpoint(@Body Map<String, Object> body);

}
