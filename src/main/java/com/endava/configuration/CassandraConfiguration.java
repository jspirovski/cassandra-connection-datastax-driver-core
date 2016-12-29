package com.endava.configuration;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;



public class CassandraConfiguration {

    private static Cluster cluster;
    private static Session session;

    public static void init() {
        cluster = Cluster.builder().addContactPoints("localhost").build();
        session = cluster.connect("cwt");
    }

}
