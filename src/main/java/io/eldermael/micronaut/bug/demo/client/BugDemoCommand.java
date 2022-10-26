package io.eldermael.micronaut.bug.demo.client;

import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;

@Command(name = "bug", description = "...", mixinStandardHelpOptions = true,
    subcommands = {
        BugSubcommand.class
    })
public class BugDemoCommand implements Runnable {
  @Option(names = {"-v", "--verbose"}, description = "...")
  boolean verbose;

  public void run() {
    // business logic here
    if (verbose) {
      System.out.println("Hi!");
    }
  }
}
