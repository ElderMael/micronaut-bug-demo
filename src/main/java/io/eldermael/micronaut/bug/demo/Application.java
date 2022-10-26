package io.eldermael.micronaut.bug.demo;

import io.eldermael.micronaut.bug.demo.client.BugDemoCommand;
import io.eldermael.micronaut.bug.demo.server.Server;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.runtime.Micronaut;

import java.util.Arrays;

import static java.util.function.Predicate.isEqual;

public class Application {

  private static String[] args;

  public static void main(String[] args) {
    Application.args = args;
    PicocliRunner.run(BugDemoCommand.class, args);
  }

  public static String[] getArgs() {
    return Application.args;
  }
}
