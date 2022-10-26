package io.eldermael.micronaut.bug.demo.client;

import io.eldermael.micronaut.bug.demo.Application;
import io.eldermael.micronaut.bug.demo.server.Server;
import io.micronaut.runtime.Micronaut;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "bug", description = "...", mixinStandardHelpOptions = true,
    subcommands = {
        BugSubcommand.class
    })
public class BugDemoCommand implements Runnable {
  @Option(names = {"-v", "--verbose"}, description = "...")
  boolean verbose;

  @Option(names = {"--server"}, description = "...")
  boolean server;

  public void run() {
    // business logic here
    if (verbose) {
      System.out.println("Hi!");
    }

    if(this.server) {
      Micronaut.run(Server.class, Application.getArgs());
    }
  }
}
