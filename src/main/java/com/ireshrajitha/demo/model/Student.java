package com.ireshrajitha.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "Student")
public class Student {

    @Transient
    public static final String SEQUENCE_NAME = "Student_sequence";
    @Id
    private int id;
    private String name;
    private String city;
}
