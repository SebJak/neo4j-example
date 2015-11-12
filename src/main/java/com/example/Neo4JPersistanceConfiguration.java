package com.example;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Sebastian on 2015-11-07.
 */
@Configurable
@EnableNeo4jRepositories(basePackages = "com.example")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.example")
public class Neo4JPersistanceConfiguration extends Neo4jConfiguration{
    

    @Override
    public Neo4jServer neo4jServer() {
        Neo4jServer server = new RemoteServer("http://localhost:7474","neo4j","neo4j");
        return server;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.example");
    }

}
