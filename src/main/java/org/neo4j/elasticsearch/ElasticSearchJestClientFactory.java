package org.neo4j.elasticsearch;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.net.ssl.*;

public class ElasticSearchJestClientFactory {
  public static JestClient getInstance(final String hostName) throws Throwable {
    JestClientFactory factory = new JestClientFactory();

    factory.setHttpClientConfig(new HttpClientConfig
        .Builder(hostName)
        .multiThreaded(true)
        .discoveryEnabled(true)
        .discoveryFrequency(1L, TimeUnit.MINUTES)
        .build());

    return factory.getObject();
  }
}
