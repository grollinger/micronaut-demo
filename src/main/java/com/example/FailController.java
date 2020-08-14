package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Get;

import javax.inject.Singleton;

@Controller("/")
@Singleton
public class FailController {
  @Get("/fail")
  public String fail() {
    throw new IllegalArgumentException("Just to invoke the error handler");
  }

  @SuppressWarnings({"MethodMayBeStatic", "unused"})
  @Error
  public HttpResponse<String> onInputValidationFailed(
      final HttpRequest<?> request, final IllegalArgumentException error) {
    return HttpResponse.badRequest("Failed");
  }
}
