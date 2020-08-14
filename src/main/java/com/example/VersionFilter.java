package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpRequestWrapper;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import org.reactivestreams.Publisher;

@Filter(Filter.MATCH_ALL_PATTERN)
public class VersionFilter implements HttpServerFilter {
  @Override
  public Publisher<MutableHttpResponse<?>> doFilter(
      final HttpRequest<?> request, final ServerFilterChain chain) {

    final HttpRequest<?> newRequest = new HttpRequestWrapper<>(request);

    return chain.proceed(newRequest);
  }
}
