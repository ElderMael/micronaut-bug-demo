package io.eldermael.micronaut.bug.demo.client;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.Map;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;

@Command(name = "bug-demo", description = "...", mixinStandardHelpOptions = true)
@RequiredArgsConstructor
public class BugDemoCommand implements Runnable {

  @Inject
  private final BugClient client;

  @Option(names = {"-v", "--verbose"}, description = "...")
  boolean verbose;

  public void run() {
    // business logic here
    if (verbose) {
      System.out.println("Hi!");
    }

    this.client.postToBuggyEndpoint(ofEntries(
        entry("goodbye", "moonman"),
        entry("adios", "hombre lunar")
    ));
  }
}
