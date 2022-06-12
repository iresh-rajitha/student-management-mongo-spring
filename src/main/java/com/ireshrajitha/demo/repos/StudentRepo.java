package com.ireshrajitha.demo.repos;

import com.ireshrajitha.demo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, Integer> {

}
