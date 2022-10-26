package io.eldermael.micronaut.bug.demo;

import io.eldermael.micronaut.bug.demo.client.BugDemoCommand;
import io.micronaut.configuration.picocli.PicocliRunner;

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
