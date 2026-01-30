package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo){
        this.repo = repo;
    }

    public StudentEntity addStudent(StudentEntity s){
        return repo.save(s);
    }

    public List<StudentEntity> getAllStudents(){
        return repo.findAll();
    }

    public StudentEntity getStudentById(Long id){
        return repo.findById(id).orElse(null);
    }

    public StudentEntity updateStudent(Long id, StudentEntity s){
        StudentEntity existing = repo.findById(id).orElse(null);
        if(existing != null){
            existing.setName(s.getName());
            existing.setEmail(s.getEmail());
            existing.setAge(s.getAge());
            existing.setCourse(s.getCourse());
            return repo.save(existing);
        }
        return null;
    }

    public void deleteStudent(Long id){
        repo.deleteById(id);
    }
}
