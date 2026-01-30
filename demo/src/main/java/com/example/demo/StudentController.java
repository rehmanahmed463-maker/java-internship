package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity s){
        StudentEntity saved = service.addStudent(s);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents(){
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable Long id){
        StudentEntity student = service.getStudentById(id);
        if(student == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id, @RequestBody StudentEntity s){
        StudentEntity updated = service.updateStudent(id, s);
        if(updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
