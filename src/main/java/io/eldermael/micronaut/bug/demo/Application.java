package io.eldermael.micronaut.bug.demo;

import io.eldermael.micronaut.bug.demo.client.BugDemoCommand;
import io.eldermael.micronaut.bug.demo.server.Server;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.runtime.Micronaut;

import java.util.Arrays;

import static java.util.function.Predicate.isEqual;

public class Application {

  public static void main(String[] args) {
    if (Arrays.stream(args).anyMatch(isEqual("--server"))) {
      Micronaut.run(Server.class);
      return;
    }

    PicocliRunner.run(BugDemoCommand.class, args);
  }

}
