package com.endava.configuration;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.endava.model.Author;
import com.endava.utils.DateCassandra;

import java.util.Date;
import java.util.UUID;


public class CassandraConfiguration {

    private static Cluster cluster;
    private static Session session;

    public static void init() {
        cluster = Cluster.builder().addContactPoints("localhost").build();
        session = cluster.connect("library");

        MappingManager manager = new MappingManager(session);

        Mapper<Author> authorMapper = manager.mapper(Author.class);

        Author authorSelect = authorMapper.get(UUID.fromString("efc730c1-8501-4da5-8ab7-858445409191"));
        Date birthDate = authorSelect.getBirth_date();

        Author authorInsert = new Author(UUID.randomUUID(), "beti", "spasovska", DateCassandra.dateStringToDate("2001-08-14 12:44"));
        authorMapper.save(authorInsert);

        Author authorUpdate = new Author(UUID.fromString("a51294df-0d16-4fb3-85e9-2e2ecc7ac1a2"), "jovan", "shalamanoski", DateCassandra.dateStringToDate("1987-12-11 12:44"));
        authorMapper.save(authorUpdate);


        authorMapper.delete(UUID.fromString("20529cb7-98d1-4989-bd07-815d8a02a6f0"));




    }

}
