package io.eldermael.micronaut.bug.demo.client;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import picocli.CommandLine;

import java.util.Map;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;

@Singleton
@CommandLine.Command(
    name = "test"
)
@RequiredArgsConstructor
public class BugSubcommand implements Runnable {

  @Inject
  private final BugClient client;

  @Override
  public void run() {
    var output = this.client.postToBuggyEndpoint(ofEntries(
        entry("goodbye", "moonman"),
        entry("adios", "hombre lunar")
    ));

    System.out.println(output);
  }
}
