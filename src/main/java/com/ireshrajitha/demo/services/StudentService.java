package com.ireshrajitha.demo.services;

import com.ireshrajitha.demo.dto.StudentDTO;
import com.ireshrajitha.demo.model.Student;
import com.ireshrajitha.demo.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public void saveStudent(Student student){
        Random r = new Random();
        student.setId(Math.abs(r.nextInt()));
        studentRepo.save(student);
    }
    public void deleteStudent(int id){
        studentRepo.deleteById(id);
    }
    public List<Student> getAll(){
        return studentRepo.findAll();
    }
    public Optional<Student> getOne(int id){
        return studentRepo.findById(id);
    }
    public void updateStudent(int id, Student student){
        student.setId(id);
        studentRepo.save(student);
    }
}
