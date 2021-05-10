package com.axiom.hyketask.config;

import com.axiom.hyketask.util.MongoContainerWrapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.sun.istack.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Profile("embedded_mongo")
@Configuration
public class EmbeddedMongoContainerConfig extends AbstractMongoClientConfiguration {


    @Bean
    public MongoContainerWrapper mongoContainer() {
        return new MongoContainerWrapper();
    }

    @NotNull
    @Override
    public MongoClient mongoClient() {
        return MongoClients
                .create(
                        "mongodb://" +
                                mongoContainer().get().getContainerIpAddress() +
                                ":" +
                                mongoContainer().getMongoDefaultPort()
                );
    }

    @Override
    protected String getDatabaseName() {
        return "mobile_service_db";
    }

    @EventListener
    public void handleContextEnd(ContextClosedEvent ctxEnd) {
        mongoContainer().get().stop();
    }
}
