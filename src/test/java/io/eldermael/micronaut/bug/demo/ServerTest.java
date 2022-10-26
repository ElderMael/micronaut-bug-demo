package io.eldermael.micronaut.bug.demo;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.util.Map.entry;
import static java.util.Map.ofEntries;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest(
    rebuildContext = true
)
class ServerTest {

  @Inject
  EmbeddedApplication application;

  @Inject
  EmbeddedServer server;

  @Test
  void testItWorks() {
    assertTrue(server.isRunning());
    assertTrue(application.isRunning());
  }

  @Test
  void shouldStoreSingleKey() {
    givenRestRequest()
        .body(
            ofEntries(
                entry("a", "b")
            )
        )
        .when()
        .post("/bug")
        .then()
        .statusCode(200)
        .contentType("application/json")
        .body("a", is("b"))
        .log()
        .all();

    givenRestRequest()
        .when()
        .get("/bug")
        .then()
        .body("a", is("b"))
        .log()
        .all();
  }

  public RequestSpecification givenRestRequest() {
    return given()
        .contentType("application/json; charset=UTF-8")
        .port(this.server.getPort())
        .log().all();
  }
}