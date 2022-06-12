package com.ireshrajitha.demo.controller;

import com.ireshrajitha.demo.dto.StudentDTO;
import com.ireshrajitha.demo.model.Student;
import com.ireshrajitha.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @CrossOrigin
    @PostMapping
    public void saveBook(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }

    @CrossOrigin
    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Student> getOne(@PathVariable("id") int id){
        return studentService.getOne(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public void updateBook(@PathVariable("id") int id , @RequestBody Student student){
        studentService.updateStudent(id,student);
    }
}
