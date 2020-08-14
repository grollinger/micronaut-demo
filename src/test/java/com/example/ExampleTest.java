package com.example;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MicronautTest
public final class ExampleTest {
  @Client(value = "/", errorType = String.class)
  @Inject
  private HttpClient client;

  @Test
  public void failureResponse() {
    final HttpClientResponseException ex =
        assertThrows(
            HttpClientResponseException.class, () -> client.toBlocking().retrieve("/fail"));

    assertEquals("Failed", ex.getResponse().body());
    assertEquals(HttpStatus.BAD_REQUEST, ex.getResponse().status());
  }
}
