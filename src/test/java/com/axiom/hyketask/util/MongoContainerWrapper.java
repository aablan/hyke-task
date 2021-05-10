package com.axiom.hyketask.util;

import org.testcontainers.containers.GenericContainer;

public class MongoContainerWrapper {

    private static final int MONGO_DEFAULT_PORT = 27017;
    private final GenericContainer container =
            new GenericContainer<>("mongo").withExposedPorts(MONGO_DEFAULT_PORT);

    public MongoContainerWrapper() {
        container.start();
    }

    public GenericContainer get() {
        return container;
    }

    public int getMongoDefaultPort() {
        return container.getMappedPort(MONGO_DEFAULT_PORT);
    }
}
