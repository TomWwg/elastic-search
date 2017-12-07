package com.example;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by wwg on 2017/12/7.
 * @author wwg
 */
@Configuration
public class MyConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {
        InetSocketTransportAddress node = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300);
        Settings settings = Settings.builder().put("cluster.name", "wali").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;
    }
}
