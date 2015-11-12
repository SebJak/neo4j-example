package com.example;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Sebastian on 2015-11-07.
 */
@Data
@Getter
@Setter
@NodeEntity(label = "TestPerson")
public class Person implements Serializable{

        @GraphId
        private Long id;

        @Index(unique = true)
        private String nick;

        private String firstName;

        private String lastName;

        private LocalDate birthDay;

        private String password;

        @Index(unique = true)
        private String email;

        private Date lastActivity;

    }


