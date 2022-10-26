package io.eldermael.micronaut.bug.demo.server;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.HashMap;
import java.util.Map;

@Controller("/bug")
public class BuggedController {

  private final Map<String, Object> store = new HashMap<>();

  @Get
  public HttpResponse<Map<String, Object>> get() {
    return HttpResponse.ok(this.store);
  }

  @Post
  public HttpResponse<Map<String, Object>> buggyPost(@Body Map<String, Object> body) {
    this.store.putAll(body);
    return HttpResponse.ok(this.store);
  }

}
